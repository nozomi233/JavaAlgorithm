package offer;

import java.util.*;

public class JZ21 {
    public int[] reOrderArray (int[] array) {
        // write code here
        List<Integer> list = new LinkedList<>();
        int oddIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                list.add(array[i]);
            } else {
                list.add(oddIndex++, array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)list.toArray()[i];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4};
        JZ21 j = new JZ21();
        System.out.println(Arrays.toString(j.reOrderArray(in)));
    }
}
