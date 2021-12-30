package com.mycompany.kafka.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycompany.kafka.entity.TSysUser;
import com.mycompany.kafka.mapper.TSysUserMapper;
import com.mycompany.kafka.service.ITSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycompany.kafka.util.MD5Utils;
import com.mycompany.kafka.util.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 尹君
 * @since 2021-12-27
 */
@Slf4j
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements ITSysUserService {
    @Autowired
    private TSysUserMapper tSysUserMapper;
    @Value("common.md5.salt")
    private String salt;


    @Override
    public List<TSysUser> getAllUser() {
        return tSysUserMapper.selectList(null);
    }

    @Override
    public int insertUser(TSysUser tSysUser) throws Exception{
        tSysUser.setId(IdWorker.getIdStr());
        String password=tSysUser.getLoginPassword();
        if(StringUtils.isEmpty(password)){
            throw new Exception("密码为空");
        }
        String realPassword=MD5Utils.getMD5(password+salt);
        tSysUser.setLoginPassword(realPassword.toUpperCase());

        return tSysUserMapper.insert(tSysUser);
    }

    @Override
    public int updateUser(TSysUser tSysUser) {

        return tSysUserMapper.updateById(tSysUser);
    }

    @Override
    public List selectAllUsers(TSysUser tSysUser) {

        return tSysUserMapper.selectList(new QueryWrapper(tSysUser));
    }

    @Override
    public boolean login(TSysUser tSysUser) {
        String userNo=tSysUser.getUserNo();
        String password=tSysUser.getLoginPassword();
        String realPassword= MD5Utils.getMD5(password+salt);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("user_no",userNo);
        map.put("login_password",realPassword.toUpperCase());
        log.info(map.toString());
       List<TSysUser> userList=tSysUserMapper.selectByMap(map);
       if(userList!=null && userList.size()>0){
           return true;

       }
        log.info("验证失败：用户不存在或者校验失败："+tSysUser);
        return false;
    }

    @Override
    public Page selectUsersByPage(Map map) throws Exception{
        int pageNo= MapUtil.getKeyIntegerValues(map,"page");
        int pageSize=MapUtil.getKeyIntegerValues(map,"pageSize");
        Page page=new Page(pageNo,pageSize) ;

        return tSysUserMapper.selectPage(page,null);
    }
}
