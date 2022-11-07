package com.project.cinematicket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Users")
public class UserEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


private String surname;


private Double moneyBalance;





}
