
CONSOLE MODULE:
Modulename: Console;
Commands:
"file {$fileName}" - process file and persist it's data to database.
"filelist" - show file names and ids from database.
"folder {$fileName}" - persist all files from folder into database.
"show {$file id}" - show file data from database.
"delete {$file id}" - delete file data from database.
NOTE: {$file id} is integer that corresponds to primary key(from database) of file object, not the file name.

Modules:
Statistics - basic module with statistics system and filereader
Console - module with spring-shell
Web-server - module with webserver with statistics algorhitm

WEB-SERVER MODULE:
Startup procedure:
0)PRE: install docker, npm;
1)Create docker container from file ./commands/create_postgre_docker.sh 
2)Launch ./commands/launch_docker.sh
3)Launch ./commands/node_install.sh
4)Launch ./commands/node_start.sh
5)Launch web-server/src/main/java/org.yakimovdenis.webserver.WebServerApplication.java
6)Navigate to localhost:4200;

NOTE: If you're under win-7, then change application.yml url from 'localhost' to your VBox machine ip.

Results:
Concurrent processing in Console module.
Angular 4 instead of ReactJS.
Console application can process folders.
Unit tests.
JDBC in console module.
Jpa+Hibernate in web-server module.
Module tests in all modules.

Known issues:
Java filereading system has one issue. While reading last empty line it has been skipped. So files with last empty line will get size minus one. That is tested in org.yakimovdenis.statistics module testing (FilesTest.java). 