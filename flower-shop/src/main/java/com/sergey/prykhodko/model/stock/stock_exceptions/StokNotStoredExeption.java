package com.sergey.prykhodko.model.stock.stock_exceptions;

public class StokNotStoredExeption extends StockException {

    public StokNotStoredExeption() {
    }

    public StokNotStoredExeption(String message) {
        super(message);
    }

    public StokNotStoredExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public StokNotStoredExeption(Throwable cause) {
        super(cause);
    }
}
