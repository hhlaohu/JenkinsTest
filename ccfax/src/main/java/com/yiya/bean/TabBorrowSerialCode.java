package com.yiya.bean;

import java.util.Date;

public class TabBorrowSerialCode {
	private Long id;

	private Byte borrow_type;

	private Integer serial_code;

	private Date create_time;

	public TabBorrowSerialCode() {

	}

	public TabBorrowSerialCode(Byte borrow_type,Integer serial_code,Date create_time) {

		this.borrow_type = borrow_type;
		this.serial_code = serial_code;
		this.create_time = create_time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getBorrow_type() {
		return borrow_type;
	}

	public void setBorrow_type(Byte borrow_type) {
		this.borrow_type = borrow_type;
	}

	public Integer getSerial_code() {
		return serial_code;
	}

	public void setSerial_code(Integer serial_code) {
		this.serial_code = serial_code;
	}

	public Date getcreate_time() {
		return create_time;
	}

	public void setcreate_time(Date create_time) {
		this.create_time = create_time;
	}
}