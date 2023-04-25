import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
class ArrayListUtilization {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>(3);
        myList.add(3);
        myList.add(2);
        myList.add(1);

        System.out.println(myList);
    }*/


    class ArrayListExample 
    {
        public static void main(String[] args) 
        {
            ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
             
            ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
             
            Collections.sort(listOne);
            Collections.sort(listTwo);
             
            //Compare unequal lists example
             
            boolean isEqual = listOne.equals(listTwo);      //false
            System.out.println(isEqual);
             
            //Compare equals lists example
             
            ArrayList<String> listThree = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
             
            isEqual = listOne.equals(listThree);      //true
            System.out.println(isEqual);
        }
    }