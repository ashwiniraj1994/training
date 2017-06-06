/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.web.dao;

import com.moviesdb.exception.ApplicationException;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;


public interface BaseWebDaoIntf<T, id extends Serializable> {

    public String isConnected();

    public T select(Class clazz, Integer id) throws ApplicationException;

    public Integer insert(T entityClass) throws ApplicationException;

    public void update(T entityClass) throws ApplicationException;

    public void delete(T entityClass) throws ApplicationException;

    public void deleteAll(Class clazz) throws ApplicationException;

    public List selectAll(Class clazz) throws ApplicationException;

    public List paginatedSelect(Class clazz, int pageNumber, int pageSize) throws ApplicationException;

    public List<T> insertAll(List<T> entityClass, Class clazz) throws ApplicationException;

    public void updateAll(List<T> entityClass, Class clazz) throws ApplicationException;

    public List<T> selectOrdered(Class clazz) throws ApplicationException;

    public void saveUpdate(T entityClass) throws ApplicationException;

    public void evict(T entityClass) throws ApplicationException;

    public void refresh(T entityClass) throws ApplicationException;

    public Session getCurrentSession();
}
