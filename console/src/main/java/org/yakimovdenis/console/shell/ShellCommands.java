//package org.yakimovdenis.console.shell;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.shell.standard.ShellComponent;
//
//import java.util.Locale;
//
//@ShellComponent
//public class ShellCommands {
//
//    @Autowired
//    public ShellCommands(TranslationService service) {
//        this.service = service;
//    }
//
//    @ShellMethod"Translate text from one language to another.")
//    public String translate(
//            @ShellOption(mandatory = true) String text,
//            @ShellOption(mandatory = true, defaultValue = "en_US") Locale from,
//            @ShellOption(mandatory = true) Locate to
//    ) {
//        // invoke service
//        return service.translate(text, from, to);
//    }
//}
