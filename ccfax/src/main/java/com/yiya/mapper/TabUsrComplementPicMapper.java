package com.yiya.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import com.yiya.bean.TabUsrComplementPic;
import com.yiya.bean.TabUsrOtherPic;


public interface TabUsrComplementPicMapper<T> extends BaseMapper<T> {
	
	public void update(TabUsrComplementPic tucp);
	
	public void add(TabUsrComplementPic  tucp);
	
	public void delete(TabUsrComplementPic  tucp);
	

	
}
