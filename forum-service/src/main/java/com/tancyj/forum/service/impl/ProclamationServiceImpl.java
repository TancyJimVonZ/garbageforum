package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.IProclamationDao;
import com.tancyj.forum.domain.Proclamation;
import com.tancyj.forum.service.IProclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProclamationServiceImpl implements IProclamationService {
    @Autowired
    private IProclamationDao proclamationDao;

    @Override
    public List<Proclamation> findAll() throws Exception {
        List<Proclamation> proclamations = proclamationDao.findAll();
        return proclamations;
    }

    @Override
    public void addproclamation(Proclamation proclamation) throws Exception {
        proclamationDao.addproclamation(proclamation);
    }

    @Override
    public void updateproclamation(Proclamation proclamation) throws Exception {
        proclamationDao.updateproclamation(proclamation);
    }

    @Override
    public void delproclamation(Integer proid) throws Exception {
        proclamationDao.delproclamation(proid);
    }

    @Override
    public Proclamation findById(Integer proid) throws Exception {
        Proclamation proclamation = proclamationDao.findById(proid);
        return proclamation;
    }
}
