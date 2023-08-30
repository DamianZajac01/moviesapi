package com.apriproject.api.service.impl;

import com.apriproject.api.dto.MovieUpdateDto;
import com.apriproject.api.repository.CategoryRepository;
import com.apriproject.api.repository.DirectorRepository;
import com.apriproject.api.repository.MovieRepository;
import com.apriproject.api.entity.Category;
import com.apriproject.api.entity.Director;
import com.apriproject.api.entity.Movie;
import com.apriproject.api.exception.EntityNotFoundException;
import com.apriproject.api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;
    private final DirectorRepository directorRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()
            -> new EntityNotFoundException(String.format("Movie with id: %s not exist.", id)));
    }

    @Override
    public Movie save(Movie movie) {

        Category category = movie.getCategory();
        Optional<Category> tempCategory = categoryRepository.getByName(category.getName());
        tempCategory.ifPresent(movie::setCategory);

        Director director = movie.getDirector();
        Optional<Director> tempDirector = directorRepository.getByFirstNameAndLastName(director.getFirstName(), director.getLastName());
        tempDirector.ifPresent(movie::setDirector);

        movie.getDirector().add(movie);

        return movieRepository.save(movie);
    }

    @Override
    public Movie update(MovieUpdateDto movieUpdateDto, Long movieId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(movieUpdateDto.getReleaseDate(), formatter);

        Movie movie = Movie.builder()
                .id(movieId)
                .title(movieUpdateDto.getTitle())
                .releaseDate(date)
                .rating(movieUpdateDto.getRating())
                .description(movieUpdateDto.getDescription())
                .category(movieUpdateDto.getCategory())
                .director(movieUpdateDto.getDirector()).build();

        return save(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
