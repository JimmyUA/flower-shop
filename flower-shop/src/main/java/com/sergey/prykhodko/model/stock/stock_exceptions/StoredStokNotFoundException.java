package com.sergey.prykhodko.model.stock.stock_exceptions;

public class StokNotFoundException extends StockException {

    public StokNotFoundException() {
    }

    public StokNotFoundException(String message) {
        super(message);
    }

    public StokNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StokNotFoundException(Throwable cause) {
        super(cause);
    }
}
