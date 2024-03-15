package entities;

public class Books extends Catalog{
    public String genre;
    public String author;

    public Books(int ISBN, String title, int yearOfPublication, int pageNumber, String author, String genre) {
        super(ISBN, title, yearOfPublication, pageNumber);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "\nISBN: " + getISBN() +
                "\n Title: " + getTitle() +
                "\nYear of publication: " + getYearOfPublication() +
                "\nNumber of pages: " + getPageNumber() +
                "\nAuthor: " + getAuthor() +
                "\nGenre: " + getGenre() +
                "\n";

    }

}
