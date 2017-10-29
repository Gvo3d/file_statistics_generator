package org.yakimovdenis.yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


import org.yaml.snakeyaml.Yaml;

public class DataSourceYamlReader {
    private Class target;

    public DataSourceYamlReader(Class target) {
        this.target = target;
    }

    public Props getDataSourceProperties(String fileName) {
        ClassLoader classLoader = target.getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
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
