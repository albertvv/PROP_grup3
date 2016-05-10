package prop.grup3;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class DriverControladorGrafoPersist {

    public static void main(String[] args) throws IOException {
        ControladorGrafoPersist cgp = new ControladorGrafoPersist();
        System.out.println("0 carregar papers\n1 carregar autors\n2 carregar conferencies\n3 carregar temes\n" +
                "4 carrega PA\n5 carrega PC\n6 carrega PT\n7 salva papers\n8 salva autors\n9 salva conferencies" +
                "\n10 salva temes\n11 save PA\n12 save PC\n13 save PT\n14 SORTIR");
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();
        while(opcio != 14) {
            switch (opcio) {
                case 0:
                    Vector<Vector<String>> mP = cgp.getPapers();
                    int j = 0;
                    for (int i = 0; i < mP.size(); ++i) {
                        if(mP.get(i).size() == 3) {
                            System.out.println(mP.get(i).get(0) + " " + mP.get(i).get(1) + " " + mP.get(i).get(2));
                            ++j;
                        }
                        else  System.out.println(mP.get(i).get(0) + " " + mP.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + mP.size());
                    System.out.println("Quantitat labels: " + j);
                    break;
                case 1:
                    Vector<Vector<String>> mA = cgp.getAutores();
                    j = 0;
                    for (int i = 0; i < mA.size(); ++i) {
                        if(mA.get(i).size() == 3) {
                            System.out.println(mA.get(i).get(0) + " " + mA.get(i).get(1) + " " + mA.get(i).get(2));
                            ++j;
                        }
                        else  System.out.println(mA.get(i).get(0) + " " + mA.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + mA.size());
                    System.out.println("Quantitat labels: " + j);
                    break;
                case 2:
                    Vector<Vector<String>> mC = cgp.getConferencias();
                    j = 0;
                    for (int i = 0; i < mC.size(); ++i) {
                        if(mC.get(i).size() == 3) {
                            System.out.println(mC.get(i).get(0) + " " + mC.get(i).get(1) + " " + mC.get(i).get(2));
                            ++j;
                        }
                        else  System.out.println(mC.get(i).get(0) + " " + mC.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + mC.size());
                    System.out.println("Quantitat labels: " + j);
                    break;
                case 3:
                    Vector<Vector<String>> mT = cgp.getTerminos();
                    for (int i = 0; i < mT.size(); ++i) {
                        System.out.println(mT.get(i).get(0) + " " + mT.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + mT.size());
                    break;
                case 4:
                    Vector<Vector<String>> PA = cgp.getPA();
                    for (int i = 0; i < PA.size(); ++i) {
                        System.out.println(PA.get(i).get(0) + " " + PA.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + PA.size());
                    break;
                case 5:
                    Vector<Vector<String>> PC = cgp.getPC();
                    for (int i = 0; i < PC.size(); ++i) {
                        System.out.println(PC.get(i).get(0) + " " + PC.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + PC.size());
                    break;
                case 6:
                    Vector<Vector<String>> PT = cgp.getPT();
                    for (int i = 0; i < PT.size(); ++i) {
                        System.out.println(PT.get(i).get(0) + " " + PT.get(i).get(1));
                    }
                    System.out.println("Quantitat linies: " + PT.size());
                    break;
                default:
                    break;
            }
            System.out.println("0 carregar papers\n1 carregar autors\n2 carregar conferencies\n3 carregar temes\n" +
                    "4 carrega PA\n5 carrega PC\n6 carrega PT\n7 salva papers\n8 salva autors\n9 salva conferencies" +
                    "\n10 salva temes\n11 save PA\n12 save PC\n13 save PT\n14 SORTIR");
            opcio = sc.nextInt();
        }
    }
}
