package Lab_5.v_5.Comparators;

import java.lang.reflect.Field;
import java.util.Comparator;

public class SortByB<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        Field field = null;
        try {
            field = o1.getClass().getDeclaredField("b");
            field.setAccessible(true);
            Double a = (Double)field.get(o1);
            return a.compareTo((Double)field.get(o2));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
