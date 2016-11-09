package com.aio.dao;

import java.util.List;

import com.aio.bean.PrintItems;
import com.aio.bean.SysParam;

public interface SysParamDao {
    	
	public List<SysParam> getAll();

	public int saveAll(SysParam s);

	public int delete();

	public int update();
}