package com.aio.service;

import com.aio.bean.XsZpView;
import com.aio.exception.DBException;

public interface QueryUserPhotoService {

	public XsZpView getUserPhotoByXh(String xh);

}
