package org.yakimovdenis.yaml;

public class Props {
    private DatabaseProperties databaseProperties;
    private Liquibase liquibase;

    public DatabaseProperties getDatabaseProperties() {
        return databaseProperties;
    }

    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public void setLiquibase(Liquibase liquibase) {
        this.liquibase = liquibase;
    }

    @Override
    public String toString() {
        return "Props{" +
                "databaseProperties=" + databaseProperties +"\n"+
                ", liquibase=" + liquibase +
                '}';
    }
}
