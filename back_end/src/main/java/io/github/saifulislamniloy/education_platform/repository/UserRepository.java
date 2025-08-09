package io.github.saifulislamniloy.education_platform.repository;

import io.github.saifulislamniloy.education_platform.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByPid(UUID pid);
}
