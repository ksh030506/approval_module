package co.kr.toss_approval.payments.auto;

import co.kr.toss_approval.Approval;
import co.kr.toss_approval.config.authorization.Authorization;
import co.kr.toss_approval.domain.TossResult;
import co.kr.toss_approval.payments.auto.mesasge.BillingResponse;
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
    public TossResult<BillingResponse> execute() throws IOException {

        String token = authorization.createToken();
        Response execute = Request.post(AUTO_BILLING_URL)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic " + token)
                .bodyString(getParam(), ContentType.APPLICATION_JSON)
                .execute();

        String json = execute.returnContent().asString(Charset.defaultCharset());
        TossResult<BillingResponse> objectTossResult = new TossResult<>();
        objectTossResult.setProperties(new Gson().fromJson(json, BillingResponse.class));
        return objectTossResult;
    }

    public String getParam() throws JsonProcessingException {
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
