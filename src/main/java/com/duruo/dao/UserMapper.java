package com.duruo.dao;

import com.duruo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectLogin(@Param("userName") String userName, @Param("userPassword") String userPassWord);

    int checkUsername(String userName);

    List<User> selectByCondition(User user);

    int updatePassword(@Param("newPassword") String newPassword,@Param("userId") Integer userId);
}