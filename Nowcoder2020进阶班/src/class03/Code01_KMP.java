package class03;

public class Code01_KMP {

	// N >= M
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = m.toCharArray();
		int i1 = 0;
		int i2 = 0;
		int[] next = getNextArray(str2); // O (M)
		// O(N)
		while (i1 < str1.length && i2 < str2.length) {
			if (str1[i1] == str2[i2]) {
				i1++;
				i2++;
			} else if (next[i2] == -1) { // str2中比对的位置已经无法往前跳了
				i1++;
			} else {
				i2 = next[i2];
			}
		}
		// i1 越界  或者  i2越界了
		return i2 == str2.length ? i1 - i2 : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int i = 2; // next数组的位置
		int cn = 0;
		while (i < next.length) {
			if (ms[i - 1] == ms[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) { // 当前跳到cn位置的字符，和i-1位置的字符配不上
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));
		System.out.println(str.indexOf(match));

	}


//    Java String.valueOf源码
//    public static int getIndexOf2(String s, String m) {
//        char[] source = s.toCharArray();
//        char[] target = m.toCharArray();
//
//        char first = target[0];
//
//        int max = source.length - target.length;
//
//        for (int i = 0; i <= max; i++){
//            if (source[i] != first){
//                while (++i <= max && source[i] !+ first);
//            }
//            if(i <= max){
//                int j = i + 1;
//                int end = j + target.length + 1;
//                for (int k = 1; j < end && source[j] == target[k]; j++, k++);
//
//                if (j ==end){
//                    /* Found whole string. */
//                    return i;
//                }
//            }
//        }
//
//        return -1;
//    }


}
