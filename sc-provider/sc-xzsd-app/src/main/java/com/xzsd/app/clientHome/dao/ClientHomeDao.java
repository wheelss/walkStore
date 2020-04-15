package com.xzsd.app.clientHome.dao;

import com.xzsd.app.clientHome.entity.HotGoodInfo;
import com.xzsd.app.clientHome.entity.RotationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientHomeDao {

    /**
     * 查询首页轮播图展示的数量
     * @return
     */
    int getSlideshowNumber();
    /**
     * 查询首页轮播图
     *
     * @return
     */
    List<RotationInfo> listRotationCharHome();

    /**
     * 查询热门位商品
     *
     * @param hotGoodInfo
     * @return
     */
    List<HotGoodInfo> listHotGoods(HotGoodInfo hotGoodInfo);

}
