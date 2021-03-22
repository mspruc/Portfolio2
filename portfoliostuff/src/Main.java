import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Boolean> test = new HashMap<>();
        test.put("slik",false);
        System.out.println(test.get("slik").equals(false));
        Importer dataGirl = new Importer("src/data");
    }

}
