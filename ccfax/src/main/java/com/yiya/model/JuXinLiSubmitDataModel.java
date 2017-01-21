package com.yiya.model;

public class JuXinLiSubmitDataModel {
     private String usr_name;
     private String id_card;
     private String cell_phone;
     private String home_addr;
     private String work_tel;
     private String work_addr;
     private String home_tel;
     private String bondsmaninf_list;

	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getCell_phone() {
		return cell_phone;
	}
	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}
	public String getHome_addr() {
		return home_addr;
	}
	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}
	public String getWork_tel() {
		return work_tel;
	}
	public void setWork_tel(String work_tel) {
		this.work_tel = work_tel;
	}
	public String getWork_addr() {
		return work_addr;
	}
	public void setWork_addr(String work_addr) {
		this.work_addr = work_addr;
	}
	public String getHome_tel() {
		return home_tel;
	}
	public void setHome_tel(String home_tel) {
		this.home_tel = home_tel;
	}
	public String getBondsmaninf_list() {
		return bondsmaninf_list;
	}
	public void setBondsmaninf_list(String bondsmaninf_list) {
		this.bondsmaninf_list = bondsmaninf_list;
	}
	@Override
	public String toString() {
		return "JuXinLiSubmitDataModel [usr_name=" + usr_name + ", id_card=" + id_card + ", cell_phone=" + cell_phone
				+ ", home_addr=" + home_addr + ", work_tel=" + work_tel + ", work_addr=" + work_addr + ", home_tel="
				+ home_tel + ", bondsmaninf_list=" + bondsmaninf_list + "]";
	}
     
}
