package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper tbItemMapper;
	public TbItem findTbItemById(Integer itemId) {
		return tbItemMapper.findTbItemById(itemId);
	}

}
