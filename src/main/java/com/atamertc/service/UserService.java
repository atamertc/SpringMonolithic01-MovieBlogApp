package com.atamertc.service;

import com.atamertc.dto.request.UserLoginRequestDto;
import com.atamertc.dto.request.UserSaveRequestDto;
import com.atamertc.dto.response.UserLoginResponseDto;
import com.atamertc.dto.response.UserSaveResponseDto;
import com.atamertc.exception.ErrorType;
import com.atamertc.exception.MovieAppException;
import com.atamertc.mapper.IUserMapper;
import com.atamertc.repository.IUserRepository;
import com.atamertc.repository.entity.User;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public UserSaveResponseDto createUser(UserSaveRequestDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Kullanici zaten mevcut");
        }
        User user = IUserMapper.INSTANCE.toUser(dto);
        userRepository.save(user);
        return IUserMapper.INSTANCE.toUserSaveResponseDto(user);
    }

    public List<User> findAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            throw new RuntimeException("Data Bulunamadi");
        }
        return userList;
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto dto) {
        Optional<User> user = userRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty()) {
            throw new MovieAppException(ErrorType.LOGIN_ERROR);
        }
        return IUserMapper.INSTANCE.toUserLoginResponseDto(user.get());
    }

    public List<UserLoginResponseDto> findAllUserNameContains(String value) {
        List<User> userList = userRepository.findAllByNameContainingIgnoreCase(value);
        if (userList.isEmpty()) {
            throw new RuntimeException("Sikinti");
        }
        return IUserMapper.INSTANCE.toUserLoginResponseDtos(userList);
    }

    public List<User> findAllByOrderByName() {
        return userRepository.findAllByOrderByName();
    }

    public List<User> findAllByEmailEndingWith(String value) {
        return userRepository.findAllByEmailEndingWith(value);
    }

    public List<User> findAllByPasswordLongerThan(Integer sayi) {
        return userRepository.findAllByPasswordLongerThan(sayi);
    }

    public List<User> findAllByPasswordLongerThan2(Integer sayi) {
        return userRepository.findAllByPasswordLongerThan2(sayi);
    }

    public List<User> findAllByPasswordLongerThan3(Integer sayi) {
        return userRepository.findAllByPasswordLongerThan3(sayi);
    }
}
