package com.moviesdb.web.dao;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.UserEntity;

/**
 * Created by shanvini on 5/20/17.
 */
public interface UserWebDaoIntf extends BaseWebDaoIntf<UserEntity, Integer> {

    public UserEntity selectUser(Integer id) throws ApplicationException;

}
