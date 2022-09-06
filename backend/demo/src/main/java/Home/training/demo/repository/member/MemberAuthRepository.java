package Home.training.demo.repository.member;

import Home.training.demo.entity.member.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {
    @Query("select ma.auth from MemberAuth ma where ma.memberNo = :memberNo")
    Optional<MemberAuth> findByMemberNo(Long memberNo);
}