package com.taotao.mapper;

import com.taotao.pojo.TbItem;

import java.util.List;

public interface TbItemMapper {

	TbItem findTbItemById(Integer itemId);

	/**
	 * 查询所有商品信息
	 * @return 返回所有商品信息的集合
	 */
	List<TbItem> findItems();
	
}