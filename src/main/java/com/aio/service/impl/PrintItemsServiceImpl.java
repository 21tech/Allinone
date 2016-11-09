package com.aio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintItems;
import com.aio.dao.PrintItemsDao;
import com.aio.exception.AioRuntimeException;
import com.aio.exception.DBException;
import com.aio.service.PrintItemsService;

@Transactional
@Service("printItemsService")
public class PrintItemsServiceImpl implements PrintItemsService {

	@Autowired
	private PrintItemsDao printItemsDao;

	@Override
	public List<PrintItems> getAll() throws DBException {
		try {
			List<PrintItems> list = printItemsDao.getAll();
			return list;
		} catch (AioRuntimeException e) {
			throw new DBException("数据库连接失败或者查询数据错误");
		}

	}

}