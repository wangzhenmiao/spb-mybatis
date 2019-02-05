package com.wangzhen.spbmybatis.repository;

import com.wangzhen.spbmybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName UserRepository
 * @Description
 * @Author momo
 * @Date 2019/2/5 下午8:16
 **/
public interface UserRepository {

    @Insert("insert into tb_user(login_name ,username ,password) "
            + "values (#{loginName},#{username},#{password})")
    public int insertUser(User user);

    /**
     * 插入数据获取主键
     */
    @Insert("insert into tb_user(login_name ,username ,password) "
            + "values (#{loginName},#{username},#{password})")
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    public void insertGetKey(User user);


    @Select("select * from tb_user where username = #{username}")
    // 引用id="userResult"的@Results
    @ResultMap("userResult")
    public User selectByUsername(@Param("username")String username);

    @Select("select * from tb_user")
    // @Results用于映射对象属性和数据库列，常用于对象属性和数据库列不同名情况
    @Results(id="userResult",value={
            @Result(id=true,column="id",property="id"),
            @Result(column="login_name",property="loginName"),
            @Result(column="password",property="password"),
            @Result(column="username",property="username")
    })
    public List<User> findAll();


    @Delete("delete from tb_user where id=#{id}")
    public void delete(final Integer id);


    @Select("select * from tb_user where id=#{id}")
    // 引用id="userResult"的@Results
    @ResultMap("userResult")
    public User findUserById(int id);

    @Update("update tb_user set username=#{username}, login_name=#{loginName} where id=#{id}")
    public void update(final User user);
}
