--�˽ű������������ݿ�Ĵ�����

--�ļ�������
CREATE OR REPLACE TRIGGER T_CET4_GENERATOR BEFORE
INSERT ON T_CET4 FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(FID) INTO mid FROM T_CET4;
      :new.FID:=mid+1;
end;
/
--�û�������
CREATE OR REPLACE TRIGGER T_USER_GENERATOR BEFORE
INSERT ON T_USER FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(USERID) INTO mid FROM T_USER;
      :new.USERID:=mid+1;
end;
/
--����������
CREATE OR REPLACE TRIGGER T_CET6_GENERATOR BEFORE
INSERT ON T_CET6 FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(SID) INTO mid FROM T_CET6;
      :new.SID:=mid+1;
end;
/
--���������
CREATE OR REPLACE TRIGGER T_PHRASE_GENERATOR BEFORE
INSERT ON T_PHRASE FOR EACH ROW
declare
      mid number;
begin
      SELECT MAX(PID) INTO mid FROM T_PHRASE;
      :new.PID:=mid+1;
end;
/





