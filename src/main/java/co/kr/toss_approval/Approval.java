package co.kr.toss_approval;

import co.kr.toss_approval.domain.TossResult;

import java.io.IOException;

public interface Approval<T> {
    TossResult<T> execute() throws IOException;
}
