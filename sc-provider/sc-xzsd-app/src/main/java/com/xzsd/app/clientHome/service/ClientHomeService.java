package com.xzsd.app.clientHome.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientHome.dao.ClientHomeDao;
import com.xzsd.app.clientHome.entity.HotGoodInfo;
import com.xzsd.app.clientHome.entity.Lists;
import com.xzsd.app.clientHome.entity.RotationInfo;
import com.xzsd.app.clientHome.entity.SlideshowList;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientHomeService {
    @Resource
    private ClientHomeDao clientHomeDao;
    /**
     * 查询轮播图
     * @return
     * @author xiekai
     * @date 2020-4-14
     */
    public AppResponse listRotationCharHome(){
        List<RotationInfo> listSlideshow = clientHomeDao.listRotationCharHome();
        SlideshowList slideshowList = new SlideshowList();
        slideshowList.setSlideshowList(listSlideshow);
        return AppResponse.success("查询首页轮播图成功", slideshowList);
    }
    /**
     * 查询热门位商品
     * @return
     * @author xiekai
     * @date 2020-4-14
     */
    public AppResponse listHotGoods(HotGoodInfo hotGoodInfo){
        //获取热门位商品展示数量
        int num = clientHomeDao.getSlideshowNumber();
        hotGoodInfo.setHotGoodsShowNums(num);
        //查询热门位商品
        List<HotGoodInfo> listHotGoods = clientHomeDao.listHotGoods(hotGoodInfo);
        Lists list = new Lists();
        list.setList(listHotGoods);
        return AppResponse.success("查询热门位商品成功", list);
    }
}
