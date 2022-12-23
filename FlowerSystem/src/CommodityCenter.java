/**
 * 商品中心
 */
public class CommodityCenter {

    MyLinkedList<commodity> commodityMyLinkedList = new MyLinkedList<>();


    // 添加商品操作
    public void add(commodity commod) {
        this.commodityMyLinkedList.addLast(commod);
    }
    // 删除商品操作
    public void delete(commodity commod) {
        String commodID = commod.getCommodityID();
        int size = commodityMyLinkedList.size();
        for (int i = 0; i < size; i++) {
            if(commodID.equals(commodityMyLinkedList.get(i).getCommodityID())) {
                commodityMyLinkedList.removeOne(commod);
            }
        }
    }


    // 查询商品操作
    public commodity findCommodity(commodity commod) {
        int len = commodityMyLinkedList.size();
        for (int i = 0; i < len; i++) {
            if(commodityMyLinkedList.get(i).getCommodityID().equals(commod)) {
                return this.commodityMyLinkedList.get(i);
            }
        }
        return null;
    }

    // 查看所有商品操作
    // （商城）
    public void findAllCommodity() {
        int len = commodityMyLinkedList.size();
        for (int i = 0; i < len; i++) {
            System.out.println(commodityMyLinkedList.get(i).toString());
        }
    }


    public MyLinkedList<commodity> getCommodityMyLinkedList() {
        return commodityMyLinkedList;
    }


    public void setCommodityMyLinkedList(MyLinkedList<commodity> commodityMyLinkedList) {
        this.commodityMyLinkedList = commodityMyLinkedList;
    }
}
