package co.kr.toss_approval.payments.auto;

import co.kr.toss_approval.domain.TossResult;
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
        TossResult<Object> execute = sut.execute();
        System.out.println("execute.getProperties() = " + execute.getProperties());
    }
}