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
    
    DBMS_OUTPUT.PUT_LINE('급여 : ' || VEMP.SALARY);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || VEMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('연봉 : ' || TO_CHAR(YSALARY, 'FML999,999,999'));
END;
/
