package co.kr.toss_approval.payments.auto;

import co.kr.toss_approval.Approval;
import co.kr.toss_approval.config.authorization.Authorization;
import co.kr.toss_approval.domain.TossResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.core5.http.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;

public class AutoPayments implements Approval {

    private final ObjectMapper objectMapper;
    private final String AUTO_BILLING_URL;
    private final Authorization authorization;

    public AutoPayments() {
        this.objectMapper = new ObjectMapper();
        this.authorization = new Authorization();
        AUTO_BILLING_URL = "https://api.tosspayments.com/v1/billing/authorizations/card";
    }

    @Override
    public TossResult<Object> execute() throws IOException {
        Response execute = Request.post(AUTO_BILLING_URL)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic dGVzdF9za18wUG94eTFYUUw4UmcyNkJrR0dZMzduTzVXbWxnOg==")
                .bodyString(aaa(), ContentType.APPLICATION_JSON)
                .execute();

        String json = execute.returnContent().asString(Charset.defaultCharset());
        TossResult<Object> objectTossResult = new TossResult<>();
        objectTossResult.setProperties(new Gson().fromJson(json, Object.class));
        return objectTossResult;
    }

    public String aaa() throws JsonProcessingException {
        Billing billing = Billing.builder()
                .cardNumber("5594382013964336")
                .cardExpirationYear("25")
                .cardExpirationMonth("09")
                .cardPassword("56")
                .customerBirthday("030506")
                .customerKey("120s8dkel8dl")
                .build();

        return objectMapper.writeValueAsString(billing);
    }

    @Data
    @Builder
    public static class Billing {
        private String cardNumber;
        private String cardExpirationYear;
        private String cardExpirationMonth;
        private String cardPassword;
        private String customerBirthday;
        private String customerKey;
    }
}
