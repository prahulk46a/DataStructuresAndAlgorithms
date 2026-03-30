package collections;

import java.util.*;

public class HashMapExample {
    //String.valueOf(t) where is t type ds, is used to convert a t to a String.
    public static void main(String[] args) {
        String str="Hello This is Hashmap example";
        //Map<String, Integer> map = new HashMap<>();
        //Map<String,Integer> map=new LinkedHashMap<>(); //Maintains order of occurrence in string
        TreeMap<String,Integer> map=new TreeMap<>(); //Sorted Order maintain
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(String.valueOf(str.charAt(i)))) {
                map.put(String.valueOf(str.charAt(i)),
                        map.get(String.valueOf(str.charAt(i))) + 1);
            } else {
                map.put(String.valueOf(str.charAt(i)), 1);
            }
        }
        System.out.println(map);

//        // EntrySet => It is similar to for each loop for objects in an array.
//        for(Map.Entry<String,Integer> entry:map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

    }

}
