package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.ITypeDao;
import com.tancyj.forum.domain.Type;
import com.tancyj.forum.service.ITagService;
import com.tancyj.forum.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private ITypeDao typeDao;

    @Override
    public List<Type> findAll() throws Exception {
        List<Type> types = typeDao.findAll();
        return types;
    }

    @Override
    public void addtype(Type type) throws Exception {
        typeDao.addtype(type);
        return;
    }

    @Override
    public void updatetype(Type type) throws Exception {
        typeDao.updatetype(type);
    }

    @Override
    public void deltype(Integer type_id) throws Exception {
        typeDao.deltype(type_id);
    }

    @Override
    public Type findById(Integer type_id) throws Exception {
        Type type = typeDao.findById(type_id);
        return type;
    }
}
