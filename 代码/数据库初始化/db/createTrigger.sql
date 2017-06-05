--此脚本用来生成数据库的触发器

--四级表自增
CREATE OR REPLACE TRIGGER T_CET4_GENERATOR BEFORE
INSERT ON T_CET4 FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(FID) INTO mid FROM T_CET4;
      :new.FID:=mid+1;
end;
/
--用户表自增
CREATE OR REPLACE TRIGGER T_USER_GENERATOR BEFORE
INSERT ON T_USER FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(USERID) INTO mid FROM T_USER;
      :new.USERID:=mid+1;
end;
/
--六级表自增
CREATE OR REPLACE TRIGGER T_CET6_GENERATOR BEFORE
INSERT ON T_CET6 FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(SID) INTO mid FROM T_CET6;
      :new.SID:=mid+1;
end;
/
--例句表自增
CREATE OR REPLACE TRIGGER T_PHRASE_GENERATOR BEFORE
INSERT ON T_PHRASE FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(PID) INTO mid FROM T_PHRASE;
      :new.PID:=mid+1;
end;
/





