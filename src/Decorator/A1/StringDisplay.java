public class StringDisplay extends Display {
    private String string;                          // 표시문자열
    public StringDisplay(String string) {           // 인수로 표시문자열을 지정
        this.string = string;
    }
    public int getColumns() {                       // 문자수
        return string.getBytes().length;
    }
    public int getRows() {                          // 줄수는 1
        return 1;
    }
    public String getRowText(int row) {             // row가 0일 때만 반환한다.
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
