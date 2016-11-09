package com.aio.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PRINT_TIMES")
@IdClass(PrintTimesPk.class)
public class PrintTimes {

	private String xh;

	private String item;

	private int numberOfPrint;

	@Id
	@Column(name = "xh")
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	@Id
	@Column(name = "item")
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "number_of_print")
	public int getNumberOfPrint() {
		return numberOfPrint;
	}

	public void setNumberOfPrint(int numberOfPrint) {
		this.numberOfPrint = numberOfPrint;
	}

}
