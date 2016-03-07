public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();
    private UrgentState() {                                // 생성자는 private
    }
    public static State getInstance() {                 // 유일한 하나의 인스턴스를 얻는다.
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 시각설정
        // 시각 설정으로는 아무것도 처리하지 않는다.     
    }                                                                   
    public void doUse(Context context) {                // 금고사용
        context.callSecurityCenter("비상:비상시의 금고사용");
    }
    public void doAlarm(Context context) {              // 비상벨
        context.callSecurityCenter("비상벨(비상시)");
    }
    public void doPhone(Context context) {              // 일반 통화
        context.callSecurityCenter("일반 통화(비상시)");
    }
    public String toString() {                          // 문자열 표현
        return "[비상시]";
    }
}
