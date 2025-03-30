package com.korit.basic.chapter16;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
    === DTO, VO, DAO, Entity ===
    : 데이터를 목적에 따라 정의하는 구조

    - DTO (Data Transfer Object) : 데이터를 전달하기 위한 객체
    - VO (Value Object) : 값 자체를 표현하는 객체
    - DAO (Data Access Object) : Database에 접근하는 역할을 하는 객체
    - Entity : 실제 DB 테이블과 매핑되는 클랫
 */

/*
    1. DTO (Data Transfer Object)
    : 계층 간 데이터 교환을 위해 사용하는 객체
    - 로직을 가지지 않는 순수한 데이터 객체(Getter, Setter만 가진 클래스)
    - 주로) DB에서 데이터를 가져오거나 REST API 통신에서 요청 및 응답 데이터를 잠ㅁ이 전달할 떄 사용
*/
// 사용자의 아이디와 비밀번호만을 가진 로그인 요청 정보를 가진 DTO
class UserSignRequestDto {
    private String userId;
    private String password;
}

/*
    2. VO (Value Object)
    : 값을 표현하는 객체
    - 데이터를 담는 용도, 불변성을 가짐(한번 생성되면 내용 변경 불가)
    - 주로) 필드값을 final 설정
    - Getter만을 가짐
*/
@AllArgsConstructor
@Getter
class Address {
    private final String city;
    private final String zipCode;
}

/*
    3. DAO (Data Access Object)
    : 데이터베이스 또는 저장 매체의 데이터에 접근하는 객체
    - 서비스 모델과 데이터베이스를 연결하는 역할
    - 데이터의 CRUD 작업을 시행하는 클래스
    - 비즈니스 로직에서 데이터베이스의 직접적인 조적없이 데이터를 다룰 수 있게 함
    - 데이터의 캡슐화
*/
// 사용자의 id에 일치하는 데이터 응답
// : 사용자 로그인 후 아이디, 닉네임 등을 포함하여 응답
@AllArgsConstructor
class UserSignInResponseDto {
    //    Sign In : 로그인
//    Sign Up : 회원가입
//    Sign Out : 로그아웃
    private String userId;
    private String nickName;
}

// 사용자 데이터베이스와 연관된 작업 모두 명시
class UserDao {
    //    로그인 한 사용자 데이터 단건 조회
    public UserSignInResponseDto getUserById(String userId) {
//        데이터베이스에서 userId에 해당하는 사용자 정보 조회
        String id = "qwe";
        String nickName = "개구리";

        return new UserSignInResponseDto(id, nickName);
    }
}

/*
    4. Entity (실재)
    : 데이터베이스의 테이블에 해당하는 데이터의 구조와 거의 일지하는 클래스
    - JPA(JAva Persistence API)와 같은 ORM(Object-Related Mapping) 툴에서 사용
    - 데이터베이스의 테이블의 레커드와 매핑, 데이터와 관련된 비즈니스 로직 포함
*/
class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String nickName;
}

public class F_Entity {
}
