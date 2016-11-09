package com.aio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintTimesView;
import com.aio.dao.PrintTimesViewDao;
import com.aio.exception.AioRuntimeException;
import com.aio.exception.DBException;
import com.aio.service.PrintTimesViewService;

@Transactional
@Service("printTimesViewService")
public class PrintTimesViewServiceImpl implements PrintTimesViewService {

	@Autowired
	private PrintTimesViewDao printTimesViewDao;

	@Override
	public List<PrintTimesView> getAllByXh(String xh) {
		try {
			List<PrintTimesView> list = printTimesViewDao.getAllByXh(xh);
			return list;
		} catch (AioRuntimeException e) {
			throw new DBException("数据库连接失败或者查询数据错误");
		}
	}

}