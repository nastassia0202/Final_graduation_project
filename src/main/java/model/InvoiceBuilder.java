package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceBuilder {
    private int id;
    private String serviceOption;
    private int accountNumber;
    private int amount;
    private String payment_purpose;
    private boolean isActive;
}
