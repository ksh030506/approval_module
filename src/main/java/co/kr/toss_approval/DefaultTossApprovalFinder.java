package co.kr.toss_approval;

import co.kr.toss_approval.card_benefit.CardBenefit;
import co.kr.toss_approval.domain.TossApprovalType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static co.kr.toss_approval.domain.TossApprovalType.CARDBENEFIT;

@Component
public class DefaultTossApprovalFinder implements TossApprovalFinder {
    private final Map<TossApprovalType, Approval> map = new HashMap<>();

    public DefaultTossApprovalFinder() {
        map.put(CARDBENEFIT, new CardBenefit());
    }

    @Override
    public Approval findBy(TossApprovalType type) {
        return map.get(type);
    }

    public void add(TossApprovalType type, CardBenefit cardBenefit) {
        map.put(type, cardBenefit);
    }
}
