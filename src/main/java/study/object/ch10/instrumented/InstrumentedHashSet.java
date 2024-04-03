package study.object.ch10.instrumented;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    @Override
    public boolean add(E e) {
        addCount += 1;
        return super.add(e);
    }

    /*
        문제) super.addAll(..) 호출시 내부에서 add(..) 호출해서 중복 카운팅
        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }
    */

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;

        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }

        return modified;
    }
}
