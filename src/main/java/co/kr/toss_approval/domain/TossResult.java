package co.kr.toss_approval.domain;

import lombok.Data;

@Data
public class TossResult<T> {

    private Long id = 1L;
    T properties;

}
