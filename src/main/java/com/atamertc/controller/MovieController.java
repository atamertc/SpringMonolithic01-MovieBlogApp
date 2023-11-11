package com.atamertc.controller;

import com.atamertc.dto.response.RatingResponseDto;
import com.atamertc.repository.entity.Movie;
import com.atamertc.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/findbyuserfavgenres")
    public ResponseEntity<List<Movie>> findByUserFavGenres(Long userId) {
        return ResponseEntity.ok(movieService.findByUserFavGenres(userId));
    }

    @GetMapping("/searchbyrating")
    public ResponseEntity<List<RatingResponseDto>> searchByRating(Double rating) {
        return ResponseEntity.ok(movieService.searchByRating(rating));
    }

    @GetMapping("/findallbyratingin")
    public ResponseEntity<List<Movie>> findAllByRatingIn(Double[] ratings) {
        return ResponseEntity.ok(movieService.findAllByRatingIn(ratings));
    }

    @GetMapping("/ratinggreaterthan/{rate}")
    public ResponseEntity<List<Movie>> findAllByRatingGreaterThan(@PathVariable Double rate) {
        //http://localhost:9090/movie/ratinggreaterthan?rate=8
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(rate));
    }

    @GetMapping("/premieredbefore")
    public ResponseEntity<List<Movie>> findAllByPremiredBefore(@RequestParam(defaultValue = "1997-05-05") String date) {
        return ResponseEntity.ok(movieService.findAllByPremiredBefore(date));
    }
}
