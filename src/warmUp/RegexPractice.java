package warmUp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
	public static void main(String[] args) {
		//Pattern p = Pattern.compile("\\p{Alpha}+ \\p{Alpha}+");
		Pattern p = Pattern.compile("(\\b\\w+\\b)( \\b\\1\\b)+");
		//String str = "ababab";
		String str = "<aaa aaa bbb bbb ccc aaa ccc ccc ccc";
		//System.out.println(Pattern.matches("aaa", str));
		Matcher m = p.matcher(str);
		//System.out.println(m.lookingAt());
		//System.out.println(m.find());
		System.out.println(p.toString());
		//str = m.replaceAll("haha");
		//while (m.lookingAt()) {
		while (m.find()) {
			System.out.println(str);
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			//System.out.println(m.end());
			System.out.println();
			str = str.replaceAll(m.group(0), m.group(1));
			//str = m.replaceAll(m.group(1));
		}
		System.out.println(str);
	}
}
