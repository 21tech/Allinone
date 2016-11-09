package com.aio.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintConfig;
import com.aio.dao.PrintConfigDao;
import com.aio.exception.AioRuntimeException;

@Transactional
@Repository("printConfigDao")
public class PrintConfigDaoImpl extends BaseDaoImpl<PrintConfig, String> implements PrintConfigDao {

	@Override
	public PrintConfig getById(String id) {
		try {
			PrintConfig result = super.get(id);
			return result;
		} catch (Exception e) {
			throw new AioRuntimeException(e);
		}
	}

	@Override
	public int delete() {
		return 0;
	}

	@Override
	public int update() {
		return 0;
	}

	@Override
	public String saveAll(PrintConfig s) {
		return null;
	}

	@Override
	public List<PrintConfig> getAll() {
		return null;
	}
}