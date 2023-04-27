package com.example.demojwt.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bank_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(name = "card_number", unique = true)
    private String cardNumber;
    private Double balance;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;
    private Boolean active;

}
