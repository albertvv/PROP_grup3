package prop.grup3; /**
 * Created by marc on 4/20/16.
 */

import org.la4j.matrix.SparseMatrix;

import java.util.Scanner;
import java.util.Vector;


public class driverGrafo {
    public static void main(String[] args) {
    /*    Grafo g = new Grafo();
        System.out.println("0 afegir entitat\n1 esborrar entitat\n2 afegir relacio\n3 esborrar relacio\n" +
                "4 relacions directes\n5 obtenir entitat\n6 obtenir matriu d'adjacencies\n7/8/9 canviar ID/nom/tag" +
                "\n10/11/12/13 obtenir Papers/Autors/Conferencies/Termes");
        while (true) {
            Scanner sc = new Scanner(System.in), sc1, sc2, sc3;
            String nom1, nom2, tipus;
            Integer x;
            int opcio = sc.nextInt();
            switch (opcio) {
                case 0: //afegir entitat
                    System.out.println("nom de l'entitat que vols afegir:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat que vols afegir ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    if (g.addEntidad(nom1, null, null, tipus))
                        System.out.println("Entitat afegida\nindex relatiu: " + g.getIndice(nom1) +
                                "\nnom: " + g.getNombre_i(g.getIndice(nom1), tipus) + "\ntipus: " +
                                tipus + "\nid: " + g.getEntidad(nom1, null, tipus).getId());
                    else System.out.println("no s'ha pogut afegir l'entitat =(");
                    break;
                case 1: //esborrar entitat
                    System.out.println("nom de l'entitat que vols esborrar:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat que vols esborrar ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    if (g.deleteEntidad(nom1, null, tipus)) System.out.println("Entitat esborrada correctament");
                    else System.out.println("No s'ha esborrat cap entitat, reviseu parametres =(");
                    break;
                case 2: //afegir relacio
                    System.out.println("nom de l'entitat origen:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    sc3 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("nom de l'entitat desti:");
                    nom2 = sc2.nextLine();
                    System.out.println("tipus de relacio ([AP, CP, TP] i les simetriques):");
                    tipus = sc3.nextLine();
                    if (g.addRelacion(nom1, nom2, tipus)) System.out.println("Relació afegida correctament");
                    else System.out.println("No s'ha pogut afegir la relacio :(");
                    break;
                case 3: //esborrar relacio
                    System.out.println("nom de l'entitat origen:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    sc3 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("nom de l'entitat desti:");
                    nom2 = sc2.nextLine();
                    System.out.println("tipus de relacio ([AP, CP, TP] i les simetriques):");
                    tipus = sc3.nextLine();
                    if (g.deleteRelacion(nom1, nom2, tipus)) System.out.println("Relació esborrada correctament");
                    else System.out.println("No s'ha pogut esborrar la relacio :(");
                    break;
                case 4: //relacions directes
                    System.out.println("nom de l'entitat de la qual vols veure les relacions:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat de la qual vols veure les relacions ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    Vector<Entidad> v = g.getRelacion(nom1, tipus);
                    System.out.print("relacions directes obtingudes:");
                    for (int i = 0; i < v.size(); ++i)
                        System.out.println(v.get(i).getNombre());
                    break;
                case 5: //obtenir entitat
                    System.out.println("nom de l'entitat que es vol obtenir:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat que es vol obtenir ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    Entidad e;
                    if ((e = g.getEntidad(nom1, null, tipus)) != null) {
                        System.out.println("entitat: " + e.getNombre());
                        System.out.println("id: " + e.getId());
                        if (tipus != "Termino") System.out.println(e.getEtiqueta());
                    }
                    else System.out.println("no s'ha obtingut cap entitat, reviseu parametres");
                    break;
                case 6: //obtenir matriu d'adjacencies
                    System.out.println("tipus de columna de la matriu ([Autor, Conferencia, Termino]):");
                    sc1 = new Scanner(System.in);
                    tipus = sc1.nextLine();
                    SparseMatrix m = g.getMatriz(tipus);
                    System.out.println("matriu obtinguda (reduida a 5x5):");
                    for (int i = 0; i < 5; i++) {
                        System.out.println("*****Paper " + i + "*****");
                        for (int j = 0; j < 5; j++) {
                            System.out.println("autor " + j + ": " + m.get(i, j));
                        }
                    }
                    break;
                case 7: //canvi ID
                    System.out.println("nom de l'entitat:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    System.out.println("nova ID:");
                    sc3 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat que es vol modificar ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    x = Integer.parseInt(sc3.nextLine());
                    if (g.setID(nom1, tipus, x)) System.out.println("ID canviada amb exit, ho podeu " +
                            "comprovar amb l'opcio 5");
                    break;
                case 8: //canvi Nom
                    System.out.println("nom original de l'entitat:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    sc3 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat que es vol modificar ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    System.out.println("nou Nom:");
                    nom2 = sc3.nextLine();
                    if (g.setNom(nom1, tipus, nom2)) System.out.println("nom canviat amb exit, ho podeu " +
                            "comprovar amb l'opcio 5");
                    break;
                case 9: //canvi Tag
                    System.out.println("nom de l'entitat:");
                    sc1 = new Scanner(System.in);
                    sc2 = new Scanner(System.in);
                    sc3 = new Scanner(System.in);
                    nom1 = sc1.nextLine();
                    System.out.println("tipus d'entitat que es vol modificar ([Paper, Autor, Conferencia, Termino]):");
                    tipus = sc2.nextLine();
                    System.out.println("nova etiqueta:");
                    nom2 = sc3.nextLine();
                    if (g.setTag(nom1, tipus, nom2)) System.out.println("tag canviat amb exit, ho podeu " +
                            "comprovar amb l'opcio 5");
                    break;
                case 10:
                    System.out.println("Llista de Papers (noms):");
                    Vector<Paper> vp = g.getPapers();
                    x = vp.size();
                    for (int i = 0; i < x; ++i)
                        System.out.println(vp.get(i).getNombre());
                    break;
                case 11:
                    System.out.println("Llista d'Autors (noms):");
                    Vector<Autor> va = g.getAutors();
                    x = va.size();
                    for (int i = 0; i < x; ++i)
                        System.out.println(va.get(i).getNombre());
                    break;
                case 12:
                    System.out.println("Llista de Congressos (noms):");
                    Vector<Conferencia> vc = g.getConferencias();
                    x = vc.size();
                    for (int i = 0; i < x; ++i)
                        System.out.println(vc.get(i).getNombre());
                    break;
                case 13:
                    System.out.println("Llista de Termes (noms):");
                    Vector<Termino> vt = g.getTerminos();
                    x = vt.size();
                    for (int i = 0; i < x; ++i)
                        System.out.println(vt.get(i).getNombre());
                    break;
                default:
                    System.out.println("T'has equivocat, gamarús!");
                    break;
            }
        }*/
    }
}
