package com.aio.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintTimes;
import com.aio.dao.PrintTimesDao;
import com.aio.exception.AioRuntimeException;

@Transactional
@Repository("printTimesDao")
public class PrintTimesDaoImpl extends BaseDaoImpl<PrintTimes, String> implements PrintTimesDao {

	@Override
	public int saveAll(PrintTimes s) {
		try {
			super.save(s);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AioRuntimeException(e);
		}

	}

}