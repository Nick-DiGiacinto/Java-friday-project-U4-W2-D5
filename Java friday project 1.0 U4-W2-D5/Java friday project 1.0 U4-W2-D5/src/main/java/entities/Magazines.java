package entities;

public class Magazines extends Catalog {
    public frequency frequency;

    public Magazines(int ISBN, String title, int yearOfPublication, int pageNumber, frequency frequency) {
        super(ISBN, title, yearOfPublication, pageNumber);
        this.frequency = frequency;
    }

    public frequency getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "\nISBN: " + getISBN() +
                "\n Title: " + getTitle() +
                "\nYear of publication: " + getYearOfPublication() +
                "\nNumber of pages: " + getPageNumber() +
                "\nFrequency: " + getFrequency().name() +
                "\n";
    }
}
