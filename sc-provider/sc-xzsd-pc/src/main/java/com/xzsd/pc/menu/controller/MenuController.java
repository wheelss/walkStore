package com.xzsd.pc.menu.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    /**
     * 新增菜单
     *
     * @param menuInfo
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        menuInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = menuService.addMenu(menuInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单列表(分页)
     * @param menuInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-4-9
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu(MenuInfo menuInfo) {
        try {
            return menuService.listMenu(menuInfo);
        } catch (Exception e) {
            logger.error("查询菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-09
     */
    @RequestMapping(value = "getMenu")
    public AppResponse getMenu(String menuId) {
        try {
            return menuService.getMenu(menuId);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        menuInfo.setUpdateUser(userId);
        try {
            return menuService.updateMenu(menuInfo);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-26
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuId) {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return menuService.deleteMenu(menuId, userId);
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 角色菜单列表
     * @param menuInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-4-13
     */
    @RequestMapping(value = "listMenuHome")
    public AppResponse listMenuHome(MenuInfo menuInfo) {
        try {
            return menuService.listMenuHome(menuInfo);
        } catch (Exception e) {
            logger.error("查询菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
