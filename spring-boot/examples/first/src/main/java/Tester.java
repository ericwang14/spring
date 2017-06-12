/**
 * Created by wanggang on 11/24/16.
 */
public class Tester {

    public static void main(String[] args) {
        double high = 100d, s = 100d,  t = 0d;

        for (int i = 1; i < 10; i++) {
            s = s + t;
            high = high / 2;
            t = high * 2;
        }

        System.out.println("10次总过经历:  " + s);
        System.out.println("第10次的反弹高度: " + high);
    }
}
