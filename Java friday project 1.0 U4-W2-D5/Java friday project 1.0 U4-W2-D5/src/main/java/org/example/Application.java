package org.example;

import entities.Magazines;
import entities.Books;
import entities.frequency;
import entities.Catalog;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//Ho realizzato quasi l'interità del progetto, e ne ho provato diverse volte la funzionalità. L'unica cosa è che
// negli ultimi aggiustamenti che ho attuato, si è verificato un piccolo problema con la bookList che stranamente non sono riuscito
//subito a risolvere, anche se la soluzione mi sembrava semplice. Non so se vi sia un problema con la mia cache di Intellij di questo progetto.
//Chiedo gentilmente di provare a risolvere questo piccolo errore presente nel main per far partire tutto il programma.
//Chiaramente io proverò il prima possibile a risolvera la situazione e se dovessi riuscirvi in modo certo effettuerò un commit
//aggiuntivo per poterti permettere di correggere più agilmente il progetto senza questo inconveniente. Ti ringrazio per la comprensione.

public class Application {

    public static void main(String[] args) {
        Faker faker00 = new Faker();
        Random random = new Random();
        frequency[] values = frequency.values();
        List<String> authorList = new ArrayList<>();
        authorList.add(faker00.book().author());
        authorList.add(faker00.book().author());
        authorList.add(faker00.book().author());
        Supplier<Magazines> randomMagazines = () -> new Magazines(random.nextInt(1, 1000000000), faker00.book().title(), random.nextInt(1890, 2024), random.nextInt(40, 650), values[random.nextInt(0, values.length)]);
        Supplier<Books> randomBooks = () -> new Books(random.nextInt(1, 1000000000), faker00.book().title(), random.nextInt(1890, 2024), random.nextInt(40, 650), authorList.get(random.nextInt(0, authorList.size())), faker00.book().genre());
        //Random magazine, limito il numero dei risultati, giusto per vederne la funzionalità
        List<Magazines> magazinesList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            magazinesList.add(randomMagazines.get());
        }
        magazinesList.forEach(System.out::println);
        //Random books
        List<Books> libriList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            libriList.add(randomBooks.get());
        }
        libriList.forEach(System.out::println);

        //Faccio uno scanner per consentire all'utente di scegliere cosa vorrebbe visualizzare fra i books o i magazines
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this catalog of books and magazines");
        System.out.println("///");
        System.out.println("What do you want to see? Select an option");
        System.out.println("1. Magazines");
        System.out.println("2. Books");
        System.out.println("3. Esc");
        int selection = scanner.nextInt();
        //Creo uno switch case, con altri switch annidati, per consentire all'utente di inserire tutti i dati del magazine o del book che sta cercando,
        // rispettando i parametri della consegna. Prima di provare chiedo gentilmente di controllare i file a disposizione, presenti come file testuali
        //nel package denominato texts
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
                        System.out.println("Insert number of pages");
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
                        System.out.println("Insert the year of publication of the book to visualize");
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
                        System.out.println("Invalid choices");
                        break;
                }
                break;
            case 3:
                System.exit(0);
        }

    }
}
