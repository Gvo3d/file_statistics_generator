package org.yakimovdenis.console;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class FilesInFolderMechanismTest {

    @Test
    public void getFilesList(){
        getFileList(getFileName("folderForTesting"));
    }

    public void getFileList(String path){
        int i=0;
        List<Path> files = new ArrayList<>();
        try {
            try (Stream<Path> paths = Files.walk(Paths.get(path))) {
                paths
                        .filter(Files::isRegularFile)
                        .forEach(files::add);
            }
            assertEquals(4, files.size());
            files.forEach(x-> System.out.println(x.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(String prefix){
        ClassLoader classLoader = getClass().getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(prefix).getFile());
        } catch (NullPointerException e) {
            file = new File(prefix);
        }
        return file.getAbsolutePath();
    }
}
