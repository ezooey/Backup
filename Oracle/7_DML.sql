-- DML : 데이터 조작 언어
-- 테이블에 값 삽입(INSERT) / 수정(UPDATE) / 삭제(DELETE)

-- INSERT : 테이블에 데이터 추가 (행 개수 증가)
-- INSERT INTO 테이블명(컬럼명1, 컬럼명2, ...) VALUES(값1, 값2, ...)
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE,
                     SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN)
VALUES(500, '송성실', '990111-1223344', 'SONG_SS@kh.or.kr', '01023456789', 'D1', 'J7', 'S3',
       3000000, 0.2, 200, SYSDATE, NULL, DEFAULT);
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, SAL_LEVEL)
VALUES(500, '송성실', '990111-1223344', 'J7', 'S3');
-- 정석 INSERT
-- 장점 : 내가 나열한 컬럼 순서대로 값을 집어넣을 수 있음(본 테이블의 컬럼 순서대로 안 해도 됨)
--     : 내가 원하는 컬럼만 뽑아서 값을 넣을 수 있음
-- 단점 : 쓰는 게 너무 많음
       
ROLLBACK;

INSERT INTO EMPLOYEE
VALUES(500, '송성실', '990111-1223344', 'SONG_SS@kh.or.kr', '01023456789', 'D1', 'J7', 'S3',
       3000000, 0.2, 200, SYSDATE, NULL, DEFAULT);
--INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, SAL_LEVEL)
--VALUES(500, '송성실', '990111-1223344', 'J7', 'S3');
-- 값의 수가 충분하지 않습니다
-- 모든 컬럼에 다 추가한다면 컬럼명 생략 가능
-- 장점 : 쓰는 게 적음
-- 단점 : 모든 컬럼에 값을 집어넣어야 함
--       본 테이블의 컬럼 순서를 외우고 있어야 함

COMMIT;