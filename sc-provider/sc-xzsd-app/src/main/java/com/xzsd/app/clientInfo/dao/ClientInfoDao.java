package com.xzsd.app.clientInfo.dao;

import com.xzsd.app.clientInfo.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientInfoDao {
    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     */
    int updateClientInvite(ClientInfo clientInfo);

    /**
     * 获取未完成订单数量
     * @param clientInfo
     * @return
     */
    int getOrder(ClientInfo clientInfo);
}
