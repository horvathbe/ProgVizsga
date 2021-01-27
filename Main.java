package horvathbence;

import java.util.ArrayList;
import java.util.List;


class Book {
    private String author;
    private String title;
    private int width;
    private int height;
    private int pageCount;
    private int pagesRead;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Page count: %d, Pages read: %d", title, pageCount, pagesRead);
    }

    public void reset() {
        pagesRead = 0;
    }

    public Book(
            String author,
            String title,
            int thickness,
            int height,
            int pageCount
    ) {
        this.author = author;
        this.title = title;
        this.width = thickness;
        this.height = height;
        this.pageCount = pageCount;
        pagesRead = 0;
    }

    public int readPages(int pages) {
        if (pages <= 0 || pages >= (pageCount + 1))
            return 0;

        if (pagesRead + pages > pageCount) {
            pagesRead = pageCount;
            return pageCount - pagesRead;
        } else {
            pagesRead += pages;
            return pages;
        }
    }
}

class Shelf {
    private int width;
    private int height;
    private List<Book> books = new ArrayList<>();

    public int getOccupiedWidth() {
        int occupied = 0;

        for (Book b : books)
            occupied += b.getWidth();

        return occupied;
    }

    public int getWidht() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Book getBookAt(int i) {
        return books.get(i);
    }

    public void removeBookAt(int i) {
        books.remove(i);
    }

    public int getBookCount() {
        return books.size();
    }

    public Shelf(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean placeBook(Book b) {
        if (height < b.getHeight() || b.getWidth() > (width - getOccupiedWidth()))
            return false;

        books.add(b);
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        for (Book b : books)
            str += b + "\n";

        return str;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
