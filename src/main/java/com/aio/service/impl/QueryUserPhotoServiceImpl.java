package com.aio.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aio.bean.XsZpView;
import com.aio.dao.QueryUserPhotoDao;
import com.aio.exception.AioRuntimeException;
import com.aio.exception.DBException;
import com.aio.service.QueryUserPhotoService;

@Transactional
@Service("queryUserPhotoService")
public class QueryUserPhotoServiceImpl implements QueryUserPhotoService {

	@Autowired
	private QueryUserPhotoDao queryUserPhotoDao;

	@Override
	public XsZpView getUserPhotoByXh(String xh) throws DBException {
		XsZpView xsZpView;
		try {
			xsZpView = queryUserPhotoDao.getByXh(xh);
			return xsZpView;
		} catch (AioRuntimeException e) {
			throw new DBException("连接数据库失败或者查询数据出错");
		}

	}

}
