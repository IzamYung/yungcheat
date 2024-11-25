import java.io.*;
import java.text.DecimalFormat;
public class latihanPA {
    
    static BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
    static DecimalFormat df = new DecimalFormat("0.00");
    static int noPilihan;
    static int bilPelajar;
    static String pelajar[] = new String [0];
    static double pngSem1[][] = new double [0][6];
    static double pngSem2[][] = new double [0][6];
    static String subjek[] = {"Bahasa Malaysia","Bahasa Inggeris","Matematik","Sains","Sejarah","Pendidikan Islam"};
    
    static double pngksem1[] = new double [0];
    static double pngksem2[] = new double [0];
    static double pngksubjek[][] = new double[0][6];
    static double pngkk[] = new double [0];
    static String anugerah[] = new String [7];


    public static void main (String args[]) throws IOException{
        do{
            menuUtama();
            switch(noPilihan){
                case 1:
                    inputNamaPelajar();
                    break;
                case 2:
                    inputPNG();
                    kiraPurata();
                    break;
                case 3:
                    papar();
                    break;
                case 4:
                    penerimaAnugerah();
                    break;
                case 5:
                    System.out.print("\nKELUAR SISTEM?\n"
                                    + "Masukkan Y untuk YA, T untuk TIDAK: ");
                    String pilihanKeluar = input.readLine();
                    if (pilihanKeluar.equals("Y") || pilihanKeluar.equals("y")){
                        System.out.println("\n********** Terima kasih kerana menggunakan  sistem ini! **********");
                    }
                    else if (pilihanKeluar.equals("T") || pilihanKeluar.equals("t")){
                        noPilihan = 1;
                    }
                    break;
                default:
                    System.out.println("\n******* RALAT PILIHAN *******\n"
                        + "SILA MASUKKAN SEMULA PILIHAN ANDA");
            }
        }while(noPilihan!=5);
    }
    public static void menuUtama() throws IOException{
        System.out.print ("\n========================================\n"
                          + "SISTEM ANALISIS ANUGERAH KVDSAZI\n"
                          + "========================================\n"
                          + "\n"
                          + "1. Daftar nama pelajar\n"
                          + "2. Input PNG\n"
                          + "3. Papar PNGK\n"
                          + "4. Papar Senarai Penerima Anugerah\n"
                          + "5. Keluar\n\n"
                          + "Pilih satu menu.\n"
                          + "Masukkan nombor pilihan : ");
        noPilihan = Integer.parseInt (input.readLine());
    }

    public static void inputNamaPelajar() throws IOException {
        System.out.print ("\n********** DAFTAR NAMA PELAJAR **********\n"
                        + "Masukkan bilangan pelajar: ");
        bilPelajar = Integer.parseInt (input.readLine());
        pelajar = new String [bilPelajar];
        for (int i=0; i<bilPelajar; i++){
            System.out.print ("Masukkan nama pelajar "+(i+1)+ ": ");
            pelajar[i] = input.readLine();
        }
        pngSem1 = new double [bilPelajar][6];
        pngSem2 = new double [bilPelajar][6];
        System.out.println ("********** DAFTAR NAMA PELAJAR SELESAI **********");
    }  
    
    public static void inputPNG() throws IOException{
        System.out.print ("\n******** INPUT PNG SEM 1 ********");
        for (int j=0; j<bilPelajar; j++){
            System.out.println("\nPelajar "+(j+1)+": "+pelajar[j]);
            for (int i=0; i<6; i++){
                System.out.print ("Masukan PNG sem 1 "+subjek[i]+": ");
                pngSem1[j][i] = Double.parseDouble(input.readLine());
            }    
        } 
        System.out.print ("\n******** INPUT PNG SEM 2 ********");
        for (int j=0; j<bilPelajar; j++){
            System.out.println("\nPelajar "+(j+1)+": "+pelajar[j]);
            for (int i=0; i<6; i++){
                System.out.print ("Masukan PNG sem 2 "+subjek[i]+": ");
                pngSem2[j][i] = Double.parseDouble(input.readLine());
            } 
        }
        System.out.println ("\n********** INPUT PNG SELESAI **********");
    }
    
