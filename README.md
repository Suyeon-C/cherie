# 💍 Chérie

Spring Framework를 이용한 악세사리 판매 및 관리 서비스 제공 웹 개발 프로젝트 
***

# 목차 

#### [1. 프로젝트 소개](#💻-프로젝트-소개)
- [1-1 주제 및 기획 배경](#1-1.-주제-및-기획-배경)
- [1-2 개발 환경](#1-2.-개발-환경) 

#### [2. 프로젝트 구조 및 설계](#2.-📃--프로젝트-구조-및-설계)
- [2-1 테이블 관계](#2-1.-테이블-관계)

#### [3. 결과물](#3.-💡-결과물)
- [3-1 메인화면](#3-1.-메인화면)
- [3-2 회원가입 및 유효성 평가](#3-2.-회원가입-및-유효성-평가)
- [3-3 로그인 & 내 정보 보기 및 수정/ 탈퇴](#3.3-로그인-&-내-정보-보기-및-수정/-탈퇴)
- [3-4 이메일/비밀번호 찾기 & 임시비밀번호 발급](#3.4-이메일/비밀번호-찾기-&-임시비밀번호-발급)
- [3-5 판매 상품 리스트/ 상세보기](#3-5.-판매-상품-리스트/-상세보기)
- [3-6 장바구니 등록 및 결제](#3-6.-장바구니-등록-및-결제)
- [3-7 주문 내역/취소 및 리뷰 작성](#3-7.-주문-내역-/-취소-및-리뷰-작성) 
- [3-8. 사업자 회원) 내 정보 및 상품 수정/탈퇴(삭제)](#3-8.-사업자-회원]-내-정보-및-상품-수정/탈퇴(삭제) )
- [3-9. 관리자) 개인 회원과 사업자 회원 목록](#3-9.-관리자]-개인-회원과-사업자-회원-목록)
***

# 💻 프로젝트 소개 


## 1-1. 주제 및 기획 배경 
- 소개:악세사리 판매 중개 플랫폼
- 구분: 웹 개발
- 개발인원 :  본인 (총 1명)
- 제작기간:  2021.12.10~ 2021.12.31 (3주)
- 기획 배경 및 목적 
: 코로나 19로 인한 비대면 의류 소비가 확산되면서 오프라인에서 온라인 플랫폼으로 넘어가는 추세이다 . 
그 중에서 의류 온라인 플랫폼에서의 한 분류로 악세사리 상품을 판매하기는 하지만 전문적으로 악세사리만 판매하는 곳은 제한적이라는 것을 주목하였다. 
따라서 악세사리 만을 전문적으로 판매하는 웹사이트 구축에 필요성을 느껴 사이트를 구축 해보았다.

## 1-2. 개발 환경

|  |  |
| ------ | ------ |
| Front-End | HTML, CSS, JS, jQuery, BootStrap |
| Back-End | JAVA, Spring, MyBatis |
| Database | MySQL,exerd |
| Server | Apache Tomcat v9.0|
| IDE| Eclipse |
| OS | Windows 10, MacOS|
| API | Kakao, Daum, Import |
|  |  |

***

# 2. 📃  프로젝트 구조 및 설계
## 2-1. 테이블 관계
<img width="600" alt="테이블" src="https://user-images.githubusercontent.com/97042437/148068310-cda81654-0dc4-467f-860f-44efc26570a0.png">

***

# 3. 💡 결과물  

##  3-1. 메인화면
![Hnet com-image](https://user-images.githubusercontent.com/97042437/148047710-53019d93-1dca-404e-a40c-781fd72599ce.gif)
- 가장 최근에 등록된 상품을 메인화면에 보여준다.
- 네이베이션 바는 비회원, 개인 회원, 사업자 회원, 관리자 회원으로 구분하여 처리한다.

## 3-2. 회원가입 및 유효성 평가
![화면 기록 2022-01-04 오후 8 26 25](https://user-images.githubusercontent.com/97042437/148099709-f09d4e30-fa5a-4e07-bd3b-06a4760053b6.gif)
- JavaScript와 Ajax를 활용하여 비동기 통신으로 이메일 중복확인을 구현하였다.
- 우편번호와 주소는 Daum API를 이용하여 주소를 입력한다.
- [JS 코드보기](https://github.com/Suyeon-C/cherie/blob/27ed76e6ec2eada4b3fd874a4eeaaa130924848f/Cherie/src/main/webapp/js/buyerSignup.js)

## 3-3. 로그인 & 내 정보 보기 및 수정/ 탈퇴
![로그인](https://user-images.githubusercontent.com/97042437/148103672-f343f02c-0420-4c90-9813-0e6290a0a5be.gif)
- 로그인은 개인 회원과 사업자 회원 창을 나누어 구현하였다. 
- Kakao 오픈 API를 이용하여 카카오 로그인 기능을 구현했으며, 가입 정보가 없을 시 자동으로 회원가입 한 후 메인화면으로 이동한다. 
- 내 정보에서 가입정보 및 회원 정보를 수정 및 탈퇴 할 수 있다. 
- [Kakao Controller 코드보기](https://github.com/Suyeon-C/cherie/blob/master/Cherie/src/main/java/com/common/controller/KakaoController.java)


## 3-4. 이메일/비밀번호 찾기 & 임시비밀번호 발급
![화면 기록 2022-01-04 오후 8 41 17](https://user-images.githubusercontent.com/97042437/148098827-e9ae31b8-3868-4139-b1df-5efb604ca30b.gif)
<img width="746" alt="스크린샷 2022-01-04 오후 8 43 51" src="https://user-images.githubusercontent.com/97042437/148071979-06585585-8a97-4382-bcb2-52b3333add08.png">

- 이메일 찾기는 회원테이블에서 이름, 휴대폰 번호를 조회하여 일치하는 이메일 데이터를 화면에 보여준다.
- 비밀번호 찾기는 이메일, 이름, 휴대폰 번호를 입력하면 이메일 주소로 임시 비밀번호를 보내주며 자동으로 비밀번호가 수정된다.(apache.commons 라이브러리 이용)
- [apache.commons를 이용한 ServiceImpl 코드보기](https://github.com/Suyeon-C/cherie/blob/27ed76e6ec2eada4b3fd874a4eeaaa130924848f/Cherie/src/main/java/com/service/BuyerServiceImpl.java)

## 3-5. 판매 상품 리스트/ 상세보기 
![화면 기록 2022-01-04 오후 9 17 24](https://user-images.githubusercontent.com/97042437/148100722-4e188b46-4f5a-4866-b9b4-c0734934e705.gif)

- 개인 회원과 판매회원 공통 사항 :
검색 기능을 통하여 조건에 맞는 상품을 볼 수 있다.
상품 상세보기에서는 그 상품을 구매한 회원들이 작성한 리뷰를 나열하여 보여준다.
페이징 처리를 통하여 구현하였으며, 등록일 순으로 상품 목록을 보여준다.
- "개인 회원"으로 로그인시, 등록된 모든 상품을 보여준다.
- '구매하기' 버튼을 통하여 장바구니에 상품을 담는다. 
- "사업자 회원" 으로 로그인 시, 자신이 등록한 상품만 보여준다.. 
- '수정하기'버튼을 누르면 현재 남은 재고량과 상품의 정보를 수정할 수 있다. 

## 3-6.장바구니 등록 및 결제 
![결제](https://user-images.githubusercontent.com/97042437/148097837-89cc8fa5-36e9-4ad3-9051-6abca7d4eab6.gif)
- 장바구니 수량 +/- ajax를 사용하여 구현하였다.
- 결제 폼은 기존 배송지와 새로운 배송지 2개로, 기존 배송지에는 회원정보에 담긴 데이터를 넣어 두고 새로운 배송지에는 새로 입력된 데이터로 결제를 진행한다.
- 상품 결제는 Import API를 통해 간편한 결제 시스템을 구현한다.
- 결제가 완료시, 데이터베이스의 주문테이블에 주문내역을 저장한다.
- 결제 내역과 주문 상세 내역은 구매자 회원의 [주문]에서 볼 수 있다.
- [코드보기](https://github.com/Suyeon-C/cherie/blob/27ed76e6ec2eada4b3fd874a4eeaaa130924848f/Cherie/src/main/java/com/cart/controller/IamportController.java)


## 3-7. 주문 내역 / 취소 및 리뷰 작성 
![리뷰](https://user-images.githubusercontent.com/97042437/148101898-d753902f-c7c6-48ab-bc89-e6d1c2a6afa9.gif)
- [주문] 카테고리 클릭시, 회원별로 주문한 내역을 보여준다. 
- 상품별로 주문 취소와 리뷰 작성이 가능하다.
- [코드보기](https://github.com/Suyeon-C/cherie/blob/27ed76e6ec2eada4b3fd874a4eeaaa130924848f/Cherie/src/main/java/com/order/controller/OrderListController.java)

## 3-8. [사업자 회원] 내 정보 및 상품 수정/탈퇴(삭제)
![프로젝트](https://user-images.githubusercontent.com/97042437/148098279-e5241a8b-226f-4092-be94-4d822f0d173e.gif)
- 개인 회원과 동일하게 내 정보 수정 및 탈퇴가 가능하도록 구현하였다.
- [코드보기](https://github.com/Suyeon-C/cherie/blob/27ed76e6ec2eada4b3fd874a4eeaaa130924848f/Cherie/src/main/java/com/jewerly/controller/JewInsertController.java)

## 3-9. [관리자] 개인 회원과 사업자 회원 목록
![바](https://user-images.githubusercontent.com/97042437/148095917-1d051245-030d-4874-b903-14f10a79f4dd.gif)
- 가입한 개인 회원과 사업자 회원에 대한 정보 확인/수정 및 탈퇴 가능하다.
- 사업자의 상품의 수정하거나 삭제 가능하다.
- [코드 보기](https://github.com/Suyeon-C/cherie/blob/27ed76e6ec2eada4b3fd874a4eeaaa130924848f/Cherie/src/main/java/com/admin/controller/AdminSellController.java)
