package com.yiya.utils;
import java.lang.reflect.Field;

import com.yiya.bean.TabUsrDecorationOrder;
import com.yiya.model.TabUsrDecorationOrderModel;

public class CopyProperties {
	 public static void copyPropertysWithoutNull(Object des, Object src){
	        Class<?> clazz = des.getClass();
	        Field[] srcfields=src.getClass().getDeclaredFields();
	        for(Field field:srcfields){
	            if(field.getName().equals("serialVersionUID"))
	                continue;
	            Field f;
	            try {
	                f = clazz.getDeclaredField(field.getName());
	                f.setAccessible(true);
	                field.setAccessible(true);
	                Object obj = field.get(src);
	                if(obj!=null)
	                    f.set(des,obj);
	            } catch (SecurityException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            catch (NoSuchFieldException e) {
	                // TODO Auto-generated catch block
	               // e.printStackTrace();
	            }
	            catch (IllegalArgumentException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
}



