package com.link.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.link.pojo.Item;
import com.link.pojo.EUDataGridResult;
import com.link.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/*
	 * 首页
	 */
	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}
	
	/*
	 * 展示其他页面
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}

	/*@RequestMapping("/showItem")
	public List<Item> showItem(){
		List<Item> item=itemService.loadItem();
		
		return item;
	}*/
	
	@RequestMapping("/item/{id}")
	@ResponseBody
	public Item getItemById(@PathVariable long id){
		Item item=itemService.getItemById(id);
		if(item != null){
			return item;
		}
		
		return null;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

}
