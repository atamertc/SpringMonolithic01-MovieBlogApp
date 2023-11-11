package com.atamertc.controller;

import com.atamertc.repository.entity.Comment;
import com.atamertc.service.CommentService;
import com.atamertc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/findallcommentbetweendates")
    public ResponseEntity<List<Comment>> findAllByUserIdAndDateBetween(Long userId, String date1, String date2) {
        return ResponseEntity.ok(commentService.findAllByUserIdAndDateBetween(userId, date1, date2));
    }

}
