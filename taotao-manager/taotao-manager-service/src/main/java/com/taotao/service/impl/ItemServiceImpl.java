package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.result.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
	// alt + 回车
	@Autowired
	private TbItemMapper tbItemMapper;
	public TbItem findTbItemById(Integer itemId) {
		return tbItemMapper.findTbItemById(itemId);
	}

	@Override
	public EasyUIResult getItemList(Integer page, Integer rows) {
		//使用分页插件 设置我们的分页信息
		PageHelper.startPage(page, rows);
		List<TbItem> items = tbItemMapper.findItems();
		//获取分页信息 表示从所有的商品集合里面分出30个商品集合对象 而且是根据当前分页出来的
		PageInfo<TbItem> pageInfo = new PageInfo<>(items);
		//只要使用了 pageinfo去关联了所有商品集合后 这个商品集合对象就只成了30个对象集合
		EasyUIResult result = new EasyUIResult(pageInfo.getTotal(),items);
		return result;
	}

}
