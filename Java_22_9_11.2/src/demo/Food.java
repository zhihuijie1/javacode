public class Food {

}
class Fruit extends Food{

}
class Apple extends Fruit{

}
class Banana extends Fruit{
}


class Message<T extends Food>{
    private T value;


    public void setName(T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }
}



class Test{
    public static void main(String[] args) {
        //创建对象

        Message<Fruit> fruit1 = new Message<>();
        Message<Food> food = new Message<>();
        Message<Banana> banana = new Message<Banana>();
        Message<Apple> apple = new Message<Apple>();
        //调用set方法

        food.setName(new Food());
        fruit1.setName(new Fruit());
        banana.setName(new Banana());
        apple.setName(new Apple());
        //调用show方法

        //Test.shows(banana);  // error
        //Test.shows(apple);   // erorr
        Test.shows(fruit1);
        Test.shows(food);
    }
    public static void shows(Message<? super Fruit> ret){
        //ret.setName(new Food()); //会发生向下转型
        System.out.println(ret.getValue());
        //Fruit 的子类和 Fruit本身 是可以设置属性值的
        ret.setName(new Apple());
        ret.setName(new Fruit());

    }
    }
