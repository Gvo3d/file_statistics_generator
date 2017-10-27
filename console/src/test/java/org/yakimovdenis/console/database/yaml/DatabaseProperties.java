package org.yakimovdenis.console.database.yaml;

import lombok.Data;

@Data
public class DatabaseProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String dialect;
}
