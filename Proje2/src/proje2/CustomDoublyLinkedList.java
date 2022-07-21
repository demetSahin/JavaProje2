package proje2;

public class CustomDoublyLinkedList {

    private class TwoWayNode { //Düğüm sınıfını çift bağlı liste sınıfında iç sınıf olarak yazmayı tercih ettim. 

        private CustomerInfo customerInfo; // Düğümlerde tutulacak bilgi CustomerInfo sınıfından üretilecek nesneler olacağı için...
        private TwoWayNode previous; // Bir önceki düğüm.
        private TwoWayNode next; // Bir sonraki düğüm.

        public TwoWayNode(CustomerInfo customerInfo) {
            this.customerInfo = customerInfo;
        }
    }

    private TwoWayNode head, tail = null; //Çift bağlı listenin başını (head) ve sonunu (tail) temsil eden 2 değişken.

    public void addNode(CustomerInfo customerInfo) { //CustomerInfo sınıfı tipinde bir parametre alan ve soyada göre sıralı olacak şekilde listeye ekleme metodu.
        TwoWayNode newNode = new TwoWayNode(customerInfo); //addNode metoduna Parametre olarak gönderilen CustomerInfo nesnesi TwoWayNode sınıfının yapılandırıcı metoduna parametre olarak gönderilip bu sınıf tipinde bir nesne yaratılır.

        if (head == null) { // Liste boşsa...
            head = tail = newNode; // baş ve son öge aynı olacak şekilde eklemenmek istenen CustomerInfo nesnesi bunlara atanır.
            head.previous = null; //baş ögenin sonraki ögesi boş olarak atanır.
            tail.next = null; // son ögenin önceki ögesi boş olarak atanır.
        } else { // Liste boş değilse
            tail.next = newNode; //eklenmek istenen CustomerInfo ögesi son ögenin sonraki ögesi olarak atanır. 
            newNode.previous = tail; //eklenmek istenen CustomerInfo ögesinin önceki ögesi son öge olacak şekilde atanır. 
            tail = newNode; // artık son öge, eklenmek istenen CustomerInfo ögesidir.
            tail.next = null; // eklenmek istenen CustomerInfo ögesi son öge olarak ayarlandıktan sonra, onun sonraki ögesi boş olarak atanır.
        }

        sortList(); // ekleme işleminden sonra liste soyada göre a'dan z'ye sıralanıyor
    }

    public void sortList() {
        TwoWayNode current = null, index = null;
        CustomerInfo temp;
        //Check whether list is empty  
        if (head == null) {
            return;
        } else {
            //Current will point to head  
            for (current = head; current.next != null; current = current.next) {
                //Index will point to node next to current  
                for (index = current.next; index != null; index = index.next) {
                    //If current's data is greater than index's data, swap the data of current and index  
                    String[] currentNames = current.customerInfo.getAdSoyad().split(" ");
                    String[] newNames = index.customerInfo.getAdSoyad().split(" ");

                    int resultSurname = currentNames[currentNames.length - 1].compareToIgnoreCase(newNames[newNames.length - 1]); //Soyadların karşılaştırılması
                    int resultName = currentNames[0].compareToIgnoreCase(newNames[0]); //Adların karşılaştırılması (Not : İki ada sahip kişilerin ilk adlarına bakılarak karşılaştırma yapılacaktır)
                    //System.out.printf("%s, %s - Result : %d\n",currentNames[currentNames.length - 1], newNames[newNames.length - 1], resultSurname);
                    //System.out.printf("%s, %s - Result : %d\n",currentNames[currentNames.length - 1], newNames[newNames.length - 1], resultSurname);
                    if (resultSurname > 0 || resultSurname == 0 && resultName > 0) { // a'dan z'ye sıralama ("resultSurname > 0" ile soyadlara, "resultSurname == 0 && resultName > 0" ile aynı soyadlı kişilerin adlarına bakılıyor)
                        temp = current.customerInfo;
                        current.customerInfo = index.customerInfo;
                        index.customerInfo = temp;
                    }
                }
            }
        }
    }

    public void reverseSortList() { // Bu metot sortList() metodunun tam tersi mantıkla yazılmıştır.
        TwoWayNode current = null, index = null;
        CustomerInfo temp;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    String[] currentNames = current.customerInfo.getAdSoyad().split(" ");
                    String[] newNames = index.customerInfo.getAdSoyad().split(" ");

                    int resultSurname = newNames[newNames.length - 1].compareToIgnoreCase(currentNames[currentNames.length - 1]);
                    int resultName = newNames[0].compareToIgnoreCase(currentNames[0]);
                    if (resultSurname > 0 || resultSurname == 0 && resultName > 0) { // z'den a'ya sıralama
                        temp = current.customerInfo;
                        current.customerInfo = index.customerInfo;
                        index.customerInfo = temp;
                    }
                }
            }
        }
    }

    public void display(int order, String checkString) { //Adı ve soyadı verilen bir müşteriyi "checkString" parametresi ile listede arayarak eğer varsa bu müşterinin bilgilerini yazdıran metot.
        //Bu metot aynı zamanda, aldığı "order" parametresine bağlı olarak...
        //... order = 0 ise a'dan z'ye...
        //... order = 1 ise z'den a'ya sıralar ve o şekilde yazdırır.
        TwoWayNode current = head;
        if (head == null) {
            System.out.println("Liste boş!..");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (checkString == null) {
            if (order == 1) {
                reverseSortList();
            }

            while (current != null) {
                System.out.print(current.customerInfo);
                current = current.next;
            }
        } else {
            while (current != null) {
                if (current.customerInfo.getAdSoyad().equalsIgnoreCase(checkString)) {
                    //System.out.print(current.customerInfo);
                    sb.append(current.customerInfo.toString());
                }
                current = current.next;
            }
            if (sb.isEmpty()) {
                System.out.println("Müşteri bulunamamıştır. Müşterinin ad ve soyadını doğru girdiğinizden emin olunuz.");
            } else {
                System.out.print(sb.toString());
            }
        }
        System.out.println();
        sortList(); // gönderilen parametreye göre a'dan z'ye veya tersi sıralama yapıldığı için liste yazdırıldıktan sonra her halükarda a'dan z'ye sıralı bırakılması yararlı olacaktır diye düşünülmüştür. 
    }

    public void delete(String checkString) { // Adı ve soyadı verilen müşterinin listeden silinmesini sağlayan silme metodu.
        TwoWayNode current = head;
        if (head == null) {
            System.out.println("Liste boş!..");
            return;
        }

        boolean found = false;
        if (checkString == null || checkString.isEmpty()) {
            System.out.println("Müşteri adı ve soyadı girilmedi. Lütfen yeniden deneyiniz.");
            return;
        } else {
            while (current != null) {
                if (current.customerInfo.getAdSoyad().equalsIgnoreCase(checkString)) {
                    if (current.next == null && current.previous == null) {
                        tail = null;
                        head = null;
                    } else if (current.next == null) {
                        current.previous.next = null;
                        tail = current.previous;
                    } else if (current.previous == null) {
                        current.next.previous = null;
                        head = current.next;
                    } else {
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                        //current = current.next;
                    }
                    found = true;
                    break;
                }
                current = current.next;
            }

            if (!found) {
                System.out.print("Listede bu isimde bir müşteri bulunmamaktadır.\n");
            } else {
                System.out.printf("%s adlı müşteri silinmiştir.\n", checkString);
                if(tail == null && head == null ) {
                    System.out.printf("Liste boşaltıldı.\n", checkString);
                }
            }
        }
        System.out.println();
    }
}
