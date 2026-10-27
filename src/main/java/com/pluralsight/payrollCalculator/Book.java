package com.pluralsight.payrollCalculator;

public class Book {
    public String title;
    public int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String title, int page) {
        this.title = title;
        this.page = page;
    }
}
