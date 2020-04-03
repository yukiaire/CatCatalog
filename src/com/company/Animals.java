package com.company;

public abstract class Animals {
    String Name, Breed;
    int Age, lifeYears;

    public Animals (String Name, String Breed, int Age) {
        this.Name = Name;
        this.Breed = Breed;
        this.Age = Age;
        this.lifeYears = 5;
    }

    public void ShowName() {
        System.out.println(Name);
    }
}
