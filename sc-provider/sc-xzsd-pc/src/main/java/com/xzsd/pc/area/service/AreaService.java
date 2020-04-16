package com.xzsd.pc.area.service;

import com.xzsd.pc.area.dao.AreaDao;
import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 查询省市区
 */
@Service
public class AreaService {
    @Resource
    private AreaDao areaDao;
    /**
     * demo 查询省市区列表
     *
     * @param areaInfo
     * @return
     * @Author xiekai
     * @Date 2020-4-13
     */
    public AppResponse listArea(AreaInfo areaInfo){
            List<AreaInfo> areaInfoList = areaDao.listArea(areaInfo);
            return AppResponse.success("查询成功！", areaInfoList);
    }
}
