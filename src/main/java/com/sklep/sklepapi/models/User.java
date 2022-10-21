package com.sklep.sklepapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

   private int id;
   private String name;
   private String surname;
   private String email;
   private int role;
   private String describe;
   private String password;


}
