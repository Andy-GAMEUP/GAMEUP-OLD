# GAMEUP-OLD
Project-GAMEUP OLD WEB SERVICE

1. WEB (프론트엔드)
프레임워크	Vue 3 + TypeScript
빌드 도구	Vite 4
상태관리	Pinia (pinia-plugin-persist)
라우팅	Vue Router 4
HTTP 클라이언트	Axios
웹소켓	SockJS + STOMP
UI 라이브러리	FullCalendar, Swiper, ApexCharts, Masonry, SortableJS
웹서버	Apache HTTP 2.4.46 (mod_jk로 Tomcat 연동)
프론트엔드 페이지 구성:
서비스 영역 (25개 Vue): 로그인, 회원가입, 미니홈, 퍼블리싱, 솔루션, 커뮤니티, 파트너, 스크랩, 지원프로그램 등
관리자 영역 (41개 Vue): 회원관리, 레벨관리, 시즌관리, 배너관리, 분석, 파트너관리, 솔루션관리 등
모달 컴포넌트 (42개): 게임 등록/관리, 파트너 신청, 공지, 프로필 수정 등

2. WAS (백엔드)
프레임워크	Spring Boot 2.2.4
언어	Java 8
빌드 도구	Gradle
DB	MySQL (MyBatis ORM)
인증	JWT (jjwt), OAuth (카카오/네이버 로그인)
본인인증	OKCert
웹소켓	Spring WebSocket + STOMP
배포 형태	WAR (GAMEUP-WAS.war)

백엔드 도메인 구조 (패키지: com.capcloud.gameup):
controller - admin/service 이중 구조 (관리자 API + 서비스 API)
service - analysis, community, home, partner, publish, solution, support, user, oauth, stomp 등
domain - 약 50개 DB 테이블 엔티티 (TB_USER, TB_HOME, TB_COMMUNITY, TB_PARTNER, TB_SOLUTION 등)
프로필 관리 - local / dev / prd 환경 분리

3. 인프라 구성
Apache HTTPD	2.4.46
Tomcat Connector (mod_jk)	1.2.48
APR	1.7.0
APR-Util	1.6.1
PCRE	8.44
배포 플로우: Git pull → npm build → dist를 www/에 복사 → Apache가 정적 파일 서빙 → /was 프록시로 Spring Boot WAS 연동

요약
게임 업계 종합 플랫폼 ("GAMEUP") 으로 보이며, 미니홈, 커뮤니티, 파트너 매칭, 솔루션(투자), 퍼블리싱, 지원프로그램(시즌제) 등의 기능을 포함한 웹서비스입니다. 
프론트는 Vue 3 + Vite, 백엔드는 Java 8 + Spring Boot + MyBatis + MySQL 구성이고, Apache + mod_jk를 통해 연동되는 전통적인 웹 아키텍처입니다. 
END 
