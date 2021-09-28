-- PL/SQL
-- 선언부          DECLARE     변수, 상수 선언
-- 실행부          BEGIN       로직 기술
-- 예외처리부       EXCEPTION   예외 발생 시 해결 문장 기술

/*
    // 변수 선언 없이 바로 실행
    System.out.println(10);
    
    // 변수 선언 후 실행 -> DECLARE 필요
    int a = 10;
    System.out.println(a);
*/

SET SERVEROUTPUT ON; 
-- 출력을 화면에 보여주도록 하는 설정

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;
/
-- /까지 세트로 들어가 있어야 함

/*
    int empId;
    String empName;
    
    final int PI = 3.14;
    
    empId = 800;
    empName = "남나눔";
    
    System.out.println("empId : " + empId);
    System.out.println("empName : " + empName);
*/

DECLARE -- 선언부 시작
    EMP_ID NUMBER;
    EMP_NAME VARCHAR2(30);
    PI CONSTANT NUMBER := 3.14; -- :=  <-- PL/SQL에서의 대입연산자
BEGIN
    EMP_ID := 800;
    EMP_NAME := '남나눔';
    
--    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' + EMP_ID);
--    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' + EMP_NAME);
      DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
      DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/
--ORA-06502: PL/SQL: 수치 또는 값 오류: 문자를 숫자로 변환하는데 오류입니다
--> 연결 연산자를 +가 아니라 ||로 써야 함

DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE; --EMPLOYEE에 있는 EMP_NAME이라고 하는 컬럼의 타입을 따라가겠다
    -- 변수명으로 사용할 이름을 따로 지정한 것
BEGIN
    SELECT EMP_ID, EMP_NAME -- EMPLOYEE테이블의 컬럼명
    INTO EMP_ID, EMP_NAME --위의 변수에 집어넣겠다는 뜻
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';
    -- 실행했을 때 나오는 EMP_ID에 대한 값을 입력하라는 건 후자의 EMP_ID를 뜻함(&사번이라고 넣어도 됨)
    -- & : 대체 변수 입력 (값 입력)
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/
 
-- 레퍼런스 변수로 EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY를 선언하고
-- EMPLOYEE테이블에서 사번, 이름, 직급코드, 부서코드, 급여를 조회 후 선언한 레퍼런스 변수에 담아 출력
-- 단, 입력 받은 이름과 일치하는 조건의 직원 조회
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    INTO EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME = '&이름';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드 : ' || DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('직급코드 : ' || JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY);
END;
/
    
DECLARE
    E EMPLOYEE%ROWTYPE;
    -- %ROWTYPE : 행에 대한 데이터형, 크기, 속성 참조
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
--    DBMS_OUTPUT.PUT_LINE('E : ' || E);
    --ORA-06550: 줄 10, 열26:PLS-00306: '||' 호출 시 인수의 갯수나 유형이 잘못되었습니다
    -- E를 바로 출력할 수 없음
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
    
END;
/

-- IF ~ THEN ~ END IF (단일 IF문)
-- EMP_ID를 입력받아 사번, 이름, 급여, 보너스율 출력
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS/*NVL(BONUS, 0)*/
    INTO EMP_ID, EMP_NAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS IS NULL) -- NVL 안 썼을 때는 이렇게 해준다
--    IF(BONUS = 0)
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다');
    END IF;
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS * 100 || '%');
END;
/

-- IF ~ THEN ~ ELSE ~ END IF(IF ~ ELSE문)
-- EMP_ID를 입력받아 해당 사원의 사번, 이름, 부서명, 소속 출력
-- TEAM변수를 만들어 소속이 KO면 국내팀, 아니면 해외팀으로 저장
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NATIONAL_CODE LOCATION.NATIONAL_CODE%TYPE;
    
    TEAM VARCHAR2(20);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
         LEFT JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = '&사번';
    
    IF(NATIONAL_CODE = 'KO')
        THEN TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || TEAM);
END;
/

