package com.xzsd.app.manangerOrder.dao;

import com.xzsd.app.manangerOrder.entity.ManagerOrderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerOrderDao {
    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     */
    int updateManangerOrderState(ManagerOrderInfo managerOrderInfo);
}
