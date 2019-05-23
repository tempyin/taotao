package com.taotao.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyTest {
    @Test
    public void  show() throws IOException {

        /**
         * 使用ftp协议来上传图片到
         * ft图片服务器里面去
         */
        //1. 创建ftp 客户端对象 用客户段对象来上传图片
        FTPClient client = new FTPClient();
        //2.使用客户端对象去连接ftp服务器 输入主机的ip地址
        client.connect("192.168.61.128",21);
        //3.使用ftp客户端对象去登录 输入账号密码 都为ftpuser
        client.login("ftpuser","ftpuser");
        //解决上传图片有时候会出现0kb的情况
        client.enterLocalPassiveMode();
        //4.指定上传图片的类型 为二进制类型
        //5.需要一个流对象 来上传图片 pathname 图片在该电脑所在的位置
        FileInputStream fis = new FileInputStream(new File("F:\\image\\2.jpg"));
        //开始上传 上传的图片路径和图片名称   和你需要上传的图片流对象
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.storeFile("/home/ftpuser/www/images/aaa.jpg",fis);
        //6.登出ftp服务器
        client.logout();
    }

}
