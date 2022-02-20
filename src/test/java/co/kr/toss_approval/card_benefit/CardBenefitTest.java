package co.kr.toss_approval.card_benefit;

import co.kr.toss_approval.card_benefit.messages.CardBenefitResponse;
import co.kr.toss_approval.domain.TossResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CardBenefitTest {

    CardBenefit sut;

    @BeforeEach
    void setUp() {
        sut = new CardBenefit();
    }

    @Test
    @DisplayName("api 테스트")
    void api_보내기() throws IOException {
        TossResult<CardBenefitResponse> result = sut.execute();
        System.out.println("result.getProperties() = " + result.getProperties());
        assertThat(result.getProperties()).isInstanceOf(CardBenefitResponse.class);
    }
}