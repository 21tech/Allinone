package com.aio.dao;

import java.util.List;

import com.aio.bean.PrintConfig;

public interface PrintConfigDao {
	
	public PrintConfig getById(String PK);
	
	public List<PrintConfig> getAll();

	public String saveAll(PrintConfig s);

	public int delete();

	public int update();
}