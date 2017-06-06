/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.web.service;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.web.dao.BaseWebDaoIntf;
import com.moviesdb.web.service.intf.BaseWebServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;


@Transactional
public abstract class BaseServiceWebImpl<T, id extends Serializable> implements BaseWebServiceIntf<T, id> {

    @Autowired
    BaseWebDaoIntf<T, id> baseWebDao;

    public void create(T clazz) throws ApplicationException {

        baseWebDao.insert(clazz);

    }

    @Override
    public T read(Class clazz, Integer id) throws ApplicationException {

        return baseWebDao.select(clazz, id);

    }

    public void update(T clazz) throws ApplicationException {
        baseWebDao.saveUpdate(clazz);
    }

    public void delete(T clazz) throws ApplicationException {

        baseWebDao.delete(clazz);

    }

}
