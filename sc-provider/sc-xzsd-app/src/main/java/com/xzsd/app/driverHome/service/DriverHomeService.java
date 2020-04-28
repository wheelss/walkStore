package com.xzsd.app.driverHome.service;

import com.xzsd.app.driverHome.dao.DriverHomeDao;
import com.xzsd.app.driverHome.entity.DriverHomeInfo;
import com.xzsd.app.driverHome.entity.Lists;
import com.xzsd.app.util.AppResponse;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DriverHomeService {
    @Resource
    private DriverHomeDao driverHomeDao;
    /**
     * 查询司机负责门店
     * @param driverHomeInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    public AppResponse listDriverStores(DriverHomeInfo driverHomeInfo){
        List<DriverHomeInfo> lists = driverHomeDao.listDriverStores(driverHomeInfo);
        if(lists.size() == 0){
            return AppResponse.bizError("查询门店信息失败");
        }
        //拼接地址
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).setAddress(lists.get(i).getProvinceName()
                    + lists.get(i).getCityName() + lists.get(i).getAreaName()
                    + lists.get(i).getAddress());
        }
        Lists list = new Lists();
        list.setList(lists);
        return AppResponse.success("查询门店信息成功", list);
    }
}
