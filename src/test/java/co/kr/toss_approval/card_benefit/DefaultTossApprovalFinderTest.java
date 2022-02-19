package co.kr.toss_approval.card_benefit;


import co.kr.toss_approval.Approval;
import co.kr.toss_approval.DefaultTossApprovalFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static co.kr.toss_approval.domain.TossApprovalType.CARDBENEFIT;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DefaultTossApprovalFinderTest {

    DefaultTossApprovalFinder sut;

    @Mock
    CardBenefit cardBenefit;

    @BeforeEach
    void setUp() {
        sut = new DefaultTossApprovalFinder();
    }

    @Test
    @DisplayName("타입으로_카드혜택_찾기")
    void 타입으로_카드혜택_찾기() throws IOException {
        sut.add(CARDBENEFIT, cardBenefit);

        Approval actual = sut.findBy(CARDBENEFIT);

        assertThat(actual).isSameAs(cardBenefit);
    }

}