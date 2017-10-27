package org.yakimovdenis.console.database.yaml;

import java.io.File;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yakimovdenis.console.ConsoleApplication;

public class DataSourceYamlReader {
    private final static String FILE_NAME = "application.yml";

    public static DatabaseProperties getDataSourceProperties() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = ConsoleApplication.class.getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(FILE_NAME).getFile());
        } catch (NullPointerException e) {
            System.out.println(e);
            throw e;
        }
        DatabaseProperties source = null;
        try {
            source = mapper.readValue(file, DatabaseProperties.class);
            System.out.println(ReflectionToStringBuilder.toString(source, ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
        }
        return source;
    }
}
