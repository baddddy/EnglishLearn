�˽ű�������ʼ���û��Լ��û�����ı��洢���̣�����������ͼ

˵����
1.initialize_user.bat�ļ���
��1��������ʼ���û���ʵ���Ͼ��ǵ���sqlplus�������У�Ȼ���½��Oracle���ݿ��ϣ�����һЩ������
��2����Ϊ�˲���Ҫ�½��û�����������system��½Oracle������Ϊ��123456��
��3����½�ɹ���ִ��user�ļ����µ�run_sql.sql�ű��ļ���ִ������ļ�ʱ�ֻ�ִ��createuser.sql�ļ���grant.sql�ļ���
��4����bat�ļ���������Ϣ��д��./log/user.log��־�ļ��С�

2.initialize_db.bat�ļ���
��1��ԭ��ͬinitialize_user.bat�ļ��������½����û���¼Oracle���ݿ⣬ִ��db�ļ����µ�run_sql.sql�ű���
��2�����ݽű����ݣ�������ִ��createTable.sql��createProcedure.sql��createTrigger.sql��createView.sql�Դﵽ���洢���̣�����������ͼ�ĳ�ʼ����
��3����bat�ļ���������Ϣ��д��./log/db.log�ļ��С