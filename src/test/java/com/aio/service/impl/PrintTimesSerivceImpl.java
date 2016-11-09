package com.aio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aio.bean.PrintTimes;
import com.aio.exception.DBException;
import com.aio.exception.NullUserGradeException;
import com.aio.service.PrintTimesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
public class PrintTimesSerivceImpl {

	@Autowired
	private PrintTimesService printTimesService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCurrentScoresByXh() {

		try {
			List<PrintTimes> list = new ArrayList<PrintTimes>();
			PrintTimes a = new PrintTimes();
			a.setItem("a");
			a.setXh("111");
			a.setNumberOfPrint(2);
			printTimesService.save(a);

		} catch (NullUserGradeException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
