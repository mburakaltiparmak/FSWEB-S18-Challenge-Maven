package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="card",schema = "fsweb")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="value",nullable = false)
    private Integer value;
    @Enumerated(value = EnumType.STRING)
    @Column(name="type")
    private Type type;
    @Enumerated(value = EnumType.STRING)
    @Column(name="color")
    private Color color;

}
