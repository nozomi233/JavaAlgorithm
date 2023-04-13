package class01.copy;

/**
 * @Author zhulang
 * @Date 2023-04-07
 **/
public class EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr){
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr){
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int cur : arr){
            if ((cur & rightOne) != 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
