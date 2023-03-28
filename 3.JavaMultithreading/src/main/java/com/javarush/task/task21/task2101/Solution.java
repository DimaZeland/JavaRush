package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000


        /*System.out.println("byte - 8 bit, диапазон от -128 до 127 = 255");
        System.out.println("используемое число - (byte) 192");
        System.out.println(String.format("%32s",Integer.toBinaryString((byte) 192)).replace(' ', '0'));
        System.out.println("Логическое умножение &");
        System.out.println(String.format("%32s",Integer.toBinaryString(255)).replace(' ', '0'));
        System.out.println("Результат:");
        System.out.println(String.format("%32s",Integer.toBinaryString((byte) 192 & 255)).replace(' ', '0'));
        System.out.println("А теперь просто отбрасываем не интересующие нас старшие разряды");
        String result = String.format("%8s",Integer.toBinaryString((byte) 192 & 255)).replace(' ', '0');
        System.out.println(result);
        System.out.println("В десятичной СС - " + Integer.parseInt(result, 2));
        System.out.println("----------------------------------------------------------");
        System.out.println("short - 16 bit, диапазон от -32 768 до 32 767 = 65 535");
        System.out.println("используемое число - (short) 34_000");
        System.out.println(String.format("%32s",Integer.toBinaryString((short) 34_000)).replace(' ', '0'));
        System.out.println("Логическое умножение &");
        System.out.println(String.format("%32s",Integer.toBinaryString(65535)).replace(' ', '0'));
        System.out.println("Результат:");
        System.out.println(String.format("%32s",Integer.toBinaryString((short) 34_000 & 65535)).replace(' ', '0'));
        System.out.println("А теперь просто отбрасываем не интересующие нас старшие разряды");
        String result2 = String.format("%16s",Integer.toBinaryString((short) 34_000 & 65535)).replace(' ', '0');
        System.out.println(result2);
        System.out.println("В десятичной СС - " + Integer.parseInt(result2, 2));*/


    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];

        for (int i = 0; i < ip.length; i++)
            netAddress[i] = (byte) (ip[i] & mask[i]);

        return netAddress;
    }

    public static void print(byte[] bytes) {
        String currentBinary;

        for (byte aByte : bytes) {
            currentBinary = Integer.toBinaryString(256 + (int) aByte);
            //System.out.print(currentBinary + " ");
            System.out.print(currentBinary.substring(currentBinary.length() - 8) + " ");

        }
        System.out.println();


    }
}
