package com.atamertc.service;

import com.atamertc.dto.response.RatingResponseDto;
import com.atamertc.repository.IMovieRepository;
import com.atamertc.repository.entity.Movie;
import com.atamertc.repository.entity.User;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService extends ServiceManager<Movie, Long> {
    private final IMovieRepository movieRepository;
    private final UserService userService;
    private final GenreService genreService;


    public MovieService(IMovieRepository movieRepository, UserService userService, GenreService genreService) {
        super(movieRepository);
        this.movieRepository = movieRepository;
        this.userService = userService;
        this.genreService = genreService;
    }

    public List<Movie> findByUserFavGenres(Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isEmpty()) {
            return new ArrayList<>();
        }
        return movieRepository.findAllByGenresIn(user.get().getFavGenres());
    }

    /**
     * Belli bir Rating uzerindeki bir filmden kac tane oldugunu ve
     * o ratingi beraber getiren metod.
     *
     * @return RatingResponseDto {Double rating, Long count(rating)}
     * @author Atamert Çakır
     */
    public List<RatingResponseDto> searchByRating(Double rating) {
        List<Tuple> tuples = movieRepository.searchByRating(rating);
        List<RatingResponseDto> dtos = new ArrayList<>();
        for (Tuple tuple : tuples) {
            dtos.add(RatingResponseDto.builder()
                    .rating((Double) tuple.get(0))
                    .count((Long) tuple.get(1))
                    .build());
        }
        return dtos;
    }

    public List<Movie> findAllByRatingIn(Double[] ratings) {
        return movieRepository.findAllByRatingIn(Arrays.asList(ratings));
    }

    public List<Movie> findAllByRatingGreaterThan(Double rate) {
        return movieRepository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findAllByPremiredBefore(String date) {
        return movieRepository.findAllByPremiredBefore(LocalDate.parse(date));
    }
}
