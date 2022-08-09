package Home.training.demo.controller.member;

import Home.training.demo.dto.member.MemberRequest;
import Home.training.demo.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/Member")
@CrossOrigin(origins = "http:localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    // 회원가입
    @PostMapping("/register")
    public MemberRequest register (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("Member register request from vue: " + memberRequest);

        service.register(memberRequest);

        return memberRequest;
    }

    // 이메일 중복 여부 체크
    @GetMapping("/checkEmail/{email}")
    public Boolean checkEmail (@PathVariable("email") String email) {
        log.info("checkEmail(): " + email);

        boolean checkEmail = service.checkEmail(email);

        return checkEmail;
    }

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
