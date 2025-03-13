package com.spring.Springboot12.Controller;

import com.spring.Springboot12.Dto.MovieDto;
import com.spring.Springboot12.Entity.MovieEntity;
import com.spring.Springboot12.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/save")
    public ResponseEntity<MovieEntity> saveMovie(@RequestBody MovieDto movieDto) {
        MovieEntity savedMovie = movieService.savemovie(movieDto);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable long id) {
        MovieDto movieDto = movieService.getById(id);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable long id,
                                              @RequestBody MovieDto movieDto) {
        MovieDto updatedMovie = movieService.updateMovie(id, movieDto);
        return ResponseEntity.ok(updatedMovie);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MovieEntity>deleteMovie(@PathVariable long id){
        MovieEntity Movie=movieService.deleteMovie(id);
        return new ResponseEntity<>(Movie, HttpStatus.OK);
    }

}
