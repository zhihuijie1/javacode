package demo;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

    //给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
    //
    //示例 1：
    //
    //输入：arr = [2,6,4,1]
    //
    //输出：false
    //
    //解释：不存在连续三个元素都是奇数的情况。
    //
    //示例 2：
    //
    //输入：arr = [1,2,34,3,4,5,7,23,12]
    //
    //输出：true
    //
    //解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。

    //方法二：
    public static void main10(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        boolean ret = threeConsecutiveOdds1(arr);
        System.out.println(ret);
    }
    public static boolean threeConsecutiveOdds1(int[] arr) {
        int count = 0;
        for(int i = 0;i < arr.length; i++){
            if(func4(arr[i]) == true){
                count++;
            }else{
                count = 0;
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }
    public static boolean func4(int n){
        if(n % 2 != 0){
            return true;
        }else{
            return false;
        }
    }

    //方法一：
    public static void main9(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        boolean ret = threeConsecutiveOdds(arr);
        System.out.println(ret);
    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        for(i = 0;i < arr.length - 2 ;i++ ){
            if(func(arr[i],arr[i+1],arr[i+2])){
                return true;
            }
        }
        if(i == (arr.length - 2)){
            return false;
        }
        return false;
    }
    public static boolean func(int a ,int b,int c){
        int[] arr = {a , b ,c};
        for(int i = 0;i < arr.length;i++){
            if(arr[i] % 2 == 0){
                return false;
            }else{
                arr[i] = -1;
            }
        }
        if(a == b && b == c && c == -1){
            return true;
        }
        return true;
    }


    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    public static void main8(String[] args) {
        int[] array = {2,1,2,3,2,5,2};
        int rend = 0;
        int flg = 0;
        rend = array[0];
        flg = 1;
        for(int i = 1; i < array.length; i++){
            if(rend == array[i]){
                flg++;
            }else{
                flg--;
            }
            if(flg == 0){
                rend = array[i];
                flg = 1;
            }
        }
        System.out.println(rend);

    }



    public static void main7(String[] args) {
        int[] array = {1,1,1,2,2,1,2,2,3,4,7};
        Arrays.sort(array);
        int ret = array[array.length / 2];//注意array.length / 2 为中间下标
        System.out.println(ret);
    }


    //给定一个非空整数数组，除了某个元素只出现一次以外，
    //其余每个元素均出现两次。找出那个只出现了一次的元素。

    //注意：异或操作符的小规律
    //（1）：0^a==a
    //(2) : a^a==0
    public static void main6(String[] args) {
        int[] array = {1,1,2,2,3,3,4};
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret = ret ^array[i];
        }
        System.out.println(ret);
    }


    //给定一个整数数组 nums 和一个整数目标值 target，
    // 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //
    //你可以按任意顺序返回答案。
    //
    //示例 1：
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    public static void main5(String[] args) {
        int[] nums = {2,7,11,15};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] ret = func3(nums , target);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] func3(int[] array ,int target){
        int[] ret = new int[2];
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }


    //给定一个有序整型数组, 实现二分查找
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = {10,5,4,6,10,2,8,3,4,6};
        int ret = func2(array , n);
        if(ret > 0){
            System.out.println(ret);
        }else {
            System.out.println("i don't find this number");
        }

    }
    public static int func2(int[] array , int n){
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(array[mid] > n){
                right = mid - 1;
            }else if(array[mid] < n){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1; //没有就返回一个无效值
    }


    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    //
    //如数组：[1,2,3,4,5,6]
    //
    //调整后可能是：[1, 5, 3, 4, 2, 6]
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6};
        func1(array);
        System.out.println(Arrays.toString(array));
    }
    public static void func1(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            while(array[left] % 2 != 0 && left < right){
                left++;//left 一直加加有时会数组越界所有加上left< right 条件
            }
            while(array[right] % 2 == 0 && left < right){
                right--;
            }
            int temp = 0;
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }


    //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        double avg = func(array);
        System.out.println(avg);
    }
    public static double func(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (sum * 1.0) / array.length;
    }


    //实现一个方法 transform, 以数组为参数,
    //循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
    //例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static void main1(String[] args) {
        int[] array = {1,2,3};
        transform(array);
        System.out.println(Arrays.toString(array));
    }
    public static void transform(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = 2 * arrays[i];
        }
    }
}
