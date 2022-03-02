package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {
    private int id;
    private String serviceOption;
    private String accountNumber;
    private String amount;
    private String payment_purpose;
    private boolean isActive;

    public Invoice getInvoice(){
        return Invoice.builder()
                .serviceOption("database")
                .accountNumber("database")
                .amount("database")
                .payment_purpose("database")
                .isActive(true)
                .build();
    }
}
