-- VIEW(뷰) : SELECT 결과를 화면에 저장한 논리적인 가상 테이블(객체)
-- 실질적인 데이터를 갖고 있지 않지만 테이블과 동일하게 사용 가능

-- VIEW 생성문
-- CREATE [OR REPLACE] VIEW 뷰이름 AS 서브쿼리

-- 사번, 이름, 부서명, 근무지역의 조회 결과를 V_EMPLOYEE 뷰에 저장
CREATE OR REPLACE VIEW V_EMPLOYEE
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) -- 부서가 없는 사람도 있어서 LEFT 해준다
     LEFT JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
     LEFT JOIN NATIONAL USING(NATIONAL_CODE);
     
--ORA-01031: 권한이 불충분합니다
--01031. 00000 -  "insufficient privileges"
-- 현재 계정에서 VIEW를 생성하기 위한 권한이 없기 때문에 나는 오류
--> 권한을 부여하기 위해 SYSTEM계정(관리자계정)에 접속

-- 1) SYSTEM계정 접속
-- 2) KH계정에 뷰 생성 권한 부여
GRANT CREATE VIEW TO KH;
-- 3) KH계정으로 돌아가 VIEW생성

SELECT * FROM V_EMPLOYEE;

UPDATE EMPLOYEE
SET EMP_NAME = '정중앙'
WHERE EMP_ID = 205;

SELECT * FROM EMPLOYEE WHERE EMP_ID = 205;
SELECT * FROM V_EMPLOYEE WHERE EMP_ID = 205;

ROLLBACK;

-- 사번, 이름, 직급, 성별(남/여), 근무연수를 V_EMP_JOB 뷰 저장
-- 서브쿼리의 SELECT절에 함수가 사용된 경우 반드시 별칭 지정
--ORA-00998: 이 식은 열의 별명과 함께 지정해야 합니다
--00998. 00000 -  "must name this expression with a column alias"
CREATE OR REPLACE VIEW V_EMP_JOB
AS
SELECT EMP_ID 사번, EMP_NAME "사원 명", JOB_NAME 직급, DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여') 성별,
       (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)) 근무연수
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE);
     
CREATE OR REPLACE VIEW V_EMP_JOB(사번, "사원 명", 직급, 성별, 근무연수)
AS
SELECT EMP_ID, EMP_NAME, JOB_NAME, DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여'),
       (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE))
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE);
     
SELECT * FROM V_EMP_JOB;

CREATE OR REPLACE VIEW V_JOB
AS
SELECT JOB_CODE, JOB_NAME
FROM JOB;

SELECT * FROM V_JOB;
SELECT * FROM JOB;

INSERT INTO V_JOB VALUES('J8', '인턴');
UPDATE V_JOB SET JOB_NAME = '알바' WHERE JOB_CODE = 'J8';
DELETE V_JOB WHERE JOB_CODE = 'J8';
--> 모두 본 테이블도 함께 적용됨

SELECT * FROM USER_VIEWS;
-- 사용자 정의 뷰 확인 데이터 딕셔너리
--> 실행해보면 TEXT에 내가 쓴 SELECT절이 그대로 들어있음
--> 뷰는 결국 SELECT절에서 데이터를 불러와서 그때그때 실행할 뿐임(결국 본 테이블을 실행시키는 셈)

-- DML명령어로 조작이 불가능한 경우
-- 1. 뷰 정의에 포함되지 않은 컬럼 조작
CREATE OR REPLACE VIEW V_JOB2
AS
SELECT JOB_CODE FROM JOB;

SELECT * FROM V_JOB2;

INSERT INTO V_JOB2 VALUES('J8', '인턴'); -- SQL 오류: ORA-00913: 값의 수가 너무 많습니다
--> 내가 SELECT한 컬럼은 1개, INSERT하려는 컬럼은 2개
UPDATE V_JOB2 SET JOB_NAME = '인턴' WHERE JOB_CODE = 'J7'; -- ORA-00904: "JOB_NAME": 부적합한 식별자
DELETE FROM V_JOB2 WHERE JOB_NAME = '사원'; -- ORA-00904: "JOB_NAME": 부적합한 식별자

-- 2. 뷰에 포함되지 않은 컬럼 중 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW V_JOB3
AS SELECT JOB_NAME FROM JOB;

INSERT INTO V_JOB3 VALUES('인턴'); -- ORA-01400: NULL을 ("KH"."JOB"."JOB_CODE") 안에 삽입할 수 없습니다
--> JOB_CODE에 NOT NULL 제약조건 걸려있음
UPDATE V_JOB3 SET JOB_CODE = NULL WHERE JOB_NAME = '사원'; -- ORA-00904: "JOB_CODE": 부적합한 식별자

-- 3. 산술표현식으로 정의된 경우
CREATE OR REPLACE VIEW EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY + (SALARY*NVL(BONUS, 0)))*12 연봉
FROM EMPLOYEE;

SELECT * FROM EMP_SAL;

INSERT INTO EMP_SAL VALUES(600, '강건강', 3000000, 36000000); -- ORA-01733: 가상 열은 사용할 수 없습니다 (10시 42분)
UPDATE EMP_SAL SET 연봉 = 80 WHERE EMP_ID = 200; 
-- 계산한 결과값이 들어가야 하기 때문에 숫자 바로 넣으면 오류

-- 4. 그룹함수/GROUP BY 포함한 경우
-- V_GROUPDEPT뷰에 부서코드, 부서 별 급여 합계, 부서 별 급여 평균 저장
CREATE OR REPLACE VIEW V_GROUPDEPT(부서코드, "부서 별 급여 합계", "부서 별 급여 평균")
AS
SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT * FROM V_GROUPDEPT;

INSERT INTO V_GROUPDEPT VALUES ('D10', 600, 400); -- ORA-01733: 가상 열은 사용할 수 없습니다
UPDATE V_GROUPDEPT SET DEPT_CODE = 'D10' WHERE DEPT_CODE = 'D3'; -- ORA-00904: "DEPT_CODE": 부적합한 식별자
--> SUM과 AVG 값이 다 바뀌어버리기 때문에 불가
DELETE FROM V_GROUPDEPT WHERE DEPT_CODE = 'D1'; -- ORA-00904: "DEPT_CODE": 부적합한 식별자

-- 5. DISTINCT를 포함한 경우
CREATE OR REPLACE VIEW V_DT_EMP
AS
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

SELECT * FROM V_DT_EMP;

INSERT INTO V_DT_EMP VALUES('J9'); -- ORA-01732: 뷰에 대한 데이터 조작이 부적합합니다
UPDATE V_DT_EMP SET JOB_CODE = 'J9' WHERE JOB_CODE = 'J7'; -- ORA-01732: 뷰에 대한 데이터 조작이 부적합합니다
DELETE FROM V_DT_EMP WHERE JOB_CODE = 'J1'; -- ORA-01732: 뷰에 대한 데이터 조작이 부적합합니다
-- 중복을 제거해서 가져온 것이기 때문에 에러 뜸 (11시 12분)

-- 6. JOIN을 이용해 여러 테이블을 연결한 경우
-- V_JOINEMP 뷰에 사번, 이름, 부서명 저장
CREATE OR REPLACE VIEW V_JOINEMP
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
     
SELECT * FROM V_JOINEMP;

INSERT INTO V_JOINEMP VALUES(700, '강건강', '총무부'); -- ORA-01776: 조인 뷰에 의하여 하나 이상의 기본 테이블을 수정할 수 없습니다.
-->조인으로 만든 뷰는 조작할 수 없다

-- VIEW 옵션
-- CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름[alias[, alias]...)]
-- AS subquery
-- [WITH CHECK OPTION]
-- [WITH READ ONLY];

-- OR REPLACE : 기존에 동일한 뷰 이름이 존재하는 경우 덮어쓰고, 존재하지 않으면 새로 생성
-- FORCE/NOFORCE
--      FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
--      NOFORCE : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성(기본 값)
-- WITH CHECK OPTION : 옵션을 설정한 컬럼 수정 불가
-- WITH READ ONLY : 조회만 가능하게 만듦

CREATE OR REPLACE VIEW V_EMP1
AS 
SELECT EMP_NO, EMP_NAME
FROM EMPLOYEE;

SELECT * FROM V_EMP1;

CREATE OR REPLACE VIEW V_EMP1
AS
SELECT EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE;

CREATE VIEW V_EMP1
AS
SELECT EMP_NAME, SALARY
FROM EMPLOYEE;
--ORA-00955: 기존의 객체가 이름을 사용하고 있습니다.

CREATE OR REPLACE FORCE VIEW V_EMP2
AS
SELECT TCODE, TNAME, TCONTENT
FROM TT;
--ORA-00942: 테이블 또는 뷰가 존재하지 않습니다
-- FORCE 넣었을 때 -> 경고: 컴파일 오류와 함께 뷰가 생성되었습니다.

CREATE OR REPLACE VIEW V_EMP3
AS
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'
WITH CHECK OPTION;

SELECT * FROM V_EMP3;

UPDATE V_EMP3
SET DEPT_CODE = 'D1'
WHERE EMP_ID = 200;
--ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다

UPDATE V_EMP3
SET EMP_NAME = '성동일'
WHERE EMP_ID = 200;
--> 이건 문제 없음

ROLLBACK;

INSERT INTO V_EMP3
VALUES(999, '강건강', '111111-1111111', 'kang_kk@kh.or.kr', '01011112222', 'D1', 'J3', 'S3',
        3000000, 0.2, 200, SYSDATE, NULL, 'N');
--ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다(D9만 되는 조건)     

INSERT INTO V_EMP3
VALUES(999, '강건강', '111111-1111111', 'kang_kk@kh.or.kr', '01011112222', 'D9', 'J3', 'S3',
        3000000, 0.2, 200, SYSDATE, NULL, 'N');
--> 제대로 삽입됨

ROLLBACK;

CREATE OR REPLACE VIEW V_DEPT
AS
SELECT * FROM DEPARTMENT
WITH READ ONLY;

INSERT INTO V_DEPT
VALUES('D10', '해외영업부', 'L1');
--ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

UPDATE V_DEPT
SET LOCATION_ID = 'L2'
WHERE DEPT_ID = 'D1';
--ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

DELETE FROM V_DEPT;
--ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

COMMIT;