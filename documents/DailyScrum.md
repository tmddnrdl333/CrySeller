## Week1

## 23.02.25 (토)

개발 프로세스를 정해보자.

대략 이런 흐름으로 개발을 진행하자:

1. 설계
   
   - 사용할 기술과 프레임워크, 브랜치 전략 등을 결정하고 기록해둔다.
   
   - 와이어프레임과 API명세서, ERD를 1차로 작성한다. (이후 수정할 일이 있을 것 같다)
   
   - 두 문서를 기반으로, 기능+페이지 단위로 몇 개의 단계를 구분한다.

2. 개발
   
   - 단계별로 (유사 Agile하게) 버전을 나눠서 개발한다.
   
   - 개발과 동시에, Swagger UI를 적용해서 API 명세서와 일치시킨다.
   
   - 첫 버전 개발을 완료하면, CI/CD를 해결하고(Master 브랜치를 자동 배포), 성능 테스트까지 할 수 있게 해본다(nGrinder).

3. 테스트
   
   - 개발과 동시에 테스트를 병행한다.
   
   - 단계별로 개발이 종료된 후에 다시 테스트를 하고, 필요시 와이어프레임과 API 명세서의 수정을 진행한다.

## 23.02.26 (일)

- 개발 프로세스 정리

- 버전 1-4 정의

- 프로젝트 이름 정하기... (크라이셀러)

- 개발 문서 정리 

## 23.02.27 (월)

- RESTful API의 URI 규칙 복습, 추가학습
  
  - 명사는 복수형으로. PUT과 DELETE Method는 보안상 취약하기 때문에 사용하지 않는 것으로.

- ERD 규칙 복습, 추가학습
  
  - 테이블명은 복수, 컬럼명은 단수로. 명명은 snake case로.
  - varchar와 char에 대해서는 짧지 않은 역사도 있고 여러 이유가 있지만... 실무자들 중 varchar를 쓰는 편이 낫다고 하는 사람이 많아보인다. 용량 절감과 개발자의 수고를 덜기 위한 목적도 있다고 한다. 
  - DATE: YYYY-MM-DD, DATETIME: YYYY-MM-DD HH:MM:SS, TIME: HH:MM:SS, TIMESTAMP: 1970-01-01 00\:00:01 \~ 2038-01-19 03\:14:07 UTC
    - DATETIME은 문자형, 8byte, 입력시 생성, TIMESTAMP는 숫자형, 4byte, 저장시 자동 생성

- Spring Boot Project 생성
  
  - Build Tool은 Gradle-Kotlin 사용
    
    - xml을 사용하는 Maven에 비해 간결, 범용성이 큼. Gradle-Groovy에 비해 IDE 지원으로 오류 강조하는 부분이 강점.

## 23.02.28 (화)

- 한 것
  
  - Spring Boot Project 초기 설정

- 할 것
  
  - Spring Boot 설정 테스트 (JPA, QueryDSL)
  
  - Entity 생성, reverse engineering, ERD 갱신
  
  - BE Directory 구조 생성
  
  - git convention 정리

## 23.03.01 (수)

- 한 것
  
  - Entity 생성, ERD 갱신
  
  - BE dir 구조 결정
  
  - git flow 전략, commit convention 정리

- 할 것
  
  - controller, service, exception, dto 등 user 관련 내용 전부 구현
  
  - user 관련 기능 테스트
  
  - 가능하면 swagger-ui 적용

## 23.03.02 (목)

- 한 것
  
  - Spring Data JPA 복습, 추가학습
  
  - JPA, QueryDSL 테스트

- 할 것
  
  - User 관련 기능 마무리
  
  - Swagger-ui 적용

- Spring Boot 3 버전을 처음 사용해봐서... javax에서 jakarta로 넘어가면서 QuerydslConfig에 문제가 생긴 것을 처음 알았다. 구글링을 통해 해결했다... [TIL]([TIL/Spring Boot 3.0 이상 버전에서 QueryDsl 사용하는 방법.md at main · tmddnrdl333/TIL · GitHub](https://github.com/tmddnrdl333/TIL/blob/main/%EA%B3%B5%EB%B6%80/Spring%20Boot%203.0%20%EC%9D%B4%EC%83%81%20%EB%B2%84%EC%A0%84%EC%97%90%EC%84%9C%20QueryDsl%20%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%20%EB%B0%A9%EB%B2%95.md))에 정리해뒀다.

## 23.03.03 (금)

- 한 것
  
  - User 관련 기능 초기버전 작성, Postman 테스트
  
  - Spring Boot JPA, QueryDsl 버그 문제 해결

- 할 것
  
  - User 관련 기능 마무리, Swagger-UI 적용, ver.1 마무리
  
  - CI/CD 학습, nGrinder 학습

## 23.03.05 (일)

- 한 것
  
  - User 관련 기능 마무리, Swagger 적용 (springdoc openapi)

- 할 것
  
  - CI/CD 학습

- 어려웠던 것
  
  - Spring Boot 3 이상 버전에서 build tool을 비롯해 swagger와의 버전 호환 등에서 접해보지 못한 문제들이 있었음. 구글링으로 개발자 블로그들의 도움을 얻어 해결했지만, 시간 소요가 많았음.

## 23.03.06 (월)

- 한 것
  
  - CI/CD 학습

- 할 것
  
  - Naver Cloud 신청, CI/CD 진행 

## 23.03.13 (수)

- 한 것
  
  - 기능 구현 가능한데까지

- 할 것
  
  - CI/CD

## 23.03.16 (목)

- 한 것
  
  - User, Item, Category 관련 API 작동 확인 (설계 ver.2까지, 로컬 단계에서)

- 마무리
  
  - 아직 완성하지 못했지만, 최종 제출일이 되었다.
  
  - 최종 제출은 미비상태로 하겠지만, 바쁜 일정이 끝난 후에는 반드시 CI/CD와 배포까지 마무리 할 것이다.
