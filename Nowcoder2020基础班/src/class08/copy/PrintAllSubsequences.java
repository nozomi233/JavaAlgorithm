package class08.copy;

/**
 * @Author zhulang
 * @Date 2023-04-24
 **/
public class PrintAllSubsequences {
    public static void main(String[] args) {
        String s = "cba";
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j <= s.length(); j++){
                System.out.println(s.substring(i, j));
            }
        }
    }
}
