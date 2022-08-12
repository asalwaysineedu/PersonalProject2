package Home.training.demo.entity.notice;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeNo;

    @Column(nullable = false)
    private String noticeTitle;

    @Column(nullable = false)
    private String noticeWriter;

    @Lob
    private String noticeContent;

    @Column(nullable = false)
    private String noticeNecessary;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int noticeView;

    @CreationTimestamp
    private Date regDate;
}
