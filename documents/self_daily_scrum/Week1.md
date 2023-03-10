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
