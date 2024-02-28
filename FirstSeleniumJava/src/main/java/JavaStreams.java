import dev.failsafe.internal.util.Assert;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Abhijeet");
        arrayList.add("Don");
        arrayList.add("Alekhya");
        arrayList.add("Adam");
        arrayList.add("Ram");

        regular(arrayList);
        streamFilter(arrayList);

        arrayList.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));

        System.out.println("*****************LIMITTING***********");
        arrayList.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

        System.out.println("*****************Stream Map****************");
        streamMap(arrayList);

    }

        public  static void regular (List<String> arrayList) {


            int count = 0;

            for (int i = 0; i < arrayList.size(); i++) {
                String actual = arrayList.get(i);
                if (actual.startsWith("A")) {
                    count++;
                }
            }
            System.out.println(count);

        }


        public static void streamFilter (List<String> arrayList) {


            Long c = arrayList.stream().filter(s -> s.startsWith("A")).count();
            System.out.println(c);
        }

        public static void streamMap(List<String> arrayList){

        arrayList.stream().filter(s -> s.length()>4).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        String arr[] = {"Abhijeet","Don",
                "Alekhya",
                "Adam",
                "Ram" };

            System.out.println("*****************************************");

        List<String> names = Arrays.asList(arr);
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


            System.out.println("**********Concatinating the arr as stream twice**********************");
            List<String> list1 = Arrays.asList(arr);
            List<String> list2 = Arrays.asList(arr);

            Stream<String> newStream = Stream.concat(list1.stream(), list2.stream());
           newStream.sorted().forEach(s -> System.out.println(s));

//            boolean flag = newStream.anyMatch(s -> s.equals("Adam"));
//            System.out.println(flag);
            System.out.println("**********************************************");

            List<String> newList = Stream.concat(list1.stream(), list2.stream()).filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
            System.out.println(newList.get(0));

            List<Integer> values = Arrays.asList(1,2,2,5,6,4,5,5,3,6);
            values.stream().distinct().forEach(s-> System.out.println(s));


        }

    }


