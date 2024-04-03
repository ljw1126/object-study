package study.object.ch10.instrumented;

import java.util.Properties;
import java.util.Stack;

/**
 * 불필요한 인터페이스 상속의 문제점
 * - 자식 클래스의 규칙을 깨버림
 */
public class TestApplication {
    public static void main(String[] args) {
        properties(); // Hashtable - Properties

        stack(); // Vector - Stack


    }

    private static void properties() {
        Properties properties = new Properties(); // key : value
        properties.setProperty("Bjarne", "C++");
        properties.setProperty("James", "Java");

        properties.put("Dennis", 99); // 상속으로한 Properties의 규칙을 깨뜨림 (String만 가능한데)

        System.out.println(properties.getProperty("Dennis")); // getProperty 호출시 String 값이 아니면 null을 반환하도록 되어있음, 데이터 정합성 깨지네
    }

    private static void stack() {
        Stack<String> stack = new Stack<>();
        stack.push("1st");
        stack.push("2st");
        stack.push("3st");

        stack.add(0, "4th"); // * 데이터 정합성 깨질 수 있다

        System.out.println(stack.pop()); // 3st
    }
}
