package com.korit.basic.practice.table.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.korit.basic.practice.table.entity.Notice;

@Getter
@Setter
public class NoticeRequestDto {
    private String title;
    private String cont;
    private boolean attachedFile; // 첨부파일
    private boolean fix;

    public NoticeRequestDto(String title, String cont, boolean attachedFile, boolean fix) {
        this.title = title;
        this.cont = cont;
        this.attachedFile = attachedFile;
        this.fix = fix;
    }

    public Notice toEntity() {
        return new Notice(null, title, cont, attachedFile, fix);
    }

}
