package com.example.kakaoshopping.domain.user;


import org.springframework.data.jpa.repository.JpaRepository;

//CRUD를 책임 질 것
public interface UserRepository extends JpaRepository<User,Integer> {
}
