package com.yiya.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yiya.model.TabUsrinf2Model;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月21日
 * @description
 */
public class TabUsrinf2Validator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		
		return TabUsrinf2Model.class.equals(arg0);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		
		TabUsrinf2Model model = (TabUsrinf2Model) obj;  
	    ValidationUtils.rejectIfEmpty(errors, "id_card", null, "id_card is empty.");  
	}
	
	
}
