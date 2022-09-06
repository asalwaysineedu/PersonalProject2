package Home.training.demo.service.member;

import Home.training.demo.controller.member.request.MemberRequest;

public interface MemberService {

    void register(MemberRequest memberRequest); // 회원가입
    boolean checkid(String id); // 이메일 중복 체크
    //boolean checkNickname(String nickname); // 닉네임 중복 체크

}
