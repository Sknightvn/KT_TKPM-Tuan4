package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;


    private String name;
}
