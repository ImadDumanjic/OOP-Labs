package LabWeek6;
import java.util.HashMap;

public class Task9{
    public static void main(String[] args){
        HashMap <String, String> nicknames = new HashMap<>();

        nicknames.put("matti", "mage");
        nicknames.put("mikael", "mixu");
        nicknames.put("arto", "arppa");

        System.out.print(nicknames.get("mikael"));
    }
}
