package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyStringBuilderVer1 implements MyStringBuilder {
    private MyArrayListVer1<Character> arrList;
    public MyStringBuilderVer1() {
        arrList = new MyArrayListVer1<>(Character.class);
    }
    @Override
    public void append(String str) {
        for(int i=0;i<str.length();i++)
            arrList.add(str.charAt(i));
    }
    public String toString() {
        String str = "";
        for(int i=0;i<arrList.size();i++)
            str+=arrList.get(i);
        return str;
    }
}
