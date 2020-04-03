package com.company;

public abstract class Animals {
    String Name, Breed;
    int Age;

    public Animals (String Name, String Breed, int Age) {
        this.Name = Name;
        this.Breed = Breed;
        this.Age = Age;
    }

    public void ShowName() {
        System.out.println(Name);
    }
}
