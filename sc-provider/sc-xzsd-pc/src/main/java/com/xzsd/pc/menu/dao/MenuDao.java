package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {
    /**
     * 新增菜单
     *
     * @param menuInfo 菜单信息
     * @return
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 获取所有菜单信息
     *
     * @return 所有菜单信息
     */
    List<MenuInfo> listMenu();
    /**
     * 查询菜单信息
     *
     * @param menuId 菜单编号
     * @return 修改结果
     */
    MenuInfo getMenu(@Param("menuId") String menuId);

    /**
     * 修改菜单信息
     *
     * @param menuInfo 菜单信息
     * @return 修改结果
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 删除菜单信息
     *
     * @param menuId 选中的菜单
     * @return
     */
    int deleteMenu(@Param("menuId") String menuId, @Param("updateUser") String updateUser);

    /**
     * 根据角色查询首页菜单显示的功能
     * @param role
     * @return
     */
    List<MenuInfo> getPageHomeMenu(@Param("role") String role);
}
