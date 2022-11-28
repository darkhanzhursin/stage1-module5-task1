package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {
    int counter;

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return x -> {

           for (int i = 0; i < x.size(); i++) {
              if (Character.isUpperCase(x.get(i).charAt(0))) {
                  counter++;
              }
           }

           if (counter == x.size()) {
               return true;
           }
           return false;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {

        List<Integer> result = new ArrayList<>();

        Consumer<List<Integer>> print = x -> {
            if (!x.isEmpty()) {

                Iterator<Integer> iterator = x.iterator();
                while (iterator.hasNext()) {
                    result.add(iterator.next());
                }

                for (int i = 0; i < x.size(); i ++) {
                    if (x.get(i) % 2 == 0) {
                        result.add(x.get(i));
                    }
                }
                x.clear();
                x.addAll(result);
            }
        };
        return print;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        List<String> result = new ArrayList<>();
        return () -> {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i).split(" ").length > 3
                    && values.get(i).endsWith(".")
                    && Character.isUpperCase(values.get(i).charAt(0))) {
                    result.add(values.get(i));
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

        Map<String, Integer> result = new HashMap<>();
        return x -> {

            for (int i = 0; i < x.size(); i++) {
                result.put(x.get(i), x.get(i).length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        List<Integer> result = new ArrayList<>();
        return (list1, list2) -> {
            Iterator<Integer> iterator = list1.iterator();
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }

            iterator = list2.iterator();
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }
            return result;
        };
    }
}
