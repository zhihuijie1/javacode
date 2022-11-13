public class Tesr {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        //遍历一遍words数组，记录每个单词出现的次数。
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                int value = map.get(words[i]) + 1;
                map.put(words[i],value);
            }else {
                map.put(words[i],1);
            }
        }
        //操作完之后，map中就知道每个单词出现的次数了
        //建堆的比较器
        PriorityQueue<Map.Entry<String,Integer>> minHeap =
                new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue() == o2.getValue()) {
                            //将字母大的放在前面
                            //可以认为o1是小的，o2是大的
                            return o2.getKey().compareTo(o1.getKey());//大的放在前面
                        }
                        return o1.getValue().compareTo(o2.getValue()); //小的放在前面
                    }
                });
        //建立小根堆
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            /**
             * 这个地方不可以一直加，然后就能顺其自然的得到TOP-k，
             * 因为当一直加对的容量大于K时就会自动扩容
             * 所以要加条件判断，当对的容量大于K的时候，要单独与堆顶元素进行比较
             */
            if(minHeap.size() < k) {
                /**
                 * 这个地方是先判断再放进去 编程中大部分都是这样，
                 *  K = 0的时候操作一次，K = 1的时候操作一次，k = 2的时候操作一次
                 */
                minHeap.offer(entry);
            }else {
                if(entry.getValue().compareTo(minHeap.peek().getValue()) > 0) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }else if(entry.getValue() == minHeap.peek().getValue()) {
                    if(entry.getKey().compareTo(minHeap.peek().getKey())< 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(minHeap.poll().getKey());
        }
        Collections.reverse(list);//反转
        return list;
    }
}