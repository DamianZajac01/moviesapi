package com.apriproject.api.service;

import com.apriproject.api.dto.MovieUpdateDto;
import com.apriproject.api.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(Long id);

    Movie save(Movie movie);

    Movie update(MovieUpdateDto movieUpdateDto, Long movieId);

    void deleteById(Long id);
}
