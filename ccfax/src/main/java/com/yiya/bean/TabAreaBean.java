package com.yiya.bean;


public class TabAreaBean extends BaseBean 
{

	private Integer area_id;
	private String area_name;
	private Integer area_parent_id;
	private Integer area_sort;
	private Integer area_deep;
	private Integer tesu_deleted;
	private String tesu_description;
	private Integer tesu_created;
	
	
	public TabAreaBean(){
		
	}
	
	public TabAreaBean(Integer area_deep,Integer area_id,Integer area_parent_id){
		this.area_id = area_id;
		this.area_parent_id = area_parent_id;
		this.area_deep = area_deep;		
	}
	
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Integer getArea_parent_id() {
		return area_parent_id;
	}
	public void setArea_parent_id(Integer area_parent_id) {
		this.area_parent_id = area_parent_id;
	}
	public Integer getArea_sort() {
		return area_sort;
	}
	public void setArea_sort(Integer area_sort) {
		this.area_sort = area_sort;
	}
	public Integer getArea_deep() {
		return area_deep;
	}
	public void setArea_deep(Integer area_deep) {
		this.area_deep = area_deep;
	}
	public Integer getTesu_deleted() {
		return tesu_deleted;
	}
	public void setTesu_deleted(Integer tesu_deleted) {
		this.tesu_deleted = tesu_deleted;
	}
	public String getTesu_description() {
		return tesu_description;
	}
	public void setTesu_description(String tesu_description) {
		this.tesu_description = tesu_description;
	}
	public Integer getTesu_created() {
		return tesu_created;
	}
	public void setTesu_created(Integer tesu_created) {
		this.tesu_created = tesu_created;
	}
	
	
	
	
	
}
