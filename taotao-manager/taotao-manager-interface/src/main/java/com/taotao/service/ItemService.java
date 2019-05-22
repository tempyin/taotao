package com.taotao.service;

import com.taotao.pojo.TbItem;
import com.taotao.result.EasyUIResult;

public interface ItemService {
	/**
	 * 查询得到商品信息
	 * @param itemId 商品id
	 * @return 指定商品id的商品信息
	 */
	TbItem findTbItemById(Integer itemId);

	/**
	 * 根据查询 显示分页的商品信息
	 * @param page 当前页面
	 * @param rows 每一页显示的记录条数
	 * @return EasyUIResult 中有在total 总记录条数 rows每一页显示的商品集合
	 */
	EasyUIResult getItemList( Integer page,Integer rows);
}
