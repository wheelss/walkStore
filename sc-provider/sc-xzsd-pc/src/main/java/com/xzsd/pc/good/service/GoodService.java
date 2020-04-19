package com.xzsd.pc.good.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.good.dao.GoodDao;
import com.xzsd.pc.good.entity.GoodInfo;
import com.xzsd.pc.goodSort.entity.GoodSortInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.RedisOperator;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 商品
 *
 * @author xiekai
 * @time 2020-3-26
 */
@Service
public class GoodService {

    @Resource
    private GoodDao goodDao;
    @Resource
    private RedisOperator redisOperator;


    /**
     * 新增商品
     *
     * @param goodInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodInfo goodInfo) {
        goodInfo.setGoodsId(StringUtil.getCommonCode(2));
        // 新增商品
        int count = goodDao.addGoods(goodInfo);
        if (0 == count) {
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 删除商品
     * @param goodsId
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId, String updateUser) {
        List<String> listCode = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //搜索轮播图表
        List<String> RgoodsIdList = goodDao.RgoodsIdList(listCode);
        //搜索热门位商品表
        List<String> HgoodsIdList = goodDao.HgoodsIdList(listCode);
        //剔除轮播图表有的商品
        for (int i = 0 ; i < listCode.size() ; i++) {
            for (String s1 : RgoodsIdList) {
                if (listCode.get(i).equals(s1)) {
                    listCode.set(i, "-1");
                }
                }
            }
        //剔除热门位商品表有的商品
        for (int i = 0 ; i < listCode.size() ; i++) {
            for (String s1 : HgoodsIdList) {
                if (listCode.get(i).equals(s1)) {
                    listCode.set(i, "-1");
                }
            }
        }
        // 删除商品表
        int count = goodDao.deleteGoods(listCode, updateUser);
        if(RgoodsIdList.size() != 0 || HgoodsIdList.size() != 0){
            appResponse = AppResponse.success("删除成功！有部分商品已被热门位商品或轮播图绑定了未被删除!");
        }
        if (0 == count) {
            appResponse = AppResponse.notFound("删除失败，请重试！");
        }

        return appResponse;
    }

    /**
     * demo 修改商品
     *
     * @param goodInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodInfo goodInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品信息
        int count = goodDao.updateGoods(goodInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse getGoods(String goodsId) {
        GoodInfo goodInfo = goodDao.getGoods(goodsId);
        return AppResponse.success("查询成功！", goodInfo);
    }

    /**
     * demo 查询商品列表（分页）
     *
     * @param goodInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listGoodsPage(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = goodDao.listGoodsPage(goodInfo);
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * demo 修改商品状态
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsShelfState(GoodInfo goodInfo) {
        List<String> listGoodsId = Arrays.asList(goodInfo.getGoodsId().split(","));
        List<String> listVersion = Arrays.asList(goodInfo.getVersion().split(","));
        List<GoodInfo> listUpdate = new ArrayList<>();
        int goodStatusId = goodInfo.getGoodsStateId();
        String updateUser =goodInfo.getUpdateUser();
        for (int i = 0 ; i < listGoodsId.size() ; i++){
            GoodInfo goodInfo1 = new GoodInfo();
            goodInfo1.setGoodsId(listGoodsId.get(i));
            goodInfo1.setVersion(listVersion.get(i));
            goodInfo1.setGoodsStateId(goodStatusId);
            goodInfo1.setUpdateUser(updateUser);
            listUpdate.add(goodInfo1);
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品信息
        int count = goodDao.updateGoodsShelfState(listUpdate);
        if (0 == count) {
            appResponse = AppResponse.notFound("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询商品分类列表
     *
     * @param goodSortInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-13
     */
    public AppResponse listGoodsClassify(GoodSortInfo goodSortInfo) {
        List<GoodSortInfo> goodSortInfoList = goodDao.listGoodsClassify(goodSortInfo);
        return AppResponse.success("查询成功！",goodSortInfoList);
    }
}
