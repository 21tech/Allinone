package com.aio.dao;

import java.util.List;

import com.aio.bean.PrintItems;
import com.aio.bean.PrintTimesView;

public interface PrintTimesViewDao {

	public List<PrintTimesView> getAllByXh(String xh);

}