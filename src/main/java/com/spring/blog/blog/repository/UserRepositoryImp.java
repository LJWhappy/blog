package com.spring.blog.blog.repository;

import com.spring.blog.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository   //注入资源表明是一个bean
public class UserRepositoryImp implements UserRepository {

    //每增加一个用户自动+1 从而做到id唯一
    private  static AtomicLong counter = new AtomicLong();
    //模拟数据库暂时吧数据放在内存  map中
    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long  id = user.getId();
        if (id == null){
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);

        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {

        return  this.userMap.get(id);
    }

    @Override
    public List<User> listUser() {

        return new ArrayList<User>( this.userMap.values());
    }
}
