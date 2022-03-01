package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceBuilder {
    private int id;
    private String serviceOption;
    private String accountNumber;
    private String amount;
    private String payment_purpose;
    private boolean isActive;
}
