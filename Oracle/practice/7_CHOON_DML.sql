-- 1. 과목유형 테이블(TB_CLASS_TYPE)에 데이터 입력
INSERT INTO TB_CLASS_TYPE VALUES(01, '전공필수');
INSERT INTO TB_CLASS_TYPE VALUES(02, '전공선택');
INSERT INTO TB_CLASS_TYPE VALUES(03, '교양필수');
INSERT INTO TB_CLASS_TYPE VALUES(04, '교양선택');
INSERT INTO TB_CLASS_TYPE VALUES(05, '논문지도');
COMMIT;

-- 2. 서브쿼리를 이용해 학생일반정보 테이블 작성
CREATE TABLE TB_학생일반정보
AS SELECT STUDENT_NO 학번, STUDENT_NAME 학생이름, STUDENT_ADDRESS 주소
   FROM TB_STUDENT;
   
-- 3. 국어국문학과 학생들의 정보가 포함되어 있는 학과정보 테이블 작성
CREATE TABLE TB_국어국문학과
AS SELECT STUDENT_NO 학번, STUDENT_NAME 학생이름, 19||(SUBSTR(STUDENT_SSN, 1, 2)) 출생년도, 
          NVL(P.PROFESSOR_NAME, '교수 미지정') 교수이름
   FROM TB_STUDENT S
        JOIN TB_PROFESSOR P ON(S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
   WHERE S.DEPARTMENT_NO = 001;

-- 4. 현 학과의 정원을 10% 증가 (단, 반올림을 사용해 소수점 자릿수가 생기지 않도록 함)
UPDATE TB_DEPARTMENT
SET CAPACITY = ROUND(CAPACITY*1.1);

-- 5. 학번 A413042인 박건우 학생의 주소를 "서울시 종로구 숭인동 181-21"로 정정
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '서울시 종로구 숭인동 181-21'
WHERE STUDENT_NO = 'A413042';

-- 6. 학생정보 테이블에서 주민번호 뒷자리를 저장하지 않도록 수정
UPDATE TB_STUDENT
SET STUDENT_SSN = SUBSTR(STUDENT_SSN, 1, 6);

-- 7. 의학과 김명훈 학생이 2005년 1학기에 수강한 '피부생리학' 점수의 학점을 3.5로 변경
UPDATE TB_GRADE
SET POINT = 3.5
WHERE STUDENT_NO = (SELECT STUDENT_NO
                    FROM TB_STUDENT
                         JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                    WHERE STUDENT_NAME = '김명훈' AND DEPARTMENT_NAME = '의학과') 
      AND CLASS_NO = (SELECT CLASS_NO
                      FROM TB_CLASS
                      WHERE CLASS_NAME = '피부생리학')
      AND TERM_NO = 200501;

-- 8. 성적 테이블(TB_GRADE)에서 휴학생들의 성적항목 제거
DELETE FROM TB_GRADE
WHERE STUDENT_NO IN (SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE ABSENCE_YN = 'Y');