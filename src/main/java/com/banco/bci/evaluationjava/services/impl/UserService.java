package com.banco.bci.evaluationjava.services.impl;

import com.banco.bci.evaluationjava.dao.UserDao;
import com.banco.bci.evaluationjava.models.dto.UserDto;
import com.banco.bci.evaluationjava.models.dto.UserResponseDto;
import com.banco.bci.evaluationjava.models.entity.Phone;
import com.banco.bci.evaluationjava.models.entity.Users;
import com.banco.bci.evaluationjava.services.IUserService;
import com.banco.bci.evaluationjava.utils.ResponseEnum;
import com.banco.bci.evaluationjava.utils.ServiceException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private UserDao userDao;

    @Override
    public void registerUser(UserDto userDto) throws ServiceException {
        Users usersList = userDao.findUsersByEmail(userDto.getEmail());
        if (usersList == null) {
            Users userFinal = Users.builder()
                    .email(userDto.getEmail())
                    .password(userDto.getPassword())
                    .createdDate(LocalDateTime.now())
                    .modifiedDate(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .token(UUID.randomUUID().toString())
                    .isActive(true)
                    .build();

            List<Phone> phoneList = new ArrayList<>();
            if (userDto.getPhones() != null && !userDto.getPhones().isEmpty()) {
                phoneList = userDto.getPhones().stream()
                        .map(phoneDto -> Phone.builder()
                                .number(phoneDto.getNumber())
                                .cityCode(phoneDto.getCitycode())
                                .countryCode(phoneDto.getCountrycode())
                                .users(userFinal)
                                .build()
                        ).collect(Collectors.toList());
            }
            userFinal.setPhones(phoneList);
            userDao.save(userFinal);

            UserResponseDto userResponseDto = UserResponseDto.builder()
                    .id(userFinal.getId())
                    .created(userFinal.getCreatedDate())
                    .modified(userFinal.getModifiedDate())
                    .lastLogin(userFinal.getLastLogin())
                    .token(userFinal.getToken())
                    .isActive(userFinal.getIsActive()).build();

            throw ServiceException.builder()
                    .data(ResponseEnum.OK)
                    .body(userResponseDto)
                    .build();
        } else {
            throw ServiceException.builder()
                    .data(ResponseEnum.NOT_USERS_EMAIL)
                    .build();
        }
    }

}
