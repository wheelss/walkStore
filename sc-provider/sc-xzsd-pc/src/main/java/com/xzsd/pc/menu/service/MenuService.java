package com.xzsd.pc.menu.service;

import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     *
     * @param menuInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo) {
        menuInfo.setMenuId(StringUtil.getCommonCode(2));
        // 新增菜单
        int count = menuDao.addMenu(menuInfo);
        if (0 == count) {
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询菜单列表（分页）
     *
     * @param menuInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    public AppResponse listMenu(MenuInfo menuInfo) {
        List<MenuInfo> menuInfoList = menuDao.listMenu(menuInfo);
        return AppResponse.success("查询成功！", menuInfoList);
    }

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return
     * @Author xiekai
     * @Date 2020-03-25
     */
    public AppResponse getMenu(String menuId) {
        MenuInfo menuInfo = menuDao.getMenu(menuId);
        return AppResponse.success("查询成功！", menuInfo);
    }

    /**
     * demo 修改菜单
     * @param menuInfo
     * @return
     * @Author xiekai
     * @Date 2020-4-9
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改菜单信息
        int count = menuDao.updateMenu(menuInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     * @Author xiekai
     * @Date 2020-4-9
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuId, String updateUser) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除菜单
        int count = menuDao.deleteMenu(menuId, updateUser);
        if (0 == count) {
            appResponse = AppResponse.notFound("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 角色菜单列表
     *
     * @param menuInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-13
     */
    public AppResponse listMenuHome(MenuInfo menuInfo) {
        if( Integer.valueOf(menuInfo.getRole()) == 0 || Integer.valueOf(menuInfo.getRole()) == '1'){
            List<MenuInfo> menuList = menuDao.listMenuHomeAdmin(menuInfo);
            return AppResponse.success("查询成功！",menuList);
        }else{
            List<MenuInfo> menuList = menuDao.listMenuHome(menuInfo);
            return AppResponse.success("查询成功！",menuList);
        }

    }
}
