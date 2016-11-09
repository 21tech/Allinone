package com.aio.dao;

import java.util.List;

import com.aio.bean.PrintItems;

public interface PrintItemsDao {
    	
	public List<PrintItems> getAll();

	public int saveAll(PrintItems s);

	public int delete();

	public int update();
}