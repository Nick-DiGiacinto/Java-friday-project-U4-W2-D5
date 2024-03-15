package org.example;

import entities.Magazines;
import entities.Books;
import entities.frequency;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();

        List<Magazines> rivisteList = new ArrayList<>();
        Magazines r1 = new Magazines(3453789011, faker.book().title(), random.nextInt(1945, 2024), random.nextInt(40, 300), frequency.weekly);
        Magazines r2 = new Magazines(5439281033, faker.book().title(), random.nextInt(1945, 2024), random.nextInt(40, 300), frequency.monthly);
        Magazines r3 = new Magazines(7453627123, faker.book().title(), random.nextInt(1945, 2024), random.nextInt(40, 300), frequency.semiannual);
        rivisteList.add(r1);
        rivisteList.add(r2);
        rivisteList.add(r3);
        rivisteList.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this catalog of books and magazines");
        System.out.println("///");
        System.out.println("What do you want to see? Select an option");
        System.out.println("1. Books");
        System.out.println("2. Magazines");
        System.out.println("3. Esc");
        int selection = scanner.nextInt();
    }

}
