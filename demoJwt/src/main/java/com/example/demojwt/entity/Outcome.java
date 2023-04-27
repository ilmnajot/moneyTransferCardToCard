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
@Entity(name = "outcome")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private Card from;
    @ManyToOne(optional = false)
    private Card to;
    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Double commissionAmount;


}
