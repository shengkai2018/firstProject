package com.link.dao;

import java.util.List;

import com.link.pojo.Item;

public interface ItemMapper {
	
	Item selectById(long id);
	
	List<Item> queryAll();
}
