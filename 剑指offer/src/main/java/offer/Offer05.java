package offer;

/**
 * @Author zhulang
 * @Date 2023-03-04
 **/
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder ss = new StringBuilder();
        for(Character c :s.toCharArray()){
            if(c == ' '){
                ss.append("%20");
            }else {
                ss.append(c);
            }
        }
        return ss.toString();
    }
}
