package com.yiya.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.aop.Key;
import com.yiya.bean.DataDictionaryType;
import com.yiya.bean.DataDictionaryValue;
import com.yiya.bean.SysUser;
import com.yiya.model.DataParameterModel;
import com.yiya.service.DataManagerService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.StringUtil;

/**
 * 数据字典控制类
 * @author lifaqiu
 * @date 2016-11-03
 */
@Controller
@RequestMapping("/dataManager") 
public class DataManagerAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(DataManagerAction.class);
	
	@Autowired(required=false)
	private  DataManagerService dataManagerService; 
	
	@RequestMapping("/data_dictionary_type") 
	public ModelAndView data_dictionary_type(DataParameterModel model,HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		return forword("dataManager/data_dictionary_type",context); 
	}
	
	@RequestMapping("/dDTDataList") 
	public void dDTDataList(DataParameterModel model,HttpServletResponse response) throws Exception{
		List<DataDictionaryType> dataList = dataManagerService.queryDDTList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/data_dictionary_value") 
	public ModelAndView data_dictionary_value(DataParameterModel model,HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		List<DataDictionaryType> list = dataManagerService.findTypeList();
		context.put("list", list);
		return forword("dataManager/data_dictionary_value",context); 
	}
	
	@RequestMapping("/dDVDataList") 
	public void dDVDataList(DataParameterModel model,HttpServletResponse response) throws Exception{
		List<DataDictionaryValue> dataList = dataManagerService.queryDDVList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@Key(operation="增加或者修改数据字典类型",param="")
	@RequestMapping("/saveOrUpdateType") 
	public void saveOrUpdateType(Integer dictionary_type_id, String dictionary_type_name,Integer is_relational_table,String relational_table_name,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if (dictionary_type_name == null || dictionary_type_name.length() > 32) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请输入长度为32个字符的类型名称");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		SysUser sysUser = SessionUtils.getUser(request);
		if (sysUser == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请先登陆，再操作");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		if (dictionary_type_id == 0) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("dictionary_type_name", dictionary_type_name);
			int count = dataManagerService.findTypeCnt(param);
			if (count > 0) {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "类型名称已存在");
				HtmlUtil.writerJson(response, jsonMap);
				return;
			}
			
			DataDictionaryType ddt = new DataDictionaryType();
			ddt.setAdd_time(new Date());
			ddt.setAdd_usr_id(sysUser.getId());
			ddt.setDictionary_type_name(dictionary_type_name);
			ddt.setIs_relational_table(is_relational_table);
			ddt.setRelational_table_name(relational_table_name);
			if (dataManagerService.addDDT(ddt) > 0) {
				jsonMap.put("flag", true);
				jsonMap.put("msg", "");
			}else {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "增加失败");
			}
			//插入成功之后，返回插入的主键id
			Integer dictionary_typeId = ddt.getDictionary_type_id();
			if ( null != dictionary_typeId)
			{
				ddt.setDictionary_type_id(dictionary_typeId);
				ddt.setDictionary_type_code("tszd_" + dictionary_typeId);//数据字典编号,tszd_拼接主键id
				dataManagerService.updateDDT(ddt);
			}
		}
		else
		{
			DataDictionaryType ddt = dataManagerService.findDDTById(dictionary_type_id);
			if (ddt == null) {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "记录不存在");
				HtmlUtil.writerJson(response, jsonMap);
				return;
			}
			if (!ddt.getDictionary_type_name().equals(dictionary_type_name)) {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("dictionary_type_name", dictionary_type_name);
				param.put("dictionary_type_id", dictionary_type_id);
				int count = dataManagerService.findTypeCnt(param);
				if (count > 0) {
					jsonMap.put("flag", false);
					jsonMap.put("msg", "类型名称已存在");
					HtmlUtil.writerJson(response, jsonMap);
					return;
				}
			}
			ddt.setDictionary_type_name(dictionary_type_name);
			ddt.setIs_relational_table(is_relational_table);
			ddt.setRelational_table_name(relational_table_name);
			if (dataManagerService.updateDDT(ddt) > 0) {
				jsonMap.put("flag", true);
				jsonMap.put("msg", "");
			}else {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "修改失败");
			}
		}
		
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@Key(operation="删除数据字典类型",param="")
	@RequestMapping("/deleteDDT") 
	public void deleteDDT(Integer dictionary_type_id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		SysUser sysUser = SessionUtils.getUser(request);
		if (sysUser == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请先登陆，再操作");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		if (dataManagerService.deleteDDT(dictionary_type_id) > 0) {
			jsonMap.put("flag", true);
			jsonMap.put("msg", "");
		}else {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "删除失败");
		}
		
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@Key(operation="增加或者修改数据字典",param="")
	@RequestMapping("/saveOrUpdateValue") 
	public void saveOrUpdateValue(Integer dictionary_value_id, Integer dictionary_type_id, String dictionary_value_name, Integer dictionary_value_key,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if (dictionary_value_name == null || dictionary_value_name.length() > 64) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请输入长度为64个字符的数据字典value名称");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		if (dictionary_type_id == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请选择数据字典类型");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		if (dictionary_value_key == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请输入数据字典value的键值");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		
		SysUser sysUser = SessionUtils.getUser(request);
		if (sysUser == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请先登陆，再操作");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		if (dictionary_value_id == 0) {
			
			DataDictionaryValue ddv = new DataDictionaryValue();
			ddv.setAdd_time(new Date());
			ddv.setAdd_usr_id(sysUser.getId());
			ddv.setDictionary_value_name(dictionary_value_name);
			ddv.setDictionary_type_id(dictionary_type_id);
			ddv.setDictionary_value_key(dictionary_value_key);
			
			if (dataManagerService.addDDV(ddv) > 0) {
				jsonMap.put("flag", true);
				jsonMap.put("msg", "");
			}else {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "增加失败");
			}
		}else {
			DataDictionaryValue ddv = dataManagerService.findDDVById(dictionary_value_id);
			if (ddv == null) {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "记录不存在");
				HtmlUtil.writerJson(response, jsonMap);
				return;
			}
			ddv.setDictionary_value_name(dictionary_value_name);
			ddv.setDictionary_type_id(dictionary_type_id);
			ddv.setDictionary_value_key(dictionary_value_key);
			
			if (dataManagerService.updateDDV(ddv) > 0) {
				jsonMap.put("flag", true);
				jsonMap.put("msg", "");
			}else {
				jsonMap.put("flag", false);
				jsonMap.put("msg", "修改失败");
			}
		}
		
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@Key(operation="删除数据字典",param="")
	@RequestMapping("/deleteDDV") 
	public void deleteDDV(Integer dictionary_value_id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		SysUser sysUser = SessionUtils.getUser(request);
		if (sysUser == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "请先登陆，再操作");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		if (dataManagerService.deleteDDV(dictionary_value_id) > 0) {
			jsonMap.put("flag", true);
			jsonMap.put("msg", "");
		}else {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "删除失败");
		}
		
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/findDDVById") 
	public void findDDVById(Integer dictionary_value_id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		DataDictionaryValue ddv = dataManagerService.findDDVById(dictionary_value_id);
		if (ddv == null) {
			jsonMap.put("flag", false);
			jsonMap.put("msg", "记录不存在");
			HtmlUtil.writerJson(response, jsonMap);
			return;
		}
		jsonMap.put("flag", true);
		jsonMap.put("msg", "");
		jsonMap.put("ddv", ddv);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 根据数据字典类型中文名查找相应的数据字典值
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDDVListByTypeName") 
	@ResponseBody
	public List<DataDictionaryValue> getDDVListByTypeName(String typeName) throws Exception{
		if(StringUtil.isEmpty(typeName)){
			throw new Exception("typeName should not be null");
		}
		DataParameterModel model = new DataParameterModel(dataManagerService.getTypeIdByTypeName(typeName),
				null, null, null,null);
		List<DataDictionaryValue> list = dataManagerService.queryDDVListWithoutPage(model);
		return list;
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 根据数据字典code查找相应的数据字典值
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDDVListByTypeCode") 
	@ResponseBody
	public List<DataDictionaryValue> getDDVListByTypeCode(String typeCode) throws Exception{
		if(StringUtil.isEmpty(typeCode)){
			throw new Exception("typeCode should not be null");
		}
		DataParameterModel model = new DataParameterModel(null,
				null, null, null,typeCode);
		List<DataDictionaryValue> list = dataManagerService.queryDDVListWithoutPage(model);
		return list;
	}
	
}
