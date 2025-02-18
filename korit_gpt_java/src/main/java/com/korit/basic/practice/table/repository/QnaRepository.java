package com.korit.basic.practice.table.repository;

import com.korit.basic.practice.table.entity.Qna;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QnaRepository {
    private final List<Qna> qnaStorage = new ArrayList<>();

    long id = 1;


    public void save(Qna qna) {
        qna.setId(id++);
        qnaStorage.add(qna);
    }

    public List<Qna> allQnas() {
        return new ArrayList<>(qnaStorage);
    }

    public Optional<Qna> findById(Long id) {
        return qnaStorage.stream()
                .filter(qn -> qn.getId() == id)
                .findFirst();
    }

    public void delete(Long id) {
        qnaStorage.removeIf(qna -> qna.getId() == id);
    }
}
