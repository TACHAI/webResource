package com.duruo.service;

import com.duruo.common.ServerResponse;
import com.duruo.po.WebAssets;

import java.util.List;

/**
 * Created by @Author tachai
 * date 2018/8/4 16:49
 *
 * @Email 1206966083@qq.com
 */
public interface IWebAssetsService {

    List<WebAssets> list(String resourceName,String resourceValue);

    ServerResponse<String> add(WebAssets webAssets);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(WebAssets webAssets);

    ServerResponse<WebAssets> selectById(Integer id);
}
