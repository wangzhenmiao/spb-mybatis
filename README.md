# spb-mybatis

一、mybatis的repository层

    public interface UserRepository {

     @Insert("insert into tb_user(login_name ,username ,password) "
             + "values (#{loginName},#{username},#{password})")
      public int insertUser(User user);
      ...
    }
    
 repository层，写了@Insert注解
    
 二、app.main中指定数据访问接口的包名
 
    @SpringBootApplication
    //指定数据访问接口的包名
    @MapperScan("com.wangzhen.spbmybatis.repository")
    public class SpbMybatisApplication {

	  public static void main(String[] args) {
	  	SpringApplication.run(SpbMybatisApplication.class, args);
	  }

    }
    
 @MapperScan("com.wangzhen.spbmybatis.repository")
