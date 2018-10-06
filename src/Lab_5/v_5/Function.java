package Lab_5.v_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Function {
    Pattern pattern = Pattern.compile("/([-.0-9]+)");
    void solve(int x) throws Exception;
}
