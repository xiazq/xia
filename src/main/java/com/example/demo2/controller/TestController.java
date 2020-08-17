package com.example.demo2.controller;

import com.example.demo2.service.impl.MiaoShaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController{
    @Resource
    private MiaoShaService miaoShaService;

    /**
     * 添加商品以及库存
     */
    @GetMapping("/miaosha")
    public String miaosha(@RequestParam(value = "id")Integer id ,@RequestParam(value = "username") String username, @RequestParam(value = "cname") String cname) {
        return miaoShaService.miaosha(id,username, cname);
    }


}
