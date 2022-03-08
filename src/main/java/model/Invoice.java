package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {
    private int id;
    private String service_option;
    private String account_number;
    private int amount;
    private String payment_purpose;
    private boolean isActive;

}
