package com.korit.basic.phr_solution.repository;

import com.korit.basic.phr_solution.entity.HealthRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecordRepository {
    List<HealthRecord> records = new ArrayList<>();
    private static RecordRepository instance = new RecordRepository();

    private RecordRepository() {
    }

    public static RecordRepository getInstance() {
        return instance;
    }

    public void save(HealthRecord record) {
        records.add(record);
    }

    public List<HealthRecord> findAll() {
        return new ArrayList<>(records);
    }

    public Optional<HealthRecord> findById(long id) {
        return records.stream()
                .filter(healthRecord -> healthRecord.getId().equals(id))
                .findFirst();
    }

    public void delete(HealthRecord healthRecord) {
        records.remove(healthRecord);
    }
}
