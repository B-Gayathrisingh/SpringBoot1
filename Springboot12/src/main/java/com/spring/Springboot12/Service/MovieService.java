package com.spring.Springboot12.Service;

import com.spring.Springboot12.Dto.MovieDto;
import com.spring.Springboot12.Entity.MovieEntity;
import com.spring.Springboot12.Repository.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService implements ImplService {
    @Autowired
    private Repo MovieRepository;

    @Override
    public MovieEntity savemovie(MovieDto moviedto) {
        MovieEntity movie = new MovieEntity(
                moviedto.getId(),
                moviedto.getName(),
                moviedto.getArea(),
                moviedto.getPrice()
        );
        MovieEntity savedMovieEntity = MovieRepository.save(movie);

        MovieDto savedMovieDto = new MovieDto(
                savedMovieEntity.getId(),
                savedMovieEntity.getName(),
                savedMovieEntity.getArea(),
                savedMovieEntity.getPrice()

        );

        return savedMovieEntity;
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity getMovie = MovieRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("movie not found id:" + id));

        MovieDto movieDto = new MovieDto(
                getMovie.getId(),
                getMovie.getName(),
                getMovie.getArea(),
                getMovie.getPrice());
        return movieDto;
    }

    @Override
    public MovieDto updateMovie(long id, MovieDto movieDto) {
        MovieEntity existingMovieentity = MovieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found by id:" + id));
        existingMovieentity.setName(movieDto.getName());
        existingMovieentity.setArea(movieDto.getArea());
        existingMovieentity.setPrice(movieDto.getPrice());

        MovieEntity updatemovie=MovieRepository.save(existingMovieentity);
        return  new MovieDto(
                updatemovie.getId(),
                updatemovie.getName(),
                updatemovie.getArea(),
                updatemovie.getPrice()
        );

    }

    @Override
    public MovieEntity deleteMovie(long id) {
        MovieEntity movieEntity = MovieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("movie not found by id:" + id));
        MovieRepository.deleteById(id);
        return movieEntity;
    }
}


