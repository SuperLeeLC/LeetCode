/**
 * @author : lichao
 * @date : 2020/6/26 9:26 下午
 */

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        int i = new Solution().lengthOfLongestSubstring(s);

        System.out.println(i);
    }

}
