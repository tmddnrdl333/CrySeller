# Git Branch 전략 & Commit Convention

## Git-flow 전략

<img title="" src="./git-flow.png" alt="" width="442" data-align="center">

- Git-flow 전략은 5종류의 브랜치가 존재한다.
  
  - master: 제품으로 출시될 수 있는 브랜치
    
    - 배포 가능한 상태만을 관리. 초기 설정 단계가 지나면, master 브랜치에 직접 commit해서는 안된다.
  
  - develop: 다음 출시 버전을 개발하는 브랜치
    
    - 개발 중인 코드의 중심이 되는 브랜치. 코드를 수정하고 싶을 때는 feature 브랜치를 생성해서 수정한 후 merge해야 한다.
  
  - feature: 기능을 개발하는 브랜치
    
    - develop 브랜치에서 파생된 브랜치로, 직접 코드를 수정하는 곳이다.
  
  - release: 이번 출시 버전을 준비하는 브랜치
    
    - develop 브랜치로부터 release 브랜치를 생성해서, 버그를 발견하고 수정하며 release를 준비하는 곳이다.
  
  - hotfix: 출시 버전에서 발생한 버그를 수정하는 브랜치
    
    - release된 프로그램에서 발생한 버그를 수정하기 위한 곳. master 브랜치로부터 생성하여, master와 develop에 merge한다.



- 작업 프로세스:
  
  - master 브랜치를 배포상태로 유지하고 (ver.1이 완성된 후)
  
  - develop 브랜치에서 feature 브랜치를 따서 기능별로 하나씩 완성한 후 develop 브랜치에 merge
  
  - develop 브랜치에 version의 구현 내용이 모두 merge되면 master 브랜치에 develop 브랜치를 merge
    
    - 작업 단위가 크거나, 꼭 점검이 필요한 개발이 포함되었다면, feature 브랜치를 develop 브랜치에 merge한 후, release 브랜치에서 테스트한 후 master 브랜치에 merge한다.
    
    - 또한 master 브랜치에서 버그를 발견한 경우, hotfix 브랜치를 직접 생성하여 수정하고 master, develop 브랜치에 다시 merge한다.



## Commit Convention

- feat : 새로운 기능 추가
- fix : 버그 수정
- design : CSS등의 사용자 UI 변경
- docs : 문서 수정
- style : 코드 formatting, 세미콜론(;) 누락, 코드 변경이 없는 경우
- refactor : 코드 리팩토링
- comment : 주석 추가 및 변경
- test : 테스트 코드, 리팩토링 테스트 코드 추가 (프로덕션 코드 변경 X)
- chore : 빌드 업무 수정, 패키지 매니저 수정 (프로덕션 코드 변경 X)
- rename : 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
- remove : 파일을 삭제하는 작업만 수행한 경우


