package com.xzsd.pc.rotation.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.good.entity.GoodInfo;
import com.xzsd.pc.rotation.dao.RotationDao;
import com.xzsd.pc.rotation.entity.RotationInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 轮播图
 * @author xiekai
 * @time 2020-3-27
 */
@Service
public class RotationService {

    @Resource
    private RotationDao rotationDao;

    /**
     * 新增轮播图
     * @param rotationInfo
     * @return
     * @author xiekai
     * @time 2020-3-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSlideshowHome(RotationInfo rotationInfo) {
        //检验排序重复
        int countSort = rotationDao.countSort(rotationInfo);
        if (0 != countSort) {
            return AppResponse.versionError("排序已存在，请重新输入！");
        }
        //检验商品重复
        int countGood = rotationDao.countGood(rotationInfo);
        if (0 != countGood) {
            return AppResponse.versionError("商品已被选择，请重新输入！");
        }
        //新增轮播图
        rotationInfo.setSlideshowId(StringUtil.getCommonCode(2));
        int count = rotationDao.addSlideshowHome(rotationInfo);
        if (0 == count) {
            return AppResponse.versionError("新增失败,请重试");
        }
        return AppResponse.success("新增成功!");
    }

    /**
     * 删除轮播图
     * @param
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlideshowHome(String slideshowId, String updateUser) {
        List<String> listCode = Arrays.asList(slideshowId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除轮播图
        int count = rotationDao.deleteSlideshowHome(listCode, updateUser);
        if (0 == count) {
            appResponse = AppResponse.notFound("删除失败，请重试！");
        }
        return appResponse;
    }
    /**
     * demo 修改轮播图状态
     * @return
     * @Author xiekai
     * @Date 2020-04-02
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideshowHomeState(RotationInfo rotationInfo) {
        List<String> listSlideshowId = Arrays.asList(rotationInfo.getSlideshowId().split(","));
        List<String> listVersion = Arrays.asList(rotationInfo.getVersion().split(","));
        List<RotationInfo> listUpdate = new ArrayList<>();
        int slideshowStateId = Integer.valueOf(rotationInfo.getSlideshowStateId());
        String updateUser =rotationInfo.getUpdateUser();
        for (int i = 0 ; i < listSlideshowId.size() ; i++){
            RotationInfo rotationInfo1 =new RotationInfo();
            rotationInfo1.setSlideshowId(listSlideshowId.get(i));
            rotationInfo1.setVersion(listVersion.get(i));
            rotationInfo1.setSlideshowStateId(String.valueOf(slideshowStateId));
            rotationInfo1.setUpdateUser(updateUser);
            listUpdate.add(rotationInfo1);
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改轮播图状态信息
        int count = rotationDao.updateSlideshowHomeState(listUpdate);
        if (0 == count) {
            appResponse = AppResponse.notFound("修改轮播图状态失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询轮播图列表（分页）
     * @param
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listSlideshowHome(RotationInfo rotationInfo)  {
        PageHelper.startPage(rotationInfo.getPageNum(), rotationInfo.getPageSize());
        List<RotationInfo> slideshowHomeList = rotationDao.listSlideshowHome(rotationInfo);
        PageInfo<RotationInfo> pageData = new PageInfo<RotationInfo>(slideshowHomeList);
        return AppResponse.success("查询成功！", pageData);

    }


    /**
     * 选择商品
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-2
     */
    public AppResponse listGoods(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = rotationDao.listGoods(goodInfo);
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }
}

