--此脚本用来生成数据库的存储过程

--添加用户
CREATE OR REPLACE 
PROCEDURE add_user
(u_email IN VARCHAR2,u_name IN VARCHAR2,u_password IN VARCHAR2,o_result OUT INTEGER)
IS
BEGIN
		INSERT INTO T_USER VALUES(0,u_email,u_name,u_password);
    o_result :=1;
EXCEPTION
    WHEN OTHERS THEN
        o_result :=0;
END add_user;
/
--添加单词
CREATE OR REPLACE 
PROCEDURE add_word
(word IN VARCHAR2,mean IN VARCHAR2,diff IN NUMBER)
IS
BEGIN
INSERT INTO T_CET4 VALUES(0,word,mean,diff,0,1);
END add_word;
/
--删除单词
CREATE OR REPLACE 
PROCEDURE delete_word
(word IN VARCHAR2)
IS
BEGIN
DELETE FROM T_CET4 WHERE FWORD=word;
END delete_word;
/
--获取常用单词
CREATE OR REPLACE 
PROCEDURE get_common_word
(common_word OUT SYS_REFCURSOR,o_result OUT INTEGER)
IS
BEGIN
		OPEN common_word FOR
		SELECT FWORD,FMEAN,DIFF FROM T_CET4 
		WHERE COMMON=1 AND rownum<=10 ORDER BY FID;
    o_result :=1;
EXCEPTION
    WHEN OTHERS THEN
        o_result :=0;
END get_common_word;
/
--根据用户名获取用户对象
CREATE OR REPLACE 
PROCEDURE get_user_by_name
(user_name IN VARCHAR2,user_result OUT SYS_REFCURSOR,o_result OUT INTEGER)
IS
BEGIN
		OPEN user_result FOR
		SELECT * FROM T_USER
		WHERE UNAME=user_name;
    o_result :=1;
EXCEPTION
    WHEN OTHERS THEN
        o_result :=0;
END get_user_by_name;
/
--分页查看单词
CREATE OR REPLACE 
PROCEDURE get_word_by_page
(page_num IN NUMBER,word_result OUT SYS_REFCURSOR,o_result OUT INTEGER)
IS
BEGIN
		OPEN word_result FOR SELECT * FROM (
		SELECT A.*, ROWNUM RN 
		FROM (SELECT * FROM T_CET4 ORDER BY FID) A 
		)
		WHERE RN BETWEEN 1+10*(page_num-1) AND 10*page_num;
    o_result :=1;
EXCEPTION
    WHEN OTHERS THEN
        o_result :=0;
END get_word_by_page;
/
--分页查看单词2
CREATE OR REPLACE 
PROCEDURE get_word_page
(start_num IN NUMBER,end_num IN NUMBER,word_result OUT SYS_REFCURSOR)
IS
BEGIN
		OPEN word_result FOR SELECT * FROM (
		SELECT A.*, ROWNUM RN 
		FROM (SELECT * FROM T_CET4 ORDER BY FID) A 
		)
		WHERE RN BETWEEN start_num AND end_num;
END get_word_page;
/
--随机获取单词
CREATE OR REPLACE 
PROCEDURE get_word_random
(word_result OUT SYS_REFCURSOR)
IS
BEGIN
		OPEN word_result FOR select * from 
		(select * from T_TRAN order by dbms_random.value)
		where rownum<=4;
END get_word_random;
/
--获取单词总数
CREATE OR REPLACE 
PROCEDURE get_word_total
(result OUT INTEGER)
IS
BEGIN
SELECT COUNT(*) INTO result FROM T_CET4;
END get_word_total;
/
--模糊查找单词
CREATE OR REPLACE 
PROCEDURE search_word
(word IN VARCHAR2,word_result OUT SYS_REFCURSOR)
IS
BEGIN
		OPEN word_result FOR SELECT * 
    FROM T_CET4 WHERE FWORD LIKE (word||'%') AND ROWNUM<=10;
END search_word;
/
--翻译句子
CREATE OR REPLACE 
PROCEDURE tran_word
(word IN VARCHAR2,mean OUT VARCHAR2)
IS
BEGIN
    SELECT TMEAN INTO mean FROM T_TRAN WHERE TWORD=word;
END tran_word;
/
--更新单词表
CREATE OR REPLACE 
PROCEDURE update_Ct4
(word VARCHAR2,mean VARCHAR2)
IS
BEGIN
UPDATE T_CET4 SET FMEAN=mean WHERE FWORD=word;
END update_Ct4;
/
