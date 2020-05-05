package com.steven.groupgenerator.datacalc;

import com.steven.groupgenerator.Controller;
import com.steven.groupgenerator.datamodel.PeopleClass;
import com.steven.groupgenerator.datamodel.ReadFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomMix {

    public String nMix(String file, int numOfGroups) {
        ReadFile info = new ReadFile();
        ArrayList<String> studentInfo = info.readEachWord(file);

//        System.out.println(studentInfo);

        List<PeopleClass> people = new ArrayList<PeopleClass>();
        for (int i = 0; i < studentInfo.size(); i += 4) {
            people.add(

                    new PeopleClass(studentInfo.get(i))
                    //name

            );


        }
        Collections.shuffle(people);
        System.out.println("Shuffled people: " + people);

        Function<PeopleClass, String> discriminator = PeopleClass::getName;
        AtomicInteger index = new AtomicInteger();
        List<List<PeopleClass>> groups = new ArrayList<>(people.stream()
                //.sorted(Comparator.comparing(discriminator))
                .collect(Collectors.groupingBy(e -> index.getAndIncrement() % numOfGroups))
                .values());

        //groups.forEach(System.out::println);
        groups.forEach(System.out::println);
        String txt = "";

        for (int j = 0; j < groups.size(); j++) {
            txt += "Group" + (j + 1);
            txt += "\r\n";
            txt += groups.get(j);
            txt += "\r\n";
            txt += "\r\n";
        }

        return txt;
    }
}
