package com.wangzhen.spbmybatis.service;

import com.wangzhen.spbmybatis.bean.User;
import com.wangzhen.spbmybatis.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Description
 * @Author momo
 * @Date 2019/2/5 下午8:17
 **/
@Service
public class UserService {

    // 注入UserRepository
    @Resource
    private UserRepository userRepository;

    public int insertUser(User user){
        return userRepository.insertUser(user);
    }

    public User selectByUsername(String username){
        return userRepository.selectByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void insertGetKey(User user) {
        // 数据插入成功以后，Mybatis框架会将插入成功的数据主键存入到user对象中去
        userRepository.insertGetKey(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
