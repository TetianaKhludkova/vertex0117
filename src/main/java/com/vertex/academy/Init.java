package com.vertex.academy;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// classes should be here
public class Init {
    private static FuncInf funcInf = File::new;


    public static void main(String[] args) {
        List<List<String>> listOfLists = new ArrayList<>();
        System.out.println(funcInf.test("test").exists());

        listOfLists.add(Arrays.asList("element1-1", "element1-2"));
        listOfLists.add(Arrays.asList("element2-1", "element2-2"));

        listOfLists.stream().flatMap(Collection::stream)
                .filter(s -> s.endsWith("2"))
                .forEach(System.out::println);
    }
}
