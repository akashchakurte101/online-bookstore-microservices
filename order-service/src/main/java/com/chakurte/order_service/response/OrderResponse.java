package com.chakurte.order_service.response;

import com.chakurte.order_service.model.Book;

public class OrderResponse {
    private int userId;

    private int bookId;

    private int quantity;

    private Book book;

    public OrderResponse(int userId, int bookId, int quantity, Book book) {
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.book = book;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
