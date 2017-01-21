import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Vladimir on 11-Jan-17.
 */
public class Java8InAction {


    static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : appleList){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void process(Runnable r){
        r.run();
    }

//    public static String processFile(){
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));
//            return br.readLine();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }
    public static String processFile(BufferedReaderProcessor brp){
        try {
            BufferedReader br = new BufferedReader(new FileReader("d:\\data.txt"));
            return brp.process(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<T>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
    public static void main(String[] args){

        List<Apple> appleList = new ArrayList<Apple>();

        appleList.add(new Apple("green", 15));
        appleList.add(new Apple("red", 50));
        appleList.add(new Apple("yellow", 75));
        appleList.add(new Apple("red",62));
        appleList.add(new Apple("green",100));
//        List<Apple> filteredAppleList = filterApples(appleList, Apple::isHeavy);
//
//        filteredAppleList.stream().forEach(System.out::println);
//
//        List<Apple> lambdaFiltered = filterApples(appleList, (Apple a) -> "yellow".equals(a.getColor()));
//        lambdaFiltered.stream().forEach(System.out::println);


       // List<Apple> streamFiltered = appleList.stream().filter(i -> "red".equals(i.getColor())).collect(Collectors.toList());
//        System.out.println("Sorting by weight");
//        streamFiltered.stream().forEach(System.out::println);

//        appleList.sort(new Comparator<Apple>(){
//            public int compare(Apple a1, Apple a2){
//                return a1.getWeight().compareTo(a2.getWeight());
//            }
//        });
        Integer blah = 5;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);

        appleList.sort(
                (Apple a1, Apple a2) -> ((Integer)a2.getWeight()).compareTo((Integer)a1.getWeight())
        );

        appleList.stream().forEach(System.out::println);

        Runnable r1 = () -> System.out.println("Hello World 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(r1);
        process(r2);
        process(() -> System.out.println("This is awesome!!!"));

       // System.out.println(processFile());
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLines);

        List<Apple> redApples = filter(appleList, (Apple apple) -> "red".equals(apple.getColor()));
        redApples.forEach(System.out::println);

        List<Integer> evenNumbers = filter(numbers, (Integer i)-> i % 2 ==0);
        evenNumbers.forEach(System.out::println);

        appleList.sort((Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        System.out.println("********* SORTED BY WEIGHT ************");
        appleList.forEach(System.out::println);

        

    }
}
