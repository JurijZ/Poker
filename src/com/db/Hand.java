package com.db;

import java.util.*;

public class Hand {

    public String C1;
    public String C2;
    public String C3;
    public String C4;
    public String C5;

    public Hand(String c1, String c2, String c3, String c4, String c5) {
        C1 = c1;
        C2 = c2;
        C3 = c3;
        C4 = c4;
        C5 = c5;
    }

    public HashSet<Character> GetHashSetOfSuit(){
        return new HashSet<Character>(Arrays.asList(C1.charAt(1), C2.charAt(1), C3.charAt(1), C4.charAt(1), C5.charAt(1)));
    }

    public List<Character> GetListOfSuit(){
        List<Character> list = List.of(C1.charAt(1), C2.charAt(1), C3.charAt(1), C4.charAt(1), C5.charAt(1));

        return list;
    }

    public HashSet<Character> GetHashSetOfValues(){
        return new HashSet<Character>(Arrays.asList(C1.charAt(0), C2.charAt(0), C3.charAt(0), C4.charAt(0), C5.charAt(0)));
    }

    public HashSet<Integer> GetHashSetOfValuesAsIntegers(){
        return new HashSet<Integer>(GetOrderedListOfValuesAsIntegers());
    }

    public List<Character> GetOrderedListOfValues(){
        var list = new ArrayList<Character>(Arrays.asList(C1.charAt(0), C2.charAt(0), C3.charAt(0), C4.charAt(0), C5.charAt(0)));
        Collections.sort(list);

        return list;
    }

    public List<Integer> GetOrderedListOfValuesAsIntegers(){
        var list = new ArrayList<Character>(Arrays.asList(C1.charAt(0), C2.charAt(0), C3.charAt(0), C4.charAt(0), C5.charAt(0)));
        List<Integer> integerList = new ArrayList<>();

        for (Character c : list) {
            if (c == 'T'){
                integerList.add(10);
            }
            else if (c == 'J'){
                integerList.add(11);
            }
            else if (c == 'Q'){
                integerList.add(12);
            }
            else if (c == 'K'){
                integerList.add(13);
            }
            else if (c == 'A'){
                integerList.add(14);
            }
            else{
                integerList.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        Collections.sort(integerList);

        return integerList;
    }

}
