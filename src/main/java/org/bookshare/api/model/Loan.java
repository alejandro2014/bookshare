package org.bookshare.api.model;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Data
public class Loan {
    private List<Book> bookLender;
    private List<Book> bookReceiver;
    private Person lender;
    private Person receiver;
    private Optional<SimpleDateFormat> dateDue;
}
