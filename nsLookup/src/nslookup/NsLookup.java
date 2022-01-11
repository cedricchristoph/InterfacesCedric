package nslookup;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLookup {

    public static void main(String args[]) {

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                lookup(args[i]);
            }
        } else {
            DataInputStream myInputStream = new DataInputStream(System.in);
            System.out
                    .println("Introduce direcciones web. Introduce exit o salir para terminar el programa");
            while (true) {
                String s;
                try {
                    s = myInputStream.readLine();
                } catch (IOException e) {
                    break;
                }
                if (s.equals("exit")) {
                    break;
                }
                if (s.equals("salir")) {
                    break;
                }
                if (s.charAt(0) == '\004') {
                    break;
                }
                lookup(s);
            }

        }

    }

    private static void lookup(String s) {
        InetAddress thisComputer;
        byte[] address;

        try {
            thisComputer = InetAddress.getByName(s);
            address = thisComputer.getAddress();
        } catch (UnknownHostException ue) {
            System.out.println("No se puede encontrar el host " + s);
            return;
        }

        if (esHost(s)) {
            for (int i = 0; i < address.length; i++) {
                int unsignedByte = address[i] < 0 ? address[i] + 256
                        : address[i];
                System.out.print(unsignedByte);
                if (!(i == (address.length - 1))) System.out.print(".");
            }
            System.out.println();
        } else {
            try {
                System.out.println(InetAddress.getByName(s));
            } catch (UnknownHostException e) {
                System.out.println("No se puede encontrar la direccion " + s);
            }
        }
    } 

    private static boolean esHost(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (!Character.isDigit(ca[i])) {
                if (ca[i] != '.') {
                    return true;
                }
            }
        }
        return false;
    } 
}

