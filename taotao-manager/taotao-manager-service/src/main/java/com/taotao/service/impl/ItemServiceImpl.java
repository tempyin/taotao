package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import com.taotao.result.EasyUIResult;
import com.taotao.result.TaotaoResult;
import com.taotao.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
	// alt + 回车
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;

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

	@Override
	public TaotaoResult addItem(TbItem tbItem, String desc) {
		//设置商品id 生成随机id
		Long id = IDUtils.genItemId();
		//设置商品时间 生成时间
		Date time = new Date();
		//设置商品状态 上架还是下架
		tbItem.setStatus((byte) 1);
		//将id 和时间设置进去
		tbItem.setId(id);
		tbItem.setCreated(time);
		tbItem.setUpdated(time);
		tbItemMapper.insert(tbItem);
		TbItemDesc itemDesc = new TbItemDesc();
		//设置商品描述类中的ItemId
		itemDesc.setItemId(id);
		//时间
		itemDesc.setCreated(time);
		itemDesc.setUpdated(time);
		//设置商品描述
		itemDesc.setItemDesc(desc);
		tbItemDescMapper.insert(itemDesc);
		/**
		 * 返回TaotaoResult.ok() 要将数据json传入页面
		 *
		 */
		return TaotaoResult.ok();
	}

}
