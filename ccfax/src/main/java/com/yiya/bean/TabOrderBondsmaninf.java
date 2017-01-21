package com.yiya.bean;

public class TabOrderBondsmaninf {
	
    private Long id;

    private Long usr_order_id;

    private String rel_usrname;

    private Integer relation;

    private String rel_mobile_phone;
    
    public TabOrderBondsmaninf(){
    	
    }
    
    public TabOrderBondsmaninf(Long usr_order_id,String rel_usrname,Integer relation,String rel_mobile_phone){
    	
    	this.usr_order_id = usr_order_id;
    	this.rel_usrname = rel_usrname;
    	this.relation = relation;
    	this.rel_mobile_phone = rel_mobile_phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsr_order_id() {
        return usr_order_id;
    }

    public void setUsr_order_id(Long usr_order_id) {
        this.usr_order_id = usr_order_id;
    }

    public String getRel_usrname() {
        return rel_usrname;
    }

    public void setRel_usrname(String rel_usrname) {
        this.rel_usrname = rel_usrname == null ? null : rel_usrname.trim();
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getRel_mobile_phone() {
        return rel_mobile_phone;
    }

    public void setRel_mobile_phone(String rel_mobile_phone) {
        this.rel_mobile_phone = rel_mobile_phone == null ? null : rel_mobile_phone.trim();
    }
}