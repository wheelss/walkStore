package com.xzsd.app.managerInfo.service;

import com.xzsd.app.managerInfo.dao.ManagerInfoDao;
import com.xzsd.app.managerInfo.entity.Lists;
import com.xzsd.app.managerInfo.entity.ManagerInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerInfoService {
    @Resource
    private ManagerInfoDao managerInfoDao;
    /**
     * 查询店长门下司机信息
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    public AppResponse listManangerDrivers(String userId){
        List<ManagerInfo> lists = managerInfoDao.listManangerDrivers(userId);
        if(lists.size() == 0){
            return AppResponse.bizError("查询司机信息列表失败");
        }
        Lists list = new Lists();
        list.setList(lists);
        return AppResponse.success("查询司机信息列表成功", list);
    }
}
