package com.mycompany.kafka.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycompany.kafka.entity.TSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 尹君
 * @since 2021-12-27
 */
public interface ITSysUserService extends IService<TSysUser> {

    List getAllUser();

    int insertUser(TSysUser tSysUser) throws Exception;

    int updateUser(TSysUser tSysUser);

    List selectAllUsers(TSysUser tSysUser);

    boolean login(TSysUser tSysUser);

    Page selectUsersByPage(Map map) throws Exception;
}