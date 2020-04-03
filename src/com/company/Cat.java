package com.company;

public class Cat extends Animals {
    CatSounds sound;
    String y = "кошка";

    public Cat (String Name, String Breed, int Age, CatSounds sound) {
       super(Name, Breed, Age);
       this.sound = sound;
    }
}
