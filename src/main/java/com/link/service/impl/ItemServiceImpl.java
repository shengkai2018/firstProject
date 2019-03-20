package com.link.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.link.dao.ItemMapper;
import com.link.pojo.Item;
import com.link.pojo.EUDataGridResult;
import com.link.service.ItemService;
/**
 * 商品管理service
 * @author sheng
 *
 */
@Service("ItemService")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemMapper itemMapper;
	
	/*
	 * 查询所有商品信息
	 * @see com.link.service.ItemService#loadItem()
	 */
	/*@Override
	public List<Item> loadItem() {
		return itemMapper.queryAll();
	}*/

	/*
	 * 根据id查询商品
	 * @see com.link.service.ItemService#getItemById(long)
	 */
	@Override
	public Item getItemById(long id) {
		Item item=itemMapper.selectById(id);
		return item;
	}

	/*
	 * 商品列表（分页查询）
	 * @see com.link.service.ItemService#getItemList(long, long)
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Item> list=itemMapper.queryAll();
		
		//创建返回值对象
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());

		return result;
	}

}
