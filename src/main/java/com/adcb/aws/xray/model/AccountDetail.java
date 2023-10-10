package com.adcb.aws.xray.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDetail {
    private String accountNo;
    private Double balance;
    private String currency;
    private String openingDate;
    private String accountHolder;

}