package Home.training.demo.service.notice;

import Home.training.demo.entity.notice.Notice;
import Home.training.demo.repository.notice.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    NoticeRepository repository;
    @Override
    public void register(Notice notice) {
        repository.save(notice);
    }

    @Override
    public List<Notice> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "noticeNo"));
    }

    @Override
    public Notice read(Integer noticeNo) {
        Optional<Notice> maybeReadBoard = repository.findById(Long.valueOf(noticeNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read Notice board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(Notice notice) {
        repository.save(notice);
    }

    @Override
    public void remove(Integer noticeNo) {
        repository.deleteById(Long.valueOf(noticeNo));
    }
}
