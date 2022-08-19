package Home.training.demo.service.member;

import Home.training.demo.dto.member.MemberRequest;
import Home.training.demo.entity.member.Member;

public interface MemberService {

    void register(MemberRequest memberRequest); // 가입
    //boolean checkEmail(String email); // 이메일 중복 체크
    //boolean checkNickname(String nickname); // 닉네임 중복 체크

}
