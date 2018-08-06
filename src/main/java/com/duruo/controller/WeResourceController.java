package com.duruo.controller;

import com.duruo.common.ServerResponse;
import com.duruo.po.WebAssets;
import com.duruo.service.IWebAssetsService;
import com.duruo.vo.PageHelp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by @Author tachai
 * date 2018/8/4 18:29
 *
 * @Email 1206966083@qq.com
 */
@Controller
@RequestMapping("/webResource/")
public class WeResourceController {
    @Autowired
    private IWebAssetsService webAssetsService;


    @GetMapping("list.do")
    @ResponseBody
    public PageHelp list(HttpSession session,String resourceName, String resourceValue, Integer pageSize, Integer pageNumber){
        Page page = PageHelper.startPage(pageNumber,pageSize);

        List<WebAssets> list = webAssetsService.list(resourceName,resourceValue);

        Long total = page.getTotal();
        PageHelp pageHelp = new PageHelp();

        pageHelp.setTotal(total);
        pageHelp.setRows(list);
        return pageHelp;
    }


    @PostMapping("add.do")
    @ResponseBody
    public ServerResponse<String> add(HttpSession session,WebAssets webAssets){
        System.out.println("进来了");
        return webAssetsService.add(webAssets);
    }

    @PostMapping("del.do")
    @ResponseBody
    public ServerResponse<String> del(HttpSession session,Integer id){
        return webAssetsService.del(id);
    }

    @PostMapping("update.do")
    @ResponseBody
    public ServerResponse<String> update(HttpSession session,WebAssets webAssets){
        return webAssetsService.update(webAssets);
    }

    @PostMapping("selectById")
    @ResponseBody
    public ServerResponse<WebAssets> selectById(HttpSession session,Integer id){
        return webAssetsService.selectById(id);
    }
}
