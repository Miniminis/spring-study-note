# Spring-study-note
> 스프링 프레임워크 공부 노트 + 프로젝트 

## 숙박 중개 플랫폼, Bitcamp 프로젝트 - 관리자 페이지 
> [관리자 페이지 링크](http://13.125.249.209:8080/adminclient/) <br>
> 현재 다른 페이지들은 aws 서버 운행 종료 상태로 접속불가, 관리자 페이지는 접속 가능

#### 구현화면 
<img src="https://github.com/Miniminis/Spring-study-note/blob/master/Project_Bitcamp_admin_page_screenshot/bitcamp_admin%20(9).png">
<img src="https://github.com/Miniminis/Spring-study-note/blob/master/Project_Bitcamp_admin_page_screenshot/bitcamp_admin%20(8).png">
<img src="https://github.com/Miniminis/Spring-study-note/blob/master/Project_Bitcamp_admin_page_screenshot/bitcamp_admin%20(7).png">
<img src="https://github.com/Miniminis/Spring-study-note/blob/master/Project_Bitcamp_admin_page_screenshot/bitcamp_admin%20(5).png">
<img src="https://github.com/Miniminis/Spring-study-note/blob/master/Project_Bitcamp_admin_page_screenshot/bitcamp_admin%20(3).png">

#### 소스코드 
* [전체 소스코드](https://github.com/kytsaaa6/Bitcamp)
* [개인 소스코드 - 서버](https://github.com/Miniminis/Spring-study-note/tree/master/BitcampServer)
* [개인 소스코드 - 클라이언트](https://github.com/Miniminis/Spring-study-note/tree/master/BitcampClient/WebContent)

#### 흐름도
* 전체 : 
<img src="bitcampMain.png">

* 관리자 페이지 : 
<img src="bitcampAdmin.png">

#### 기술/구조
* 웹 표준 
    * `HTML5`
    * `CSS3`
    * `JavaScript`
    * `jQuery`
    * `Bootstrap4`
* TOMCAT 컨테이너 사용
* DBMS - `MySQL`
* Spring Framework
* `MyBatis`
* 한국 관광공사 tour API 사용 : 숙박 정보 가져옴
    * `jQuery`, `aJax`, `JSON` 파싱
* `RESTful Api 구조`  
    * 서버 <--> 클라이언트 통신을 위한 REST 인터페이스 구현
* `AWS` 배포
    * `EC2`
    * `RDS`
    
    
#### 프로젝트 설명 PPT 
* 각 기능 설명 
* 구현 중 어려웠던 점 
* 개선사항 
* [Link](https://docs.google.com/presentation/d/1hhPwEseWwrb17LAxn_P52P8mdpbJRNxlcyZXdio_ijI/edit#slide=id.g6121b993da_2_148)
    
    
#### 구현 중 겪었던 어려움 
* **ajax 비동기통신 이용하여 PUT METHOD 실행**  <br>
프로젝트를 싱글페이지로 구성하다보니 ajax를 사용하여 사진 파일을 포함한 form 을 PUT method 이용하여 구현하는 과정에서 어려움을 겪음 <br>
--> 해결 : form 에서 사진 파일을 수정할 때에는 **onchange() 매서드** 를 이용해서 **첫번째 비동기통신** 을 처리하고, 전체 form을 제출할 때에는 사진 파일만 제외한 나머지 정보들만 넘겨서 **두번째 비동기 통신** 을 해서 처리함 <br>
--> 더 공부하고 싶은 내용 : 프론트 프레임워크 Vue 나 React를 이용하면 Single Page Application을 제작하는데 보다 수월하다고 함. 이를 배워서 적용해볼 예정  


#### 버전설명
* 자세한 사항은 본 repository의 커밋 내역 중 [Bitcamp]를 참고
* v0 
   * 한국 관광공사 Tour Api 이용해서 한국 숙박 리스트 출력 완료 
   * 숙박 상세 페이지 Bootstrap Modal 적용해서 완성 
   * 호텔별 룸 등록, 리스트, 삭제 기능 구현 완료 
   * 관리자 페이지 전체 스타일 적용 
   * 사용자 페이지 전체 스타일 적용 
   * AWS EC2 배포 및 RDS 연결 
* v1
   * 관리자 페이지 v1 완성
   * 후기 페이지 NAVER Blog Api 적용에 도움 
