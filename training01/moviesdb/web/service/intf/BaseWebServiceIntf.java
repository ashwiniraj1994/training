/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesdb.web.service.intf;

import com.moviesdb.exception.ApplicationException;

import java.io.Serializable;


public interface BaseWebServiceIntf<T, id extends Serializable> {

    public void create(T clazz) throws ApplicationException;

    public T read(Class clazz, Integer id) throws ApplicationException;

    public void update(T clazz) throws ApplicationException;

    public void delete(T clazz) throws ApplicationException;
}
