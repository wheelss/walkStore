package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.dao.StoresDao;
import com.xzsd.pc.store.entity.StoresInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class StoresService {
    @Resource
    private StoresDao storesDao;

    /**
     * 新增门店
     *
     * @param storesInfo
     * @return
     * @author xiekai
     * @time 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoresInfo storesInfo) {
        storesInfo.setStoreId(StringUtil.getCommonCode(2));
        storesInfo.setInviteCode(StringUtil.getShortCode(6));
        //检验门店是否存在
        int countStore = storesDao.countStore(storesInfo);
        if (0 != countStore) {
            return AppResponse.bizError("门店已存在，请重新输入！");
        }
        //检验店长编号是否存在
        int countUserId = storesDao.countUserId(storesInfo);
        if (0 == countUserId) {
            return AppResponse.bizError("店长不存在，请重新输入！");
        }
        //检验店长编号是否绑定门店
        int countUserUsed = storesDao.countUserUsed(storesInfo);
        if (0 != countUserUsed) {
            return AppResponse.bizError("店长已被绑定，请重新输入！");
        }

        // 新增门店
        int count = storesDao.addStore(storesInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询门店详情
     *
     * @param storeId
     * @return
     * @Author xiekai
     * @Date 2020-4-10
     */
    public AppResponse getStore(String storeId)  {
        StoresInfo storesInfo = storesDao.getStore(storeId);
        return AppResponse.success("查询成功！", storesInfo);
    }

    /**
     * demo 查询门店列表（分页）
     *
     * @param storesInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    public AppResponse listStores(StoresInfo storesInfo) {
        if ((storesInfo.getRole() == 0) ||(storesInfo.getRole() == 1)){
            PageHelper.startPage(storesInfo.getPageNum(), storesInfo.getPageSize());
            List<StoresInfo> goodInfoList = storesDao.listStores(storesInfo);
            PageInfo<StoresInfo> pageData = new PageInfo<StoresInfo>(goodInfoList);
            return AppResponse.success("查询成功！", pageData);
        }else{
            String userId = SecurityUtils.getCurrentUserId();
            storesInfo.setUserId(userId);
            PageHelper.startPage(storesInfo.getPageNum(), storesInfo.getPageSize());
            List<StoresInfo> goodInfoList = storesDao.listStoresManger(storesInfo);
            PageInfo<StoresInfo> pageData = new PageInfo<StoresInfo>(goodInfoList);
            return AppResponse.success("查询成功！", pageData);
        }
    }

    /**
     * demo 修改门店
     *
     * @param storesInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoresInfo storesInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验门店是否存在
        int countStore = storesDao.countStore(storesInfo);
        if (0 == countStore) {
            return AppResponse.bizError("门店不存在");
        }
        //检验店长编号是否存在
        int countUserId = storesDao.countUserId(storesInfo);
        if (0 == countUserId) {
            return AppResponse.bizError("店长不存在存在，请重新输入！");
        }
        //检验店长编号是否绑定门店
        int countUserUsed = storesDao.countUserUsed(storesInfo);
        if (0 != countUserUsed) {
            return AppResponse.bizError("店长已被绑定，请重新输入！");
        }
        // 修改门店信息
        int count = storesDao.updateStore(storesInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除门店
     *
     * @param storeId
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId, String updateUser) {
        List<String> listCode = Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店
        int count = storesDao.deleteStore(listCode, updateUser);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
