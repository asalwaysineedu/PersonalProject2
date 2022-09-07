package Home.training.demo.service.member;

import Home.training.demo.controller.member.request.MemberRequest;

public interface MemberService {

    void register(MemberRequest memberRequest); // 회원가입
    boolean checkId(String id); // 아이디 중복 체크
    public MemberRequest login (MemberRequest memberRequest); // 로그인


}
