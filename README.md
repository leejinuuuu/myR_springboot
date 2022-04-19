#### 참고
> https://github.com/leejinuuuu/myR

------------

#### TODO
> ~~page error 처리~~

------------

#### API
+ /ct
    + (GET) /ls
    + (GET) /std
    + (POST) /add
    + (POST) /md
    + (GET)
    + (DELETE)
+ /ig
    + (GET) /ls
    + (POST) /add
    + (POST) /md
    + (GET)
    + (DELETE)
+ /us
    + (GET) /check
    + (GET) /login
    + (POST) /signup
    + (GET) /search
    + (POST) /md
    + (GET)
    + (DELETE)
+ /cb
    + (POST) /setting/add
    + (DELETE) /setting
    + (POST) /download/add
    + (DELETE) /download
    + (POST) /comment/add
    + (DELETE) /comment


------------

#### 정리
> 패스워드 암호화 관련  
(출처: https://devlog-wjdrbs96.tistory.com/212)

> MyBatis 변수  
"#" : 기존의 SQL문에서 따옴표를 사용할 때 사용(문자)  
"$" : 기존의 SQL문에서 따옴표를 사용하지 않을 때 사용(숫자)  

> DTO, ENTITY Class 차이
DTO : Request, Response을 위해 변경이 용이한 클래스
ENTITY : DB 테이블와 매칭될 클래스
(출처 : https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html)

> 머리정리
주고받는 데이터는 최대한 id값만 포함한 배열들로 이뤄지게
