package com.xzsd.app.manangerOrder.service;

import com.xzsd.app.manangerOrder.dao.ManagerOrderDao;
import com.xzsd.app.manangerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ManagerOrderService {
    @Resource
    private ManagerOrderDao managerOrderDao;
    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManangerOrderState(ManagerOrderInfo managerOrderInfo){
        int count = managerOrderDao.updateManangerOrderState(managerOrderInfo);
        if(count == 0){
            return AppResponse.bizError("修改订单状态失败");
        }
        return AppResponse.success("修改订单状态成功");
    }
}
