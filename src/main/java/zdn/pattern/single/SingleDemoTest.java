package zdn.pattern.single;

import java.util.HashSet;
import java.util.Set;

public class SingleDemoTest {

    public static void main(String[] args) {
        Set<SingleDemo> singleDemos = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            SingleDemo instance = SingleDemo.getInstance();
            singleDemos.add(instance);
        }
        System.out.println(singleDemos.size());
    }
}
