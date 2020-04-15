package com.xzsd.app.cos.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.cos.entity.CosInfo;
import com.xzsd.app.util.COSClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CosService {

    /**
     * 图片上传
     * @author xiekai
     * @time 2020-04-13
     */
    public AppResponse uploadImage(List<MultipartFile> imageFile) {
        COSClientUtil cosClientUtil = new COSClientUtil();
        String name, imageUrl;
        String  url = "";
        try {
            if(imageFile.size() == 1){
                //上传一张图片
                name = cosClientUtil.uploadFile2Cos(imageFile.get(0));
                imageUrl = cosClientUtil.getImgUrl(name);
                String[] split = imageUrl.split("\\?");
                url = split[0];
            }else if(imageFile.size() > 1){
                //上传多张图片
                for (MultipartFile image : imageFile) {
                    name = cosClientUtil.uploadFile2Cos(image);
                    imageUrl = cosClientUtil.getImgUrl(name);
                    String[] split = imageUrl.split("\\?");
                    url = url + split[0] + ",";
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url);
        CosInfo cosInfo = new CosInfo();
        cosInfo.setImagePath(url);
        return AppResponse.success("图片上传成功！", cosInfo);
    }
}
