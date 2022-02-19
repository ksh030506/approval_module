package co.kr.toss_approval.card_benefit;

import co.kr.toss_approval.Approval;
import co.kr.toss_approval.card_benefit.messages.CardBenefitResponse;
import co.kr.toss_approval.domain.TossResult;
import com.google.gson.Gson;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;

import java.io.IOException;
import java.nio.charset.Charset;

public class CardBenefit implements Approval  {

    @Override
    public TossResult<CardBenefitResponse> execute() throws IOException {
        Response execute = Request.get("https://api.tosspayments.com/v1/promotions/card")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic dGVzdF9za18wUG94eTFYUUw4UmcyNkJrR0dZMzduTzVXbWxnOg==")
                .execute();

        String json = execute.returnContent().asString(Charset.defaultCharset());
        TossResult<CardBenefitResponse> cardBenefitResponseTossResult = new TossResult<>();
        cardBenefitResponseTossResult.setProperties(new Gson().fromJson(json, CardBenefitResponse.class));
        return cardBenefitResponseTossResult;
    }

}
