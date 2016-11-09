package com.aio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintTimes;
import com.aio.dao.PrintTimesDao;
import com.aio.exception.AioRuntimeException;
import com.aio.exception.DBException;
import com.aio.service.PrintTimesService;

@Transactional
@Service("printTimesService")
public class PrintTimesServiceImpl implements PrintTimesService {

	@Autowired
	private PrintTimesDao printTimesDao;

	@Override
	public int save(PrintTimes s) {
		try {
			printTimesDao.saveAll(s);
			return 0;
		} catch (AioRuntimeException e) {
			throw new DBException("数据库连接失败或者插入数据错误");
		}

	}

}