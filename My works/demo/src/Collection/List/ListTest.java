package Collection.List;

import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> names = List.of("Anu","","Malu","Jithu","Melbi","","Anu");
        System.out.println(names);
        System.out.println(names.get(0));
        System.out.println(names.indexOf("Anu"));

    }
}
