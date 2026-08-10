package com.example.myschedulemysql.service.impl;

import com.example.myschedulemysql.dao.UserDao;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.request.LoginReqDto;
import com.example.myschedulemysql.dto.request.UserRequestDto;
import com.example.myschedulemysql.dto.response.user.UserResponseDto;
import com.example.myschedulemysql.entity.UserEntity;
import com.example.myschedulemysql.exception.ApiException;
import com.example.myschedulemysql.mapper.ErrorMapper;
import com.example.myschedulemysql.mapper.User.UserMapper;
import com.example.myschedulemysql.service.IUserService;
import com.example.myschedulemysql.util.CodeGenerate;
import com.example.myschedulemysql.util.ImageUtil;
import com.example.myschedulemysql.validator.user.UserValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserDao userDao;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public BaseWebResponse<UserResponseDto> Register(UserRequestDto request, MultipartFile file) {

        if (userDao.existsByUserNameOrTelephone(
                request.getUsername(),
                request.getTelephone())) {
            throw new ApiException(new ErrorMapper(409, "User or Telephone already exist"));
        }

        userValidator.UserRegiserValidate(request);

        UserEntity user = save(request, file, null);
        user.setUserCode(CodeGenerate.getCode("PH", user.getId()));
        user = save(request, null, user.getId());

        UserResponseDto data = userMapper.toDto(user);

        return BaseWebResponse.<UserResponseDto>builder()
                .status(200)
                .message("User register successfully")
                .data(data)
                .build();
    }

    @Override
    public String LoginUser(LoginReqDto request)  {
        return "";
    }

    @Override
    public BaseWebResponse<List<UserResponseDto>> getUsers()  {

        List<UserEntity> users = userDao.findAll();
        List<UserResponseDto> data = userMapper.toDto(users);

        return BaseWebResponse.<List<UserResponseDto>>builder()
                .status(200)
                .message("Users retrieved successfully !")
                .data(data)
                .build();
    }


    @Override
    public BaseWebResponse<UserResponseDto> getUserById(Long id) {

        UserEntity user = userDao.findById(id)
                .orElseThrow(() ->
                        new ApiException(new ErrorMapper(404, "User not found"))
                );

        UserResponseDto data = userMapper.toDto(user);

        return BaseWebResponse.<UserResponseDto>builder()
                .status(200)
                .message("User retrieved successfully!")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<UserResponseDto> Update(Long id, UserRequestDto request, MultipartFile file) {

        UserEntity user = save(request, file, id);

        UserResponseDto data = userMapper.toDto(user);

        return BaseWebResponse.<UserResponseDto>builder()
                .status(200)
                .message("User updated successfully!")
                .data(data)
                .build();
    }

    @Transactional
    @Override
    public BaseWebResponse<Void> Delete(Long id) {

        try {
            userDao.findById(id)
                    .orElseThrow(() ->
                            new ApiException(new ErrorMapper(404, "User not found"))
                    );

            userDao.deleteById(id);

            return BaseWebResponse.<Void>builder()
                    .status(200)
                    .message("User deleted successfully!")
                    .build();

        } catch (ApiException e) {
            throw e;
        } catch (Exception e) {
            log.error("Failed to delete user with id {}: {}", id, e.getMessage(), e);
            throw new ApiException(new ErrorMapper(500, "Failed to delete user, please try again"));
        }
    }

    private UserEntity save(UserRequestDto request, MultipartFile file, Long id)  {
        try {
            UserEntity user;

            if (Objects.isNull(id)) {
                user = new UserEntity();
                user.setUsername(request.getUsername());
                user.setTelephone(request.getTelephone());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                user.setStatus(request.getStatus());
                user.setCreatedAt(LocalDateTime.now());
            } else {
                user = userDao.findById(id)
                        .orElseThrow(() ->
                                new ApiException(new ErrorMapper(404, "User not found"))
                        );

                if (Objects.nonNull(request)) {
                    if (Objects.nonNull(request.getUsername())) {
                        user.setUsername(request.getUsername());
                    }
                    if (Objects.nonNull(request.getTelephone())) {
                        user.setTelephone(request.getTelephone());
                    }
                    if (Objects.nonNull(request.getPassword())) {
                        user.setPassword(passwordEncoder.encode(request.getPassword()));
                    }
                    if (Objects.nonNull(request.getStatus())) {
                        user.setStatus(request.getStatus());
                    }
                }
            }

            if (Objects.nonNull(file) && !file.isEmpty()) {
                user.setImage(ImageUtil.saveImage(file, "users"));
            }

            return userDao.saveEntity(user);

        } catch (Exception e) {
            log.error("Failed to save user (id={}): {}", id, e.getMessage(), e);
            throw new ApiException(new ErrorMapper(500, "Failed to save user, please try again"));
        }
    }
}