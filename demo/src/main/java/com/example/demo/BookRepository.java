package com.example.demo;

import java.util.List;

public class BookRepository {

    public List<String> findBookTitles() {
        return List.of("GRE", "Harry Potter");
    }
}
