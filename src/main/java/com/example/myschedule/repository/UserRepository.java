package com.example.myschedule.repository;

import com.example.myschedule.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAllByDeletedAtIsNull();

    boolean existsByUsernameOrTelephone(String username, String telephone);

    void deleteById(Long id);

    Optional<UserEntity> findByUsername(String username);
}
