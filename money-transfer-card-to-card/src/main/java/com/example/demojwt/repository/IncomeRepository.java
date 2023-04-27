package com.example.demojwt.repository;

import com.example.demojwt.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income>getAllByToCardId_Id(String cardId_id);
}
