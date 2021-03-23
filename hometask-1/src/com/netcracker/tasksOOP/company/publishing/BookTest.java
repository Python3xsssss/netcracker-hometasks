package com.netcracker.tasksOOP.company.publishing;

public class BookTest {
    public static void main(String[] args) {
        System.out.println("--------- 4. Book: test ---------");

        Book.Author[] authors = new Book.Author[]{
                new Book.Author("Ivan Ivanov", "iivanov@mail.ru", 'm'),
                new Book.Author("Petr Petrov", "ppetrov@mail.ru", 'm'),
                new Book.Author("Mikhail Mikhailov", "mmikhailov@mail.ru", 'm'),
        };

        Book newBook = new Book("Untitled", authors, 500.0, 5);
        System.out.println(newBook.toString());
        System.out.println("Authors: " + newBook.getAuthorNames());

        System.out.println("---------------------------------\n\n");
    }
}
