package com.atamertc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {

    //Genel Hatalar
    BAD_REQUEST(4100, "Parametre Hatasi", HttpStatus.BAD_REQUEST),

    //UserService Hatalari
    USER_NOT_FOUND(4101, "Boyle bir kullanici bulunamadi", HttpStatus.NOT_FOUND),
    LOGIN_ERROR(4102, "Kullanici adi veya sifre hatali", HttpStatus.UNAUTHORIZED),

    //MovieService Hatalari
    MOVIE_NOT_FOUND(4201, "Boyle bir film bulunamadi", HttpStatus.NOT_FOUND),

    //CommentService Hatalari
    COMMENT_NOT_FOUND(4301, "Boyle bir yorum bulunamadi", HttpStatus.NOT_FOUND),

    INTERNAL_ERROR_SERVER(5100, "Sunucu Hatasi", HttpStatus.INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
