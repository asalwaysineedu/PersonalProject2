package Home.training.demo.controller.notice.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NoticeRequest {

    private String noticeTitle;
    private String noticeWriter;
    private String noticeContent;

    public NoticeRequest(String noticeTitle, String noticeWriter, String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeWriter = noticeWriter;
        this.noticeContent = noticeContent;
    }

}
