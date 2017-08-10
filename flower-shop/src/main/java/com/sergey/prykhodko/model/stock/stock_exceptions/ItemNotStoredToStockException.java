package com.sergey.prykhodko.model.stock.stock_exceptions;

public class ItemNotStoredToStockException extends StockException{

    public ItemNotStoredToStockException() {
    }

    public ItemNotStoredToStockException(String message) {
        super(message);
    }

    public ItemNotStoredToStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotStoredToStockException(Throwable cause) {
        super(cause);
    }
}
