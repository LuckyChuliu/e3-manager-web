package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem item , String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
	
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public E3Result deleteItem(Long ids) {
		E3Result result = itemService.deleteItemById(ids);
		return result;
	}
	
	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public E3Result instockItem(long ids) {
		E3Result result = itemService.instockItem(ids);
		return E3Result.ok();
	}
		
	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public E3Result reshelfItem(long ids) {
		E3Result result = itemService.reshelfItem(ids);
		return E3Result.ok();
	}
}
