package com.aio.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MODIFIED_PRINT_TIMES_VIEW")
@IdClass(PrintTimesPk.class)
public class PrintTimesView {

	private String xh;

	private String item;

	private String describe;

	private String reNumber;

	@Id
	@Column(name = "xh")
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	@Column(name = "item")
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "describe")
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Column(name = "re_number")
	public String getReNumber() {
		return reNumber;
	}

	public void setReNumber(String reNumber) {
		this.reNumber = reNumber;
	}

}
