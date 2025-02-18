package com.korit.basic.practice.table.dto.response;

import lombok.Getter;
import lombok.Setter;
import com.korit.basic.practice.table.entity.Notice;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeResponseDto {
    private long id; // 테이블 고유 번호

    private String title;
    private String cont;
    private boolean attachedFile; // 첨부파일
    private boolean fix;

    public NoticeResponseDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.cont = notice.getCont();
        this.attachedFile = notice.isAttachedFile();
        this.fix = notice.isFix();
    }

    public static NoticeResponseDto fromEntity(Notice notice) {
        return new NoticeResponseDto(notice);
    }
}
