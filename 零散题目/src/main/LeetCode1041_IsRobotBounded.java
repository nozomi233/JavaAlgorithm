package main;

/**
 * @Author zhulang
 * @Date 2023-04-11
 **/
public class LeetCode1041_IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int[][] direc = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int n = instructions.length();
        int direction = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            if (instructions.charAt(i) == 'G'){
                x += direc[direction][0];
                y += direc[direction][1];
            } else if (instructions.charAt(i) == 'L'){
                direction += 3;
                direction %= 4;
            } else {
                direction += 1;
                direction %= 4;
            }
        }

        return (x == 0 && y == 0) || direction != 0;
    }
}
