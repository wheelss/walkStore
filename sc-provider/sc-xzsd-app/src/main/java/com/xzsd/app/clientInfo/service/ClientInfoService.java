package com.xzsd.app.clientInfo.service;

import com.xzsd.app.clientInfo.dao.ClientInfoDao;
import com.xzsd.app.clientInfo.entity.ClientInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ClientInfoService {
    @Resource
    private ClientInfoDao clientInfoDao;
    /**
     * 修改客户店铺邀请码
     * @param clientInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        int counts = clientInfoDao.getOrder(clientInfo);
        if(counts != 0){
            return AppResponse.bizError("有未完成的订单,如若想更换请联系客服");
        }
        int count = clientInfoDao.updateClientInvite(clientInfo);
        if(0 == count){
            return AppResponse.bizError("修改邀请码失败");
        }
        return AppResponse.success("修改邀请码成功");
    }
}
