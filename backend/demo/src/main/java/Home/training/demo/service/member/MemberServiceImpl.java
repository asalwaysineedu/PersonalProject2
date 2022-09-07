package Home.training.demo.service.member;

import Home.training.demo.controller.member.request.MemberRequest;
import Home.training.demo.entity.member.Member;
import Home.training.demo.entity.member.MemberAuth;
import Home.training.demo.repository.member.MemberAuthRepository;
import Home.training.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Override
    public void register(MemberRequest memberRequest) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getPassword(), memberRequest.getNickname(), memberRequest.getProfileImg());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    // 아이디 중복 여부 체크
    @Override
    public boolean checkId(String id) {
        // DB에 가서 지금 요청들어온 아이디랑 똑같은 아이디가 있는지 찾아봐라
        Optional<Member> check = memberRepository.checkId(id);
        System.out.println("check : " + check.isEmpty());
        return check.isEmpty();
    }

    // 로그인
    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findById(memberRequest.getId());

        if (maybeMember == null) {
            log.info("해당 아이디의 멤버가 없습니다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("비밀번호를 잘못 입력했습니다.");
            return null;
        }

        if (loginMember.getId().equals(memberRequest.getId())) {
            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setId(loginMember.getId());
            memberRequest.setPassword(loginMember.getPassword());
            memberRequest.setNickname(loginMember.getNickname());
            memberRequest.setProfileImg(loginMember.getProfileImg());
        }


        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),
                memberRequest.getId(),
                null,
                memberRequest.getNickname(),
                memberRequest.getProfileImg(),
                memberRequest.getAuth()
        );

        return response;
    }

}
