package com.xzsd.pc.client.dao;


import com.xzsd.pc.client.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 查询客户
 */
@Mapper
public interface ClientDao {

    /**
     * 获取所有客户信息
     *
     * @param clientInfo 客户信息
     * @return 所有客户信息
     */
    List<ClientInfo> listClient(ClientInfo clientInfo);

    /**
     * 获取店长客户信息
     *
     * @param clientInfo 客户信息
     * @return 所有客户信息
     */
    List<ClientInfo> listClientStore(ClientInfo clientInfo);
}
