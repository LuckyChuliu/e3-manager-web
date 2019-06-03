package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCatService;

@Controller
public class ContentCatController {
	
	@Autowired
	private ContentCatService contentCatService;
	
	@RequestMapping("content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> showContentCatList(@RequestParam(name="id",defaultValue="0") Long parentId){
		List<EasyUITreeNode> result = contentCatService.getContentCatList(parentId);
		return result;
	} 
	
	@RequestMapping(value="/content/category/create",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addContentCategory(Long parentId , String name) {
		E3Result result = contentCatService.addContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public E3Result renameContentCategory(Long id , String name) {
		E3Result result = contentCatService.renameContentCategory(id, name);
		return result;
	}
	
	@RequestMapping("/content/category/delete/")
	@ResponseBody
	public E3Result delContentCategory(Long id) {
		E3Result result = contentCatService.delContentCategory(id);
		return result;
	}

}
