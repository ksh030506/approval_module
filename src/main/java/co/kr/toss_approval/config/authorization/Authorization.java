package co.kr.toss_approval.config.authorization;

import java.util.Base64;

public class Authorization {
    private final String SECRET_KEY;

    public Authorization() {
        SECRET_KEY = System.getenv("TOSS_SECRET_KEY") + ":";
    }

    public String createToken() {
       return Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }

}
