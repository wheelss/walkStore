package com.xzsd.pc.client.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientService {
    @Resource
    ClientDao clientDao;

    /**
     * demo 查询用户列表（分页）
     *
     * @param clientInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listClient(ClientInfo clientInfo) {
        if(clientInfo.getRole() == 0 || clientInfo.getRole() == 1){
            PageHelper.startPage(clientInfo.getPageNum(), clientInfo.getPageSize());
            List<ClientInfo> clientInfoList = clientDao.listClient(clientInfo);
            // 包装Page对象
            PageInfo<ClientInfo> pageData = new PageInfo<ClientInfo>(clientInfoList);
            return AppResponse.success("查询成功！", pageData);
        }else{
            PageHelper.startPage(clientInfo.getPageNum(), clientInfo.getPageSize());
            List<ClientInfo> clientInfoList = clientDao.listClientStore(clientInfo);
            // 包装Page对象
            PageInfo<ClientInfo> pageData = new PageInfo<ClientInfo>(clientInfoList);
            return AppResponse.success("查询成功！", pageData);
        }
    }
}
