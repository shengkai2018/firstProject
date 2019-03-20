package com.link.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link.dao.ItemCatMapper;
import com.link.pojo.ItemCat;
import com.link.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private ItemCatMapper itemCatMapper;
	
	/*
	 * 查询商品类目
	 * @see com.link.service.ItemCatService#getItemCatList()
	 */
	@Override
	public List<ItemCat> getItemCatList() {
		List<ItemCat> list=itemCatMapper.queryAll();
		
		return list;
	}

}
