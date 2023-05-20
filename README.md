# SOPTKATHON_web_2_Server

> 32th SOPTKATHON_web_2_Server <br>
>
> 솝커톤 웹 2조 서버

<br>

## 🖤 SOPTKATHON Web 2_Server Developers


- 임승하
- 진승희
![A6A168EB-13C4-478F-87DC-0149BF1D429C](https://github.com/SopkathonTeam3/server/assets/77621712/5167d4ef-c5f0-4b74-9385-9007cbc724d7)




<br>

## 🗂️ Project Foldering

- common
    - dto
        - response
- exception
    - model
    
- user
    - service
    - controller
        - dto
    - domain
        - repository
- room
    - service
    - controller
        - dto
    - domain
        - repository
- post
    - service
    - controller
        - dto
    - domain
        - repository



<br>

## 📌 ERD

<img width="697" alt="스크린샷 2023-05-21 오전 12 43 00" src="https://github.com/SopkathonTeam3/server/assets/77621712/8acf9219-dcbb-410c-a7a4-11dafee15919">




<br>
<br>


## 🙋🏻‍♀️ 역할 분담

<div markdown="1">  

|    기능명     |    담당자    | 
|:----------:|:---------:|
|  프로젝트 세팅   |   `승하`    |  
|     배포     |   `승희`    |  
|   RDS 세팅   |   `승하`    |  
|  깃 협업툴 세팅  |   `승희`    |
|   DB 설계    | `승하` `승희` |
| API 명세서 작성 | `승하` `승희` |  
|   API 개발   | `승하` `승희` | 

</div>
 <br>

## 📌 Coding Convention
### 1. 기본적으로 네이밍은 **누구나 알 수 있는 쉬운 단어**를 선택한다.
    - 우리는 외국인이 아니다. 쓸데없이 어려운 고급 어휘를 피한다.

### 2. 변수는 CamelCase를 기본으로 한다.
    - userEmail, userCellPhone ...

### 3. URL, 파일명 등은 kebab-case를 사용한다.
    - /user-email-page ...

### 4. 패키지명은 단어가 달라지더라도 무조건 소문자를 사용한다.
    - frontend, useremail ...

### 5. ENUM이나 상수는 대문자로 네이밍한다.
    - NORMAL_STATUS ...

### 6. 함수명은 소문자로 시작하고 **동사**로 네이밍한다.
    - getUserId(), isNormal() ...

### 7. 클래스명은 **명사**로 작성하고 UpperCamelCase를 사용한다.
    - UserEmail, Address ...

### 8. 객체 이름을 함수 이름에 중복해서 넣지 않는다. (= 상위 이름을 하위 이름에 중복시키지 않는다.)
    - line.getLength() (O) / line.getLineLength() (X)

### 9. 컬렉션은 복수형을 사용하거나 컬렉션을 명시해준다.
    - List ids, Map<User, Int> userToIdMap ...

### 10. 이중적인 의미를 가지는 단어는 지양한다.
    - event, design ...

### 11. 의도가 드러난다면 되도록 짧은 이름을 선택한다.
    - retreiveUser() (X) / getUser() (O)
    - 단, 축약형을 선택하는 경우는 개발자의 의도가 명백히 전달되는 경우이다. 명백히 전달이 안된다면 축약형보다 서술형이 더 좋다.

### 12. 함수의 부수효과를 설명한다.
    - 함수는 한가지 동작만 수행하는 것이 좋지만, 때에 따라 부수 효과를 일으킬 수도 있다.

        ```
        fun getOrder() {
          if (order == null) {
              order = Order()
          }
        return order
        }
        ```

    - 위 함수는 단순히 order만 가져오는 것이 아니라, 없으면 생성해서 리턴한다.
    - 그러므로 getOrder() (X) / getOrCreateOrder() (O)

### 13. LocalDateTime -> xxxAt, LocalDate -> xxxDt로 네이밍

### 14. 객체를 조회하는 함수는 JPA Repository에서 findXxx 형식의 네이밍 쿼리메소드를 사용하므로 개발자가 작성하는 Service단에서는 되도록이면 getXxx를 사용하자.



## ☑️ Git Convention
### 📌 Commit Convention

### 언어

한글, 영어 무엇을 사용하여도 상관 없으나 식별할 수 있도록 작성한다.

해당 commit 이 어떤 commit 인지 알 수 있어야 한다.

### Description

글자의 큰 제한은 없으나 되도록 50 글자 내외로 작성하도록 한다.

### Body

글자의 큰 제한은 없으나 가능한 100 글자가 넘는 경우 줄 바꿈이 가능하도록 노력한다.


### > Commit Type:

Commit Message Type 은 아래 명시된 기준으로 분류한다.


- [FEAT] : 기능 추가
- [FIX] : 에러 수정, 버그 수정
- [REFACTOR] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [MODIFY] : 코드 수정 (기능의 변화가 있을 때)
- [CHORE] : gradle 세팅, 위의 것 이외에 거의 모든 것



### 📌Branch Convention

- main, develop, feature
위 3가지 branch 를 기본으로 한다.

- main → develop → feature
feature 브랜치는 feat/기능명으로 사용.

- 이슈를 사용하는 경우
feat/[issue num]_[feature name]

<br>





