package com.taotao.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taotao.manage.pojo.ItemDesc;
import com.taotao.manage.service.ItemDescService;

@Controller
@RequestMapping("item/desc")
public class ItemDescController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ItemDescController.class);

	@Autowired
	private ItemDescService itemDescService;

	/**
	 * 根据ID查询商品描述
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "{itemId}", method = RequestMethod.GET)
	public ResponseEntity<ItemDesc> queryItemDescById(
			@PathVariable("itemId") Long itemId) {
		try {
			ItemDesc desc = this.itemDescService.queryById(itemId);
			return ResponseEntity.ok(desc);
		} catch (Exception e) {
			LOGGER.error("查询商品描述失败 itemId = " + itemId);
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				null);
	}
	
	
}
