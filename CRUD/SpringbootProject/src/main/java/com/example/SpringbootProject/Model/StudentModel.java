package com.example.SpringbootProject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "Student")
public class StudentModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private String email;
    private int age;

    @Override
    public String toString(){
        return "[id = "+ id +" name = "+ name + " email = " + email + " age = " + age + "]";
    }
}
