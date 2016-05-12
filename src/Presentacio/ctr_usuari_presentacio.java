/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import prop.grup3.ctr_usuari_dom;
/**
 *
 * @author bernat
 */
public class ctr_usuari_presentacio {
    private ctr_usuari_dom ctr_dom;
    private crear_relacio crear_relacio;
    private crear_usuari crear_usuari;
    private gestio_privilegiat gestio_privilegiat;
    private gestio_relacions gestio_relacions;
    private gestio_usuari gestio_usuari;
    private inici inici;
    private loggin loggin;
    private modificar_relacio modificar_relacio;
    private modificar_usuari_estandard modificar_usuari_estandard;
    private modificar_usuari_privilegiat modificar_usuari_privilegiat;
    ctr_usuari_presentacio(){
        ctr_dom = new ctr_usuari_dom();
        crear_relacio = new crear_relacio(this);
        crear_usuari = new crear_usuari(this);
        gestio_privilegiat = new gestio_privilegiat(this);
        gestio_relacions = new gestio_relacions(this);
        gestio_usuari = new gestio_usuari(this);
        inici = new inici(this);
        loggin = new loggin(this);
        modificar_relacio = new modificar_relacio(this);
        modificar_usuari_estandard = new modificar_usuari_estandard(this);
        modificar_usuari_privilegiat = new modificar_usuari_privilegiat(this);
    }
    boolean loggin(String nom, String pass){
        return ctr_dom.loggin(nom, pass);
    }
    void afegir_relacio(String nom, String path, String descripcio){
        ctr_dom.afegir_relacio(nom, path, descripcio);
    }
    boolean esborrar_relacio(String nom){
        return ctr_dom.esborrar_relacio(nom);
    }
    boolean modificar_relacio(String nom, String nomNou, String descripcio){
        return ctr_dom.modificar_relacio(nom, nomNou, descripcio);
    }
    boolean modificar_usuari_estandard(String oldPass, String pass, String nom, String sexe, String data){
        return ctr_dom.modificar_usuari_estandard(oldPass, pass, nom, sexe, data);
    }
    boolean modificar_usuari_privilegiat(String username, String pass, String nom, String sexe, String data ){
        return ctr_dom.modificar_usuari_privilegiat(username, pass, nom, sexe, data);
    }
    ArrayList<ArrayList<String>> relacions_directes(String nom, String tipus){
        return ctr_dom.relacions_directes(nom, tipus);
    }
    ArrayList<ArrayList<String>> informacio_relacions(){
        return ctr_dom.informacio_relacions();
    }
    void borrar_usuari_estandard(){
        ctr_dom.borrar_usuari_estandard();
    }
    boolean crear_usuari(String username, String pass, boolean privilegiat){
        return ctr_dom.crear_usuari(username, pass, privilegiat);
    }
    boolean borrar_usuari(String user_borrar){
        return ctr_dom.borrar_usuari(user_borrar);
    }
    boolean donar_privilegis(String username){
        return ctr_dom.donar_privilegis(username);
    }
    ArrayList<ArrayList<String>> informacio_usuaris(){
        return ctr_dom.informacio_usuaris();
    }
    void afegir_element(String nom, String tipus, String etiq){
        ctr_dom.afegir_element(nom, tipus, etiq);
    }
    void afegir_relacio_graf(String primer, String segon, String tipus){
        ctr_dom.afegir_relacio_graf(primer, segon, tipus);
    }
    void esborrar_element(String nom, String tipus){
        ctr_dom.esborrar_element(nom, tipus);
    }
    void esborrar_relacio_graf(String primer, String segon, String tipus){
        ctr_dom.esborrar_relacio_graf(primer, segon, tipus);
    }
    void carregar_usuaris() throws FileNotFoundException,NullPointerException{
        ctr_dom.carregar_usuaris();
    }
    void guardar_usuaris() throws FileNotFoundException,NullPointerException{
        ctr_dom.guardar_usuaris();
    }
    String usuari_actual(){
        return ctr_dom.usuari_actual();
    }
    void crear_relacio(){
        crear_relacio.vista(this);
    }
    void crear_usuari(){
        crear_usuari.vista(this);
    }
    void gestio_privilegiat(){
        gestio_privilegiat.vista(this);
    }
    void gestio_relacions(){
        gestio_relacions.vista(this);
    }
    void gestio_usuari(){
        gestio_usuari.vista(this);
    }
    void inici(){
        inici.vista(this);
    }
    void loggin(){
        loggin.vista(this);
    }
    void modificar_relacio(){
        modificar_relacio.vista(this);
    }
    void modificar_usuari_estandard(){
        modificar_usuari_estandard.vista(this);
    }
    void modificar_usuari_privilegiat(){
        modificar_usuari_privilegiat.vista(this);
    }
}
