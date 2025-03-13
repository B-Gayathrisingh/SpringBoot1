package com.spring.Springboot12.Service;

import com.spring.Springboot12.Dto.MovieDto;
import com.spring.Springboot12.Entity.MovieEntity;

public interface ImplService {
    MovieEntity savemovie(MovieDto moviedto);
    MovieDto getById(long id);
   MovieDto updateMovie(long id, MovieDto movieDto);
    MovieEntity deleteMovie(long id);
}
