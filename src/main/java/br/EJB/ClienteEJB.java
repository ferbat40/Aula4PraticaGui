/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.EJB;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Pessoal
 */
public class ClienteEJB {
    
    public int somar(int A, int B){
        
              
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        props.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout","5000");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts","100:500:100:500");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts","500:2000:50:1000");

        InitialContext ejbRemoteContext;
        try {
            ejbRemoteContext = new InitialContext(props);
        } catch (NamingException ex) {
            System.out.println("ERRO");
            System.out.println(ex.getMessage());
            return -1;
        }

        br.ICalculadora beanRemote;
        try {
            beanRemote = (br.ICalculadora) ejbRemoteContext.lookup("java:global/Aula4PraticaWeb/EJBCalculadora");
            int x = beanRemote.soma(A, B);
            return x;
        } catch (NamingException ex) {
            System.out.println("ERRo");
            System.out.println(ex.getMessage());
            return -2;
        }
    }


        

    
}
