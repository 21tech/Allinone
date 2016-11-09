package com.aio.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aio.bean.PrintTimesView;
import com.aio.dao.PrintTimesViewDao;
import com.aio.exception.AioRuntimeException;

@Transactional
@Repository("printTimesViewDao")
public class PrintTimesViewDaoImpl extends BaseDaoImpl<PrintTimesView, String> implements PrintTimesViewDao {

	@Override
	public List<PrintTimesView> getAllByXh(String xh) {
		try {
			String sql = "select * from modified_print_times_view where xh=?";
			List<PrintTimesView> result = super.getListBySQLCastToClass(sql, xh);
			return result;
		} catch (Exception e) {
			throw new AioRuntimeException(e);
		}
	}

}