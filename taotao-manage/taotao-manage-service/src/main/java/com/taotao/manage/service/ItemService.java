package com.taotao.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;

/**
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @date 2017年8月30日
 */
@Service
public class ItemService extends BaseService<Item> {

	@Autowired
	private ItemDescService itemDescService;

	/**
	 * Save item and item desc
	 * 
	 * @param item
	 * @param desc
	 */
	public void saveItem(Item item, String desc) {
		item.setId(null);
		item.setStatus(1);
		super.save(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(item.getId());
		this.itemDescService.save(itemDesc);
	}
}
