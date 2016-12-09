# Hello, stranger!

이 어플리케이션은 외국인들을 위한 메뉴판 번역 서비스입니다. 더 이상 외국인들은 엉터리 번역과 알아볼 수 없는 메뉴를 볼 필요 없습니다. 길거리 밖에서도 비콘이 있는 매장이라면 메뉴를 쉽게 접할 수 있습니다.  
__외국인__에게는모바일(Android)을, __매장주인__에게는 매장관리를 위한 웹(web)이 제공됩니다.
___

## 작업환경    
1. 모바일  
   target sdk 6.0(marshmallow) / minimum sdk 4.4 (kitkat)  
* 안드로이드 스튜디오(IDE) 2.1.2   
* java - 1.8.0
   <br><br>
2. 웹  
   RoR(Ruby on Rails)
* Ruby 2.3.1
* Rails 4.2.6
    * front-end-development-framework : semantic-ui
      <br><br>
3. 데이터베이스  
   MySQL  
   <br><br>
4. 서버 테스트  
   **가상 서버 c9.io**
   <br>
   무료로 사용할 수 있는 클라우드 통합 개발환경입니다. 이곳에서 서버 구동 시 최소 4~6시간 동안 서버가 열립니다. ubuntu의 workspace와 에디터를 구축해주며, 서버 구동 시 모든 사람들이 볼 수 있도록 public DNS를 제공합니다.  
   <br>
   **사용 목적**  
   안드로이드와 웹, 데이터베이스를 짧게 테스트할 때 사용할 것입니다. 개발 작업이 90프로까지 진행되면 서버를 아마존 EC2로 옮길 예정입니다.<br><br>

<br><br>


### 주요 기술

“매장별 콘텐츠 제공”

 사용자의 블루투스로 매장의 비콘이 인식될 시, 신호를 받고 사용자 정보에 따른 메뉴 판을 생성해 보여준다. 메뉴 판들은 flip 동작으로 넘겨볼 수 있다. 

<br>

“사용자 트래킹”

 매장에 방문한 사용자를 트래킹하여 해당 매장의 리뷰 채팅방 접근여부를 결정한다. 방문 전의 사용자들은 리뷰를 읽기(only read)만 가능하고 방문 후 사용자들은 리뷰 쓰기(read&wrtie)가 가능하다.

<br><br>

#### Project의 상세 구조를 wiki에 작성.

Data Parsing pages - server와 parsing 함수/data 관리를 명시

For api test user - c9 server 사용방법

Server API - server request/response 시 요청할 url 형식 명시

Volley - volley에 관해 정리한 참고 문서

데이터베이스 스키마 - project에서 설계한 database구조 및 요구사항 정리

이슈정리 - 개발 중 발생한 ide 이슈를 정리(IDE이슈만)

화면설계 - 사용자 시나리오 및 화면설계, 소개 영상 url 첨부
