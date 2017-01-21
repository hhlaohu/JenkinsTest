package com.yiya.model;

public class CustomerNoteModel extends BaseModel {
	private int note_id; //主键id
	private String note_time;// '备注时间',
	private String note_content; //'备注内容',
	private String note_person;// '备注人',
	private int  customer_id; //客户id
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int noteId) {
		note_id = noteId;
	}
	public String getNote_time() {
		return note_time;
	}
	public void setNote_time(String noteTime) {
		note_time = noteTime;
	}
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String noteContent) {
		note_content = noteContent;
	}
	public String getNote_person() {
		return note_person;
	}
	public void setNote_person(String notePerson) {
		note_person = notePerson;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customerId) {
		customer_id = customerId;
	}
}
