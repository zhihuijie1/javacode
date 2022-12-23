import java.util.HashSet;
import java.util.Scanner;

public class commodity {
    private String name;
    private String commodityID;
    private String price;
    private String count; // 商品的数量
    private String likeCount; // 商品的点赞数
    HashSet<String> hashSet = new HashSet<>();


    public commodity() {
        this.likeCount = "0";
        this.price = "0";
    }


    // 构造一个商品
    public commodity(String name, String commodityID, String price, String count, String likeCount) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.likeCount = likeCount;
        while(hashSet.contains(commodityID)) {
            System.out.println("ID重复请重新输入");
            Scanner scanner = new Scanner(System.in);
            commodityID = scanner.next();
        }
        hashSet.add(commodityID);
        this.commodityID = commodityID;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof commodity)) {
            return false;
        }
        commodity P = (commodity)obj;
        if(P.getName().equals(this.getName())) {
            return true;
        }else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "commodity{" +
                "name='" + name + '\'' +
                ", commodityID=" + commodityID +
                ", price='" + price + '\'' +
                ", count=" + count +
                ", likeCount='" + likeCount + '\'' +
                '}';
    }

    // 设置商品ID
    public void setCommodityID(String commodityID) {
        while(hashSet.contains(commodityID)) {
            System.out.println("ID重复请重新输入");
            Scanner scanner = new Scanner(System.in);
            commodityID = scanner.next();
        }
        hashSet.add(commodityID);
        this.commodityID = commodityID;
    }


    public String getName() {
        return name;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public String getPrice() {
        return price;
    }

    public String getCount() {
        return count;
    }

    public String getLikeCount() {
        return likeCount;
    }


    public void setName(String name) {
        this.name = name;
    }



    public void setPrice(String price) {
        this.price = price;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }
}
