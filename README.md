
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

Known issues:
Java filereading system has one issue. While reading last empty line it has been skipped. So files with last empty line will get size minus one. That is tested in org.yakimovdenis.statistics module testing (FilesTest.java). 