-- 사용자에게 사번을 받아와 그 사원의 전체 정보를 VEMP에 저장
-- VEMP를 이용하여 연봉 계산(보너스가 있을 경우 보너스 포함하여 계산)
-- 연봉 결과 값은 YSALARY에 저장
-- 급여 이름 연봉(\1,000,000) 자릿수 표시까지 형식대로 출력

DECLARE
    VEMP EMPLOYEE%ROWTYPE;
    YSALARY NUMBER;
BEGIN
    SELECT *
    INTO VEMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    IF(VEMP.BONUS IS NOT NULL)
        THEN YSALARY := (VEMP.SALARY * (1 + VEMP.BONUS)) * 12;
    ELSE
        YSALARY := VEMP.SALARY * 12;
    END IF;
    
--    DBMS_OUTPUT.PUT_LINE('급여 : ' || VEMP.SALARY);
--    DBMS_OUTPUT.PUT_LINE('이름 : ' || VEMP.EMP_NAME);
--    DBMS_OUTPUT.PUT_LINE('연봉 : ' || TO_CHAR(YSALARY, 'FML999,999,999'));
    DBMS_OUTPUT.PUT_LINE(VEMP.SALARY || ' ' || VEMP.EMP_NAME || ' ' || TO_CHAR(YSALARY, 'FML999,999,999'));
END;
/

-- IF ~ THEN ~ ELSIF ~ THEN ~ ELSE ~ END IF (IF ~ ELSE IF ~ ELSE문)
-- 점수를 입력 받아 SCORE에 저장
-- 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 그 외 F
-- 등급은 GRADE에 저장
-- 당신의 점수는 SCORE점이고 학점은 GRADE학점입니다
DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := '&점수';
    IF (SCORE >= 90)
        THEN GRADE := 'A';
    ELSIF (SCORE >= 80)
        THEN GRADE := 'B';
    ELSIF (SCORE >= 70)
        THEN GRADE := 'C';
    ELSIF (SCORE >= 60)
        THEN GRADE := 'D';
    ELSE
        GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고 학점은 ' || GRADE || '학점입니다.');
END;
/

-- CASE ~ WHEN ~ THEN ~ END (SWITH ~ CASE문)
-- 사번을 입력하여 해당 사원의 사번, 이름, 부서명 출력
-- D1 인사관리부 / D2 회계관리부 / D3 마케팅부 / D4 국내영업부 / 
-- D5 해외영업1부/ D6 해외영업2부 / D7 해외영업3부 / D8 기술지원부 / D9 총무부
DECLARE
    E EMPLOYEE%ROWTYPE;
    DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    IF E.DEPT_CODE = 'D1'
        THEN DEPT_TITLE := '인사관리부';
    ELSIF E.DEPT_CODE = 'D2'
        THEN DEPT_TITLE := '회계관리부';
    ELSIF E.DEPT_CODE = 'D3'
        THEN DEPT_TITLE := '마케팅부';
    ELSIF E.DEPT_CODE = 'D4'
        THEN DEPT_TITLE := '국내영업부';
    ELSIF E.DEPT_CODE = 'D5'
        THEN DEPT_TITLE := '해외영업1부';
    ELSIF E.DEPT_CODE = 'D6'
        THEN DEPT_TITLE := '해외영업2부';
    ELSIF E.DEPT_CODE = 'D7'
        THEN DEPT_TITLE := '해외영업3부';
    ELSIF E.DEPT_CODE = 'D8'
        THEN DEPT_TITLE := '기술지원부';
    ELSIF E.DEPT_CODE = 'D9'
        THEN DEPT_TITLE := '총무부';
    ELSE
        DEPT_TITLE := '배정X';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(E.EMP_ID || ' ' || E.EMP_NAME || ' ' || DEPT_TITLE);
END;
/

DECLARE
    E EMPLOYEE%ROWTYPE;
    DNAME DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';
    
