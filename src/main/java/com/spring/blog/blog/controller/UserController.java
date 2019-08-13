package com.spring.blog.blog.controller;

import com.spring.blog.blog.domain.User;
import com.spring.blog.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询用户
     */
    @GetMapping   //获取用户列表
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     *根据id查询用户
     *
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取或者创建表单
     *
     */
    @GetMapping(value = "/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("users/form","userModel",user);

    }

}


















