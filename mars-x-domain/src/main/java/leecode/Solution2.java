package leecode;

/**
 * @author: sj.hu
 * @date: 2020/3/12 16:22
 **/
public class Solution2 {

    public static void main(String[] args) {

        String str1 = "cancel";
        String str2 = "cancellation";
        System.out.println(wordDistance_1(str1, str2));
    }

    public static int wordDistance(String str1, String str2) {
        if(str1.equals(str2)) return 0;

        if(str1.length() == 0) return str2.length();
        else if(str2.length() == 0) return str1.length();

        int d = 0;
        if(str1.charAt(str1.length()-1) != str2.charAt(str2.length()-1))
            d=1;

        return Math.min(Math.min(
                wordDistance(str1.substring(0, str1.length()-1), str2) + 1,
                wordDistance(str1, str2.substring(0, str2.length()-1)) + 1),
                wordDistance(str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1)) + d);
    }

    public static int wordDistance_1(String str1, String str2) {
        int[][] matrix = new int[str1.length()+1][str2.length()+1];

        for(int i=1; i<str1.length()+1; i++) {
            for(int j=1; j<str2.length()+1; j++) {
                int d = 0;
                if(str1.charAt(i-1) != str2.charAt(j-1)) {
                    d = 1;
                }
                matrix[i][j] = Math.min(Math.min(
                        matrix[i-1][j] + 1,
                        matrix[i][j-1] + 1),
                        matrix[i-1][j-1] + d
                );
            }
        }
        return matrix[str1.length()][str2.length()];
    }

}
