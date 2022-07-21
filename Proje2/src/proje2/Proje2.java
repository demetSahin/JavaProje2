package proje2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Proje2 {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("customer.txt"));//dosyadan bilgi okuma için.
        } catch (FileNotFoundException e) {//dosya okumada hata varsa programdan çıkılır.
            System.out.println("Dosya Bulunamadı.");
            System.exit(0);
        }

        CustomDoublyLinkedList cDLList = new CustomDoublyLinkedList();

        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine(); // Dosyayı satır satır okumak için.
            String[] arrOfStr = satir.split(","); // Dosyadan bir bütün String  olarak gelen satır içindeki değişkenleri birbirinden virgüllerden ayırmak için.
            String adSoyad = arrOfStr[0]; //Oluşturduğumuz "arrOfStr" dizisinin ilk elemanı ad ve soyad bilgisini tutar.
            String adres = arrOfStr[1]; //Oluşturduğumuz "arrOfStr" dizisinin ikinci elemanı adres bilgisini tutar.
            ArrayList<String> numaralar = new ArrayList();
            for (int d = 2; d < arrOfStr.length; d++) { //her satırın 3. ve varsa sonraki ögeleri telefon numaraları olduğu için.
                numaralar.add(arrOfStr[d]);
            }
            cDLList.addNode(new CustomerInfo(arrOfStr[0], arrOfStr[1], numaralar));
        }

        Scanner scan = new Scanner(System.in);
        String menu;
        boolean done = false;
        do {
            System.out.format("Lütfen yapmak istediğiniz işlemle ilgili sayıyı giriniz : ");
            System.out.println();
            System.out.format("*************************************************\n");
            System.out.format("1 : Müşteri ekle.\n"
                    + "2 : Adı soyadı girilen müşterinin bilgilerini yazdır.\n"
                    + "3 : Adı soyadı girilen müşteriyi sil.\n"
                    + "4 : Listeyi soyada göre a'dan z'ye alfabetik sırada yazdır.\n"
                    + "5 : Listeyi soyada göre z'den a'ya alfabetik sırada yazdır.\n"
                    + "6 : Çık.\n");
            System.out.format("*************************************************\n");

            menu = scan.nextLine().toUpperCase();

            switch (menu) {
                case "1" -> {
                    System.out.println("Müşteri Ekleme : ");

                    System.out.print("Müşterinin adını ve soyadını giriniz : ");
                    String adSoyad = scan.nextLine();

                    System.out.print("Müşterinin şehrini giriniz : ");
                    String adres = scan.nextLine();

                    ArrayList<String> numaralar = new ArrayList();

                    System.out.print("Müşterinin telefon numarasını giriniz : ");
                    String phoneNumber = scan.nextLine();
                    numaralar.add(phoneNumber);

                    System.out.println("Müşteriye ait başka telefon numarası var mı : (E)vet / (H)ayır : ");
                    String n = scan.nextLine();
                    while (n.equalsIgnoreCase("E")) {
                        System.out.print("Müşterinin telefon numarasını giriniz : ");
                        phoneNumber = scan.nextLine();
                        numaralar.add(phoneNumber);
                        System.out.println("Müşteriye ait başka telefon numarası var mı : (E)vet / (H)ayır : ");
                        n = scan.nextLine();
                    }
                    
                    cDLList.addNode(new CustomerInfo(adSoyad, adres, numaralar)); // girilen bilgiler CustomerInfo sınıfının yapılandırıcı metoduna parametre olarak gönderilerek bu sınıf tipinde yeni bir nesne oluşturulduktan sonra CustomDoublyLinkedList sınıfının yapılandırıcı metoduna parametre olarak gönderilir.  
                    
                    System.out.println("Aşağıda bilgileri bulunan müşteri listeye eklenmiştir : ");
                    cDLList.display(0, adSoyad);
                }
                case "2" -> {
                    System.out.println("Adı soyadı girilen müşterinin bilgilerini yazdırma : ");
                    System.out.print("Müşterinin adını ve soyadını giriniz : ");
                    String adSoyad = scan.nextLine();
                    cDLList.display(0, adSoyad);
                }
                case "3" -> {
                    System.out.println("Adı soyadı girilen müşteriyi silme : ");
                    System.out.print("Müşterinin adını ve soyadını giriniz : ");
                    String adSoyad = scan.nextLine();
                    cDLList.delete(adSoyad);
                }
                case "4" -> {
                    System.out.println("Listenin soyada göre a'dan z'ye alfabetik sırada yazdırılması : ");
                    cDLList.display(0, null);
                }
                case "5" -> {
                    System.out.println("Listenin soyada göre z'den a'ya alfabetik sırada yazdırılması : ");
                    cDLList.display(1, null);
                }
                case "6" -> {
                    System.out.println("Çıkış yapıldı.");
                    done = true;
                }
                default ->
                    System.out.println("\n*************************************************\n"
                            + "Lütfen 1 - 6 arasında sayı karakteri giriniz.\n");
            }
        } while (!done);
    }
}