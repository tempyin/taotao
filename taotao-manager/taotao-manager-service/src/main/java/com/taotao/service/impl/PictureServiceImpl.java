package com.taotao.service.impl;

import com.taotao.result.PictureResult;
import com.taotao.service.PictureService;
import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;//地址 ip
    @Value("${FTP_PORT}")
    private Integer FTP_PORT; //端口号
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;//账号
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;//密码
    @Value("${FILI_UPLOAD_PATH}")
    private String FILI_UPLOAD_PATH;//上传图片的路劲
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;//路径

    @Override
    public PictureResult uploadFile(byte[] bytes, String name) {
        /**
         * 调用上传图片的工具类
         *byte数组变回图片
         * htpclient.storeFile（）需要inputSteam对象
         * 将byte数组 变成inputsteam
         */
        PictureResult result = new PictureResult();
        try{
            //将byte数组变成  inputsteam 的子类
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            //name 表示图片的名称 得到后缀名
            String newName = IDUtils.genImageName()+name.substring(name.lastIndexOf("."));
            //以当前年月日生成的字符串
            String filepath = new DateTime().toString("yyy/MM/dd");
            FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FTP_PASSWORD,FILI_UPLOAD_PATH,filepath,newName,bis);
            result.setError(0);
            result.setUrl(IMAGE_BASE_URL+"/"+filepath+"/"+newName);
            result.setMessage("成功");
        }catch (Exception ex){
            ex.printStackTrace();
            result.setError(1);
            result.setMessage("不成功");
        }


        return result;
    }
}
