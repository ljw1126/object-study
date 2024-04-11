package study.object.ch10.instrumented;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    @Override
    public boolean add(E e) {
        addCount += 1;
        return super.add(e);
    }

    /*
        문제) super.addAll(..) 호출시 내부에서 add(..) 호출해서 중복 카운팅
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

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        InstrumentedHashSet<?> that = (InstrumentedHashSet<?>) other;
        return addCount == that.addCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addCount);
    }
}
