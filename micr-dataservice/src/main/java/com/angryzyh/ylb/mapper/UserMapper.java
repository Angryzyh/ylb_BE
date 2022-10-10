package com.angryzyh.ylb.mapper;

import com.angryzyh.ylb.pojo.po.UserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Angryzyh
* @description 针对表【u_user(用户表)】的数据库操作Mapper
* @createDate 2022-10-09 14:24:26
* @Entity com.angryzyh.ylb.pojo.po.UserPo
*/
@Repository
public interface UserMapper extends BaseMapper<UserPo> {

    Integer selectUserCount();
}




