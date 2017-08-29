package com.taotao.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.manage.pojo.ItemCat;
import com.taotao.manage.service.ItemCatService;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	/**
	 * Find item cat by parent id
	 * 
	 * @param parentId
	 *            The parent id of item cat
	 * @return A json format data for <code>List</code> item cat
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemCat>> queryItemCatByParentId(
			@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		try {
			List<ItemCat> itemCatList = this.itemCatService.findItemCatsByParentId(parentId);
			if (itemCatList == null || itemCatList.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			} else {
				return ResponseEntity.ok(itemCatList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
