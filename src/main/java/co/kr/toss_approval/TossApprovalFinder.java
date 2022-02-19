package co.kr.toss_approval;

import co.kr.toss_approval.domain.TossApprovalType;

public interface TossApprovalFinder {
    Approval findBy(TossApprovalType type);
}
