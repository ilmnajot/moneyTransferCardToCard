package com.example.demojwt.repository;

import com.example.demojwt.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCRepository extends JpaRepository<Card, Long> {

    boolean existsByUsernameAndId(String username, Long id);
}
