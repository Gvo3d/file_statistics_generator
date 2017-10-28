package org.yakimovdenis.console.database.yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.yakimovdenis.console.ConsoleApplication;
import org.yaml.snakeyaml.Yaml;

public class DataSourceYamlReader {
    private final static String FILE_NAME = "application.yml";

    public static Props getDataSourceProperties() {
        ClassLoader classLoader = ConsoleApplication.class.getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(FILE_NAME).getFile());
        } catch (NullPointerException e) {
            System.out.println(e);
            throw e;
        }
        Yaml yaml = new Yaml();
        Props config = null;
        try (InputStream in = Files.newInputStream(file.toPath())) {
             config = yaml.loadAs(in, Props.class);
            System.out.println("loaded: "+config.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
