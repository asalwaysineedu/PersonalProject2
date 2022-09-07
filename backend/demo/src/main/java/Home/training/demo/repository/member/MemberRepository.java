package Home.training.demo.repository.member;

import Home.training.demo.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.id = :id")
    Optional<Member> checkId(@Param("id") String id);

    @Query("select m from Member m where m.id = :id")
    Optional<Member> findById(@Param("id") String id);
}
