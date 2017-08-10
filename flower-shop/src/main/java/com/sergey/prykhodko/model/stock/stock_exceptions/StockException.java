package com.sergey.prykhodko.model.stock.stock_exceptions;

public class StockException extends Exception{

    public StockException() {
    }

    public StockException(String message) {
        super(message);
    }

    public StockException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockException(Throwable cause) {
        super(cause);
    }
}
