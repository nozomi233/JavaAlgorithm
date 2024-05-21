package main.testcode;

// 唯品会
public class VipSolution {

    public void bobSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length -1; i >= 0; i--) {
            // 比较大小，交换
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,9,2};
        VipSolution s = new VipSolution();
        s.bobSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }
}
