package org.yakimovdenis.console.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.yakimovdenis.console.model.FileStatistics;
import org.yakimovdenis.console.service.StatisticsService;

import java.nio.file.NoSuchFileException;

@ShellComponent
public class ShellCommands {

    @Autowired
    private StatisticsService statisticsService;

    @ShellMethod("File statistics method")
    public String file(@ShellOption String fileName) {
        try {
            return statisticsService.persistFileStatistics(fileName).toString();
        } catch (NoSuchFileException e) {
            return "Can't find file with filename: " + fileName;
        }
    }

    @ShellMethod("File statistics method")
    public String show(@ShellOption Integer fileId) {
        return statisticsService.getStatisticsForFile(fileId).toString();
    }

    @ShellMethod("Folder statistics method")
    public String folder(@ShellOption String folderName) {
        StringBuilder builder = new StringBuilder();
        boolean first=true;
        for (FileStatistics statistics : statisticsService.persistFileStatisticsInDirectory(folderName)) {
            if (first){
                first = false;
            } else {
                builder.append(System.lineSeparator());
            }
            builder.append("File: id=" + statistics.getId() + ", uploaded=" + statistics.getFileUploadDate() + ", name=" + statistics.getFileName());
        }
        return builder.toString();
    }

    @ShellMethod("Show all files from database method")
    public String filelist() {
        StringBuilder builder = new StringBuilder();
        boolean first=true;
        for (FileStatistics statistics : statisticsService.getFileNameAndIds()) {
            if (first){
                first = false;
            } else {
                builder.append(System.lineSeparator());
            }
            builder.append("File: id=" + statistics.getId() + ", uploaded=" + statistics.getFileUploadDate() + ", name=" + statistics.getFileName());
        }
        return builder.toString();
    }

    @ShellMethod("Delete file statistics method")
    public String delete(@ShellOption Integer id) {
        return "Result: " + statisticsService.deleteFileStatistics(id);
    }
}
