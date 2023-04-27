package com.example.demojwt.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OutcomeDto {


    @NotBlank(message = "Enter the card id")
    private String from; // from_card_id

    @NotBlank(message="Enter the card id for payment")
    private String to; // to_card_id
    @NotBlank(message = "Enter amount of expense")
    private Double amount;


}
