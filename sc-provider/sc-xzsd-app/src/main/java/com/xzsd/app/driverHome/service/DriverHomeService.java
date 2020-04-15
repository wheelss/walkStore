package com.xzsd.app.driverHome.service;

import com.xzsd.app.driverHome.dao.DriverHomeDao;
import com.xzsd.app.driverHome.entity.DriverHomeInfo;
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
        List<DriverHomeInfo> list = driverHomeDao.listDriverStores(driverHomeInfo);
        if(list.size() == 0){
            return AppResponse.bizError("查询门店信息失败");
        }
        //拼接地址
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAddress(list.get(i).getProvinceName()
                    + list.get(i).getCityName() + list.get(i).getAreaName()
                    + list.get(i).getAddress());
        }
        return AppResponse.success("查询门店信息成功", list);
    }
}
