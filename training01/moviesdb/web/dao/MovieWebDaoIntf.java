package com.moviesdb.web.dao;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.MovieEntity;


/**
 * Created by ashwinirajasekar on 5/23/17.
 */

public interface MovieWebDaoIntf extends BaseWebDaoIntf<MovieEntity, Integer> {

        public MovieEntity selectMovie(Integer id) throws ApplicationException;

    }


