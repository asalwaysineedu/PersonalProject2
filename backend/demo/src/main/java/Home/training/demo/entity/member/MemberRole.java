package Home.training.demo.entity.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    MEMBER("ROLE_MEMBER"),     // 일반 유저
    MANAGER("ROLE_MANAGER");     // 사이트 관리자

    private final String value; // value값을 못 바꾸게 final로
}
