package com.aio.bean;

import javax.persistence.Embeddable;

@Embeddable
public class PrintTimesPk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3189377913561552068L;

	private String xh;

	private String item;

	public PrintTimesPk() {
	}

	public PrintTimesPk(String xh, String item) {
		this.xh = xh;
		this.item = item;
	}

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((xh == null) ? 0 : xh.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintTimesPk other = (PrintTimesPk) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (xh == null) {
			if (other.xh != null)
				return false;
		} else if (!xh.equals(other.xh))
			return false;
		return true;
	}

}