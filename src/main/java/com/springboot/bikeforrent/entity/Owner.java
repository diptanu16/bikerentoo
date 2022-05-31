package com.springboot.bikeforrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "bikedata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    private  String bikename;

    private String phoneno;

    private String pincode;

}
