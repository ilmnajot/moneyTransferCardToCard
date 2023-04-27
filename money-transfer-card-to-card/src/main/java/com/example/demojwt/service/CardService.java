package com.example.demojwt.service;

import com.example.demojwt.entity.Card;
import com.example.demojwt.payload.CardDto;
import com.example.demojwt.repository.CardCRepository;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class CardService {

    private final CardCRepository cardCRepository;

    public CardService(CardCRepository cardCRepository) {
        this.cardCRepository = cardCRepository;
    }

    public ResponseEntity<?> getAll() {
        return ok(cardCRepository.findAll());
    }

    public ResponseEntity<?> getOne(Long cardId) {
        Optional<Card> optionalCard = cardCRepository.findById(cardId);
        if (optionalCard.isEmpty())
            return notFound().build();
        return ok(optionalCard.get());
    }

    public ResponseEntity<?> createCard(CardDto cardDto, HttpServletRequest request) {
        Card card = new Card();
        request.getUserPrincipal().getName(),
                cardDto.getBalance() != null ? cardDto.getBalance():0D,
        new Date(),
        Date.from(LocalDateTime.now().plusYears(10).toInstant(ZoneOffset.UTC))
        return null;
    }
}
