package Home.training.demo.dto.member;

import lombok.Data;

@Data
public class MemberRequest {
    private String email;
    private String password;
    private String nickname;
    private String mobile;
    private String role;

    public MemberRequest (String email, String password, String nickname, String mobile, String role){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.mobile = mobile;
        this.role = role;
    }
}
