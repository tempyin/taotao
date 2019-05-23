package com.taotao.service;

import com.taotao.result.PictureResult;

public interface PictureService {
    /**
     *  页面jsp会把商品信息发送到controller
     *      controller可以直接用对象去接收 如果的是图片类型
     *     可以用MultipartFile 来接 但要把所有东西都放在一个集合对象中去
     *     把对象作为参数发送到service 里去执行逻辑 在调用dao层执行sql语句
     *     储存到数据库中  dubbo不能传递MultipartFile 这类数据
     *     所以MultipartFile 通过springmvc 可以变成byte数组
     *     dubbo可以传递byte数组 byte数组里面放的是图片的二进制数据
     */
    /**
     *上传图片的方法
     * @param bytes 图片的byte数组 表示图片
     * @param name 图片的名称
     * @return  PictureResult对象 三个属性 error（0表示成功 1表示失败）
     * url 上传以后图片的地址 message（200 500 404 ）
     * 发送给web 根据状态 判断是否上传成功
     */
    PictureResult uploadFile(byte[] bytes, String name);
}
