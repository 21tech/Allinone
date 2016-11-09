package com.aio.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aio.bean.PrintTimesView;
import com.aio.service.PrintTimesViewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
public class PrintTimesViewSerivceImpl {

	@Autowired
	private PrintTimesViewService printTimesViewService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAllByXh() {
		try {
			List<PrintTimesView> ptv = printTimesViewService.getAllByXh("20122125111");
			if (!ptv.isEmpty()) {
				for (PrintTimesView tmp : ptv) {
					System.out.println(tmp.getXh());
					System.out.println(tmp.getDescribe());
					System.out.println(tmp.getItem());
					System.out.println(tmp.getReNumber());
				}
			}else{
				System.out.println("空");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
