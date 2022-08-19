package Home.training.demo.service.member;

import Home.training.demo.dto.member.MemberRequest;
import Home.training.demo.entity.member.Member;
import Home.training.demo.entity.member.MemberAuth;
import Home.training.demo.repository.member.MemberAuthRepository;
import Home.training.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    // 회원가입
    /*
        1. passwordEncoder

    */
    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(
                memberRequest.getEmail(), memberRequest.getPassword(), memberRequest.getNickname(),
                memberRequest.getProfileImg(), memberRequest.getAuth());

        memberEntity.addAuth(authEntity);
        memberRepository.save(memberEntity);
    }

}
