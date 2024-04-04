package study.object.ch11.stack;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * 합성 사용
 * Stack 의 퍼블릭 인터페이스에는 불필욯나 Vector의 오퍼레이션(메소드)가 포함되지 않는다
 * 클라이언트는 더 이상 임의 위치에 요소를 추가하거나 삭제할 수 없다
 * 따라서 마지막 위치에서만 요소를 추가하거나 삭제할 수 있는 Stack의 규칙을 어길 수 없게 된다
 */
public class Stack<E> {
    private Vector<E> elements = new Vector<>();

    public E push(E item) {
        elements.addElement(item);
        return item;
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.remove(elements.size() - 1);
    }
}
