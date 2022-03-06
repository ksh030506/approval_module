package co.kr.toss_approval.payments.auto.mesasge;

import lombok.Data;

@Data
public class BillingResponse {

    private String mId;
    private String customerKey;
    private String authenticatedAt;
    private String method;
    private String billingKey;
    private String cardCompany;
    private String cardNumber;

}
