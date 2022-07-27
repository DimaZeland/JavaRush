package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        String file3 = br.readLine();

        FileInputStream fi = new FileInputStream(file1);
        FileOutputStream fo2 = new FileOutputStream(file2);
        FileOutputStream fo3 = new FileOutputStream(file3);

        int count = fi.available();

        byte[] arr = new byte[count];
        fi.read(arr,0,count);
        fi.close();

        if(0 == count % 2)
        {
            
            fo2.write(arr, 0,count / 2);
            fo3.write(arr, (count/2), count/ 2);
        }
        else
        {
            fo2.write(arr, 0,(count / 2) + 1);
            fo3.write(arr, (count/2)+1 , count / 2);
        }
        fo2.close();
        fo3.close();
    }
}
