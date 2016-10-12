package JunitPrac;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Shiyi on 9/28/2016.
 */
public class TestJunit {
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
}
