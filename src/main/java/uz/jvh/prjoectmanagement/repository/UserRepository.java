package uz.jvh.prjoectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jvh.prjoectmanagement.entity.UserEntity;
import uz.jvh.prjoectmanagement.enumerators.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findByRole(UserRole role);
}
