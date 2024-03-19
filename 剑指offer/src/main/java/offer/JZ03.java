package offer;

import java.util.HashMap;
import java.util.Map;

public

class JZ03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : numbers){
            if (map.containsKey(i) && map.get(i) >= 1){
                return i;
            } else {
                map.put(i, map.getOrDefault(i, 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ03 s = new JZ03();
        int[] n = new int[]{2,3,1,0,2,5,3};
        System.out.println(s.duplicate(n));
    }
}
