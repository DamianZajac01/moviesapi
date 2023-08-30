package com.apriproject.api.controller;

import com.apriproject.api.dto.MovieUpdateDto;
import com.apriproject.api.entity.Movie;
import com.apriproject.api.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieRestController {

    private final MovieServiceImpl movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable Long movieId) {
        return movieService.findById(movieId);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/{movieId}")
    public Movie updateMovie(@RequestBody MovieUpdateDto movieUpdateDto, @PathVariable Long movieId) {
        return movieService.update(movieUpdateDto, movieId);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable Long movieId) {
        movieService.deleteById(movieId);
    }
}