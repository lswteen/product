# With Springboot framework Product

> Spring Boot기반으로 기본적인 설정을 자동화하고 Multi Module 구조와 DDD(Domain Driven Design)으로 스켈로튼을 구성합니다.

> 사용 기술 : Spring Cloud Gateway, JPA, H2, Swagger2

## Springboot MSA 및 DDD Multi Module 구조 스켈레톤
1. 점진적인 확장형으로 core, domain, service, gateway 패키지 분리 및 Multi Module 구조 작업
2. 결합도와 응집도를 최소화함
3. DDD에 대한 정리정보 https://github.com/lswteen/til-1/tree/master/book/DDD
4. 소스파편화를 최소화하여 협업시 소스 작업 복잡도 줄어듬 git 관리및 빌드 배포시 용이함.

## Core
> 서비스에서 필요로하는 공통적인 비지니스 및 에러처리 기능 특정 서비스영역에서만 사용되는것이 아닌 core에 필요한 요소작업

* annotation 설정
* yaml properties 설정
* API 공통 Error Exception 설정
* 객체 매핑 설정
* 그외 필요한것들은 작업하면서 추가함

## Domain
> 상품 테이블 에 해당하는 domain 정보처리 영역 entity, repository, service 

* 도메인은 서비스플랫폼에서 사용되는 가장 명확한 바운더리가 있어야합니다.
* 다른 서비스 조합이 필요하다면 service 패키지에서 조합하여 사용할수 있는 구조가 되어야 합니다.
* 꼭 해당 하는 도메인에 필요한 기능만 작성해야 합니다.

## Service
> 서비스에 필요한 기능을 구현합니다. request, response, service, controller 존재합니다.

* 클라이언트과 호출하는 부분들에 대한 인터페이스와 행동,행위 등에 해당하는 기능을 작업합니다.
* domain에 service 에서 해야하는 부분들은 넣으시면 안됩니다.

## Gateway
> MSA 구조라면 필요한 기능입니다. API에 대한 필터를 추가하며 Appkey 나 throttling 등을 처리할수 있습니다.

* 클라이언트과 호출하는 부분들에 대한 인터페이스와 행동,행위 등에 해당하는 기능을 작업합니다.
* Spring cloud gateway 입니다. 
* 아직은 없지만 추후 인증 및 권한, 서비스 검색, 캐싱, 속도제한, 부하분산, 로깅 추적, 특정 해더 변환, 화이트리스트 정책 등을 제공할수 있습니다.

## Local Mac 기준 선행조건 순서 Intellij 기준 Setup
1. https://github.com/lswteen/product.git 소스레벨 master 브렌치로 내려받기 하시면됩니다.
2. IntelliJ에 Lombok Plugin을 설치한다.
    ```
    Preferences > Plugins > Browse repositories.. > Lombok 검색 > Install > restart
    ```
3. Gradle 창에서 Refresh를 클릭힌다. 인고의 시간이 지나면 모든 라이브러리가 download되고 **Run** 가능한 상태가 된다.
4. 그래도 안되면 File > Invalidate Caches.. > 클릭후 클리어 하면 잘못된 소스다운로드를 초기화할수있다.
5. JDK 11 버전으로 부탁드립니다.
6. Local환경이다보니 redis, h2 설정이 필요합니다.
7. 아래 정보기준으로 진행하시면됩니다.

## H2 DB connections 환경 설정
- **아래 이미지처럼 H2 설정을 변경하시면됩니다.**
  <img width="910" alt="스크린샷 2021-10-28 오후 9 31 59" src="https://user-images.githubusercontent.com/3292892/139255693-cf536305-0be4-496e-b9df-8880e4b45713.png">


## gradle 버전으로 해당 버전 다운로드 이후 실행했는데 정상동작 안하면 아래이미지대로 진행 해주시면됩니다.
build 하위에서 clean -> build -> bootRun 하시면됩니다.

<img width="276" alt="스크린샷 2021-10-28 오후 9 34 51" src="https://user-images.githubusercontent.com/3292892/139256396-272cebf9-53c5-4929-a8e5-3d0bdd525bff.png">

## 해당 내용은 인텔리J에서 클린하는 기능입니다.
<img width="411" alt="스크린샷 2021-10-28 오후 9 34 59" src="https://user-images.githubusercontent.com/3292892/139256278-d7cbf032-b1c5-4b06-9305-cac87a540f39.png">
<img width="442" alt="스크린샷 2021-10-28 오후 9 35 04" src="https://user-images.githubusercontent.com/3292892/139256182-a0762b56-858e-454d-be57-2a81c8156c39.png">

## 상품
* Goods, Product
* 저는 둘다 상품에 해당한다고 생각하며
* 해당 서비스 플랫폼에서 사용중인 것으로 맞춰서 하면된다고 생각합니다.
* 
* 되도록이면 full name 으로 하는것을 선호하는 편입니다.
* 시간과 여러가지 이유로 리펙토링이 필요하고
* 코드리뷰와 여러부분 피드백 요청으로 수정이 되어야합니다.
* 
* 상품 구성 테이블
* 확장성 차원에서 고려하였으며 쿠팡API 참고 하였습니다.
* 실제로 네이버 상품등록, 쿠팡상품은 대략적으로 어떻게 구성되어있는지 인지되어있는상태입니다.
* 티몬에서 상품 대량등록 엑셀파일기능 구현이 필요하여 네이버와 쿠팡은 분석도하고 직접 토이 프로젝트로 구현 진행 하였습니다.
* 
* 상품(goods)
* 상품옵션(goodsItem) 상품 one to 상품옵션 many
* 상품이미지(goodsItemImage) 상푸옵션 one to 상품이미지 many
* 상품정보
* 카테고리
* 배송방법
* 상품재고
* 
* 구매후기,스타일후기,상품사진후기,일반후기
* 좋아요수, 누적판매, 상품 조회수 등등등...

