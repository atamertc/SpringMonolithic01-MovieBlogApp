package com.atamertc.repository;

import com.atamertc.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {

    //Rating belli bir rating uzerindekileri getirin
    List<Movie> findAllByRatingGreaterThan(Double rate);

    List<Movie> findAllByPremiredBefore(LocalDate date);

    //Belirli bir Kullanıcının ilgi alanlarını kapsayan filmleri geitiriniz
    List<Movie> findAllByGenresIn(List<Long> genres);

    @Query("SELECT m.rating, count(m.rating) FROM Movie m WHERE m.rating>?1 GROUP BY m.rating")
    List<Tuple> searchByRating(Double rating);

    List<Movie> findAllByRatingIn(List<Double> ratings);

}
