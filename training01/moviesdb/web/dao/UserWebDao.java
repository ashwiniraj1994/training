package com.moviesdb.web.dao;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shanvini on 5/20/17.
 */
@Repository("userWebDao")
public class UserWebDao extends BaseWebDao<UserEntity, Integer> implements UserWebDaoIntf {


    @Override
    public UserEntity selectUser(Integer id) throws ApplicationException {
        UserEntity user = null;
        try{
            user = (UserEntity) getCurrentSession().get(UserEntity.class, id);
        }catch (Exception e) {
            throw new ApplicationException("Select " + DAO_ERROR, e);
        }
        return user;
    }
}
