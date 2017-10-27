
Modules:
Statistics - basic module with statistics system and filereader
Console - module with spring-shell
Web-server - module with webserver with statistics algorhitm

Known issues:
Java filereading system has one issue. While reading last empty line it has been skipped. So files with last empty line will get size minus one. That is tested in org.yakimovdenis.statistics module testing (FilesTest.java). 