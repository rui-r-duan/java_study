class Value{
    static int c=0;
    Value(){
        c=15;
    }
    Value(int i){
        c=i;
    }
    static void inc(){
        c++;
    }
}
class StaticTest{
    public static void prt(String s){
        System.out.println(s);
    }
    Value v=new Value(10);
    static Value v1,v2;
    static{
        prt("v1.c="+v1.c+"  v2.c="+v2.c);
        v1=new Value(27);
        prt("v1.c="+v1.c+"  v2.c="+v2.c);
        v2=new Value(15);
        prt("v1.c="+v1.c+"  v2.c="+v2.c);
    }

    public static void main(String[] args){
        StaticTest ct=new StaticTest();
        prt("ct.c="+ct.v.c);
        prt("v1.c="+v1.c+"  v2.c="+v2.c);
        v1.inc();
        prt("v1.c="+v1.c+"  v2.c="+v2.c);
        prt("ct.c="+ct.v.c);
    }
}
