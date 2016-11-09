package com.aio.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintItems;
import com.aio.bean.PrintTimes;
import com.aio.dao.PrintItemsDao;
import com.aio.exception.AioRuntimeException;

@Transactional
@Repository("printItemsDao")
public class PrintItemsDaoImpl extends BaseDaoImpl<PrintItems, String> implements PrintItemsDao {

	@Override
	public int saveAll(PrintItems s) {
		try {
			super.save(s);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AioRuntimeException(e);
		}

	}

	@Override
	public List<PrintItems> getAll() {
		try {

			String sql = "select * from print_items";
			List<PrintItems> result = super.getListBySQLCastToClass(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AioRuntimeException(e);
		}
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

}