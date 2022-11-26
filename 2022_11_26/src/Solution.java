import java.util.*;
public class Solution {
    public int StrToInt(String str) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Character> hashSet2 = new HashSet<>();
        int nuber = 0;
        for(int i = 0; i < 10; i++) {
            hashSet.add(i);
        }
        hashSet2.add('+');
        hashSet2.add('-');
        hashSet2.add('/');
        for(int i = 0; i < str.length(); i++) {
            if(hashSet.contains((int)str.charAt(i))) {
                nuber = nuber * 10 + (int)str.charAt(i);
            }else if(!hashSet2.contains(str.charAt(i))) {
                return 0;
            }
        }
        return nuber;
    }


}