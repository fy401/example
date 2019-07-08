package net.fengyu.transaction.dao;


import net.fengyu.transaction.vo.Customer;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CustomerDao {

    @Select("select * from customer where id = #{id}")
    Customer getCustomerById(@Param("id") int id);

    @Insert("insert into customer(id,username,city,gender) values (#{id},#{username},#{city},#{gender})")
    int insertCustomer(@Param("id") int id,@Param("username") String username,@Param("city") String city,@Param("gender") int gender);

    @Update("update customer set city = #{city} where id = #{id}")
    int updateCustomerbyId(@Param("id") int id,@Param("city") String city);
}
