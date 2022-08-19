package Home.training.demo.controller.member;

import Home.training.demo.dto.member.MemberRequest;
import Home.training.demo.entity.member.Member;
import Home.training.demo.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http:localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입
    @PostMapping("/register")
    public void register (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("Member register request from vue: " + memberRequest.getEmail() + ", " +
                memberRequest.getPassword() + ", " + memberRequest.getNickname() + ", " +
                memberRequest.getMobile() + ", " +
                (memberRequest.getAuth().equals("관리자") ? "ROLE_ADMIN" : "ROLE_INDIVIDUAL"));

        memberService.register(memberRequest);
    }

    // 이메일 중복 여부 체크
    /*@GetMapping("/checkEmail/{email}")
    public ResponseEntity<Boolean> checkEmail (@PathVariable String email) {
        log.info("checkEmail(): " + email);

        boolean checkEmail = memberService.checkEmail(email);

        return ResponseEntity.ok(memberService.checkEmail(email));
    }*/

    /* 닉네임 중복 체크
    @GetMapping("/checkNickname/{nickname}")
    public Boolean checkNickname (@PathVariable("nickname") String nickname) {
        log.info("checkNickname(): " + nickname);

        boolean checkNickname = service.checkNickname(nickname);

        return checkNickname;
    } */

    // 로그인
    /*@PostMapping("/login")
    public String [] login (@Validated @RequestBody LoginDto loginDto) throws Exception{

        log.info("Member Login(): " + loginDto);

        String [] response = service.login(loginDto);
        log.info("check" + response);

        if (response != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }
        return response;
    }*/
}
