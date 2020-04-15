package com.tancyj.forum.service;

import com.tancyj.forum.domain.Type;
import com.tancyj.forum.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ITypeService {
    public List<Type> findAll() throws Exception;
    public void addtype(Type type) throws Exception;
    public void updatetype(Type type) throws Exception;
    public void deltype(Integer type_id) throws Exception;
    public Type findById(Integer type_id) throws Exception;

}
