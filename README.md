# JavaProje2

Genel Problem Tanımı:
Çift bağlı liste (doubly linked list) veri yapısı kullanımına dayanan ve müşterilerin soyada göre
alfabetik sıralı olarak tutulduğu bir müşteri bilgi kayıt uygulaması geliştirilmesi istenmektedir. Bu
bağlamda aşağıda detaylı olarak verilen gereksinimleri karşılayacak Java kodlarını yazınız.

Gereksinimler:
Müşteri bilgi kayıt uygulamasında müşterilerin adı ve soyadları, adresleri ve telefon numaraları yer
almaktadır. Müşterilerin ad soyadını temsil etmek için String tipinde adSoyad, adres bilgisini temsil
etmek için String tipinde adres değişkenleri olacaktır. Müşterinin birden fazla telefon numarası
olabilir, bu nedenle müşterinin telefon numaraları bir “ArrayList” içinde saklanacaktır. Bu bilgilere
göre müşteriler için "CustomerInfo" isimli bir sınıf oluşturunuz. Bu sınıfta istediğiniz "constructor"
metot(lar), get/set metotları ve toString olması yeterlidir.

Yazacağınız düğüm ("Node") sınıfında çift bağlı liste için gerekli bağ sahaları yanı sıra
CustomerInfo sınıfı tipinde bir değişken tanımı da yapılacaktır.

NOT: Node sınıfını ayrı veya çift bağlı liste sınıfında iç sınıf (inner class) olarak yazmak açıklama
satırında belirtilmek üzere sizin tercihinize bırakılmıştır.

Çift Bağlı liste sınıfı ("DoublyLinkedList") yazmanız istenmektedir. Çift bağlı liste sınıfınızda, çift
bağlı liste kullanmanın olası avantajlarından yararlanabilmek için listenin başını (head) ve sonunu
(tail) temsil eden 2 değişken tanımlayınız. Çift bağlı liste sınıfında olması gereken metotlar aşağıda
anlatılan seçeneklerle bağlantılı olarak şunlardır:

* CustomerInfo sınıfı tipinde bir parametre alan ve soyada göre sıralı olacak şekilde listeye ekleme
yapan metot

* Adı ve soyadı verilen bir müşteriyi listede arayarak eğer varsa bu müşterinin bilgilerini yazdıran
metot

* Adı ve soyadı verilen müşterinin listeden silinmesini sağlayan silme metodu

* Tüm kayıtları artan alfabetik sırada (A’dan Z’ye) ekrana yazdıran metot

* Tüm kayıtları azalan alfabetik sırada (Z’den A’ya) ekrana yazdıran metot


Uygulamada kullanıcıya aşağıdaki seçenekler sunulmalıdır:

1) Aşağıda gösterilen biçimdeki ve customer.txt isimli metin dosyasından okuma yapılarak çift bağlı
liste bellekte oluşturulmalıdır. (Veriler virgül ile ayrılmıştır.)

NOT: Rehber isme göre alfabetik sıralı oluşturulacak olup, aynı isimde diğer bir kişi
geldiğinde soyada göre alfabetik sıralı olacak şekilde eklenecektir. Birden fazla isimli
kişilerde adSoyad değişkeninin içindeki son String soyadı temsil etmektedir.
customer.txt
Veli Tuz, 0 533 1111111, 0 232 1111111
Ali Can Kara, 0 554 2222222, 0 543 3333333, 0 312 1111111
Canan Demir, 0 216 4444444
…. gibi

2) Klavyeden tüm verileri girilen müşteri listeye alfabetik sıraya göre uygun olan pozisyona
eklenecektir. Diğer deyiş ile çift bağlı listeye ekleme yapılmış olacaktır.

3) Klavyeden adı ve soyadı girilen bir müşterinin bilgileri ekrana yazdırılacaktır.

4) Adı ve soyadı girilen müşteri listeden silinecektir. (Basitleştirme adına aynı isim ve soyada sahip
kişi olmadığı varsayılabilir.) Diğer deyiş ile çift bağlı listeden silme yapılmış olacaktır.

5) Listenin içindeki tüm kayıtlar artan alfabetik sırada (A’dan Z’ye) ekrana yazdırılacaktır.

6) Listenin içindeki tüm kayıtlar azalan sırada (Z’den A’ya) ekrana yazdırılacaktır.

7) ÇIKIŞ: Programdan çıkılacaktır.
