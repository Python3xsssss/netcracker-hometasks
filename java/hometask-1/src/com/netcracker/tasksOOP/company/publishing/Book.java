package com.netcracker.tasksOOP.company.publishing;

import java.util.Arrays;

public class Book {

    public static class Author {
        private String name;
        private String email;
        private char gender;

        public Author() {
        }

        public Author(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        public Author(Author another) {
            this(another.getName(), another.getEmail(), another.getGender());
        }

        @Override
        protected Object clone() {
            Author author = null;
            author = new Author(
                    this.getName(), this.getEmail(), this.getGender());

            return author;
        }


        @Override
        public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }
    }

    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = new Author[authors.length];
        for (int i = 0; i < authors.length; i++) { // authors.clone(); // Arrays.copyOf(authors, authors.length);
            this.authors[i] = new Author(authors[i]); // c++ style
        }
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this(name, authors, price);
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public String getAuthorNames() {
        StringBuilder out = new StringBuilder();

        for (Author aut: authors) {
            out.append(aut.name).append(", ");
        }

        if (out.length() > 0)
            out = new StringBuilder(out.substring(0, out.length() - 2));

        return out.toString();
    }
}

