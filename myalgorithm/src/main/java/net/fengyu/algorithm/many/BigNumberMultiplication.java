package net.fengyu.algorithm.many;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigNumberMultiplication {


    public static void main( String[] args ) {

        List<Integer> a = Arrays.asList(1,2,4,5,6,3,2);
        List<Integer> b = Arrays.asList(2,9,5,5);

        System.out.println(multiplication(a,b));
    }


    public static List<Integer> multiplication(List<Integer> a, List<Integer> b) {

        if(a == null || a.size() == 0 || b == null || b.size() == 0) {
            return null;
        }

        List<Integer> resultList = new ArrayList<Integer>(a.size() + b.size());
        for(int i=0; i< (a.size() + b.size())  ;i++) {
            resultList.add(0);
        }


        for(int i=0; i<a.size(); i++) {
            for (int j=0; j<b.size(); j++) {
                resultList.set(i+j, a.get(i)*b.get(j) + resultList.get(i+j));
            }
        }

        int carry = 0;
        for(int k=0; k< resultList.size() ; k++) {
            int numk = resultList.get(k);

            resultList.set(k,(numk + carry) % 10);
            carry = (numk + carry) / 10;

        }

        return resultList;
    }
}
