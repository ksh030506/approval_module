package co.kr.toss_approval.card_benefit.messages;

import lombok.Data;

import java.util.List;

@Data
public class CardBenefitResponse {

    private List<DiscountCards> discountCards;
    private List<InterestFreeCards> interestFreeCards;

    @Data
    private class DiscountCards {
        private String cardCompany;
        private String companyCode;
        private String discountCode;
        private String dueDate;
        private int minimumPaymentAmount;
        private int maximumPaymentAmount;
        private int balance;
        private int discountAmount;
    }

    @Data
    private class InterestFreeCards {
        private String cardCompany;
        private String companyCode;
        private String dueDate;
        private List<Integer> installmentFreeMonths;
        private int minimumPaymentAmount;
    }
}
