package com.taotao.mapper;

import com.taotao.pojo.TbItemDesc;

public interface TbItemDescMapper {
    /**
     * 将商品描述信息插入到数据库中
     * @param itemDesc 商品描述信息对象
     */
    void insert(TbItemDesc itemDesc);
}