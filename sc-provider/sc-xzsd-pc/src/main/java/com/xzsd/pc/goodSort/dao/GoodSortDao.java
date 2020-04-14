package com.xzsd.pc.goodSort.dao;

import com.xzsd.pc.goodSort.entity.GoodSortInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类
 *
 * @author
 * @time 2020-3-25
 */
@Mapper
public interface GoodSortDao {
    /**
     * 统计商品分类数量
     *
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int countGoodSortAcct(GoodSortInfo goodSortInfo);

    /**
     * 统计删除商品目录子类数量
     *
     * @param classifyId 分类id
     * @return
     */
    int countGoodSorts(@Param("classifyId") String classifyId);

    /**
     * 新增商品分类
     *
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int addGoodsClassify(GoodSortInfo goodSortInfo);

    /**
     * 查询商品分类信息
     *
     * @param classifyId 商品分类id
     * @return 修改结果
     */
    GoodSortInfo getGoodsClassify(@Param("classifyId") String classifyId);

    /**
     * 获取所有商品分类信息
     * @param goodSortInfo 商品分类信息
     * @return 所有商品分类信息
     */
    List<GoodSortInfo> getNodeTree(GoodSortInfo goodSortInfo);

    /**
     * 修改商品分类信息
     *
     * @param goodSortInfo 商品分类信息
     * @return 修改结果
     */
    int updateGoodsClassify(GoodSortInfo goodSortInfo);

    /**
     * 删除商品分类
     * @param classifyId
     * @param userId
     * @return
     */
    int deleteGoodsClassify(@Param("classifyId") String classifyId,@Param("userId") String userId);
}
