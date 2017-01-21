package com.yiya.bean;

public class TabUsrOrderPic {
    private Long id;

    private Long usr_order_id;

    private String pic_desc;

    private String pic_addr;

    private String order_sn;

    private Byte is_code;

    private Byte sequence;

    private Byte pic_type;
    
    
    public TabUsrOrderPic(){
    	
    }
    
    public TabUsrOrderPic(String order_sn){
    	
    	this.order_sn = order_sn;
    }
    
    public TabUsrOrderPic(String order_sn,Byte pic_type,String pic_addr){
    	
    	this.order_sn = order_sn;
    	this.pic_type = pic_type;
    	this.pic_addr = pic_addr;
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

    public String getPic_desc() {
        return pic_desc;
    }

    public void setPic_desc(String pic_desc) {
        this.pic_desc = pic_desc == null ? null : pic_desc.trim();
    }

    public String getPic_addr() {
        return pic_addr;
    }

    public void setPic_addr(String pic_addr) {
        this.pic_addr = pic_addr == null ? null : pic_addr.trim();
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn == null ? null : order_sn.trim();
    }

    public Byte getIs_code() {
        return is_code;
    }

    public void setIs_code(Byte is_code) {
        this.is_code = is_code;
    }

    public Byte getSequence() {
        return sequence;
    }

    public void setSequence(Byte sequence) {
        this.sequence = sequence;
    }

    public Byte getPic_type() {
        return pic_type;
    }

    public void setPic_type(Byte pic_type) {
        this.pic_type = pic_type;
    }
}