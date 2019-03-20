package com.link.service;

import java.util.List;

import com.link.pojo.Item;
import com.link.pojo.EUDataGridResult;

public interface ItemService {
	
//	List<Item> loadItem();
	
	Item getItemById(long id);
	
	EUDataGridResult getItemList(int page, int rows);
	
}
