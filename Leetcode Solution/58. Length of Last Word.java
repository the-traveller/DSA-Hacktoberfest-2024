/**
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 *
 */

import java.util.StringTokenizer;
class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        String str="";
        if(s==null||s.length()==0)
            return 0;
        StringTokenizer st=new StringTokenizer(s);
        int count=st.countTokens();
        for(int i=0;i<count-1;i++)
            str=st.nextToken();
        str=st.nextToken();
        return (int)(str.length());

    }
}