package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        switch (args[0]) {
            case "-u": {
                int id = Integer.parseInt(args[1]);

                String name = "";
                for (int i = 2; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                Product product = new Product(id, name.trim(), price, quantity);

                boolean is = false;

                for (Product p : products)
                    if (p.id == product.id) {
                        p.price = product.price;
                        p.name = product.name;
                        p.quantity = product.quantity;
                        is = true;
                        break;
                    }

                if (false == is)
                    try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                        fileWriter.write("\n");
                        fileWriter.write(product.toString());
                    }
                else {
                    try (FileWriter fileWriter = new FileWriter(fileName, false)) {
                        for (Product pr : products) {
                            fileWriter.write(pr.toString());
                            fileWriter.write("\n");
                        }
                    }
                }
                break;
            }
            case "-d": {
                int id = Integer.parseInt(args[1]);

                for (Product p : products) {
                    if (p.id == id) {
                        products.remove(p);
                        break;
                    }
                }


                try (FileWriter fileWriter = new FileWriter(fileName, false)) {
                    for (Product product : products) {
                        fileWriter.write(product.toString());
                        fileWriter.write("\n");
                    }
                }

                break;
            }
        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}
