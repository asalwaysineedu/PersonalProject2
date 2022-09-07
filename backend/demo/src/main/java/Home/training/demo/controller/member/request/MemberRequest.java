package Home.training.demo.controller.member.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {
    private String id;
    private String password;
    private String nickname;
    private String auth;
    private String profileImg;

    public MemberRequest (String id, String password, String nickname, String auth, String profileImg){
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.auth = auth;
        this.profileImg = profileImg;
    }

}
