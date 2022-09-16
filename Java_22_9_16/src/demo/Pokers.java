package demo;

import java.util.ArrayList;
import java.util.Random;

public class Pokers {

    public static final String[] SUITS = {"♥","♦","♣","♠"};

    public ArrayList<Poker> func (){

        //创建一个纸盒
        ArrayList<Poker> arrayList = new ArrayList<>();
        //一共有四个花色，每个花色13张牌
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                arrayList.add(new Poker(SUITS[i],j ));
                //在这个地方花色要随着I的不同而改变。所以设立一个数组
            }
        }
        return arrayList;
    }
    public void shuffle(ArrayList<Poker>arrayList){
        Random random = new Random();
        for(int i = arrayList.size()-1; i > 0; i--){
            int ret = random.nextInt(i);
            //交换
            swap(arrayList , ret , i);
        }
    }

    public static void swap(ArrayList<Poker> arrayList, int ret,int i){
        Poker temp = arrayList.get(ret);
        arrayList.set(ret,arrayList.get(i));
        arrayList.set(i,temp);
    }



    public static void main(String[] args) {
        Pokers pokers = new Pokers();
        //建立一个纸盒
        ArrayList<Poker> arrayList = pokers.func();
        System.out.println(arrayList);
        //开始洗牌
        pokers.shuffle(arrayList);
        System.out.println(arrayList);
        //开始揭牌
        //3个人每个人抽5张牌
        ArrayList<Poker> hand1 = new ArrayList<>();
        ArrayList<Poker> hand2 = new ArrayList<>();
        ArrayList<Poker> hand3 = new ArrayList<>();
        ArrayList<ArrayList<Poker>> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(i,arrayList.get(0));
                arrayList.remove(0);
            }
        }
        for (int i = 0; i < hands.size(); i++) {
            System.out.println(hands.get(i));
            System.out.println();
        }
        System.out.println("剩余牌的数目");

        System.out.println(arrayList);



    }

}
