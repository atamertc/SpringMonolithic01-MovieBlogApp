package com.atamertc.mapper;

import com.atamertc.dto.request.UserSaveRequestDto;
import com.atamertc.dto.response.UserLoginResponseDto;
import com.atamertc.dto.response.UserSaveResponseDto;
import com.atamertc.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final UserSaveRequestDto dto);

    UserSaveResponseDto toUserSaveResponseDto(final User user);

    UserLoginResponseDto toUserLoginResponseDto(final User user);

    List<UserLoginResponseDto> toUserLoginResponseDtos(final List<User> userList);

}
