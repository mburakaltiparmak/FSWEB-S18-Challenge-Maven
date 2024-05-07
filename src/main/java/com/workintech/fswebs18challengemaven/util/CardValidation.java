package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {
    //TODO Card tipleri düzenlenecek
    public static void validateCard(Card card){
        if(card.getType()!=null && card.getValue()!= null && card.getValue()>0){
            throw new CardException("Mesaj", HttpStatus.BAD_REQUEST);
        }
        if(card.getType().equals(Type.JOKER) && (card.getColor()!=null)|| (card.getValue()!=null && card.getValue()>0)){
            throw new CardException("Eğer kart tipi JOKER ise hem value hem de color null olmalıdır.",HttpStatus.BAD_REQUEST);

        }
    }
}
