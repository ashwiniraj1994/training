package com.moviesdb.web.service.intf;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.UserEntity;

import java.util.List;

/**
 * Created by shanvini on 5/20/17.
 */
public interface UserWebServiceIntf extends BaseWebServiceIntf<UserEntity, Integer> {


    public UserEntity createUser(UserEntity user) throws ApplicationException;

    public UserEntity update(UserEntity site, Integer id) throws ApplicationException;

    public UserEntity delete(Integer id) throws ApplicationException;
}
