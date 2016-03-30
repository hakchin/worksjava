public interface Context {

    public abstract void setClock(int hour);                // 시각의 설정
    public abstract void changeState(State state);          // 상태변화
    public abstract void callSecurityCenter(String msg);    // 경비센터 호출
    public abstract void recordLog(String msg);             // 경비센터 기록
}
