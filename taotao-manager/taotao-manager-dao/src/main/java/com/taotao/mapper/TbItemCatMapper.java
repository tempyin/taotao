package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.TbItemCat;

public interface TbItemCatMapper {
    /**
     * 查询指定分类信息  根据parentid
     * @param parentId  指定的parentid
     * @return 返回一个集合
     */
    List<TbItemCat> findItemCatByParentId(Long parentId);
}