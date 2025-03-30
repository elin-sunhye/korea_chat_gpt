package com.korit.basic.practice.table.repository;

import com.korit.basic.practice.table.entity.Notice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NoticeRepository {
    //    DB를 대신하는 리스트
    private final List<Notice> noticeStorage = new ArrayList<>();
    //    아이디
    long id = 1;


    public void save(Notice notice) {
        notice.setId(id++);
        noticeStorage.add(notice);
    }

    public List<Notice> allNotice() {
        return new ArrayList<>(noticeStorage);
    }

    public Optional<Notice> findById(long id) {
        return noticeStorage.stream()
                .filter(nt -> nt.getId() == id)
                .findFirst();
    }

    public void delete(long id) {
        noticeStorage.removeIf(nt -> nt.getId() == id);
    }
}
