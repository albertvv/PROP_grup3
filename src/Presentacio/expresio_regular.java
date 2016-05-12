/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author bernat
 */
public class expresio_regular {
    static Pattern patron_sin_espacios = Pattern.compile("[^A-Za-z0-9]");
    static Pattern patron_con_espacios = Pattern.compile("[^A-Za-z0-9 ]");
    public static boolean aux(String entrada, Pattern patro){
        if(entrada == null) return true;
        Matcher encaja = patro.matcher(entrada);
        return !encaja.find();
    }
    public static boolean sense_espais(String entrada){
        return aux(entrada, patron_sin_espacios);
    }
    public static boolean amb_espais(String entrada){
        return aux(entrada, patron_con_espacios);
    }
    private static boolean ATC(char c){
        return c == 'A' || c=='T' || c == 'C';
    }
    public static boolean path(String entrada){
        boolean p;
        p = entrada.charAt(0) == 'P';
        if(!p && !ATC(entrada.charAt(0))) return false;
        for(int i = 1; i < entrada.length(); ++i){
            if(!((p && ATC(entrada.charAt(i))) || (!p && (entrada.charAt(i) == 'P')))) return false;
            p = !p;
        }
        return true;
    }
}
