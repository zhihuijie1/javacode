package demo2;

public class Test {
    public static void main(String[] args) {
        SeqList seqList = new SeqList();
        seqList.add(1);
        seqList.add(2);
        seqList.add(3);
        seqList.display();
        try {
            seqList.add(1,10);
        }catch (PosWrongfulException e) {
            e.printStackTrace();
        }
        seqList.display();
        System.out.println("==========================");
        System.out.println(seqList.contains(10));
        System.out.println(seqList.contains(100));
        System.out.println(seqList.indexOf(10));
        System.out.println(seqList.indexOf(100));
        System.out.println("==========================");

        try {
            System.out.println(seqList.get(1));
        }catch (PosWrongfulException e) {
            e.printStackTrace();
        }

        seqList.set(0,99);
        seqList.display();
        System.out.println("==========================");

        seqList.remove(10);
        seqList.display();
        System.out.println("==========================");

        seqList.clear();
        seqList.display();

        seqList.add(19999);
        seqList.display();

    }
}
