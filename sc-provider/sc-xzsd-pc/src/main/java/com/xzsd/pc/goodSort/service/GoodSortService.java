package com.xzsd.pc.goodSort.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goodSort.dao.GoodSortDao;
import com.xzsd.pc.goodSort.entity.GoodSortInfo;
import com.xzsd.pc.goodSort.entity.OneClassifyList;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 商品分类增删改查
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
        // 新增商品分类
        int count = goodSortDao.addGoodsClassify(goodSortInfo);
        if (0 == count) {
            return AppResponse.versionError("新增失败，请重试！");
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
     * demo 查询商品分类列表
     *
     * @param goodSortInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listAllGoodsClassify(GoodSortInfo goodSortInfo) {
        List<GoodSortInfo> oneClassifyLists = goodSortDao.getNodeTree(goodSortInfo);
        OneClassifyList oneClassifyList = new OneClassifyList();
        oneClassifyList.setOneClassifyList(oneClassifyLists);
        return AppResponse.success("查询成功！", oneClassifyList);
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
        // 修改分类信息
        int count = goodSortDao.updateGoodsClassify(goodSortInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除分类
     * @param classifyId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsClassify(String classifyId,String userId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        int counts = goodSortDao.countGoodSorts(classifyId);
        //查看一级分类下是否有二级分类
        if(counts != 0){
            appResponse = AppResponse.notFound("删除失败，删除目录有二级分类");
        }
        //查看二级分类下是否有商品
        int countG = goodSortDao.countGoods(classifyId);
        if(countG != 0){
            appResponse = AppResponse.notFound("删除失败，删除目录有二级分类");
        }
        // 删除分类
        int count = goodSortDao.deleteGoodsClassify(classifyId,userId);
        if (0 == count) {
            appResponse = AppResponse.notFound("删除失败，请重试！");
        }
        return appResponse;
    }
}
