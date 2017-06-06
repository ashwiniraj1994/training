package com.moviesdb.web.service;

import com.moviesdb.exception.ApplicationException;
import com.moviesdb.model.MovieEntity;
import com.moviesdb.web.dao.MovieWebDaoIntf;
import com.moviesdb.web.service.intf.MovieWebServiceIntf;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by ashwinirajasekar on 5/24/17.
 */

@SuppressWarnings("rawtypes")

@Transactional
@Service("movieWebService")
public class MovieWebServiceImpl extends BaseServiceWebImpl<MovieEntity, Integer> implements MovieWebServiceIntf {

        @Autowired
        private MovieWebDaoIntf movieWebDao;

        private static final Logger LOGGER = getLogger(com.moviesdb.web.service.MovieWebServiceImpl.class);

        @Override
        public MovieEntity createMovie(MovieEntity movie) throws ApplicationException {
            Integer id = movieWebDao.insert(movie);
            MovieEntity movieCreated = movieWebDao.selectMovie(id);
            return movieCreated;
        }

        @Override
        public MovieEntity update(MovieEntity movie, Integer id) throws ApplicationException {
            movieWebDao.update(movie);
            MovieEntity siteModified = movieWebDao.selectMovie(id);
            return siteModified;
        }

        @Override
        public MovieEntity delete(Integer id) throws ApplicationException {
            MovieEntity movieDeleted = movieWebDao.select(MovieEntity.class, id);
            if (movieDeleted == null) {
                return null;
            } else {
                LOGGER.info("Movie with id {} is deleted ", movieDeleted.getId());
                movieWebDao.delete(movieDeleted);
                return movieDeleted;
            }
        }

}
