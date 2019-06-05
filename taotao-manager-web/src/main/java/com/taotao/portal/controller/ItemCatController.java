package com.taotao.controller;

import com.taotao.result.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
// 首先要去springmvc配置文件中配置dubbo
//窄化映射
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    //网页传递过来的参数 为id 默认有初始值为0 将初始值赋值给parentId
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

        final List<EasyUITreeNode> result = itemCatService.getCatList(parentId);
        return result;
    }
}
