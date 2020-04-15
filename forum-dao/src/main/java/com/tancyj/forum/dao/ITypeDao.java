package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Type;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ITypeDao {
    @Select("select * from type")
    @Results(id = "typeMap",
            value = {
                    @Result(id = true,column = "type_id",property = "type_id"),
                    @Result(column = "type",property = "type"),
                    @Result(column = "type_id",property = "posts",
                            many = @Many(
                                    select="com.tancyj.forum.dao.IPostDao.findByTid",
                                    fetchType= FetchType.LAZY
                            )
                    ),
            }
    )
    public List<Type> findAll() throws Exception;
    @Insert("insert into type(type) VALUES(#{type})")
    public void addtype(Type type) throws Exception;

    @Update("UPDATE type set type = #{type} WHERE type_id = #{type_id};")
    public void updatetype(Type type) throws Exception;

    @Delete("delete from type where type_id = #{type_id}")
    public void deltype(Integer type_id) throws Exception;

    @ResultMap("typeMap")
    @Select("select * from type where type_id = #{type_id}")
    public Type findById(Integer type_id) throws Exception;

}
