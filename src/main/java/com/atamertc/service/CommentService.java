package com.atamertc.service;

import com.atamertc.repository.ICommentRepository;
import com.atamertc.repository.entity.Comment;
import com.atamertc.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService extends ServiceManager<Comment, Long> {
    private final ICommentRepository commentRepository;


    public CommentService(ICommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllByUserIdAndDateBetween(Long userId, String date1, String date2) {
        LocalDate start = LocalDate.parse(date1);
        LocalDate end = LocalDate.parse(date2);
        return commentRepository.findAllByUserIdAndDateBetween(userId, start, end);
    }
}
