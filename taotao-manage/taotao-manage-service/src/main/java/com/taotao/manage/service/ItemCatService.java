package com.taotao.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;

@Service
public class ItemCatService extends BaseService<ItemCat> {

	/**
	 * Find item cat by parent id
	 * 
	 * @param parentId
	 *            The parent id of item cat
	 * @return A item cat <code>List</code> with same parent id given in parameter
	 */
	public List<ItemCat> findItemCatsByParentId(Long parentId) {
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);
		return this.queryListByWhere(itemCat);
	}
}
