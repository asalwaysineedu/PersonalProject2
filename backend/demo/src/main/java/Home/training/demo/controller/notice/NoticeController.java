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

    @PostMapping("/register")
    public void NoticeBoardRegister (@Validated @RequestBody Notice notice) {
        log.info("NoticeBoardRegister()");

        service.register(notice);
    }

    @GetMapping("/list")
    public List<Notice> NoticeBoardList () {
        log.info("NoticeBoardList()");

        return service.list();
    }

    @GetMapping("/{noticeNo}")
    public Notice NoticeBoardRead (
            @PathVariable("noticeNo") Integer noticeNo) {
        log.info("NoticeBoardRead()");

        return service.read(noticeNo);
    }

    @PutMapping("/{noticeNo}")
    public Notice NoticeBoardModify (
            @PathVariable("noticeNo") Integer noticeNo,
            @RequestBody Notice notice) {
        log.info("jpaBoardModify(): " + notice);

        notice.setNoticeNo(Long.valueOf(noticeNo));
        service.modify(notice);

        return notice;
    }

    @DeleteMapping("/{noticeNo}")
    public void NoticeBoardRemove (
            @PathVariable("noticeNo") Integer noticeNo) {
        log.info("NoticeBoardRemove()");

        service.remove(noticeNo);
    }
}