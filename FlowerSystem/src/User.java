import java.util.Scanner;

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


    // 下单操作
    public  void makeOrder(CommodityCenter commodityCenter, Order order) {
        commodityCenter.findAllCommodity(); // 查看所有的商品
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            // 用户输入商品ID
            System.out.println("请输入要选的商品 以及 要购买的商品个数");
            String commodityID = scanner.next();
            // 找到该商品
            commodity commod = this.findCommondityByCommondityID(commodityID,commodityCenter);
            while(true) {
                int commodtyCount = scanner.nextInt();
                String CommodityCount = commodtyCount+" ";  // 个数
                if(Integer.parseInt(commod.getCount()) - Integer.parseInt(CommodityCount) < 0 ) {
                    System.out.println("商品购买的数量有误，请重新输入");
                }else{
                    break;
                }
            }
            // 添加商品进入订单中
            order.purchased_by_user(commod);
            System.out.println("请输入手机号：");
            String phone = scanner.next();
            Order orderIndtation = new Order(phone); // 创建一个订单


        }
    }
    // 通过商品ID找到对应的商品
    private commodity findCommondityByCommondityID(String commondityID, CommodityCenter commodityCenter) {
        int len = commodityCenter.getCommodityMyLinkedList().size();
        for (int i = 0; i < len; i++) {
            if(Integer.parseInt(commodityCenter.getCommodityMyLinkedList().get(i).getCommodityID()) == Integer.parseInt(commondityID)) {
                return commodityCenter.getCommodityMyLinkedList().get(i);
            }
        }
        return null;
    }

    // 签收操作

    // 订单查询操作

    // 查询用户信息操作

    // 查看消费记录操作

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
