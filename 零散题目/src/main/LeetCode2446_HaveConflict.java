package main;

/**
 * @Author zhulang
 * @Date 2023-05-17
 **/
public class LeetCode2446_HaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
