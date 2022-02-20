# 사용 방법

환경 변수 : SECRET_KEY

1. 준비
- toss_approval 모듈을 import
- `TossApprovalFinder`를 빈으로 가져온다.
- `TossApprovalType` 이넘을 만든다.
  - `CARDBENEFIT`

2. 카드 혜택 보기
```tossApprovalFinder.findby(CARDBENEFIT).execute()```

