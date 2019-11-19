package net.fengyu.transaction.dao2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TrantestDao {

    @Insert("insert into tran_test(id,name,age) values (#{id},#{name},#{age})")
    int insertTrantest(@Param("id") int id, @Param("name") String name, @Param("age") int age);
}
