package com.game.clicker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.game.clicker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    @Modifying
    @Query("update User u set u.score = u.score+1 where u.username = ?1")
    void setUserScoreByUsername(String username);
}
