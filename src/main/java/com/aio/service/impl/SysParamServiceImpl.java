package com.aio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.SysParam;
import com.aio.dao.SysParamDao;
import com.aio.exception.AioRuntimeException;
import com.aio.exception.DBException;
import com.aio.service.SysParamService;

@Transactional
@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService {

	@Autowired
	private SysParamDao sysParamDao;

	@Override
	public List<SysParam> getAll() throws DBException {
		try {
			List<SysParam> list = sysParamDao.getAll();
			return list;
		} catch (AioRuntimeException e) {
			throw new DBException("数据库连接失败或者查询数据错误");
		}

	}

}