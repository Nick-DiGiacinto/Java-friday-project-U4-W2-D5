package texts;

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

//Tutte le scelte utente sono presenti nel file Application contenuto nel package org.example

public class FileMainForBookAndMagazines {
    public static void main(String[] args) {
        Random random = new Random();
        Faker faker00 = new Faker();
        frequency[] values = frequency.values();
        List<String> authorList = new ArrayList<>();
        authorList.add(faker00.book().author());
        authorList.add(faker00.book().author());
        authorList.add(faker00.book().author());
        Supplier<Books> randomBooks = () -> new Books(random.nextInt(1, 1000000000), faker00.book().title(), random.nextInt(1890, 2024), random.nextInt(40, 650), authorList.get(random.nextInt(0, authorList.size())), faker00.book().genre());
        Supplier<Magazines> randomMagazines = () -> new Magazines(random.nextInt(1, 1000000000), faker00.book().title(), random.nextInt(1890, 2024), random.nextInt(40, 650), values[random.nextInt(0, values.length)]);

        List<Magazines> magazinesList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            magazinesList.add(randomMagazines.get());
        }
        List<Books> booksList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            booksList.add(randomBooks.get());
        }

        File books = new File("src/main/java/texts/books.txt");
        File magazines = new File("src/main/java/texts/magazines.txt");
        try {
            FileUtils.writeStringToFile(books, booksList + System.lineSeparator(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(magazines, magazinesList + System.lineSeparator(), StandardCharsets.UTF_8);
            System.out.println("written");
            // leggiamo il contenuto del file
            String contentMagazines = FileUtils.readFileToString(magazines, StandardCharsets.UTF_8);
            String contentBook = FileUtils.readFileToString(books, StandardCharsets.UTF_8);
            System.out.println("///Magazines///");
            System.out.println(contentBook);
            System.out.println("///Books///");
            System.out.println(contentMagazines);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
