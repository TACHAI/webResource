package com.duruo.service.impl;

import com.duruo.common.ServerResponse;
import com.duruo.dao.WebAssetsMapper;
import com.duruo.po.WebAssets;
import com.duruo.service.IWebAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @Author tachai
 * date 2018/8/4 16:53
 *
 * @Email 1206966083@qq.com
 */
@Service("iWebAssetsService")
public class WebAssetsServiceImpl implements IWebAssetsService{
    @Autowired
    private WebAssetsMapper webAssetsMapper;

    @Override
    public List<WebAssets> list(String resourceName,String resourceValue) {
        List<WebAssets> list = webAssetsMapper.list(resourceName,resourceValue);
        if(list!=null){
            return list;
        }
        return null;
    }

    @Override
    public ServerResponse<String> add(WebAssets webAssets) {
       int result = webAssetsMapper.insert(webAssets);
       if(result>0){
           return ServerResponse.createBySuccess("增加资源成功");
       }else {
           return ServerResponse.createByErrorMessage("添加资源失败");
       }
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int result = webAssetsMapper.deleteByPrimaryKey(id);
        if(result>0){
            return ServerResponse.createBySuccessMessage("删除资源成功");
        }else {
            return ServerResponse.createByErrorMessage("删除资源失败");
        }
    }

    @Override
    public ServerResponse<String> update(WebAssets webAssets) {
        if(webAssets!=null){
            int result = webAssetsMapper.updateByPrimaryKeySelective(webAssets);
            if(result>0){
                return ServerResponse.createBySuccessMessage("更新成功");
            }else {
                return ServerResponse.createByErrorMessage("更新失败");
            }
        }
        return ServerResponse.createByErrorMessage("参数为空");
    }

    @Override
    public ServerResponse<WebAssets> selectById(Integer id) {
        WebAssets webAssets = webAssetsMapper.selectByPrimaryKey(id);
        if(webAssets!=null){
            return ServerResponse.createBySuccess(webAssets);
        }else {
            return ServerResponse.createByErrorMessage("没有找到相关的值");
        }
    }
}
