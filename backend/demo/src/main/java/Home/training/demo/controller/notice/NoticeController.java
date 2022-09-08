package Home.training.demo.controller.notice;

import Home.training.demo.entity.notice.Notice;
import Home.training.demo.service.notice.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Notice")
@CrossOrigin(origins = "http:localhost:8080", allowedHeaders = "*")
public class NoticeController {

    @Autowired
    private NoticeService service;

    // 작성
    @PostMapping("/register")
    public void NoticeBoardRegister (@Validated @RequestBody Notice notice) {
        log.info("NoticeBoardRegister()");

        service.register(notice);
    }

    // 목록
    @GetMapping("/list")
    public List<Notice> NoticeBoardList () {
        log.info("NoticeBoardList()");

        return service.list();
    }

    // 읽기
    @GetMapping("/{noticeNo}")
    public Notice NoticeBoardRead (
            @PathVariable("noticeNo") Integer noticeNo) {
        log.info("NoticeBoardRead()");

        return service.read(noticeNo);
    }

    // 수정
    @PutMapping("/{noticeNo}")
    public Notice NoticeBoardModify (
            @PathVariable("noticeNo") Integer noticeNo,
            @RequestBody Notice notice) {
        log.info("jpaBoardModify(): " + notice);

        notice.setNoticeNo(Long.valueOf(noticeNo));
        service.modify(notice);

        return notice;
    }

    // 삭제
    @DeleteMapping("/{noticeNo}")
    public void NoticeBoardRemove (
            @PathVariable("noticeNo") Integer noticeNo) {
        log.info("NoticeBoardRemove()");

        service.remove(noticeNo);
    }
}
