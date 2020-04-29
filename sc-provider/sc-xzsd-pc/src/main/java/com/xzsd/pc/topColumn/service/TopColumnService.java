package com.xzsd.pc.topColumn.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.topColumn.dao.TopColumnDao;
import com.xzsd.pc.topColumn.entity.TopColumnInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 顶部栏模块
 */
@Service
public class TopColumnService {
    @Resource
    private TopColumnDao topColumnDao;

    /**
     * 查询顶部栏
     * @param userId
     * @return
     * @time 2020/4/9
     */
    public AppResponse getTopColumn(String userId){
        TopColumnInfo topColumnInfo = topColumnDao.getTopColumn(userId);
        if(null == topColumnInfo){
            return AppResponse.notFound("查询顶部栏失败");
        }
        return AppResponse.success("查询顶部栏成功", topColumnInfo);
    }
}
