public class commodity {
    private String name;
    private String commodityID;
    private String price;
    private String count; // 商品的数量
    private String likeCount; // 商品的点赞数

    public commodity(String name, String commodityID, String price, String count, String likeCount) {
        this.name = name;
        this.commodityID = commodityID;
        this.price = price;
        this.count = count;
        this.likeCount = likeCount;
    }

    public commodity() {
        this.likeCount = "0";
        this.price = "0";
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

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
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
