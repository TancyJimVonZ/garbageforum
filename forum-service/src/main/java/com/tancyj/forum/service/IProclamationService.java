package com.tancyj.forum.service;

import com.tancyj.forum.domain.Proclamation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProclamationService {
    public List<Proclamation> findAll() throws Exception;
    public void addproclamation(Proclamation proclamation) throws Exception;
    public void updateproclamation(Proclamation proclamation) throws Exception;
    public void delproclamation(Integer proid) throws Exception;
    public Proclamation findById(Integer proid) throws Exception;

}
