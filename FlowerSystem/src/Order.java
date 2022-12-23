
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Order {
    private String orderID; // 订单号
    private String sellerID; // 商家号
    private String satte; // 订单的状态
    private MyLinkedList<commodity> commodity_menu; // 用户购买的商品
    private String BothPrice; // 订单上所有物品的花费金额


    public Order() {
        this.satte = "未发货";
        this. BothPrice = "0";
    }


    // 用构造方法来创建订单
    public Order(String phone) {
        this.orderID = this.createOrderId(phone);
    }

    // 创建订单号
    /**
     * 创建的方法：顾客的手机号 + 加时间 -》精确到毫秒
     */
    public String createOrderId(String phone) {
        Date date = new Date(System.currentTimeMillis());  //给定一个毫秒时间值来创建一个Date对象
        DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_DD hh:FF:SS"); // 时间格式话成的格式是 YYYY_MM_DD hh:FF:SS
        String timeFormat = dateFormat.format(date); // 对Date中的毫秒级时间进行格式化
        String timePeriod = timeFormat.substring(14,16) + timeFormat.substring(17,19); // substring(beginIndex, endIndex)方法是获取子字符串，注意下标是左闭右开
        String orderSTring = phone + timePeriod;
        return orderSTring;
    }


    // 修改订单状态
    public Boolean Modify_status(String status) {
        this.satte = status;
        return true;
    }


    // 添加用户购买的商品
    public void purchased_by_user(commodity comdy) {
        this.commodity_menu.addLast(comdy);
    }


    // 计算总花费
    public String total_cost(MyLinkedList<commodity> commodityLinkedList) {
        int size = commodityLinkedList.size();
        int money = 0;
        for (int i = 0; i < size; i++) {
            money += Integer.parseInt(commodityLinkedList.get(i).getPrice());
        }
        return money+"";
    }


    public String getOrderID() {
        return orderID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public String getSatte() {
        return satte;
    }

    public MyLinkedList<commodity> getCommodity_menu() {
        return commodity_menu;
    }

    public String getBothPrice() {
        return BothPrice;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public void setSatte(String satte) {
        this.satte = satte;
    }

    public void setCommodity_menu(MyLinkedList<commodity> commodity_menu) {
        this.commodity_menu = commodity_menu;
    }

    public void setBothPrice(String bothPrice) {
        BothPrice = bothPrice;
    }
}
