import java.util.HashSet;
import java.util.Scanner;

public class Seller {
    private String sellerID ;
    private MyLinkedList<commodity> wareHome;
    private String acount; // 账户
    private String passworld; // 密码
    private String name;
    private MyLinkedList<Order> UnSignedOrderList = new MyLinkedList<>(); // 未签收的订单表
    private MyLinkedList<Order> SignedOrderList = new MyLinkedList<>(); // 消费记录 / 已签收的订单表
    private String TOTALprice; // 总收入
    private String selledCount; // 总的销售量
    HashSet<String> hashSet = new HashSet<>();
    HashSet<commodity> hashSet2 = new HashSet<>();


    // 创建一个商家的一些基本的信息
    public Seller(String sellerID,String acount, String passworld, String name) {
        this.sellerID = sellerID;
        this.acount = acount;
        this.passworld = passworld;
        this.name = name;
        while(hashSet.contains(sellerID)) {
            System.out.println("ID重复请重新输入");
            Scanner scanner = new Scanner(System.in);
            sellerID = scanner.next();
        }
        hashSet.add(sellerID);
        this.sellerID = sellerID;
    }


    // 上架商品
    public void addInWareHome(commodity commod,WareHome wareHome,CommodityCenter commodityCenter) {
        if(hashSet2.contains(commod)) {
            String count = Integer.parseInt(wareHome.findCommodity(commod).getCount()) + Integer.parseInt(commod.getCount())+"";
            commod.setCount(count);
            wareHome.deleteCommondity(commod);
            commodityCenter.delete(commod);
            wareHome.addCommondity(commod);
            commodityCenter.add(commod);
        }else {
            hashSet2.add(commod);
            wareHome.addCommondity(commod);
        }
    }


    // 查询未签收的订单
    public MyLinkedList<Order> findUnsignedOrderList() {
        return null;
    }


    // 查询销售记录（已签收的订单）
    public MyLinkedList<Order> findSignedOrderList() {
        return null;
    }


    // 显示商家的个人信息
    @Override
    public String toString() {
        return "Seller{" +
                "sellerID='" + sellerID + '\'' +
                ", acount='" + acount + '\'' +
                ", passworld='" + passworld + '\'' +
                ", name='" + name + '\'' +
                ", TOTALprice='" + TOTALprice + '\'' +
                ", selledCount='" + selledCount + '\'' +
                '}';
    }


}