## Swagger 상품 URI
> core, domain, service 를 순서대로 clean > build 하고 service application bootRun 하시면 됩니다.


http://localhost:9030/swagger-ui.html
상품 API 확인 가능합니다.

h2가 in memory형태라 application 동작시에만 저장됩니다.
1. 상품 등록
2. 상품 조회

![스크린샷 2021-11-07 오후 7 03 19](https://user-images.githubusercontent.com/3292892/140640588-6fb0ace3-01b8-4222-af85-ab6a43175f13.png)

## 상품 등록 API 호출
Goods 
GoodsItem 
One to Many 구조 입니다.

옵션 정보들은 카테고리에 따라서 등록가능한 단위가 조정됩니다.
상품이 옵션을 많이 넣는방법보다는 고객이 선택을 최소화 할수 있는 형태가 상품 마케팅에서 
효율적입니다.

무신사, 에이블리, 아이디어스, 마켓컬리, 정육각, 오늘회 등 카테고리 특화상품 단일상품 구조가 고객의
시간과 선택을 줄여주기 때문입니다.

테이블은 단일 상품, 다중옵션 모두 등록 가능한 구조이며 옵션은 카테고리에 따라 단위등록 변경될수 있는 기능이 추가되어야합니다.
![스크린샷 2021-11-07 오후 7 05 58](https://user-images.githubusercontent.com/3292892/140640680-cd2f7993-4415-4637-a37b-848dd8d0f40c.png)

![스크린샷 2021-11-07 오후 7 06 24](https://user-images.githubusercontent.com/3292892/140640809-9659e4bb-0557-4783-b9f1-d1a04b015102.png)


## 상품 등록 API 호출

request payload
```json
[{
"vendorId" : 1000
,"sellerGoodsName" : "AMI 화이트 빅하트 로그 가디건"
,"displayGoodsName": "남성 21FW 체인스티치 빅하트 로고 가디건 - 화이트"
,"brand" : "AMI"
,"deliveryMethod": "SEQUENCIAL"
,"deliveryCompanyCode":"FREE"
,"deliveryCharge":"2500"
,"returnCenterId":"1000"
,"goodsDetails" : "아미 화이트 빅하트 로그 가디건 상품 상세 정보 입니다."
,"saleStartedAt" : "2021-11-11 23:00:00"
,"saleEndedAt" : "2022-11-11 23:00:00"
,"goodsItemList" : [{
"itemName" : "화이트 가디건"
,"originalPrice" : 795000
,"salePrice" : 495000
,"maximumBuyForPerson" : 10
,"adultOnly": "EVERYONE"
,"taxType" : "TAX"
,"modelNo" : "A21HK303016100"
},
{
"itemName" : "블랙 가디건"
,"originalPrice" : 695000
,"salePrice" : 395000
,"maximumBuyForPerson" : 10
,"adultOnly": "EVERYONE"
,"taxType" : "TAX"
,"modelNo" : "A21HK303016101"
}
]
}]
```
<img width="319" alt="스크린샷 2021-11-07 오후 7 32 42" src="https://user-images.githubusercontent.com/3292892/140641390-2b57f608-3114-424c-a470-6322a2cf5f0e.png">

방금 등록한 상품에 식별 번호 goodsId 를 Query String 호출하면 
해당 구조로 조회 됩니다.

![스크린샷 2021-11-07 오후 7 12 51](https://user-images.githubusercontent.com/3292892/140640833-a0d40d70-a2fb-4a6e-b0f2-82251c0187c6.png)

상품 조회는 goodsId 를 여러개 호출할수 있도록 작업하여 

dummy 상품 등록을 하나 더 해보도록 하겠습니다.
![스크린샷 2021-11-07 오후 7 14 46](https://user-images.githubusercontent.com/3292892/140640885-ff51f717-ce45-40f1-b241-8ad6df160cde.png)

방금 등록한 dummy상품 2개를 추가후 조회한 모습입니다.
![스크린샷 2021-11-07 오후 7 16 09](https://user-images.githubusercontent.com/3292892/140640936-47869361-a560-4e49-95b4-e5be8dd54d83.png)

## 더 고려해야할 사항
> Gateway
vendor(파트너, 협력사) API 를 상품등록 할때 밴더별로 등급을 
매겨서 등록하는 방식이나 특정 밴더사 상품등록 API를 조절해야하는 필요성이 있는데 아래 내용처럼 가능합니다.
뽑아주시면 해당 내용 기능 구현 해보도록 하겠습니다.

https://spring.io/blog/2021/04/05/api-rate-limiting-with-spring-cloud-gateway

Throttling 는 아래 leaky_bucket 방식으로 진행할예정이며
이부분은 MSA 아키텍처와 함께 나온 내용입니다. 8년전쯤.. SKP,SKT develops 개발할때도 구현 해봤던 방식이며
지금은 spring cloud gateway에서 Redis 기능을 이용해서 yml을 통해 공부를 하면 쉽게? 설정 가능한것을 알고있습니다.

![스크린샷 2021-11-07 오후 7 26 52](https://user-images.githubusercontent.com/3292892/140641244-5268e663-3137-4b97-be6c-742eae986f04.png)
https://en.wikipedia.org/wiki/Leaky_bucket



