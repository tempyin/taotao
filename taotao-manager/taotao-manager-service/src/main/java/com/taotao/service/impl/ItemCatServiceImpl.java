package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.result.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
   @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getCatList(Long parentId) {
        List<TbItemCat> itemCats = itemCatMapper.findItemCatByParentId(parentId);
        List<EasyUITreeNode> result = new ArrayList<EasyUITreeNode>();
        for(TbItemCat itemCat:itemCats){
            EasyUITreeNode node  = new EasyUITreeNode();
            //设置id
            node.setId(itemCat.getId());
            //设置name
            node.setText(itemCat.getName());
            //设置状态 关闭 或者打开 itemCat 中的isparent 判断是不是父表
            node.setState(itemCat.getIsParent()?"closed":"open");
            result.add(node);
        }
        //最后在applicationContext配置文件中配置dubbo
        return result;
    }
}
