package com.moviesdb.web.service.intf;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.MovieEntity;

/**
 * Created by ashwinirajasekar on 5/23/17.
 */
public interface MovieWebServiceIntf extends BaseWebServiceIntf<MovieEntity, Integer> {


    public MovieEntity createMovie(MovieEntity movie) throws ApplicationException;

    public MovieEntity update(MovieEntity site, Integer id) throws ApplicationException;

    public MovieEntity delete(Integer id) throws ApplicationException;
}
