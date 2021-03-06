package com.aio.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aio.exception.DBException;
import com.aio.exception.NullUserGradeException;
import com.aio.service.QueryGradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
public class QueryGradeServiceImplTest  {

	@Autowired
	private QueryGradeService queryGradeService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCurrentScoresByXh() {

		try {
			List r = queryGradeService.getCurrentGradeByXh("2013211090");
		} catch (NullUserGradeException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
