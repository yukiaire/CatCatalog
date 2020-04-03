package com.company;

import java.util.ArrayList;

public class Dog extends Animals {
    Commands[] commands;

    public Dog(String Name, String Breed, int Age)
    {
        super(Name, Breed, Age);
    }
    public Dog(String Name, String Breed, int Age,Commands[] commands) {
        super(Name, Breed, Age);
        this.commands = commands;
    }

    public int QuantityCommands() {
        int k = 0;
        for (int i = 0; i < commands.length; i++)
            if (commands[i] != null)
                k++;

        return k;
    }
}
