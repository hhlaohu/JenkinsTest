package com.yiya.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.DataDictionaryType;
import com.yiya.bean.DataDictionaryValue;
import com.yiya.mapper.DataManagerMapper;
import com.yiya.model.DataParameterModel;

@Service("dataManagerService")
public class DataManagerService<T> extends BaseService<T> {

	private final static Logger log = Logger.getLogger(DataManagerService.class);

	@Autowired
	private DataManagerMapper mapper;

	@Override
	public DataManagerMapper getMapper() {
		return mapper;
	}

	public List<DataDictionaryType> queryDDTList(DataParameterModel model) throws Exception {
		Integer rowCount = queryDDTCount(model);
		model.getPager().setRowCount(rowCount);
		return mapper.queryDDTList(model);
	}

	public int queryDDTCount(DataParameterModel model) throws Exception {
		return mapper.queryDDTCount(model);
	}

	public int queryDDTCount1(DataParameterModel model) throws Exception {
		return mapper.queryDDTCount1(model);
	}

	public List<DataDictionaryValue> queryDDVList(DataParameterModel model) throws Exception {
		Integer rowCount = queryDDVCount(model);
		model.getPager().setRowCount(rowCount);
		return mapper.queryDDVList(model);
	}

	public int queryDDVCount(DataParameterModel model) throws Exception {
		return mapper.queryDDVCount(model);
	}

	public int findTypeCnt(Map<String, Object> param) {

		return mapper.findTypeCnt(param);
	}

	public int addDDT(DataDictionaryType ddt) {

		return mapper.addDDT(ddt);
	}

	public DataDictionaryType findDDTById(Integer dictionary_type_id) {

		return mapper.findDDTById(dictionary_type_id);
	}

	public int updateDDT(DataDictionaryType ddt) {

		return mapper.updateDDT(ddt);
	}

	public int deleteDDT(Integer dictionary_type_id) {

		return mapper.deleteDDT(dictionary_type_id);
	}

	public int addDDV(DataDictionaryValue ddv) {

		return mapper.addDDV(ddv);
	}

	public DataDictionaryValue findDDVById(Integer dictionary_value_id) {

		return mapper.findDDVById(dictionary_value_id);
	}

	public int updateDDV(DataDictionaryValue ddv) {

		return mapper.updateDDV(ddv);
	}

	public int deleteDDV(Integer dictionary_value_id) {

		return mapper.deleteDDV(dictionary_value_id);
	}

	public List<DataDictionaryType> findTypeList() {

		return mapper.findTypeList();
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 条件查询全部数据，不进行分页
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionaryValue> queryDDVListWithoutPage(DataParameterModel model) throws Exception {
		Integer rowCount = queryDDTCount1(model);
		model.setRows(rowCount);
		model.getPager().setRowCount(rowCount);
		model.getPager().setPageOffset(0);
		return mapper.queryDDVList(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 根据字典中文名称查找typeId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Integer getTypeIdByTypeName(String typeName) throws Exception {

		DataParameterModel model = new DataParameterModel();
		model.setDictionary_type_name(typeName);
		List<DataDictionaryType> list = mapper.queryDDTList(model);
		if (list != null && list.size() == 1) {
			return list.get(0).getDictionary_type_id();
		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月29日
	 * @description 根据typeCode查找typeId
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	public Integer getTypeIdByTypeCode(String typeCode) throws Exception {

		DataParameterModel model = new DataParameterModel();
		model.setDictionary_type_code(typeCode);
		List<DataDictionaryType> list = mapper.queryDDTList(model);
		if (list != null && list.size() == 1) {
			return list.get(0).getDictionary_type_id();
		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月29日
	 * @description 根据字典key值获取对应的中文名称
	 * @return
	 * @throws Exception 
	 */
	public String getDictionaryValueNameBykey(String typeCode, Integer key) throws Exception {
		
		Integer typeId = getTypeIdByTypeCode(typeCode);
		DataParameterModel model = new DataParameterModel();
		model.setDictionary_type_id(typeId);
		model.setDictionary_value_key(key);
		List<DataDictionaryValue> list = mapper.queryDDVList(model);
		if(list != null && list.size() == 1){
			return list.get(0).getDictionary_value_name();
		}
		return null;
	}

}
