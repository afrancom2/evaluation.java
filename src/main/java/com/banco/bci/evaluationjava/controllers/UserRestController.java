package com.banco.bci.evaluationjava.controllers;

import com.banco.bci.evaluationjava.models.dto.UserDto;
import com.banco.bci.evaluationjava.services.IUserService;
import com.banco.bci.evaluationjava.utils.ResponseEnum;
import com.banco.bci.evaluationjava.utils.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserRestController {

    private IUserService userService;

    @PostMapping("/user")
    public void users(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) throws Exception {
        List<String> errors = bindingResult.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        if (!errors.isEmpty()) {
            throw ServiceException.builder()
                    .data(ResponseEnum.BAD_REQUEST)
                    .body(errors)
                    .build();
        }
        userService.registerUser(userDto);
    }
}
