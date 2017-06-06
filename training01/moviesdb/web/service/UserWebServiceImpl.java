package com.moviesdb.web.service;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.UserEntity;

import javax.transaction.Transactional;

import com.moviesdb.web.dao.BaseWebDaoIntf;
import com.moviesdb.web.dao.UserWebDaoIntf;
import com.moviesdb.web.service.intf.BaseWebServiceIntf;
import com.moviesdb.web.service.intf.UserWebServiceIntf;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service("userWebService")
@SuppressWarnings("rawtypes")
public class UserWebServiceImpl extends BaseServiceWebImpl<UserEntity, Integer> implements UserWebServiceIntf {

    @Autowired
    private UserWebDaoIntf userWebDao;

    private static final Logger LOGGER = getLogger(UserWebServiceImpl.class);

    @Override
    public UserEntity createUser(UserEntity user) throws ApplicationException {
        Integer id = userWebDao.insert(user);
        UserEntity userCreated = userWebDao.selectUser(id);
        return userCreated;
    }

    @Override
    public UserEntity update(UserEntity user, Integer id) throws ApplicationException {
        userWebDao.update(user);
        UserEntity siteModified = userWebDao.selectUser(id);
        return siteModified;
    }

    @Override
    public UserEntity delete(Integer id) throws ApplicationException {
        UserEntity userDeleted = userWebDao.select(UserEntity.class, id);
        if (userDeleted == null) {
            return null;
        } else {
            LOGGER.info("User with id {} is deleted ", userDeleted.getId());
            userWebDao.delete(userDeleted);
            return userDeleted;
        }
    }
}
