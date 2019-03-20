package com.link.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.link.dao.ItemMapper;
import com.link.pojo.Item;

public class PageTest {

	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		ItemMapper mapper = applicationContext.getBean(ItemMapper.class);

		//分页处理
		PageHelper.startPage(2, 3);
		List<Item> list = mapper.queryAll();
		//取商品列表
		for (Item item : list) {
			System.out.println(item.getTitle());
		}
		//取分页信息
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);
		
	}

}