--    DNAME := CASE
--                WHEN E.DEPT_CODE = 'D1' THEN '인사관리부'
--> 이렇게 해도 됨

    DNAME := CASE E.DEPT_CODE
                WHEN 'D1' THEN '인사관리부'
                WHEN 'D2' THEN '회계관리부'
                WHEN 'D3' THEN '마케팅부'
                WHEN 'D4' THEN '국내영업부'
                WHEN 'D5' THEN '해외영업1부'
                WHEN 'D6' THEN '해외영업2부'
                WHEN 'D7' THEN '해외영업3부'
                WHEN 'D8' THEN '기술지원부'
                WHEN 'D9' THEN '총무부'
                ELSE '배정X'
            END;
    DBMS_OUTPUT.PUT_LINE(E.EMP_NAME || ' ' || E.EMP_ID || ' ' || DNAME);
END;
/

-- BASIC LOOP : 내부에 처리문 작성, 마지막에 LOOP를 벗어날 조건 명시
-- LOOP
--      처리문
--      조건문
-- END LOOP;

DECLARE
    N NUMBER := 1; -- 초기화
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
        
        -- 1. IF 사용
--        IF N > 5
--            THEN EXIT;
--        END IF;
        -- 2. WHEN 사용
        EXIT WHEN N > 5;
    
    END LOOP;
END;
/

-- FOR LOOP
-- FOR 인덱스 IN 초기값..최종값  --> 초기화 불요
-- LOOP
--      처리문
-- END LOOP;

BEGIN
    FOR N IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

-- 5부터 1까지
BEGIN
    FOR N IN 5..1
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/
--> 초기값 5가 1보다 작거나 같으면 이라는 조건이 들어가는 것이기 때문에 결과가 아무것도 나오지 않고 종료
-- LOOP 안에 DBMS_OUTPUT.PUT_LINE(6-N); 이라고 하면 잘 나옴

-- 혹은 REVERSE 이용
BEGIN
    FOR N IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

-- 구구단 홀수단 출력
BEGIN
    FOR I IN 1..9
    LOOP
        IF MOD(I, 2) = 1
            THEN FOR J IN 1..9
            LOOP 
                DBMS_OUTPUT.PUT_LINE(I || '*' || J || '=' || I*J);
            END LOOP;
            DBMS_OUTPUT.PUT_LINE(' ');
        END IF;
    END LOOP;
END;
/

-- WHILE LOOP
-- WHILE 조건
-- LOOP
--      처리문
-- END LOOP;
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE N <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
    END LOOP;
END;
/

-- 5부터 거꾸로
DECLARE
    N NUMBER := 5;
BEGIN
    WHILE N >= 1
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N - 1;
    END LOOP;
END;
/

DECLARE
    I NUMBER := 2;
    J NUMBER;
BEGIN
    WHILE I <= 9
    LOOP
        J := 1;
        IF MOD(I, 2) = 0
        THEN 
            WHILE J <= 9
            LOOP
                DBMS_OUTPUT.PUT_LINE(I || '*' || J || '=' || I*J);
                J := J + 1;
            END LOOP;
            DBMS_OUTPUT.PUT_LINE(' ');
        END IF;
        I := I + 1;
    END LOOP;
END;
/

-- 미리 정의되어 있는 예외
-- NO_DATA_FOUND : SELECT문이 아무 행도 반환하지 못 할 때
-- DUP_VAL_ON_INDEX : UNIQUE제약조건이 있는 컬럼에서 중복되는 데이터가 들어갈 때
-- ZERO_DIVIDE : 0으로 나눌 때
DECLARE
    NAME VARCHAR2(30);
BEGIN
    SELECT EMP_NAME INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    -- 999 입력하면 01403. 00000 -  "no data found"
    
    DBMS_OUTPUT.PUT_LINE(NAME);
EXCEPTION
    WHEN NO_DATA_FOUND
        THEN DBMS_OUTPUT.PUT_LINE('없는 사번입니다.');
END;
/

BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&사번'
    WHERE EMP_ID = 200;
    -- 중복되는 사번으로 입력하면 무결성 제약조건 위배
EXCEPTION
    WHEN DUP_VAL_ON_INDEX
        THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다.');
END;
/

SELECT * FROM EMPLOYEE WHERE EMP_ID = 999;
ROLLBACK;


