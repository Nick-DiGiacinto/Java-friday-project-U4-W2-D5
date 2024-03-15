package entities;

public class Catalog {
    private int ISBN;
    private String title;
    private int yearOfPublication;
    private int pageNumber;

    public Catalog(int ISBN, String title, int yearOfPublication, int pageNumber) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.pageNumber = pageNumber;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearOfPublication() {
        return this.yearOfPublication;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }


}
