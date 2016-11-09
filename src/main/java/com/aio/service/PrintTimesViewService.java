package com.aio.service;

import java.util.List;

import com.aio.bean.PrintTimesView;

public interface PrintTimesViewService {

	public List<PrintTimesView> getAllByXh(String xh);

}