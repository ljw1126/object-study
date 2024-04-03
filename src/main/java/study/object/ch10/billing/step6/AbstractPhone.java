package study.object.ch10.billing.step6;

import study.object.ch09.money.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPhone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateFee(call));
        }

        return result;
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    protected abstract Money calculateFee(Call call);

}
