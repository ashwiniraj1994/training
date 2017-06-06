/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.web.dao;

import com.moviesdb.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Transactional
@Repository("baseWebDao")
public abstract class BaseWebDao<T, id extends Serializable> implements BaseWebDaoIntf<T, id> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseWebDao.class);
    public static final String DAO_ERROR = "DAO Error";
   // @Autowired
   // private SessionFactory sessionFactory;

    @Autowired
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public String isConnected() {
        return Boolean.toString(getCurrentSession().isConnected());
    }

    @Override
    public Integer insert(T entityClass) throws ApplicationException {
        Integer iD = null;
        try {
            iD = Integer.parseInt(getCurrentSession().save(entityClass).toString());
            //Add a force refresh for cases where we do operations like insert/update followed by a select.
            //Required because user_query_cache = true returns cached data for queries like select.
            //A flush() should be called for a refersh()
            //getCurrentSession().flush();
            //getCurrentSession().refresh(entityClass);
        } catch (Exception e) {
            throw new ApplicationException("Insert " + DAO_ERROR, e);
        }
        return iD;

    }

    @Override
    public void update(T entityClass) throws ApplicationException {
        try {
            getCurrentSession().merge(entityClass);
            //Add a force refresh for cases where we do operations like insert/update followed by a select.
            //Required because user_query_cache = true returns cached data for queries like select.
            //A flush() should be called for a refersh()
            getCurrentSession().flush();
            getCurrentSession().refresh(entityClass);
        } catch (Exception e) {
            throw new ApplicationException("Update " + DAO_ERROR, e);
        }

    }

    @Override
    public void saveUpdate(T entityClass) throws ApplicationException {
        try {
            getCurrentSession().saveOrUpdate(entityClass);
        } catch (Exception e) {
            throw new ApplicationException("Update " + DAO_ERROR, e);
        }

    }

    @Override
    public void evict(T entityClass) throws ApplicationException {
        try {
            getCurrentSession().evict(entityClass);
        } catch (Exception e) {
            throw new ApplicationException("Evict " + DAO_ERROR, e);
        }
    }

    @Override
    public void refresh(T entityClass) throws ApplicationException {
        try {
            getCurrentSession().refresh(entityClass);
        } catch (Exception e) {
            throw new ApplicationException("Refresh " + DAO_ERROR, e);
        }

    }

    @Override
    public void delete(T entityClass) throws ApplicationException {
        LOGGER.info("deleting {}", entityClass.getClass());
        try {
            getCurrentSession().delete(entityClass);
        } catch (Exception e) {
            throw new ApplicationException("Delete " + DAO_ERROR, e);
        }

    }

    @Override
    public void deleteAll(Class clazz) throws ApplicationException {
        try {
            String hql = String.format("delete from %s", clazz.getName());
            Query query = getCurrentSession().createQuery(hql);
            query.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Delete All " + DAO_ERROR, e);
        }

    }

    @Override
    public T select(Class clazz, Integer id) throws ApplicationException {
        T eb = null;
        try {
            eb = (T) getCurrentSession().get(clazz, id);
        } catch (Exception e) {
            throw new ApplicationException("Select " + DAO_ERROR, e);
        }
        return eb;

    }

    @Override
    public List selectAll(Class clazz) throws ApplicationException {
        List T = null;
        try {
            String hql = String.format("from %s", clazz.getName());
            Query query = getCurrentSession().createQuery(hql);
            T = query.list();
        } catch (Exception e) {
            throw new ApplicationException("Select All " + DAO_ERROR, e);
        }
        return T;
    }

    @Override
    public List paginatedSelect(Class clazz, int pageNumber, int pageSize) throws ApplicationException {
        List T = null;
        try {
            Criteria criteria = getCurrentSession().createCriteria(clazz);
            criteria.setFirstResult((pageNumber) * pageSize);
            criteria.setMaxResults(pageSize);
            T = criteria.list();
        } catch (Exception e) {
            throw new ApplicationException("Paginated Select " + DAO_ERROR, e);
        }
        return T;
    }

    @Override
    public List<T> insertAll(List<T> entityClass, Class clazz) throws ApplicationException {

        List<T> returnList = new ArrayList<T>();
        try {
            for (T t : entityClass) {
                Integer i = Integer.parseInt(getCurrentSession().save(t).toString());
                // Using evict to remove the session object and force Hibernate to do a select
                // Without evict, hibernate isn't doing a select for get() and returning the object in memory after insert
                getCurrentSession().evict(t);
                T eb = (T) getCurrentSession().get(clazz, i);
                returnList.add(eb);
            }
        } catch (Exception e) {
            throw new ApplicationException("Insert All " + DAO_ERROR, e);
        }
        return returnList;
    }

    @Override
    public void updateAll(List<T> entityClass, Class clazz) throws ApplicationException {
        try {
            for (T t : entityClass) {
                getCurrentSession().saveOrUpdate(t);
            }
        } catch (Exception e) {
            throw new ApplicationException("Update All " + DAO_ERROR, e);
        }
    }

    @Override
    public List<T> selectOrdered(Class clazz) throws ApplicationException {
        List<T> dataList = null;
        try {
            //.addOrder(org.hibernate.criterion.Order.desc("created_date") )
            Criteria criteria = getCurrentSession().createCriteria(clazz);
            dataList = criteria.list();
        } catch (Exception e) {
            throw new ApplicationException("Select Ordered " + DAO_ERROR, e);
        }
        return dataList;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    

}
