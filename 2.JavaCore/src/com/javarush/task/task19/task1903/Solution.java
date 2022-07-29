package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution
{
    public static Map<String, String> countries = new HashMap<String, String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args)
    {


    }

    public static class IncomeDataAdapter implements Customer, Contact
    {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData d)
        {
            data = d;
        }

        public IncomeDataAdapter()
        {
            super();
        }

        @Override
        public String getCompanyName()
        {
            //For example: JavaRush Ltd.
            return data.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName()
        {
            //For example: Ivanov, Ivan
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {

           /* // 38                                  0123456789 10
            //For example1: 501234567, For example2: 71112233
            //For example1: +38(050)123-45-67, For example2:  +38(007)111-22-33
            StringBuffer bf = new StringBuffer("+" + data.getCountryPhoneCode() + "()"); // +38()

            String pNumber = String.valueOf(data.getPhoneNumber());
            String operator = 9 == pNumber.length() ? "0" + pNumber.substring(0, 2) : "00" + pNumber.substring(0, 1);

            bf.insert(4, operator); // +38(050) || +38(007)

            String endNumber = pNumber.substring(pNumber.length() - 7, pNumber.length()); // 1112233
            bf.append(endNumber); // +38(050)1112233
            bf.insert(13, "-"); // +38(050)11122-33
            bf.insert(11, "-"); // +38(050)111-22-33

            return bf.toString();*/
            String res = String.format("+%d(%2$s)%3$s-%4$s-%5$s", data.getCountryPhoneCode(),
                    String.format("%010d", data.getPhoneNumber()).substring(0, 3),
                    String.format("%010d", data.getPhoneNumber()).substring(3, 6),
                    String.format("%010d", data.getPhoneNumber()).substring(6, 8),
                    String.format("%010d", data.getPhoneNumber()).substring(8));

            return res;
        }
    }


    public interface IncomeData
    {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer
    {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact
    {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}