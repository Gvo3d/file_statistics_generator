package org.yakimovdenis.console.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Locale;

@ShellComponent
public class ShellCommands{

    @ShellMethod("Test method")
    public String translate(
            @ShellOption String text
    ) {
        // invoke service
        return "Hello, "+text+"!";
    }
}
