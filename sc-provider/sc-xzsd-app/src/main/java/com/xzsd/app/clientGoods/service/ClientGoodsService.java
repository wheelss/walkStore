package com.xzsd.app.clientGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.*;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientGoodsService {
    @Resource
    private ClientGoodsDao clientGoodsDao;

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    public AppResponse getGoods(String goodsId){
        GoodsInfo goodsInfo = clientGoodsDao.getGoods(goodsId);
        String score = String.format("%.2f", goodsInfo.getGoodsEvaluateScore());
        goodsInfo.setGoodsEvaluateScore(Double.valueOf(score));
        return AppResponse.success("查询商品详情成功", goodsInfo);
    }
    /**
     * 查询商品评价
     * @param goodsEvaluateInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    public AppResponse listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo){
        PageHelper.startPage(goodsEvaluateInfo.getPageNum(), goodsEvaluateInfo.getPageSize());
        List<GoodsEvaluateInfo> goodsEvaluateList = clientGoodsDao.listGoodsEvaluates(goodsEvaluateInfo);
        PageInfo<GoodsEvaluateInfo> pageData = new PageInfo<>(goodsEvaluateList);
        return AppResponse.success("查询商品评价列表成功！",pageData);
    }
    /**
     * 查询一级商品分类
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    public AppResponse listOneGoodsClassify(){
        List<GoodSortInfo> oneClassifyLists = clientGoodsDao.listOneGoodsClassify();
        OneClassifyList oneClassifyList = new OneClassifyList();
        oneClassifyList.setOneClassifyList(oneClassifyLists);
        return AppResponse.success("查询一级商品分类成功", oneClassifyList);
    }
    /**
     * 查询二级商品分类及商品
     * @return
     * @author xiekai
     * @time 2020-4-16
     */
    public AppResponse listGetClassGoods(String classifyId){
        List<GoodSortInfo> twoClassifyLists = clientGoodsDao.listGetClassGoods(classifyId);
        TwoClassifyList twoClassifyList = new TwoClassifyList();
        twoClassifyList.setTwoClassifyList(twoClassifyLists);
        return AppResponse.success("查询二级商品分类及商品成功", twoClassifyList);
    }


}
