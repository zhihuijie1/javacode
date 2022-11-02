public class Test {
    public static void main(String[] args) {
        BanarySearch banarySearch = new BanarySearch();
        int[] array = new int[]{5,3,4,1,7,8,2,6,0,9};
        for(int i = 0; i < array.length; i++) {
            banarySearch.insert(array[i]);
        }
    }
}
