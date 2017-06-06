package com.moviesdb.web.dao;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.MovieEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ashwinirajasekar on 5/23/17.
 */


@Repository("movieWebDao")
public class MovieWebDao extends BaseWebDao<MovieEntity, Integer> implements MovieWebDaoIntf {


    @Override
    public MovieEntity selectMovie(Integer id) throws ApplicationException {
        MovieEntity movie = null;
        try {
            movie = (MovieEntity) getCurrentSession().get(MovieEntity.class, id);
        } catch (Exception e) {
            throw new ApplicationException("Select " + DAO_ERROR, e);
        }
        return movie;
    }
}
