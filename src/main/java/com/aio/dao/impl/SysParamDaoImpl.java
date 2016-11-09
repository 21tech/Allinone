package com.aio.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintTimes;
import com.aio.bean.SysParam;
import com.aio.dao.SysParamDao;
import com.aio.exception.AioRuntimeException;

@Transactional
@Repository("sysParamDao")
public class SysParamDaoImpl extends BaseDaoImpl<SysParam, String> implements SysParamDao {

	 
	@Override
	public List<SysParam> getAll() {
		try {
			String sql ="select * from sys_param order by id asc";
			List<SysParam> result =super.getListBySQLCastToClass(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AioRuntimeException(e);
		}
	}

	@Override
	public int saveAll(SysParam s) {
		try {
			super.save(s);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AioRuntimeException(e);
		}
	}

	@Override
	public int delete() {
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

}