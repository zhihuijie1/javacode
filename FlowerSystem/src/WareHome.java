public class WareHome {
    private MyLinkedList<commodity> wareHome = new MyLinkedList<>();
    // 查找商品
    public commodity findCommodity(commodity commod) {
        int len = wareHome.size();
        for (int i = 0; i < len; i++) {
            if(wareHome.get(i).equals(commod)) {
                return wareHome.get(i);
            }
        }
        return null;
    }


    // 删除商品
    public void deleteCommondity(commodity common) {
        wareHome.removeOne(common);
    }

    // 增加商品
    public void addCommondity(commodity common) {
        wareHome.addLast(common);
    }

    // 打印仓库中的所有商品
    public void printAllCommondity() {
        int len = this.wareHome.size();
        for (int i = 0; i < len; i++) {
            System.out.println(wareHome.get(i));
        }
    }

    // 查询仓库的所有信息


    @Override
    public String toString() {
        return "WareHome{" +
                "wareHome=" + wareHome +
                '}';
    }
}
