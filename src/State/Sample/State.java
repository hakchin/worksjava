public interface State {
    public abstract void doClock(Context context, int hour);    // 시각설정
    public abstract void doUse(Context context);                // 금고사용
    public abstract void doAlarm(Context context);              // 비상벨
    public abstract void doPhone(Context context);              // 일반통화
}
