package com.korit.basic.practice.table;

import com.korit.basic.practice.table.controller.NoticeController;
import com.korit.basic.practice.table.controller.QnaController;
import com.korit.basic.practice.table.dto.request.NoticeRequestDto;
import com.korit.basic.practice.table.dto.request.QnaRequestDto;
import com.korit.basic.practice.table.entity.Category;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        NoticeController notice = new NoticeController();
        QnaController qna = new QnaController();

        Scanner sc = new Scanner(System.in);

        while (true) {
         try {
             System.out.println("=== 게시판 생성하기 ===");
             System.out.println("1. 공지사항 생성");
             System.out.println("2. 공지사항 조회");
             System.out.println("3. 공지사항 수정");
             System.out.println("4. 공지사항 삭제");
             System.out.println("=== === ===");
             System.out.println("5. QNA 생성");
             System.out.println("6. QNA 조회");
             System.out.println("7. QNA 수정");
             System.out.println("8. QNA 삭제");
             System.out.println("0. 종료");
             System.out.print("선택 >>> ");
             int choice = sc.nextInt();
             sc.nextLine();

             switch (choice) {
                 case 1 :
                     System.out.print("제목 : ");
                     String title = sc.nextLine();
                     System.out.print("내용 : ");
                     String cont = sc.nextLine();
                     System.out.print("첨부파일 여부 (Y, N) : ");
                     String attachedFile = sc.nextLine();
                     System.out.print("상단 고정 여부 (Y, N) : ");
                     String fix = sc.nextLine();

                     notice.createNoticeController(new NoticeRequestDto(title, cont, attachedFile.equals("Y"), fix.equals("Y")));
                     break;
                 case 2 :
                     notice.allNoticeController();
                     break;
                 case 3 :
                     System.out.print("수정할 ID : ");
                     int modifyId = sc.nextInt();

                     System.out.print("수정 제목 : ");
                     String newTitle = sc.nextLine();
                     System.out.print("수정 내용 : ");
                     String newCont = sc.nextLine();
                     System.out.print("수정 첨부파일 여부 (Y, N) : ");
                     String newAttachedFile = sc.nextLine();
                     System.out.print("수정 상단 고정 여부 (Y, N) : ");
                     String newFix = sc.nextLine();

                     notice.updateNoticeController(modifyId, new NoticeRequestDto(newTitle, newCont, newAttachedFile.equals("Y"), newFix.equals("Y")));
                     break;
                 case 4 :
                     System.out.print("삭제할 ID : ");
                     int delId = sc.nextInt();
                     notice.deleteNoticeController(delId);
                     break;
                 case 5 :
                     System.out.print("제목 : ");
                     String qTitle = sc.nextLine();
                     System.out.print("내용 : ");
                     String qCont = sc.nextLine();
                     System.out.print("첨부파일 여부 (Y, N) : ");
                     String qAttachedFile = sc.nextLine();
                     System.out.print("응답 : ");
                     String qAnswer = sc.nextLine();
                     System.out.print("분류 : ");
                     String categoryInput = sc.nextLine();

                     Category category = Category.fromString(categoryInput);

                     qna.createQnaController(new QnaRequestDto(qTitle, qCont, qAttachedFile.equals("Y"), qAnswer, category));
                     break;
                 case 6 :
                     qna.allQnaController();
                     break;
                 case 7 :
                     System.out.print("수정할 ID : ");
                     Long modifyQId = sc.nextLong();

                     System.out.print("제목 : ");
                     String qNewTitle = sc.nextLine();
                     System.out.print("내용 : ");
                     String qNewCont = sc.nextLine();
                     System.out.print("첨부파일 여부 (Y, N) : ");
                     String qNewAttachedFile = sc.nextLine();
                     System.out.print("응답 : ");
                     String qNewAnswer = sc.nextLine();
                     System.out.print("분류 : ");
                     String newCategoryInput = sc.nextLine();

                     Category newCategory = Category.fromString(newCategoryInput);


                     qna.updateQnaController(modifyQId, new QnaRequestDto(qNewTitle, qNewCont, qNewAttachedFile.equals("Y"), qNewAnswer, newCategory));
                     break;
                 case 8 :
                     System.out.print("삭제할 ID : ");
                     Long delQId = sc.nextLong();
                     sc.nextLine();
                     qna.deleteQnaController(delQId);
                     break;
                 case 0 :
                     System.out.println("종료합니다 :)");
                     return;
                 default:
             }
         } catch (InputMismatchException e) {
             System.out.println("스캐너 오류");
         }
         catch (Exception e) {
             System.out.println("인자값 오류");
         }
        }
        
    }
}
