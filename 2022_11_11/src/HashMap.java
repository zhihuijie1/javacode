import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
public class HashMap {
    public static void build() {
        java.util.HashMap<String,Integer> hashMap = new java.util.HashMap<>();
        hashMap.put("小白" , 21);
        hashMap.put("小红", 18);
        hashMap.put("小岩", 20);
        hashMap.put("小", 20);
        System.out.println(hashMap);
        for (String key:hashMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        for (Integer ret :hashMap.values()) {
            System.out.print(ret + " ");
        }
        System.out.println();
        for (Map.Entry<String,Integer> ret : hashMap.entrySet()) {
            System.out.print(ret.getKey() + "->" + ret.getValue() + " ");
        }
    }
    public static void buildSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("xiaohong");
        hashSet.add("xiaobai");
        hashSet.add("dabai");
        Iterator<String> it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

    }
    public static void main(String[] args) {
        buildSet();
    }
}
