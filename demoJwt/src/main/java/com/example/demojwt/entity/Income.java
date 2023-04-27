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
@Entity(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Card fromCardId;

    @ManyToOne(optional = false)
    private Card toCardId;


    @Column(nullable = false)
    private Double amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

}
