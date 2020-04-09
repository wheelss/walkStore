package com.xzsd.pc.goodSort.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goodSort.dao.GoodSortDao;
import com.xzsd.pc.goodSort.entity.GoodSortInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户
 *
 * @author xiekai
 * @time 2020-3-25
 */
@Service
public class GoodSortService {
    @Resource
    private GoodSortDao goodSortDao;

    /**
     * 新增商品分类
     *
     * @param goodSortInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsClassify(GoodSortInfo goodSortInfo) {
        goodSortInfo.setClassifyId(StringUtil.getCommonCode(2));
        //检验商品分类是否存在
        int countGoodSortAcct = goodSortDao.countGoodSortAcct(goodSortInfo);
        if (0 != countGoodSortAcct) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }

        // 新增商品分类
        int count = goodSortDao.addGoodsClassify(goodSortInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询商品分类详情
     * @param classifyId
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse getGoodsClassify(String classifyId) {
        GoodSortInfo goodSortInfo = goodSortDao.getGoodsClassify(classifyId);
        return AppResponse.success("查询成功！", goodSortInfo);
    }


    /**
     * demo 查询商品分类列表（分页）
     *
     * @param goodSortInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listAllGoodsClassify(GoodSortInfo goodSortInfo) {

        PageHelper.startPage(goodSortInfo.getPageNum(), goodSortInfo.getPageSize());
        List<GoodSortInfo> goodInfoList = goodSortDao.listAllGoodsClassify(goodSortInfo);
        PageInfo<GoodSortInfo> pageData = new PageInfo<GoodSortInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 修改商品分类
     * @param goodSortInfo
     * @Author xiekai
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsClassify(GoodSortInfo goodSortInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = goodSortDao.countGoodSortAcct(goodSortInfo);
        if (0 == countUserAcct) {
            return AppResponse.bizError("用户账号不存在！");
        }
        // 修改用户信息
        int count = goodSortDao.updateGoodsClassify(goodSortInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除轮播图
     * @param classifyId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsClassify(String classifyId,String userId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        int counts = goodSortDao.countGoodSorts(classifyId);
        if(counts != 0){
            appResponse = AppResponse.bizError("删除失败，删除目录有二级分类");
        }
        // 删除轮播图
        int count = goodSortDao.deleteGoodsClassify(classifyId,userId);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
