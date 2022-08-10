package demo1;

public class Test3 {
    private int a;
    private int b;
    private double c;
    private double d;
    private double e;
    public Test3(int a, int b){
        this.a = a;
        this.b = b;
        //this.max1(this.a , this.b);
    }

    public Test3(double c,double d,double e){
        this.c = c;
        this.d = d;
        this.e = e;
        //this.max2(this.c , this.d ,this.e);
    }
    public int max1(int a,int b){
        return a>b? a : b;
    }
    public double max2(double c,double d,double e){
        return (c > d? c : d)>e? (c > d? c : d) : e;
    }

}
