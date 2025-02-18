package com.korit.basic.chapter14;

/*

 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K_Practice {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList(
                "document.pdf", "image1.png", "video.mp4", "presentation.ppt", "image2.png", "image3.jpg", "image4.png", "javascript.js"
        );

//        1. 특정 학장자(.png, .jpg) 필터링
//        List<String>
        List<String> filteredFiles = fileNames.stream()
                .filter(name -> name.endsWith(".png") || name.endsWith(".jpg"))
//                endsWith("") : 해당 문자열로 끝나는 데이터는 true 반환
                .collect(Collectors.toList());

        if (filteredFiles.isEmpty()) {
            System.out.println("이미지 파일이 없습니다");
            return;
        }
        System.out.println("이미지 파일 필터링 : " + filteredFiles);

//        2. 파일 이름 알파벳순 정렬
//        List<String>
        List<String> sortedFiles = fileNames.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("파일 이름 알파벳순 정렬 : " + sortedFiles);
    }
}
