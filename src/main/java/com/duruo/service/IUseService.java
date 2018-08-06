package com.duruo.service;

import com.duruo.common.ServerResponse;
import com.duruo.po.User;
import com.duruo.vo.UserVo;

import java.util.List;

/**
 * Created by @Author tachai
 * date 2018/6/10 17:20
 *
 * @Email 1206966083@qq.com
 */
public interface IUseService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<UserVo> selectById(Integer id);
//    ServerResponse<List<User>> select
    ServerResponse<List<UserVo>> list(User user);
    ServerResponse<String> insertUser(User user);
    ServerResponse<String> deleteUser(Integer userId);
    ServerResponse<String> updateUser(User user);
    ServerResponse<String> resetPassword(Integer userId);
}
