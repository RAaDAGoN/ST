package ru.st;

public class Book {
    private String title;
    private Author author;
    private int year;

    public Book(String title, Author author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author.getName() +
                ", year=" + year +
                '}';
    }
}

class Author{
    private String name;
    private String gender;
    private String email;

    public Author(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class testingBook{
    public void testBook(){
        Book book1 = new Book("Книга1", new Author("Автор1", "Мужчина", "Email1@mail.ru"), 2010);
        Book book2 = new Book("Книга2", new Author("Автор2", "Женщина", "Email2@mail.ru"), 2015);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }
}
