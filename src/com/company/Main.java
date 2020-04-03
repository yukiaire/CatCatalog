package com.company;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static Animals[] AnimalsCatalog = new Animals[100];
    private static  int AnimalsCount;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Cat cat;
    static Dog dog;

    public static void main(String[] args) throws Exception {
        AnimalsCatalog[0] = new Cat("Васька", "Полосатый", 2, CatSounds.Murrr);
        AnimalsCatalog[1] = new Cat("Нишка", "Сфинкс", 3, CatSounds.Arrr);
        Cat cat1 = (Cat)AnimalsCatalog[1];
            System.out.println(cat1.sound);

        AnimalsCatalog[1].ShowName();
        AnimalsCount = 2;
        boolean isExit = false;

        while (!isExit) {
            for (int i = 0; i < AnimalsCount; i++) {
                System.out.print("Имя: " + AnimalsCatalog[i].Name + " Порода: " + AnimalsCatalog[i].Breed + " Возраст: " + AnimalsCatalog[i].Age);

                if (AnimalsCatalog[i] instanceof Cat) {
                    cat = (Cat) AnimalsCatalog[i];
                    System.out.println(" Мурчит: " + cat.sound);
                }
                else {
                    dog = (Dog)AnimalsCatalog[i];
                    System.out.println(" Команды: " + dog.QuantityCommands());
                }
            }
            System.out.println("Введите 1, чтобы добавить животное, 2 чтобы удалить, 3 - выход ");
            int Command = Integer.parseInt(reader.readLine());
            switch (Command) {
                case 1:
                    System.out.println("Введите 1, чтобы добавить кошку, введите 2, чтобы добавить собаку, 3 - выйти");
                    CreateAnimal(Integer.parseInt(reader.readLine()));
                    break;
                case 2:
                    System.out.println("Введите номер животного для удаления");
                    int numberAnimal = Integer.parseInt(reader.readLine()) - 1;

                    for (int k = numberAnimal; k < AnimalsCount; k++)
                        if (k + 1 == AnimalsCount) {
                            AnimalsCatalog[AnimalsCount - 1] = null;
                            AnimalsCount--;
                        } else
                            AnimalsCatalog[k] = AnimalsCatalog[k + 1];
                    break;
                default:
                    isExit = true;
                    break;
            }
        }
    }

    public static void CreateCat() throws IOException {
        System.out.print("Введите имя: ");
        String Name = reader.readLine();
        System.out.print(" введите породу: ");
        String Breed = reader.readLine();
        System.out.print(" введите возраст: ");
        int Age = Integer.parseInt(reader.readLine());
        System.out.println("Введите уровень мурчания: 1-3");
        CatSounds CatSound = CatSounds.values()[Integer.parseInt(reader.readLine()) - 1];
        AnimalsCatalog[AnimalsCount] = new Cat(Name, Breed, Age, CatSound);
        AnimalsCount++;
    }

    public static void CreateDog() throws IOException {
        System.out.print("Введите имя: ");
        String NameDog = reader.readLine();
        System.out.print(" введите породу: ");
        String BreedDog = reader.readLine();
        System.out.print(" введите возраст: ");
        int AgeDog = Integer.parseInt(reader.readLine());
        System.out.println("Введите команды, которые знает собака: 1 - Фас, 2 - Аппорт, 3 - Умри, 4 - Дай лапу, " +
                "5 - Хороший мальчик, 0 - продолжить");
        int com = 1;
        Commands[] coms = new Commands[5];

        while (com != 0) {
            com = Integer.parseInt(reader.readLine());
            if (com == 0) break;
            coms[com-1] = Commands.values()[com-1];
            System.out.printf("введите команды, которые знает собака: 1 - фас %s 2 - аппорт %s 3 - умри %s " +
                "4 - дай лапу %s 5 - хороший мальчик %s",
                coms[0] != null ? "(выбрана)" : "",
                coms[1] != null ? "(выбрана)" : "",
                coms[2] != null ? "(выбрана)" : "",
                coms[3] != null ? "(выбрана)" : "",
                coms[4] != null ? "(выбрана)" : "");
        }
        AnimalsCatalog[AnimalsCount] = new Dog(NameDog, BreedDog, AgeDog, coms);
        AnimalsCount++;
    }

    public static void CreateAnimal (int AddAnimal) throws IOException {
        switch (AddAnimal) {
            case 1:
                CreateCat();
                System.out.flush();
                break;
            case 2:
                CreateDog();
                System.out.flush();
                break;
            case 3:
                break;
        }
    }
}