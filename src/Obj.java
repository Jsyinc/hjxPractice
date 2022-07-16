import java.util.Comparator;

public class Obj implements Comparator {
    int a, b;

    Obj() {
    }

    Obj(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
