package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.UserEntity;
import com.example.myschedulemysql.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDao extends BaseDBDao<UserEntity, Long> {

    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> findAllByDeletedAtIsNull() {
        return userRepository.findAllByDeletedAtIsNull();
    }

    public boolean existsByUserNameOrTelephone(String username, String telephone) {
        return userRepository.existsByUsernameOrTelephone(username, telephone);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}