public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();           // 이 필드에 문서를 구축한다.
    public void buildTitle(String title) {                       // 일반 텍스트에서의 타이틀
     	buffer.append("==============================\n");          // 장식선
        buffer.append("『" + title + "』\n");                       // 『』가 붙은 타이틀
        buffer.append("\n");                                        // 공란        
    }
    public void buildString(String str) {                        // 일반 텍스트에서의 문자열
        buffer.append('■' + str + "\n");                           // ■이 붙은 문자열
        buffer.append("\n"); 
    }
    public void buildItems(String[] items) {                     // 일반 텍스트에서의 항목
        for (int i = 0; i < items.length; i++) {            
            buffer.append("●" + items[i] + "\n");                // ●이 붙은 항목
        }
        buffer.append("\n");                                        // 공란
    }
    public Object buildResult() {                                 // 완성된 문서
        buffer.append("==============================\n");          // 장식선
        return buffer.toString();                                   // StringBuffer를 String으로 변환
    }
}
