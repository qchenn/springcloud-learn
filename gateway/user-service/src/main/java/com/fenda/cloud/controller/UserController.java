package com.fenda.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fenda
 * @create 2022/12/30 01:18
 */

@RestController
public class UserController {



    @GetMapping("/user/{id}")
    public String selectUserById(@PathVariable("id") Integer id) throws Exception {
//        验证重试时放开
//        if(id ==1){
//            throw new Exception();
//        }
        return "user: "+id;
    }


    @GetMapping("/user/selectUserByName")
    public String selectUserByName(@RequestParam("username") String name){
        return "user: "+name;
    }


}
