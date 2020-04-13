package com.xzsd.pc.hotGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * 新增热门位商品
     * @param hotGoodsInfo
     * @return
     * @author xiekai
     * @time 2020-4-9
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo) {
        //检验排序重复
        int countSort = hotGoodsDao.countSort(hotGoodsInfo);
        if (0 != countSort) {
            return AppResponse.bizError("排序已存在，请重新输入！");
        }
        //检验商品重复
        int countGood = hotGoodsDao.countGood(hotGoodsInfo);
        if (0 != countGood) {
            return AppResponse.bizError("商品已被选择，请重新输入！");
        }
        //新增轮播图
        hotGoodsInfo.setHotGoodsId(StringUtil.getCommonCode(2));
        int count = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败,请重试");
        }
        return AppResponse.success("新增成功!");

    }

    /**
     * 查询热门位商品详情
     *
     * @param hotGoodsId
     * @return
     * @Author xiekai
     * @Date 2020-04-9
     */
    public AppResponse getHotGoods(String hotGoodsId) {
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.getHotGoods(hotGoodsId);
        return AppResponse.success("查询成功！", hotGoodsInfo);
    }

    /**
     * demo 查询热门位商品列表（分页）
     *
     * @param hotGoodsInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo) {

        PageHelper.startPage(hotGoodsInfo.getPageNum(), hotGoodsInfo.getPageSize());
        List<HotGoodsInfo> goodInfoList = hotGoodsDao.listHotGoods(hotGoodsInfo);
        PageInfo<HotGoodsInfo> pageData = new PageInfo<HotGoodsInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * demo 修改热门位商品
     *
     * @param hotGoodsInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = hotGoodsDao.countHotGoodAcct(hotGoodsInfo);
        if (0 == countUserAcct) {
            return AppResponse.bizError("商品不存在");
        }
        //检验排序重复
        int countSort = hotGoodsDao.countSort(hotGoodsInfo);
        if (0 != countSort) {
            return AppResponse.bizError("排序已存在，请重新输入！");
        }
        //检验商品重复
        int countGood = hotGoodsDao.countGood(hotGoodsInfo);
        if (0 != countGood) {
            return AppResponse.bizError("商品已被选择，请重新输入！");
        }
        // 修改热门位商品信息
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 查询热门位商品展示数量
     * @return
     * @Author xiekai
     * @Date 2020-04-9
     */
    public AppResponse getHotGoodsShowNum() {
        AppResponse appResponse = AppResponse.success("查询成功");
        int count = hotGoodsDao.getHotGoodsShowNum();
        if(0 == count){
            appResponse = AppResponse.versionError("查询失败");
        }
        return appResponse;
    }

    /**
     * demo 修改热门位商品展示数量
     *
     * @param hotGoodsInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改热门位商品展示数量
        int count = hotGoodsDao.updateHotGoodsShowNum(hotGoodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除热门位商品
     *
     * @param hotGoodsId
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsId, String updateUser) {
        List<String> listCode = Arrays.asList(hotGoodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = hotGoodsDao.deleteHotGoods(listCode, updateUser);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
