package Home.training.demo.service.notice;

import Home.training.demo.entity.notice.Notice;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoticeService {
    public void register (Notice notice);
    public List<Notice> list ();
    public Notice read (Integer noticeNo);
    public void modify (Notice notice);
    public void remove (Integer noticeNo);

}
