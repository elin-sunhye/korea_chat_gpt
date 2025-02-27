package com.korit.boardback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/** 메일을 보낸 후 메일 속 인증버튼에 get 요청을 걸어서 token을 받는다 */

@Configuration
@EnableAsync
// 비동기 처리 -> 프론트에서 백으로 메일 전송 api 호출 시 응답이 올 떄까지 프론트에서 아무것도 못 하기 떄문에
// 1번 프로트에서 응답이 올떄까지 프론트에서 전송중이라는 로딩 알럿을 띄운다
// 2번 비동기로 설정하고 api 호출 시 별개의 스레드로 분리!
public class AsyncConfig {
}
