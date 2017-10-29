package org.yakimovdenis.yaml;

public class Liquibase{
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Liquibase{\n"+
                "enabled=" + enabled +
                '}';
    }
}
