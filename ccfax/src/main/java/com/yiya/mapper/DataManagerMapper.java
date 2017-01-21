package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.DataDictionaryType;
import com.yiya.bean.DataDictionaryValue;
import com.yiya.model.DataParameterModel;


public interface DataManagerMapper<T> extends BaseMapper<T> {

	List<DataDictionaryType> queryDDTList(DataParameterModel model);

	int queryDDTCount(DataParameterModel model);

	List<DataDictionaryValue> queryDDVList(DataParameterModel model);

	int queryDDVCount(DataParameterModel model);

	int findTypeCnt(Map<String, Object> param);

	int addDDT(DataDictionaryType ddt);

	DataDictionaryType findDDTById(Integer dictionary_type_id);

	int updateDDT(DataDictionaryType ddt);

	int deleteDDT(Integer dictionary_type_id);

	int addDDV(DataDictionaryValue ddv);

	DataDictionaryValue findDDVById(Integer dictionary_value_id);

	int updateDDV(DataDictionaryValue ddv);

	int deleteDDV(Integer dictionary_value_id);

	List<DataDictionaryType> findTypeList();

	int queryDDTCount1(DataParameterModel model);

}
