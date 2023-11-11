package com.atamertc.repository;

import com.atamertc.repository.entity.Comment;
import com.atamertc.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end);
}
