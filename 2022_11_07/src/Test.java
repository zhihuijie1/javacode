public class Test {
    /**
     思路：建立一个数组用来存放字母出现的次数
     每个字母通过哈希函数就可以准确的定位到数组的下标
     最后再通过遍历一下字符串判断一下字符所对应的数组中元素是否是一然后返回其下标。
     */
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        int i = 0;
        //每个字母通过哈希函数就可以准确的定位到数组的下标
        while(i < s.length()) {
            char ret = s.charAt(i);
            array[ret - 'a']++;//元素对应的数组
            i++;
        }
        //最后再通过遍历一下字符串判断一下字符所对应的数组中元素是否是一然后返回其下标。
        int j = 0;
        while(j < s.length()) {
            char ret = s.charAt(j);
            if(array[ret - 'a'] == 1) {
                return j;
            }
            j++;
        }
        return -1;
    }
}
