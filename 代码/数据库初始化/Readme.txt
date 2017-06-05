此脚本用来初始化用户以及用户里面的表，存储过程，触发器，视图

说明：
1.initialize_user.bat文件：
（1）用来初始化用户，实质上就是调用sqlplus的命令行，然后登陆到Oracle数据库上，进行一些操作；
（2）因为此操作要新建用户，所以我用system登陆Oracle，密码为：123456；
（3）登陆成功后执行user文件夹下的run_sql.sql脚本文件，执行这个文件时又会执行createuser.sql文件和grant.sql文件；
（4）此bat文件的运行信息会写在./log/user.log日志文件中。

2.initialize_db.bat文件：
（1）原理同initialize_user.bat文件，利用新建的用户登录Oracle数据库，执行db文件夹下的run_sql.sql脚本；
（2）根据脚本内容，会依次执行createTable.sql，createProcedure.sql，createTrigger.sql，createView.sql以达到表，存储过程，触发器，视图的初始化。
（3）此bat文件的运行信息会写在./log/db.log文件中。