package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    @PostMapping
    public Card save(@RequestBody Card card){
        CardValidation.validateCard(card);
        return cardRepository.save(card);
    }
    @GetMapping
    public List<Card> getAll(){
        return cardRepository.findAll();
    }
    @GetMapping("/byColor/{color}")
    public List<Card> getAllByColor(@PathVariable("color") String color){
    return cardRepository.findByColor(color);
    }
    @GetMapping("/byValue/{value}")
    public List<Card> getAllByValue(@PathVariable("value") Integer value){
        return cardRepository.findByValue(value);
    }
    @GetMapping("/byType/{type}")
    public List<Card> getAllByType(@PathVariable("type") String type){
        return cardRepository.findByType(type);
    }
    @PutMapping("/{id}")
    //fixme add id validation
    public Card update(@PathVariable("id") Long id,@RequestBody Card card){
        Optional<Card> optionalCard =cardRepository.findById(id);
        if(!optionalCard.isPresent()){
            throw new CardException("To update need existing id : " + id, HttpStatus.NOT_FOUND);
        }
        card.setId(id);
return cardRepository.save(card);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        //fixme add id validation

        Optional<Card> optionalCard =cardRepository.findById(id);
        if(!optionalCard.isPresent()){
            throw  new CardException("To remove need existing id : " + id, HttpStatus.NOT_FOUND);
        }
        cardRepository.delete(optionalCard.get());
    }

}
