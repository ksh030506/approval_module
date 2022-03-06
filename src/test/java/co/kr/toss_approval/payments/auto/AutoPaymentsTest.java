package co.kr.toss_approval.payments.auto;

import co.kr.toss_approval.domain.TossResult;
import co.kr.toss_approval.payments.auto.mesasge.BillingResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AutoPaymentsTest {


    AutoPayments sut;

    @BeforeEach
    void setUp() {
        sut = new AutoPayments();
    }

    @Test
    void 빌링키_발급() throws IOException {
        TossResult<BillingResponse> execute = sut.execute();
        System.out.println("execute.getProperties() = " + execute.getProperties());
    }
}