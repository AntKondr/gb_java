import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class sem5 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phones = new HashMap<>();
        String name;
        String phone;
        String name_phone;

        try (BufferedReader file = new BufferedReader(new FileReader("phone_book.data"))) {
            name_phone = file.readLine();
            while (name_phone != null) {
                String[] name_phone_arr = name_phone.split(" ");
                name = name_phone_arr[0];
                phone = name_phone_arr[1];
                if (phones.containsKey(name)) {
                    phones.get(name).add(phone2);
                }
                else {
                    phones.put(name, new ArrayList<>());
                    phones.get(name).add(phone1);
                }
                name_phone = file.readLine();
            }
        }


        String name = "Ivanov";
        String phone1 = "123456";
        String phone2 = "2345678";

        for (int i = 0; i < 2; i++) {
        }

        System.out.println(phones);
    }
}