= NHN MART

= 기능 및 요구사항

== 회원

* [ ] 회원은 회원가입 시 100만 포인트를 기본 지급합니다.
* [ ] 회원은 관리자(ROLE_ADMIN), 회원 (ROLE_USER) 권한이 있습니다.

=== 기능

* [ ] 회원은 회원가입과 탈퇴를 할 수 있습니다.
* [ ] 회원은 1개 이상의 주소를 설정할 수 있습니다.

== 장바구니

* [ ] 상품을 장바구니에 담을 수 있습니다.
* [ ] 이미 장바구니에 상품이 담겨 있다면 중복으로 담을 수 없습니다.
* [ ] 주문이 완료된 상품은 장바구니에서 삭제되어야 합니다.

== 주문 및 결제

* [ ] users의 user_point를 이용해서 결제합니다.
* [ ] 주문이 완료되면 주문 금액의 10%를 point로 적립받습니다.
* [ ] 주문하는 과정에서 예외가 발생하면 모두 RollBack 되어야 합니다.

== index 페이지

* [ ] /index.do 즉 welcome page이며 카테고리별로 상품이 노출됩니다.
* [ ] 카테고리가 선택되지 않았다면 전체 상품이 노출됩니다.
* [ ] 페이징 처리되어야 합니다.
* [ ] 상품명으로 검색할 수 있어야 합니다.
  ** [ ] 검색 시 카테고리는 전체가 선택된 것으로 간주합니다.

== 마이 페이지

* [ ] 로그인한 회원만 접근할 수 있습니다.

=== 기능

* [ ] 회원 정보 수정

* [ ] 주문 명세 조회
  ** [ ] 페이징 처리
  ** [ ] 정렬 : 최근에 주문 역순으로 내림차순 정렬

* [ ] 포인트 사용내력 조회
  ** [ ] 페이징 처리
  ** [ ] 정렬 : 최근 사용내력 순으로 내림차순 정렬

* 주소 관리
  ** [ ] 회원의 주소를 등록, 수정, 삭제할 수 있습니다.

== 관리자 페이지

* [ ] 로그인한 관리자 회원만 접근할 수 있습니다.

=== 기능

* 상품 카테고리 관리
  ** [ ] 1단계 카테고리를 구현
  ** [ ] 정렬 : 정렬순서에 의한 오름차순 정렬

* 상품 관리
  ** [ ] 상품은 반드시 하나 이상의 카테고리에 속해야 합니다.
  ** [ ] 하나의 상품은 최대 3개의 카테고리에 속할 수 있습니다.(확장성을 고려합니다.)
  ** [ ] 상품은 리스트에 노출할 thumbnail 이미지를 제공해야 합니다. ( 존재하지 않다면 별도의 no-image를 노출합니다.)
  ** [ ] 상품은 상세 페이지에 노출할 이미지를 제공해야 합니다.
  ** [ ] 상품은 등록, 수정, 삭제가 가능합니다.
  ** [ ] 페이징 처리

* 회원 관리
  ** [ ] 쇼핑몰에 가입된 회원을 확인할 수 있습니다.(리스트, 상세 보기 구현)
  ** [ ] 회원리스트 구현 시 관리자(ROLE_ADMIN), 일반회원(ROLE_USER) 분리하여 정렬되어야 합니다.
  ** [ ] 정렬 : 가입 일자 기준으로 내림차순 정렬
  ** [ ] 페이징 처리
  ** [ ] 관리자 페이지 내에서 회원등록, 수정, 삭제는 구현하지 않습니다.

=== 포인트

* [ ] 매일 첫 로그인 시 1만 포인트를 적립합니다.
* [ ] 포인트의 적립 및 사용기록은 기록되어야 합니다.

= More

* 문제 1 ~ 13번까지 구현했다면 아래 기능 구현 항목들을 참고하여 쇼핑몰을 구현합니다.
* 14번은 주문결제, 포인트 구현시 적절한 시점에 참고하여 구현합니다.

== 기능 구현

=== Pagination

* page 번호는 1부터 시작합니다.
* 모든 페이징 처리는 link:../../src/main/java/com/nhnacademy/shoppingmall/common/page/Page.java[Page.java]
  기반으로 구현합니다.

=== View 구현

* View는 JSP를 사용합니다.
* JSP로 작성된 페이지는 반드시 FrontServlet에 의해서 호출되어야 합니다.
* 과도한 Scriptlet을 사용하지 않습니다.

=== 회원

* 사용자는 아이디, 비밀번호를 이용하여 로그인합니다.
* 로그인하면 사용자를 식별할 수 있는 Session이 생성되며 60분 동안 유지됩니다.
  ** SQL Injection을 방어할 수 있는 코드를 작성합니다.
* 사용자는 회원가입과 동시에 100만 포인트가 부여됩니다. ( 포인트를 사용해서 결제합니다.)

=== 상품

* 관리자 페이지에서 상품을 등록, 수정, 삭제할 수 있습니다.
* 상품은 반드시 하나의 카테고리에 속해야 합니다.
* 위지윅 에디터는 사용하지 않습니다.
* 상품 이미지를 업로드 합니다.
* 이미지가 존재하지 않는다면 `src/main/webapp/resources/no-image.png` 가 노출됩니다.
  ** http://localhost:8080/resources/no-image.png

=== 최근 본 상품구현

* 쇼핑몰 index page에서 최근 본 상품 5개가 노출됩니다.
* 최근 본 상품 구현 시 Cookie, Session, DB 등을 이용한 다양한 방법이 있습니다. 장단점을 고려하여 한 가지 방법을 선택하여 구현합니다.
* 로그인하지 않더라도 최근 본 상품을 확인할 수 있어야 합니다.

=== 장바구니

* 장바구니는 수량을 변경할 수 있습니다.
* 주문이 완료되면 해당 상품은 장바구니에서 삭제됩니다.
* 상품을 중복해서 장바구니에 등록할 수 없습니다.

=== 주문

* 주문을 완료하면 포인트가 적립됩니다.
* 포인트 적립은 독립된 Thread 내에서 처리될 수 있도록 구현합니다.
  ** 포인트 적립 실패에 대해서는 error 로그로 기록합니다.
  ** 포인트 적립이 실패하더라도 주문은 정상 처리됩니다.

* error 처리
  ** 주문 수량이 부족하면 주문을 할 수 없습니다.
  ** 회원의 포인트 < 결제금액이면 주문을 할 수 없습니다.

=== 포인트

* 제품을 주문하면 10%가 포인트로 적립됩니다.
* 포인트 사용이력을 확인할 수 있어야 합니다.

== Test Code 작성

* Repository Test를 작성합니다.
  **  테스트에 사용한 데이터는 테스트가 종료되면 RollBack 되어야 합니다.
* Service Test를 작성합니다.
  ** Mockito를 사용하여 Test Case를 작성합니다.
* ** com.nhnacademy.shoppingmall.check 하위 package에 Test Code를 작성하지 않습니다. **