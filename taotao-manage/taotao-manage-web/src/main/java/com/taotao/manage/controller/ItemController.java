package com.taotao.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIResult;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {

	/**
	 * 总结： 1、 方法的入参处需要将参数打印出 2、 业务执行的状态发生变化时，需要打印 3、 异常处需要打印
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	/**
	 * 新增商品
	 * @param desc
	 * @param item
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveItem(@RequestParam("desc") String desc,
			Item item,@RequestParam("itemParams") String itemParams) {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("新增商品  item={},desc={}", item, desc);
		}
		try {
			this.itemService.saveItem(item, desc,itemParams);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("新增商品成功  item={},desc={}", item, desc);
			}
			//返回状态码201
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			LOGGER.error("新增商品失败：title= " + item.getTitle() + "desc = " + desc);
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<EasyUIResult> queryItemsList(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "30") Integer rows) {
		try {
			PageInfo<Item> pageInfo = this.itemService
					.queryItemPage(page, rows);
			EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(),
					pageInfo.getList());

			return ResponseEntity.ok(easyUIResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				null);
	}
	
	
	/**
	 * 修改商品
	 * @param desc
	 * @param item
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateItem(@RequestParam("desc") String desc,
			Item item) {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("修改商品  item={},desc={}", item, desc);
		}
		try {
			this.itemService.updateItem(item, desc);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("修改商品成功  item={},desc={}", item, desc);
			}
			//返回状态码204
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			LOGGER.error("修改商品失败：title= " + item.getTitle() + "desc = " + desc);
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}


}
