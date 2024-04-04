p384

1) 기본 정책 : 일반 요금제 , 심야 할인 요금제
2) 부가 정책 : 세금 정책, 기본 요금 할인 정책

부가 정책이 다음과 같은 특성을 가진다<br/>
① 기본 정책의 계산 결과에 부가 정책(ex 세금)이 적용된다<br/>
② 선택적으로 적용 할 수 있다<br/>
기본 정책에 부가 정책을 적용하거나, 안하거나<br/>
③ 조합 가능하다<br/>
기본 정책에 세금 정책 또는 기본 요금 할인 정책을 적용하거나, 또는 둘다 적용하거나<br/>
④ 부가 정책은 임의 순서로 적용가능하다<br/>
기본정책에 세금 정책을 적용 후 기본 요금 할인 적용하거나, 기본 요금 할인 적용 후 세금 적용하거나<br/>

---

**step2**
상속을 이용해서 기본 정책 구현하기 (p385)
예제 소스 참고. step2/TaxableRegulaPhone.java

---

**step3**
step2/TaxableRegulaPhone.java 에서 super 호출하여 부모에 대한 자식 결합도가 높아짐
이를 해결하기 위해 부모 클래스에 추상 메서드를 정의 afterCalculate(..)

부모에 추상 메서드가 추가 됨에 따라 일반 요금제와 심야 할인 요금제에서 오버라이딩을 해야 한다
자식 클래스의 수가 적다면 큰 문제가 아니겠지만, 자식 클래스의 수가 많다면 꽤나 번거로운 일이 될 수 밖에 없다

```java
@Override
protected Money afterCalculated(Money money){
        return money;
        }
```

추상 클래스에서 기본 구현을 제공하고 오버라이딩 하는 방법을 적용할 수 있다

```java
public abstract class Phone {
    // ..

    // 훅 메소드 (hook method, p390)
    // 자식 클래스에서 오버라이딩할 의도로 메서드를 추가했지만, 편의를 위해 기본 구현을 제공하는 메서드
    protected Money afterCalculated(Money fee) {
        return fee;
    }
}
```

---

**step4 중복 코드의 덫에 걸리다**
<br/>
상속을 이용한 해결 방법은 모든 가능한 조합별로 자식 클래스를 하나씩 추가하게 만든다
<br/>
① 심야 할인에도 세금을 부과할 수 있도록 TaxableNightlyDiscountPhone 추가 (NightlyDiscountPhone의 자식 클래스)
<br/>
② 일반 요금제 + 기본 요금 할인 정책 = RateDiscountableRegularPhone
<br/>
③ 심야 할인 + 기본 요금 할인 정책 = RateDiscountableNightlyDiscountPhone
<br/>
④ 일반 요금제 + 세금 정책 + 기본 요금 할인 정책 = TaxableAndRateDiscountableRegularPhone
<br/>
⑤ 일반 요금제 + 기본 요금할인정책 + 세금 정책 = RateDiscountableAndTaxableRegularPhone
<br/>
⑥ 심야 할인 + 세금 정책 + 기본 요금 할인 정책 = TaxableAndDiscountableNightlyDiscountPhone
<br/>
⑦ 심야 할인 + 기본 요금 할인 정책 + 세금 정책 = RateDiscountableAndTaxableNightlyDiscountPhone

> "클래스 폭발", "조합의 폭발" <br/>
> 상속의 남용으로 하나의 기능을 추가하기 위해 필요 이상으로 많은 수의 클래스를 추가해야 하는 경우

**클래스 폭발의 문제점** <br/>

- 자식 클래스가 부모 클래스의 구현에 강하게 결합되도록 강요 (super.* 호출)
- 컴파일 타임에 결정된 부모 - 자식 관계는 변경될 수 없기 때문에 다양한 조합이 필요한 상황에서 유일한 해결방법은 조합 수만큼 신규 클래스를 추가하는 것이다
- 문제 해결을 위해 "합성"을 사용하면 런타임에 객체 사이의 의존성을 자유롭게 변경할 수 있다

---

**step5**
p398 합성 관계로 변경하기
<br/>

- 데코레이터 패턴 활용
- RatePolicy 공통 인터페이스 구현
- 추상 클래스 : BasicRatePolicy, AdditionalRatePolicy
