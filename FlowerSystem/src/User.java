public class User {
    private String name;
    private String phone;
    private String acount; // 账户
    private String passworld; // 密码
    private String price; //钱

    private MyLinkedList<Order> UnSignedOrderList = new MyLinkedList<>(); // 未签收的订单表
    private MyLinkedList<Order> SignedOrderList = new MyLinkedList<>(); // 消费记录 / 已签收的订单表

    // 充值操作
    public String recharge(int priceValue) {
        setPrice(Integer.parseInt(price) + priceValue + " ");
        return price;
    }
    // 查看所有商品操作
    public void findAllCommodity(MyLinkedList<commodity> LinkedCommodity) {
        int len = LinkedCommodity.size();
        for (int i = 0; i < len; i++) {
            System.out.println(LinkedCommodity.get(i).toString());
        }
    }

    // 下单操作
    public  void makeOrder() {

    }

    // 签收操作


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAcount() {
        return acount;
    }

    public String getPassworld() {
        return passworld;
    }

    public String getPrice() {
        return price;
    }

    public MyLinkedList<Order> getUnSignedOrderList() {
        return UnSignedOrderList;
    }

    public MyLinkedList<Order> getSignedOrderList() {
        return SignedOrderList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUnSignedOrderList(MyLinkedList<Order> unSignedOrderList) {
        UnSignedOrderList = unSignedOrderList;
    }

    public void setSignedOrderList(MyLinkedList<Order> signedOrderList) {
        SignedOrderList = signedOrderList;
    }
}
