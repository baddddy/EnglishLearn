echo off 
title 创建表空间和用户 
sqlplus system/123456 @.\user\run_sql.sql >>.\log\user.log
exit
