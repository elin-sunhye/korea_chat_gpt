package com.korit.boardback.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    @Value("${user.dir}")
    private String rootPath;

    public String saveFile(String path, MultipartFile file) {
        if(file.isEmpty()) {
            return null;
        }

        String newFilename = null;

        try {
            String originFilename = file.getOriginalFilename();
            newFilename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originFilename;

            File newFilePath = new File(rootPath + "/" + path); // 폴더의 경로가 존재하지 않으면 경로 파일 생성
            if(!newFilePath.exists()) {
                newFilePath.mkdirs();
            }

            File newFile = new File(newFilePath + "/" + newFilename); // 파일에 대한 경로 생성
            file.transferTo(newFile); // 받아온 file을 newFile 경로로 변경
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFilename;
    }

//    폴더에 있는 이전 이미지 삭제
    public void delFile(String path) {
        File file = new File(rootPath + "/" + path);
        if(file.exists()) {
            file.delete();
        }
    }
}
