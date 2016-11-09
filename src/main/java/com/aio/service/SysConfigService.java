package com.aio.service;

import java.util.List;

import com.aio.bean.SysConfig;
import com.aio.exception.DBException;

public interface SysConfigService {

	public List<SysConfig> getAllSysConfig();

}