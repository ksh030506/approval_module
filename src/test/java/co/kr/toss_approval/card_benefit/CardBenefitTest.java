package co.kr.toss_approval.card_benefit;

import co.kr.toss_approval.card_benefit.messages.CardBenefitResponse;
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
        CardBenefitResponse result = sut.execute();
        assertThat(result).isInstanceOf(CardBenefitResponse.class);
    }
}