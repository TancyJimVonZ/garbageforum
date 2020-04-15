package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Proclamation;
import com.tancyj.forum.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProclamationDao {
    @Select("select * from proclamation")
    public List<Proclamation> findAll() throws Exception;
    @Insert("insert into proclamation(procontent,prosta,prodate) VALUES(#{procontent},#{prosta},#{prodate})")
    public void addproclamation(Proclamation proclamation) throws Exception;

    @Update("UPDATE proclamation set procontent = #{procontent},prosta = #{prosta},prodate = #{prodate}WHERE proid = #{proid};")
    public void updateproclamation(Proclamation proclamation) throws Exception;

    @Delete("delete from proclamation where proid = #{proid}")
    public void delproclamation(Integer proid) throws Exception;

    @Select("select * from proclamation where proid = #{proid}")
    public Proclamation findById(Integer proid) throws Exception;

}
