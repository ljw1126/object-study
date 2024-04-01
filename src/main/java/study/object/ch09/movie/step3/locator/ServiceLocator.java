package study.object.ch09.movie.step3.locator;

import study.object.ch09.movie.step3.DiscountPolicy;

/**
 * 숨겨진 의존성은 나쁘다 p326
 * 캡슐화는 코드를 읽고 이해하는 행위와 관련이 있다. 클래스의 퍼블릭 인터페이스만으로 사용방법을 이해할 수 잇는 코드가 캡슐화 관점에서
 * 훌륭햔 코드다.
 * 클래스의 사용법을 익히기 위해 구현 내부를 샅샅이 뒤져야 한다면 그 클래스의 캡슐화는 무너진 것이다.
 * 숨겨진 의존성이 가지는 가장 큰 문제점은 의존성을 이해하기 위해 코드의 내부 구현을 이해할 것을 강요한다는 것이다.
 * 따라서 숨겨진 의존성은 캡슐화를 위반한다.
 */
public class ServiceLocator {
    private static ServiceLocator instance = new ServiceLocator();
    private DiscountPolicy discountPolicy;

    private ServiceLocator() {
    }

    public static DiscountPolicy discountPolicy() {
        return instance.discountPolicy;
    }

    public static void provide(DiscountPolicy discountPolicy) {
        instance.discountPolicy = discountPolicy;
    }
}
