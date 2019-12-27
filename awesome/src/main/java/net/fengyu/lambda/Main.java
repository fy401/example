package net.fengyu.lambda;

import net.fengyu.App;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        Comparator<Apple> byWeight= Comparator.comparingInt(Apple::getWeight);

        Apple a1 = new Apple(8,1);
        Apple a2 = new Apple(9,2);

        System.out.println(byWeight.compare(a1,a2));
    }


}
