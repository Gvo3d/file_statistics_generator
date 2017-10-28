package org.yakimovdenis.webserver.support;

import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
