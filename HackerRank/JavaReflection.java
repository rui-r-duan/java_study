import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student {
    public void add(int ... args) {
        int s = 0;
        String separator = "";
        for (int i : args) {
            System.out.print(separator + i);
            s += i;
            separator = "+";
        }
        System.out.println("=" + s);
    }
    protected int protectedMethod(int a) {
        return a;
    }
    private double privateGetScore() {
        return Math.PI * 20;
    }
}

public class JavaReflection {

    public static void main(String[] args){
        Class student = new Student().getClass();
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m : methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
