package com.campusdual.classroom;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Exercise27 {
    public static void main(String[] args) throws FileNotFoundException {
        createShoppinglistXml();
        createShoppinglistJson();
    }

    public static Map<String, Integer> createShoppingMap(){
        Map<String, Integer> shoppinglist = new HashMap<>();
        shoppinglist.put("Manzana", 2);
        shoppinglist.put("Leche", 1);
        shoppinglist.put("Pan", 3);
        shoppinglist.put("Huevo", 2);
        shoppinglist.put("Queso", 1);
        shoppinglist.put("Cereal", 1);
        shoppinglist.put("Agua", 4);
        shoppinglist.put("Yogur", 6);
        shoppinglist.put("Arroz", 2);

        return shoppinglist;
    }

    public static void createShoppinglistXml() throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(new File("src/main/resources/shoppingList.xml"))){
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            pw.println("<shoppinglist>");
            pw.println("<items>");
            for (Map.Entry<String, Integer> entry : createShoppingMap().entrySet()){
                pw.println("<item quantity=\"" + entry.getValue() + "\">");
                pw.println(entry.getKey());
                pw.println("</item>");
            }
            pw.println("</items>");
            pw.println("</shoppinglist>");
        }
    }

    public static void createShoppinglistJson() throws FileNotFoundException {
        Map<String, Integer> shoppingMap = createShoppingMap();
        try(PrintWriter pw = new PrintWriter(new File("src/main/resources/shoppingList.json"))) {
            pw.println("{");
            pw.print("\n\"items\": [");
            for(Map.Entry<String, Integer> entry : shoppingMap.entrySet()){
                pw.print("{\"quantity\": " + entry.getValue() + ",\n\"text\": \"" + entry.getKey() + "\"},");
            }
            pw.print("]");
            pw.println("}");
        }

    }
}
