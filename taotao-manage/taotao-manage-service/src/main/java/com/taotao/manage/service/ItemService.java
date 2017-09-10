package com.taotao.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;
import com.taotao.manage.pojo.ItemParamItem;

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

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
    private ItemParamItemService itemParamItemService;


	/**
	 * Save item and item desc
	 * 
	 * @param item
	 * @param desc
	 */
	public void saveItem(Item item, String desc,String itemParams) {
		item.setId(null);
		item.setStatus(1);
		super.save(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(item.getId());
		this.itemDescService.save(itemDesc);
		
		// 保存规格参数数据
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(item.getId());
        itemParamItem.setParamData(itemParams);
        this.itemParamItemService.save(itemParamItem);
	}

	/**
	 * 分页查询所有商品
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Item> queryItemPage(Integer page, Integer rows) {
		Example example = new Example(Item.class);
		example.setOrderByClause("updated DESC");

		/**
		 * 进行分页
		 */
		PageHelper.startPage(page, rows);
		List<Item> list = this.itemMapper.selectByExample(example);
		return new PageInfo<>(list);

	}

	/**
	 * 修改商品
	 * @param item
	 * @param desc
	 */
	public void updateItem(Item item, String desc) {
		item.setStatus(null);
		item.setCreated(null);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(item.getId());
		super.updateSelective(item);
		this.itemDescService.updateSelective(itemDesc);

	}
}
