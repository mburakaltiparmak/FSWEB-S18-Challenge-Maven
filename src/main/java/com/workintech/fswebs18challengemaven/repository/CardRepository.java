package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CardRepository extends JpaRepository <Card,Long> {
    /*
    void save(Card card);
    Card findByColor(String color);
    Card findAll();
    Card findByValue(Integer value);
    Card findByType(String type);
    void update(Card card);
    void remove(long id);

     */
    //select * from fsweb.card c where c.color=color
    @Query(value = "SELECT * FROM FSWEB.card WHERE color = color",nativeQuery = true)
    List<Card> findByColor(String color);
    @Query(value = "SELECT * FROM FSWEB.card WHERE value = value",nativeQuery = true)
    List<Card> findByValue(Integer value);
    @Query(value = "SELECT * FROM FSWEB.card WHERE type = type",nativeQuery = true)
    List<Card> findByType(String type);
}
