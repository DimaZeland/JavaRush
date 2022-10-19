package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector
{
    SimpleConnector connector;
    SecurityChecker securityChecker = new SecurityCheckerImpl();

    public SecurityProxyConnector(String string)
    {
        connector = new SimpleConnector(string);
    }

    @Override
    public void connect()
    {
        System.out.println("Performing security check...");
        if(securityChecker.performSecurityCheck())
        {
            connector.connect();
        }
        else
            System.out.println("FAILED SECURITY CHECK, WON'T CONNECT!");
    }
}
