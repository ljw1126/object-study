package study.object.ch11.properties;

import java.util.Hashtable;

/**
 * 상속 대신 합성을 사용
 * - 내부 구현에 밀접하게 결합되는 상속과 달리 합성으로 변경한 Properties는
 * hashtable의 내부 구현에 관해 알지 못한다. 단지 get(..), set(..) 오퍼레이션이 포함된
 * 퍼블릭 인터페이스를 통해서 Hashtable과 협력할 수 있다
 */
public class Properties {
    private Hashtable<String, String> properties = new Hashtable<>();

    public String setProperty(String key, String value) {
        return properties.put(key, value); // key에 해당하는 값이 있으면 old를 리턴
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

}
