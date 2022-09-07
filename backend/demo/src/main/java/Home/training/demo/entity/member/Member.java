package Home.training.demo.entity.member;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@Table(name = "member")
/*
getter,setter를 사용하는 이유는 클래스의 필드에 직접 접근하는걸 막기 위해서다.
객체의 데이터는 함부로 공개하지 않는다.
그래서 사용하는것이 getter와 setter이다.
getter setter는 객체의 데이터에 직접 접근하지 않고 메소드를 통해 데이터에 접근,변경한다.

Setter 사용 지양
Entity 클래스 생성 시 Getter는 만들어야 하지만 Entity 일관성 보존을 위해 Setter 사용은 지양
무분별한 Setter 사용은 Entity 클래스의 Instance가 언제, 어디에서 변경되었는지 파악하기 어려움
Setter 대신 Builder 패턴을 활용하면 멤버 변수가 많아져도 필요한 데이터만 Field에 넣는 것이 용이

JPA나 json parser와 같은 라이브러리를 쓸 때에는 반드시 클래스에 기본 생성자가 있어야 한다.
이 경우 @NoArgsConstructor를 쓸 수 밖에 없다. 그러면 클래스 레벨에서 @Builder를 쓸 수가 없어진다.
방법은 전체 필드를 사용하는 생성자를 직접 선언하고 그 생성자에 @Builder 어노테이션을 쓰든가,
아니면 @NoArgsConstructor 와 @AllArgsConstructor를 모두 쓰면 된다.
*/
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 8)
    private String nickname;

    @Column
    private String profileImg;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList;

    public Member (String id, String password, String nickname, String profileImg) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.profileImg = profileImg;
    }

    public void MemberRequest() {

    }

    public void addAuth (MemberAuth auth) {
        if (authList == null) {
            authList = new ArrayList<MemberAuth>();
        }
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
