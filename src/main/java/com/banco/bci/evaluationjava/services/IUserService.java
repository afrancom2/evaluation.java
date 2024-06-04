package com.banco.bci.evaluationjava.services;

import com.banco.bci.evaluationjava.models.dto.UserDto;
import com.banco.bci.evaluationjava.utils.ServiceException;

public interface IUserService {

    void registerUser(UserDto userDto) throws ServiceException;

}
