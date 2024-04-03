package study.object.ch10.billing.step8;

import study.object.ch09.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * p372 세금 추가
 * p373 부모 상태 추가에 따른 변경은 자식의 생성자 초기화는 어쩔 수 없다
 * 다만 행동을 중복시키는 것보다 현명한 선택이다
 */
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateFee(call));
        }

        return result.plus(result.times(taxRate));
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public double getTaxRate() {
        return taxRate;
    }

    protected abstract Money calculateFee(Call call);

}
