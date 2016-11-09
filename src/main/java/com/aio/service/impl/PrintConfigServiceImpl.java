package com.aio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintConfig;
import com.aio.dao.PrintConfigDao;
import com.aio.exception.AioRuntimeException;
import com.aio.exception.DBException;
import com.aio.service.PrintConfigService;

@Transactional
@Service("PrintConfigService")
public class PrintConfigServiceImpl implements PrintConfigService {

	@Autowired
	private PrintConfigDao printConfigDao;

	@Override
	public PrintConfig getById(String PK) {
		try {
			PrintConfig result = printConfigDao.getById(PK);
			return result;
		} catch (AioRuntimeException e) {
			throw new DBException("数据库连接失败或者查询数据错误");
		}
	}

}