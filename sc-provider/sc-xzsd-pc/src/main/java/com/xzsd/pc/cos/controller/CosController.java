package com.xzsd.pc.cos.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.cos.service.CosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/imageUpload")
public class CosController {
    private static final Logger logger = LoggerFactory.getLogger(CosController.class);

    @Resource
    private CosService cosService;

    /**
     * 图片上传
     * @param imageFile
     * @return
     * @time 2020-4-13
     */
    @PostMapping("uploadImage")
    public AppResponse uploadImage(List<MultipartFile> imageFile) {
        try{
            return cosService.uploadImage(imageFile);
        }catch (Exception e){
            logger.error("图片上传失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
