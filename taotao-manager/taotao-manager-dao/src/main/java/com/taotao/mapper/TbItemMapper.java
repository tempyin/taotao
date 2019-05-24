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

	/**
	 * 将TbItem 对象添加到数据库中
	 * @param tbItem TbItem 对象
	 */
    void insert(TbItem tbItem);
}