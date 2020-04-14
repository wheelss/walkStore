package com.xzsd.pc.topColumn.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topColumn.service.TopColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("topOfColumn")
public class TopColumnController {
    public static final Logger logger = LoggerFactory.getLogger(TopColumnController.class);

    @Resource
    private TopColumnService topColumnService;

    /**
     * 查询顶部栏
     */
    @PostMapping("getTopOfColumn")
    public AppResponse getTopColumn(){
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return topColumnService.getTopColumn(userId);
        }catch (Exception e){
            logger.error("查询顶部栏失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
