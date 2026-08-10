package com.example.myschedulemysql.validator.user;

import com.example.myschedulemysql.dto.request.UserRequestDto;
import com.example.myschedulemysql.exception.ApiException;
import com.example.myschedulemysql.mapper.ErrorMapper;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void UserRegiserValidate(UserRequestDto user) {

        if(user.getUsername()==null || user.getUsername().length()==0){
            throw new ApiException(new ErrorMapper(400, " Invalid User name"));
        }

        if(user.getPassword()==null || user.getPassword().length()==0 || user.getPassword().length()< 8){
            throw new ApiException(new ErrorMapper(400, " Password cannot be less than 8 characters"));
        }

        if(user.getTelephone()==null || user.getTelephone().length()==0){
            throw new ApiException(new ErrorMapper(400, " Invalid Telephone Number"));
        }

    }
}
