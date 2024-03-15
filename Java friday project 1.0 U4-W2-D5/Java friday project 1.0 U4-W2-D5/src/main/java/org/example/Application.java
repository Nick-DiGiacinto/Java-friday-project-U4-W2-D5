package org.example;

import entities.Magazines;
import entities.Books;
import entities.frequency;
import entities.Catalog;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();

        List<Magazines> magazinesList = new ArrayList<>();
        Magazines r1 = new Magazines(1453789011, faker.book().title(), random.nextInt(1945, 2024), random.nextInt(40, 300), frequency.weekly);
        Magazines r2 = new Magazines(1539281033, faker.book().title(), random.nextInt(1945, 2024), random.nextInt(40, 300), frequency.monthly);
        Magazines r3 = new Magazines(1653627123, faker.book().title(), random.nextInt(1945, 2024), random.nextInt(40, 300), frequency.semiannual);
        magazinesList.add(r1);
        magazinesList.add(r2);
        magazinesList.add(r3);
        magazinesList.forEach(System.out::println);
        //Faccio uno scanner per consentire all'utente di scegliere cosa vorrebbe visualizzare fra i books o le magazines
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this catalog of books and magazines");
        System.out.println("///");
        System.out.println("What do you want to see? Select an option");
        System.out.println("1. Magazines");
        System.out.println("2. Books");
        System.out.println("3. Esc");
        int selection = scanner.nextInt();
        //creo uno switch case, con altri switch annidati, per consentire all'utente di inserire tutti i dati del magazine o del book che sta cercando,
        // rispettando i parametri della consegna
        switch (selection) {
            case 1:
                System.out.println("1. Insert a new magazine");
                System.out.println("2. See a magazine");
                System.out.println("3. See magazines ordered by year of publication");
                System.out.println("4. Esc");
                System.out.println("///");
                int selection1 = scanner.nextInt();
                switch (selection1) {
                    case 1:
                        System.out.println("Insert the data of the magazine");
                        System.out.println("Insert the ISBN code");
                        int ISBN1 = scanner.nextInt();
                        System.out.println("Insert the title of the magazine");
                        String title1 = scanner.next();
                        System.out.println("Insert the year of publication of the magazine you want to see");
                        int yearOfPublication2 = scanner.nextInt();
                        System.out.println("Insert the number of pages of the magazine");
                        int pageNumber1 = scanner.nextInt();
                        System.out.println("Insert the publication frequency of the magazine");
                        System.out.println("1 - weekly");
                        System.out.println("2 - monthly");
                        System.out.println("3 - semiannual");
                        frequency weekly;
                        frequency monthly;
                        frequency biannual;
                        int sc = scanner.nextInt();
                        Magazines magazine;
                        switch (sc) {
                            case 1:
                                weekly = frequency.weekly;
                                magazine = new Magazines(ISBN1, title1, yearOfPublication2, pageNumber1, weekly);
                                magazinesList.add(magazine);
                                break;
                            case 2:
                                monthly = frequency.monthly;
                                magazine = new Magazines(ISBN1, title1, yearOfPublication2, pageNumber1, monthly);
                                magazinesList.add(magazine);
                                break;
                            case 3:
                                biannual = frequency.semiannual;
                                magazine = new Magazines(ISBN1, title1, yearOfPublication2, pageNumber1, biannual);
                                magazinesList.add(magazine);
                                break;
                            default:
                                System.out.println("Selection invalid");
                                break;
                        }
                        System.out.println("Magazine correctly added");
                        break;
                    case 2:
                        System.out.println("Insert the ISBN code of the magazine");
                        int ISBN4 = scanner.nextInt();
                        for (Magazines magazine1 : magazinesList) {
                            if ((magazine1.getISBN()) == ISBN4) {
                                System.out.println(magazine1);
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Insert the year of publication of the magazine you want to see");
                        int yearOfPublication3 = scanner.nextInt();
                        List<Magazines> magazinesList1 = magazinesList.stream().filter(magazines -> magazines.getYearOfPublication() == yearOfPublication3).toList();
                        magazinesList1.forEach(System.out::println);
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                break;
            case 2:
                System.out.println("1. Insert a new book");
                System.out.println("2. See a book");
                System.out.println("3. See books for year of publication");
                System.out.println("4. See books for author");
                System.out.println("5. Esc");
                System.out.println("///");
                int selection2 = scanner.nextInt();
                switch (selection2) {
                    case 1:
                        System.out.println("Insert the ISBN code of the book you want to see");
                        int ISBN = scanner.nextInt();
                        System.out.println("Insert the title of the book");
                        String title = scanner.next();
                        System.out.println("Insert year of publication");
                        int yearOfPublication = scanner.nextInt();
                        System.out.println("Insert number of pages);
                        int pageNumber = scanner.nextInt();
                        System.out.println("Insert the author of the book");
                        String author = scanner.next();
                        System.out.println("Insert the genre of the book");
                        String genre = scanner.next();
                        Books book = new Books(ISBN, title, yearOfPublication, pageNumber, author, genre);
                        booksList.add(book);
                        System.out.println("Book correctly added");
                        break;
                    case 2:
                        System.out.println("Insert the ISBN code of the book you want to see");
                        int ISBN3 = scanner.nextInt();
                        for (Books book1 : booksList) {
                            if ((book1.getISBN()) == ISBN3) {
                                System.out.println(book1);
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Insert the yaer of publication of the book to visualize");
                        int yearOfPublication2 = scanner.nextInt();
                        List<Books> booksList1 = booksList.stream()
                                .filter(books -> books.getYearOfPublication() == yearOfPublication2)
                                .toList();
                        booksList1.forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("Insert book author");
                        Scanner scanner2 = new Scanner(System.in);
                        String author2 = scanner2.nextLine();
                        List<Books> booksList2 = booksList.stream().filter(booksS -> booksS.getAuthor().equalsIgnoreCase(author2)).collect(Collectors.toList());
                        booksList2.forEach(System.out::println);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
                break;
            case 3:
                System.exit(0);
        }
    }
}
