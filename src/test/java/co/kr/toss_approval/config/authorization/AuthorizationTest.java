package co.kr.toss_approval.config.authorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class AuthorizationTest {
    Authorization sut;

    @BeforeEach
    void setUp() {
        sut = new Authorization();
    }

    @Test
    void 토스_토큰_생성() {
        System.out.println("Authorization: " + "Basic " + sut.createToken());
    }
}