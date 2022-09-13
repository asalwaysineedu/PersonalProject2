package Home.training.demo.controller.notice;

import Home.training.demo.entity.notice.Notice;
import Home.training.demo.service.notice.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class NoticeController {

    @Autowired
    private NoticeService NoticeService;

    // 작성
    @PostMapping("/register")
    public void NoticeRegister (@Validated @RequestBody Notice notice) {
        log.info("NoticeRegister()");

        NoticeService.register(notice);
    }

    // 목록
    @GetMapping("/list")
    public List<Notice> NoticeBoardList () {
        log.info("NoticeBoardList()");

        return NoticeService.list();
    }

    // 읽기
    @GetMapping("/{noticeNo}")
    public Notice NoticeBoardRead (
            @PathVariable("noticeNo") Integer noticeNo) {
        log.info("NoticeBoardRead()");

        return NoticeService.read(noticeNo);
    }

    // 수정
    @PutMapping("/{noticeNo}")
    public Notice NoticeBoardModify (
            @PathVariable("noticeNo") Integer noticeNo,
            @RequestBody Notice notice) {
        log.info("jpaBoardModify(): " + notice);

        notice.setNoticeNo(Long.valueOf(noticeNo));
        NoticeService.modify(notice);

        return notice;
    }

    // 삭제
    @DeleteMapping("/{noticeNo}")
    public void NoticeBoardRemove (
            @PathVariable("noticeNo") Integer noticeNo) {
        log.info("NoticeBoardRemove()");

        NoticeService.remove(noticeNo);
    }
}