    public static void kiraPurata(){
        pngksem1 = new double [bilPelajar];
        pngksem2 = new double [bilPelajar];
        pngksubjek = new double[bilPelajar][6];
        pngkk = new double [bilPelajar];
        for (int i=0; i<bilPelajar; i++){
            pngksem1[i] = (pngSem1[i][0]+pngSem1[i][1]+pngSem1[i][2]+pngSem1[i][3]+pngSem1[i][4]+pngSem1[i][5])/6;
            pngksem2[i] = (pngSem2[i][0]+pngSem2[i][1]+pngSem2[i][2]+pngSem2[i][3]+pngSem2[i][4]+pngSem2[i][5])/6;
            double jumlahPngkSubjek = 0;
            for (int j=0; j<6; j++){
                pngksubjek[i][j] = (pngSem1[i][j]+pngSem2[i][j])/2;
                jumlahPngkSubjek += pngksubjek[i][j];
            }
            pngkk[i] = jumlahPngkSubjek/6;
        }
    }

    public static void papar(){
        System.out.println ("\n********** PAPARAN KEPUTUSAN 1 SVM ***********");
        System.out.println("\nPNG 1 SVM  SEMESTER 1");
        System.out.println("NAMA\t||\tBM\tBI\tMATE\tSAINS\tSEJARAH\tPAI\tPNGK Sem 1");
        for(int i=0; i<bilPelajar;i++){
            System.out.println(pelajar[i]+"\t||\t"+df.format(pngSem1[i][0])+"\t"+df.format(pngSem1[i][1])+"\t"+df.format(pngSem1[i][2])+"\t"+df.format(pngSem1[i][3])+"\t"+df.format(pngSem1[i][4])+"\t"+df.format(pngSem1[i][5])+"\t"+df.format(pngksem1[i]));
        }
        System.out.println("\nPNG 1 SVM  SEMESTER 2");
        System.out.println("NAMA\t||\tBM\tBI\tMATE\tSAINS\tSEJARAH\tPAI\tPNGK Sem 1");
        for(int f=0; f<bilPelajar;f++){
            System.out.println(pelajar[f]+"\t||\t"+df.format(pngSem2[f][0])+"\t"+df.format(pngSem2[f][1])+"\t"+df.format(pngSem2[f][2])+"\t"+df.format(pngSem2[f][3])+"\t"+df.format(pngSem2[f][4])+"\t"+df.format(pngSem2[f][5])+"\t"+df.format(pngksem2[f]));
        }
        System.out.println("\nPNGK 1 SVM");
        System.out.println("NAMA\t||\tBM\tBI\tMATE\tSAINS\tSEJARAH\tPAI\tPNGKK");
        for(int k=0; k<bilPelajar;k++){
            System.out.println(pelajar[k]+"\t||\t"+df.format(pngksubjek[k][0])+"\t"+df.format(pngksubjek[k][1])+"\t"+df.format(pngksubjek[k][2])+"\t"+df.format(pngksubjek[k][3])+"\t"+df.format(pngksubjek[k][4])+"\t"+df.format(pngksubjek[k][5])+"\t"+df.format(pngkk[k]));
        }
        System.out.println("\n********** PAPARAN KEPUTUSAN TAMAT **********");
    }
    
    public static void penerimaAnugerah(){
        System.out.println("\n********** SENARAI PENERIMA ANUGERAH **********\n");
        double subpngkk = 0;
        for(int i=0; i<6; i++){
            double subpngk = 0;
            for(int j=0; j<bilPelajar; j++){
                if(subpngk<pngksubjek[j][i]){
                    subpngk = pngksubjek[j][i];
                    anugerah[i] = pelajar[j];
                }
            }
            System.out.println("Anugerah Terbaik "+subjek[i]+": "+anugerah[i]);
        }
        for(int a=0; a<bilPelajar; a++){
            if(subpngkk<pngkk[a]){
                subpngkk = pngkk[a];
                anugerah[6] = pelajar[a];
            }
        }
        System.out.println("Anugerah Pelajar Cemerlang: "+anugerah[6]);
        System.out.println("\n********** SENARAI PENERIMA ANUGERAH TAMAT **********");
    }
}