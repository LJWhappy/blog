package com.spring.blog.blog.repository;

import com.spring.blog.blog.domain.User;

import java.util.List;

public interface UserRepository {
    /**
     * 更新或保存user
     */

    User saveOrUpdateUser(User user);

    /**
     * 删除user
     */

    void deleteUserById(Long id);

    /**
     * 根据id查询用户
     */

    User getUserById(Long id);


    /**
     * 批量查询user
     */

    List<User> listUser();
}
