package com.game.clicker.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="score", nullable = false)
    private Integer score;


    public User(String username, String password) {
        this.username=username;
        this.password=password;
        this.score=0;
    }
    public User() {}

}
