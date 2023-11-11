package com.atamertc.dto.response;

import com.atamertc.repository.entity.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponseDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private List<Long> favMovies;

    private List<Long> favGenres;

    private List<Long> comments;

    private EUserType userType;

}
