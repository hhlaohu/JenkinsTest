package com.yiya.action;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.aop.Key;
import com.yiya.bean.PzGood;
import com.yiya.bean.SpecConfig;
import com.yiya.model.PzGoodAndSpecConfigModel;
import com.yiya.model.PzGoodModel;
import com.yiya.model.SpecConfigModel;

import com.yiya.service.PzGoodService;
import com.yiya.service.SpecConfigService;

import com.yiya.utils.HtmlUtil;
import com.yiya.utils.ReadExcel;

 
@Controller
@RequestMapping("/pzGood") 
public class PzGoodAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(PzGoodAction.class);
	
	
	@Autowired(required=false)
	private  PzGoodService<PzGood> pzGoodService; 
	
	@Autowired(required=false)
	private  SpecConfigService<SpecConfig> specConfigService; 
	
	private PzGood pzGood = new PzGood();
	
	private PzGood pzGoodone;
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(PzGoodModel model,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		List<PzGood> listPG = pzGoodService.listAll();//获取货物名称列表
		List<PzGood> listP = pzGoodService.queryPlace();
		List<PzGood> listL = pzGoodService.queryLevel();
		List<SpecConfig> listSC = specConfigService.querySpecConfigList();
		context.put("listPG", listPG);//把货物名称传递到前台页面
		context.put("listP", listP);
		context.put("listL", listL);
		context.put("listSC", listSC);
		return forword("fk/pzGood",context); 
	}
	
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  dataList(PzGoodModel model,HttpServletResponse response) throws Exception{
		  Map<String, Object> params = new HashMap<String, Object>();
		  int startRow = (model.getPage() - 1) * model.getRows();
		  params.put("startRow", startRow);
		  params.put("rows", model.getRows());
		  List<PzGoodAndSpecConfigModel> dataList = pzGoodService.queryAllJoinSpecConfig(params);
		  
		  // 设置页面数据
		  Map<String, Object> jsonMap = new HashMap<String, Object>();
		  jsonMap.put("total", pzGoodService.queryCountbyAll());
      	  jsonMap.put("rows", dataList);
          HtmlUtil.writerJson(response, jsonMap);
	}
	
	/** 添加配置管理信息**/
	@RequestMapping("/addPzGood")
	@Key(operation="添加配置管理信息",param="addPzGood")
	public void addPzGood(String pz_good_name,String pz_good_place,String pz_good_level,String pz_good_size,String market_prices,String unit,String pledge_multiplier,HttpServletResponse response) throws Exception{
		pzGood = new PzGood();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String,Object>  map = new HashMap<String,Object>();
		Map<String,Object>  querymap = new HashMap<String,Object>();
		Map<String,Object>  queryAll = new HashMap<String,Object>();
		
		querymap.put("pz_good_name", pz_good_name);
		querymap.put("pz_good_place", pz_good_place);	
		querymap.put("pz_good_level", pz_good_level);
		querymap.put("pz_good_size", pz_good_size);
		
    	if(null!=pzGoodService.queryAllByName(querymap)){//若4个数据都匹配,数据已存在
			jsonMap.put("msg", 6);
	    	 HtmlUtil.writerJson(response, jsonMap);
	      	return;
		}
    	
		if(null!=pzGoodService.queryPlaceIsAll(querymap)){//根据货物名称查询后,第二个产地是全部
			if(pz_good_place.equals("2468")){
				jsonMap.put("msg", 1);
		    	 HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		if(null!=pzGoodService.queryLevelIsAll(querymap)){//根据货物名称,产地查询后,第三个等级是全部
			if(pz_good_level.equals("2468")){
				jsonMap.put("msg", 1);
		    	 HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		if(null!=pzGoodService.querySizeIsAll(querymap)){//根据货物名称,产地,等级查询后,第四个规格是全部
			if(pz_good_size.equals("0")){
				jsonMap.put("msg", 1);
		    	 HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		List<PzGoodAndSpecConfigModel> list = pzGoodService.queryPzGoodSizeReject(querymap);//当货物名称,产地,等级都相同时,再根据规格是否互斥
		if(list!=null && !list.isEmpty()){
			SpecConfig sc = specConfigService.querySpecConfigReject(Integer.parseInt(pz_good_size));//查询用户输入的规格
			if(sc!=null){
				Integer sc_begin = sc.getValue_begin();//查询出后的开始结束值
				Integer sc_end = sc.getValue_end();
				for(PzGoodAndSpecConfigModel pgascm : list){//遍历集合,逐一比较规格名称是否在开始结束范围内
					Integer valBegin = pgascm.getValue_begin();//已存在的开始值
					Integer valEnd = pgascm.getValue_end();//结束
					if(valBegin<sc_end && sc_end<=valEnd){
					    jsonMap.put("msg", 2);
				    	HtmlUtil.writerJson(response, jsonMap);
				      	return;
					}
					if(valBegin<=sc_begin && sc_begin<valEnd){
					    jsonMap.put("msg", 2);
				    	HtmlUtil.writerJson(response, jsonMap);
				      	return;
					}
				}
			}
		}
		queryAll.put("pz_good_name", pz_good_name);
		queryAll.put("pz_good_place", pz_good_place);
		
		if(!pz_good_place.equals("2468")){
			pzGood = pzGoodService.queryByName(queryAll);//商品存在产地为全部的数据，产地只能为全部
			if(pzGood!=null){
				jsonMap.put("msg", 3);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		if(!pz_good_level.equals("2468")){
			pzGood = pzGoodService.queryLevelIn(queryAll);//商品存在等级为全部的数据，等级只能为全部
			if(pzGood!=null){
				jsonMap.put("msg", 4);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		queryAll.put("pz_good_level", Integer.valueOf(pz_good_level));
		if(!pz_good_size.equals("0")){
			pzGood = pzGoodService.querySizeIn(queryAll);//商品存在规格为全部的数据，规格只能为全部
			if(pzGood!=null){
				jsonMap.put("msg", 5);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		map.put("pz_good_name", pz_good_name);
		map.put("pz_good_place", pz_good_place);	
		map.put("pz_good_level", pz_good_level);
//		map.put("pz_good_size", pz_good_size);
		map.put("pz_good_size", Integer.valueOf(pz_good_size));
		map.put("market_prices", market_prices);
		map.put("unit", unit);
		map.put("pledge_multiplier", pledge_multiplier);
		pzGoodService.addPzGood(map);
		jsonMap.put("msg", 0);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**修改配置管理信息**/
	@RequestMapping("/updatePzGood")
	@Key(operation="修改配置管理信息",param="updatePzGood")
	public void updatePzGood(String pz_id,String pz_good_name,String pz_good_place,String pz_good_level,String pz_good_size,String market_prices,String unit,String pledge_multiplier,HttpServletResponse response) throws Exception{
		pzGood = new PzGood();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String,Object>  map = new HashMap<String,Object>();
		Map<String,Object>  querymap = new HashMap<String,Object>();
		Map<String,Object>  queryAll = new HashMap<String,Object>();
		
		querymap.put("pz_id", pz_id);
		querymap.put("pz_good_name", pz_good_name);
		querymap.put("pz_good_place", pz_good_place);	
		querymap.put("pz_good_level", pz_good_level);
		querymap.put("pz_good_size", pz_good_size);
		
		if(null!=pzGoodService.queryAllByName(querymap)){//若4个数据都匹配,数据已存在
			jsonMap.put("msg", 6);
	    	 HtmlUtil.writerJson(response, jsonMap);
	      	return;
		}
		
		if(null!=pzGoodService.queryAllByName2(querymap)){//若4个数据都匹配,数据已存在
			jsonMap.put("msg", 6);
	    	 HtmlUtil.writerJson(response, jsonMap);
	      	return;
		}
    	
		if(null!=pzGoodService.queryPlaceIsAll(querymap)){//根据货物名称查询后,第二个产地是全部
			if(pz_good_place.equals("2468")){
				jsonMap.put("msg", 1);
		    	 HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		if(null!=pzGoodService.queryLevelIsAll(querymap)){//根据货物名称,产地查询后,第三个等级是全部
			if(pz_good_level.equals("2468")){
				jsonMap.put("msg", 1);
		    	 HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		if(null!=pzGoodService.querySizeIsAll(querymap)){//根据货物名称,产地,等级查询后,第四个规格是全部
			if(pz_good_size.equals("0")){
				jsonMap.put("msg", 1);
		    	 HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		List<PzGoodAndSpecConfigModel> list = pzGoodService.queryPzGoodSizeReject(querymap);//当货物名称,产地,等级都相同时,再根据规格是否互斥
		if(list!=null && !list.isEmpty()){
			SpecConfig sc = specConfigService.querySpecConfigReject(Integer.parseInt(pz_good_size));//查询用户输入的规格
			if(sc!=null){
				Integer sc_begin = sc.getValue_begin();//查询出后的开始结束值
				Integer sc_end = sc.getValue_end();
				for(PzGoodAndSpecConfigModel pgascm : list){//遍历集合,逐一比较规格名称是否在开始结束范围内
					Integer valBegin = pgascm.getValue_begin();//已存在的开始值
					Integer valEnd = pgascm.getValue_end();//结束
					if(valBegin<sc_end && sc_end<=valEnd){
					    jsonMap.put("msg", 2);
				    	HtmlUtil.writerJson(response, jsonMap);
				      	return;
					}
					if(valBegin<=sc_begin && sc_begin<valEnd){
					    jsonMap.put("msg", 2);
				    	HtmlUtil.writerJson(response, jsonMap);
				      	return;
					}
				}
			}
		}
		
		queryAll.put("pz_id", pz_id);
		queryAll.put("pz_good_name", pz_good_name);
		queryAll.put("pz_good_place", pz_good_place);
		if(!pz_good_place.equals("2468")){
			pzGood = pzGoodService.queryByName(queryAll);//商品存在产地为全部的数据，产地只能为全部
			if(pzGood!=null){
				jsonMap.put("msg", 3);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		if(!pz_good_level.equals("2468")){
			pzGood = pzGoodService.queryLevelIn(queryAll);//商品存在等级为全部的数据，等级只能为全部
			if(pzGood!=null){
				jsonMap.put("msg", 4);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		queryAll.put("pz_good_level", pz_good_level);
		if(!pz_good_size.equals("0")){
			pzGood = pzGoodService.querySizeIn(queryAll);//商品存在规格为全部的数据，规格只能为全部
			if(pzGood!=null){
				jsonMap.put("msg", 5);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
		}
		
		map.put("pz_id", pz_id);
		map.put("pz_good_name", pz_good_name);
		map.put("pz_good_place", pz_good_place);
		map.put("pz_good_level", pz_good_level);
		map.put("pz_good_size", pz_good_size);
		map.put("market_prices", market_prices);
		map.put("unit", unit);
		map.put("pledge_multiplier", pledge_multiplier);
		pzGoodService.modifyPzGood(map);
		jsonMap.put("msg", 0);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**删除配置管理信息**/
	@RequestMapping("/deletePzGood")
	@Key(operation="删除配置管理信息",param="deletePzGood")
	public void deletePzGood(String pz_id,HttpServletResponse response) throws Exception{
		pzGoodService.delete(pz_id);
	}
	
	
	
	/**按货物名称查询列表**/
	@RequestMapping("/queryPzGoodName")
	public void queryPzGoodName(PzGoodModel model,HttpServletResponse response) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		int startRow = (model.getPage() - 1) * model.getRows();
		map.put("startRow", startRow);//分页查询条件
	    map.put("rows", model.getRows());
		map.put("pz_good_name", model.getPz_good_name());//按货物名称条件查询
		List<PzGoodAndSpecConfigModel> dataList = pzGoodService.queryAllJoinSpecConfig(map);
		
		//设置货物名称查询页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",pzGoodService.queryPzGoodNameCount(model));//传前台页面显示总条数
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);;
	}

	/**配置管理批量导入**/
	@RequestMapping("/importExcelFile") 
	@Key(operation="配置管理批量导入",param="importExcelFile")
	public ModelAndView importExcelFile(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
	   String path = request.getSession().getServletContext().getRealPath("upload");  
       String fileName = UUID.randomUUID().toString()+file.getOriginalFilename();  //防止文件重名覆盖
      //  System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }
        //保存  
        try {  
        	file.transferTo(targetFile);  
            String filePath = targetFile.toString();//获取Excel文件名
        	ReadExcel re = new ReadExcel();
            List<PzGood> list = re.readXls(filePath,response);//读取Excel数据列表
            PzGood pzGood = null;
            Integer count = 0;
            if(list!=null){
	            for(PzGood pz : list){
	            	   pzGood = new PzGood();
	            	   pzGood.setPz_good_name(pz.getPz_good_name());
	            	   pzGood.setPz_good_place(pz.getPz_good_place());
	            	   pzGood.setPz_good_level(pz.getPz_good_level());
	            	   pzGood.setPz_good_size(pz.getPz_good_size());
	            	   pzGoodone=pzGoodService.queryByone(pzGood);
	            	   if(null!=pzGoodone){
	            		   continue;
	            	   }
	            	   pzGood.setMarket_prices(pz.getMarket_prices());
	            	   pzGood.setUnit(pz.getUnit());
	            	   pzGood.setPledge_multiplier(pz.getPledge_multiplier());
	            	   count = pzGoodService.insertBatchPzGood(pzGood);
	   		   }
	           if(count>0){
	            	 sendSuccessMessage(response, "1");
	            	 return null;
	           }else{
	            	sendFailureMessage(response, "0");
	           }
          }
          
    		/**删除导入到服务器的模板文件**/
    		deleteFile(filePath);
    		File filePathFile = new File(filePath);
    		filePathFile.delete();

        } catch (Exception e) {  
        	sendFailureMessage(response, "0");
        	e.printStackTrace();
            log.info("导入数据失败");
        }
		return null;  
	}
	
	/**删除导入到服务器的模板方法**/
	public  void deleteFile(String localFileName) {
		File localFile = new File(localFileName);
		boolean flag = false;
		if(localFile.isFile()&&localFile.exists()){
			log.debug("localFileName--"+localFileName);
			flag = localFile.getAbsoluteFile().delete();
		}
		log.debug("文件" + localFileName + "是否删除成功：" + flag);
	}
	
	
	/**规格管理**/
	@RequestMapping("/getSpecConfigList") 
	public void  getstockdetail(SpecConfigModel model,HttpServletResponse response) throws Exception{	
		List<SpecConfig> dataList = specConfigService.queryByList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**添加规格管理**/
	@RequestMapping("/addSpecConfig")
	@Key(operation="添加规格管理",param="addSpecConfig")
	public void addSpecConfig(SpecConfig bean,HttpServletResponse response) throws Exception{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		SpecConfig sc = new SpecConfig();
		if(bean.getSpec_type()==0){//A类
			if(bean.getValue_begin()!=null || bean.getValue_end()!=null){//A类中开始与结束不能有值
				jsonMap.put("msg", 0);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
			sc.setSpec_name(bean.getSpec_name());
			sc.setSpec_type(bean.getSpec_type());
		}
		if(bean.getSpec_type()==1){//B类
			sc.setSpec_type(bean.getSpec_type());
			sc.setValue_begin(bean.getValue_begin());
			sc.setValue_end(bean.getValue_end());
		}
		SpecConfig specConfig = specConfigService.querySpecConfig(sc);//查询相同的规格数据是否存在,若存在不能再添加
		if(specConfig!=null){
			jsonMap.put("msg", 1);
	    	HtmlUtil.writerJson(response, jsonMap);
	      	return;
		}
		specConfigService.add(bean);
		HtmlUtil.writerJson(response, jsonMap);
		 
	}
	
	/**修改规格管理**/
	@RequestMapping("/updateSpecConfig")
	@Key(operation="修改规格管理",param="updateSpecConfig")
	public void updateSpecConfig(SpecConfig bean,HttpServletResponse response) throws Exception{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		SpecConfig sc = new SpecConfig();
		if(bean.getSpec_type()==0){//A类
			if(bean.getValue_begin()!=null || bean.getValue_end()!=null){//A类中开始与结束不能有值
				jsonMap.put("msg", 0);
		    	HtmlUtil.writerJson(response, jsonMap);
		      	return;
			}
			sc.setSpec_name(bean.getSpec_name());
			sc.setSpec_type(bean.getSpec_type());
		}
		if(bean.getSpec_type()==1){//B类
			sc.setSpec_type(bean.getSpec_type());
			sc.setValue_begin(bean.getValue_begin());
			sc.setValue_end(bean.getValue_end());
		}
		SpecConfig specConfig = specConfigService.querySpecConfig(sc);//查询相同的规格数据是否存在,若存在不能再修改
		if(specConfig!=null){
			jsonMap.put("msg", 1);
	    	HtmlUtil.writerJson(response, jsonMap);
	      	return;
		}
		specConfigService.update(bean);
		HtmlUtil.writerJson(response, jsonMap);
	}
}