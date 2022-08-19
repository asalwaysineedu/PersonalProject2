package Home.training.demo.dto.member;

import Home.training.demo.entity.member.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MemberRequest {
    private String email;
    private String password;
    private String nickname;
    private String mobile;
    private String profileImg;
    private String auth;

    public MemberRequest (String email, String password, String nickname, String mobile, String profileImg, String auth){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.mobile = mobile;
        this.profileImg = profileImg;
        this.auth = auth;
    }
}
