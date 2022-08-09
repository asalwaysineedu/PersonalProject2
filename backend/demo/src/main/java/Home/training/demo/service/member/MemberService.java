package Home.training.demo.service.member;

import Home.training.demo.dto.member.MemberRequest;

public interface MemberService {

    public void register(MemberRequest memberDto);
    public boolean checkEmail(String email);
}
