package com.mycompany.kafka.controller;


import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycompany.kafka.controller.BaseController;
import com.mycompany.kafka.entity.TSysUser;
import com.mycompany.kafka.service.ITSysUserService;
import com.mycompany.kafka.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 尹君
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/api/server/user/")
public class TSysUserController extends BaseController {
    @Autowired
    private ITSysUserService itSysUserService;


    /**
     * 插入用户
     * @param tSysUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login( @RequestBody TSysUser tSysUser){

        boolean b=itSysUserService.login(tSysUser);
        if(b){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }




    }

    /**
     * 插入用户
     * @param tSysUser
     * @return
     */
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insertUser( @RequestBody TSysUser tSysUser) throws Exception{

        int k=itSysUserService.insertUser(tSysUser);

        return CommonResult.success();


    }

    /**
     * 更新用户
     * @param tSysUser
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateUser(@RequestBody  TSysUser tSysUser){

        int k=itSysUserService.updateUser(tSysUser);

        return CommonResult.success();

    }
    /**
     * 查询所有用户
     * @param tSysUser
     * @return
     */
    @RequestMapping(value = "/selectAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult selectAllUsers(@RequestBody TSysUser tSysUser){

        List list=itSysUserService.selectAllUsers(tSysUser);

        return CommonResult.success(list);

    }

    /**
     * 根据条件分页查询男足条件的用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/selectUsersByPage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult selectUsersByPage(@RequestBody Map map) throws Exception{

        Page page=itSysUserService.selectUsersByPage(map);
        JSONObject objJson = JSONObject.parseObject(JSON.toJSONString(page));
        return CommonResult.success(objJson);

    }

}
