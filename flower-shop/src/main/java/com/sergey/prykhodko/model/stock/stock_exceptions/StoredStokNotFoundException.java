package com.sergey.prykhodko.model.stock.stock_exceptions;

public class StoredStokNotFoundException extends StockException {

    public StoredStokNotFoundException() {
    }

    public StoredStokNotFoundException(String message) {
        super(message);
    }

    public StoredStokNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoredStokNotFoundException(Throwable cause) {
        super(cause);
    }
}
