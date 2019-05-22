package com.taotao.service;

import com.taotao.result.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {
    /**
     * 根据分类id查询分类信息
     * @param parentId 父级分类id
     * @return 返回一个EasyUITreeNode对象 中包含
     * 三个属性id name state（“closed”“open”）
     * closed 关闭 说明可关闭也可打开
     * open 打开就不能再打开了
     */
    List<EasyUITreeNode> getCatList(Long parentId);

}
