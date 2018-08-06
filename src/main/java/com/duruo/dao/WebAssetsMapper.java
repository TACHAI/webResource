package com.duruo.dao;

import com.duruo.po.WebAssets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface WebAssetsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebAssets record);

    int insertSelective(WebAssets record);

    WebAssets selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebAssets record);

    int updateByPrimaryKey(WebAssets record);

    List<WebAssets> list(@Param("resourceName") String resourceName, @Param("resourceValue") String resourceValue);
}