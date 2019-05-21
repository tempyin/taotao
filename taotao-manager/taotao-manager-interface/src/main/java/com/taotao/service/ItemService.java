package com.taotao.service;

import com.taotao.pojo.TbItem;

public interface ItemService {
	/**
	 * 查询得到商品信息
	 * @param itemId 商品id
	 * @return 指定商品id的商品信息
	 */
	TbItem findTbItemById(Integer itemId);
}