-- PROCEDURE(프로시저) : PL/SQL을 저장하는 객체(변수처럼 저장해서 사용 가능)
-- 간단하게 호출해서 사용
-- CREATE OR REPLACE PROCEDURE 프로시저명[(매개변수, ...)]
-- IS
--      선언부
-- BEGIN
--      실행부
-- EXCEPTION
--      예외처리부
-- END;
-- /
-- EXECUTE 프로시저명;
-- 혹은
-- EXEC 프로시저명;



SELECT * FROM EMP_01;

-- 프로시저 DEL_ALL_EMP 생성(이것만으로 삭제되지 X)
CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
BEGIN
    DELETE FROM EMP_01;
END;
/
ROLLBACK;
--Procedure DEL_ALL_EMP이(가) 컴파일되었습니다.

-- DEL_ALL_EMP프로시저 호출
EXECUTE DEL_ALL_EMP;
EXEC DEL_ALL_EMP;
-- 단축버전
ROLLBACK;

SELECT * FROM USER_SOURCE; -- 프로시저를 관리하는 데이터 딕셔너리
-- VIEW하고 비슷하게 이 안에 코드가 한 줄씩 들어 있어 불러올 수 있게 함

-- 사번을 입력받아 해당하는 사람을 지움
-- public void method(int inputEmpId) 이런 식으로 만든 것임
CREATE OR REPLACE PROCEDURE DEL_EMP_ID(INPUT_EMP_ID EMPLOYEE.EMP_ID%TYPE)
IS
BEGIN
    DELETE FROM EMPLOYEE
--    WHERE EMP_ID = '&사번';
    WHERE EMP_ID = INPUT_EMP_ID;
    -- 프로시저 생성시 사번 입력해서 고정되는 걸 방지하기 위함
END;
/
-- 200번 입력 후 실행하면 Procedure DEL_EMP_ID이(가) 컴파일되었습니다.

SELECT * FROM EMPLOYEE;

--EXEC DEL_EMP_ID;
-- PL/SQL 프로시저가 성공적으로 완료되었습니다.
--> 사번 입력 없이 바로 200번이 지워져버림

EXEC DEL_EMP_ID('&사번');
-- 위에서 매개변수를 추가해줬으므로 이 안에 넣어줌
-- 만약 200이라고 넣으면 입력창 없이 바로 200번이 삭제됨

ROLLBACK;

-- FUNCTION : 프로시저와 동일, 다만 반환 값 존재
-- CREATE OR REPLACE FUNCTION 함수명[(매개변수, ...)]
-- RETURN 데이터타입
-- IS
--      선언부
-- BEGIN
--      실행부
--      RETURN 반환 값;
-- EXCEPTION
--      예외처리부
-- END;
-- /
-- EXECUTE 함수명;
-- EXEC 함수명;

-- 212번의 사원 이름 출력하기
CREATE OR REPLACE FUNCTION SELECT212
RETURN EMPLOYEE.EMP_NAME%TYPE --VARCHAR2 해도 됨
IS
    ENAME EMPLOYEE.EMP_NAME%TYPE; --VARCHAR2(20);
BEGIN
    SELECT EMP_NAME
    INTO ENAME
    FROM EMPLOYEE
    WHERE EMP_ID = 212;
    
    RETURN ENAME;    
END;
/

--EXEC SELECT212;
--ORA-06550: 줄 1, 열7:PLS-00221: 'SELECT212'는 프로시저가 아니거나 정의되지 않았습니다
--> 변수 필요

VARIABLE EX_NAME VARCHAR2(20);
EXEC :EX_NAME := SELECT212;
PRINT EX_NAME;
--SELECT212가 실행되면 반환되는 값을 외부 변수 EX_NAME에다 대입하겠다

-- 사번을 입력 받아 해당 사원의 연봉을 계산하고 리턴하는 함수 생성
CREATE OR REPLACE FUNCTION YSALARY_CALC(V_ID EMPLOYEE.EMP_ID%TYPE)
RETURN NUMBER
IS
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
    YSALARY NUMBER;
BEGIN
    SELECT SALARY, NVL(BONUS, 0)
    INTO SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = V_ID;
    
    YSALARY := (SALARY * (1 + BONUS)) * 12;
--    DBMS_OUTPUT.PUT_LINE(YSALARY);

    RETURN YSALARY;
    
--    IF BONUS IS NULL
--        THEN
--        DBMS_OUTPUT.PUT_LINE(SALARY * 12);
--    ELSE
--        DBMS_OUTPUT.PUT_LINE(SALARY * (1 + BONUS));
--    END IF;
END;
/

VARIABLE EX_YSAL NUMBER;
EXEC :EX_YSAL := YSALARY_CALC('&사번');
PRINT EX_YSAL;
-- 매개변수 넣지 않으면 인수의 갯수나 유형이 잘못되었습니다는 에러 발생

-- TRIGGER(트리거) : 테이블/뷰가 DML문에 의해 변경이 됐을 때 자동으로 실행할 내용을 저장해두는 객체
-- 트리거 종류
-- SQL문의 실행 시기에 따른 분류
--      BEFORE TRIGGER : SQL문 실행 전 트리거 실행
--      AFTER TRIGGER  : SQL문 실행 후 트리거 실행
-- SQL문에 의해 영향을 받은 ROW에 따른 분류
--      ROW TRIGGER       : SQL문 각 ROW에 대해 한 번씩 실행(FOR EACH ROW옵션 작성)
--                              :OLD -> 참조 전 열의 값 
--                                      (INSERT : 존재X, UPDATE : 수정 전 자료, DELETE : 삭제할 자료)
--                              :NEW -> 참조 후 열의 값
--                                      (INSERT : 입력한 자료, UPDATE : 수정 후 자료, DELETE : 존재X)
--      STATEMENT TRIGGER : SQL문에 의해 한 번만 실행(DEFAULT)

-- CREATE OR REPLACE TRIGGER 트리거명
-- BEFORE | AFTER
-- INSERT | UPDATE | DELETE
-- ON 테이블명
-- [FOR EACH ROW]
-- [WHEN 조건]
-- DECLARE 선언부
-- BEGIN 실행부
-- EXCEPTION 예외처리부
-- END;
-- /

-- EMPLOYEE테이블에 사원이 추가 되면 '신입사원이 입사했습니다' 문구 출력 : TRG_01 트리거 생성
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다.');
END;
/

INSERT INTO EMPLOYEE
VALUES (888, '도대담', '222222-2222222', 'do_dd@kh.or.kr', '01012344321',
        'D5', 'J3', 'S3', 3000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
        
COMMIT;

-- 상품 정보 테이블
CREATE TABLE PRODUCT(
    PCODE NUMBER PRIMARY KEY,
    PNAME VARCHAR2(30),
    BRAND VARCHAR2(30),
    PRICE NUMBER,
    STOCK NUMBER DEFAULT 0
);
-- 상품 입출고 이력 테이블
CREATE TABLE PRO_DETAIL(
    DCODE NUMBER PRIMARY KEY,
    PCODE NUMBER,
    PDATE DATE,
    AMOUNT NUMBER,
    STATUS VARCHAR2(10) CHECK(STATUS IN('입고', '출고')),
    FOREIGN KEY(PCODE) REFERENCES PRODUCT(PCODE)
);

CREATE SEQUENCE SEQ_PCODE;
CREATE SEQUENCE SEQ_DCODE;

INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '모니터', '최고', 100, DEFAULT);
INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '마우스', '찍찍', 50, DEFAULT);
INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '키보드', '타닥', 80, DEFAULT);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON PRO_DETAIL
FOR EACH ROW
BEGIN
    -- 상품이 입고된 경우
    IF :NEW.STATUS = '입고'
    --> 새로 입력한 값이 입고라면
        THEN
            UPDATE PRODUCT
            SET STOCK = STOCK + :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
    -- 상품이 출고된 경우
    IF :NEW.STATUS = '출고'
        THEN
            UPDATE PRODUCT
            SET STOCK = STOCK - :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 10, '입고');
--> PRO_DETAIL에 데이터 추가, PRODUCT의 재고컬럼에 데이터 업데이트됨
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 3, SYSDATE, 5, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 7, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 12, '입고');

INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 8, '출고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 1, '출고');

COMMIT;