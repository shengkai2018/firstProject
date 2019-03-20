package com.link.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.link.pojo.ItemCat;
import com.link.service.ItemCatService;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List getItemCat(){
		List<ItemCat> list=itemCatService.getItemCatList();
		
		List catList=new ArrayList();
		for(ItemCat itemCat:list){
			Map node=new HashMap();
			node.put("id", itemCat.getId());
			node.put("text", itemCat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.put("state", itemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}
}
