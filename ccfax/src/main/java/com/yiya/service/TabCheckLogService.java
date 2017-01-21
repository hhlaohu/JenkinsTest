package com.yiya.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabCheckLog;
import com.yiya.mapper.TabCheckLogMapper;


@Service("tabCheckLogService")
public class TabCheckLogService extends BaseService<TabCheckLog> {
	
	
	@Autowired
    private TabCheckLogMapper mapper;

	public TabCheckLogMapper getMapper() {
		return mapper;
	}
 
	public void update(TabCheckLog tu){
		mapper.update(tu);
	}
	
	public void add(TabCheckLog tu){
		mapper.add(tu);
	}
	
	public void delete(TabCheckLog tu){
		mapper.delete(tu);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年10月24日
	 * @description 根据操作时间查找最新的一条审核日志
	 * @param params
	 * @return
	 */
	public TabCheckLog queryLastCheckLog(Map<String, Object> params){
		return mapper.queryLastCheckLog(params);
	}
	
	
	/**
	 * @author frank_wang
	 * @data 2016年10月31日
	 * @description check_result转换为中文
	 * @return
	 */
	public String transterCheckResult(int value){
		
		if(value == 0){
			return "初始状态";
		}else if(value == 1){
			return "未审核";
		}else if(value == 2){
			return "初审不通过";
		}else if(value == 3){
			return "初审通过";
		}else if(value == 4){
			return "复审不通过";
		}else if(value == 5){
			return "复审通过";
		}else if(value == 6){
			return "退回初审";
		}else if(value == 7){
			return "终审不通过";
		}else if(value == 8){
			return "终审通过";
		}else if(value == 9){
			return "退回复审";
		}
		return String.valueOf(value);
	}
	
}
