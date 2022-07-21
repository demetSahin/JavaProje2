package proje2;

import java.util.ArrayList;

public class CustomerInfo {
    private String adSoyad; //Müşterilerin ad soyadını temsil etmek için String tipinde adSoyad değişkeni
    private String adres; //Müşterilerin adresini temsil etmek için String tipinde adres değişkeni
    private ArrayList<String> numaralar; //Müşterilerin telefon numaralarını temsil etmek için ArrayList tipinde numaralar değişkeni

    public CustomerInfo(String adSoyad, String adres, ArrayList numaralar) { //id ve adSoyad değişkenlerini parametre olarak alan constructor metodu
        this.adSoyad = adSoyad;
        this.adres = adres;
        this.numaralar = numaralar;
    }

    public String getAdSoyad() { // adSoyad için getter
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) { // adSoyad için setter
        this.adSoyad = adSoyad;
    }

    public String getAdres() { // adres için getter
        return adres;
    }

    public void setAdres(String adres) { // adres için setter
        this.adres = adres;
    }
    
    public ArrayList getNumaralar() { // numaralar için getter
        return numaralar;
    }

    public void setNumaralar(ArrayList numaralar) { // adSoyad için setter
        this.numaralar = numaralar;
    }

    @Override
    public String toString() { // Bilgileri yazdırmak için Object sınıfındaki toString metodunu override ettik
        StringBuilder sb = new StringBuilder();
        sb.append("Müşteri { Adı Soyadı : ");
        sb.append(adSoyad);
        sb.append("; Adresi : ");
        sb.append(adres);
        sb.append("; Numara(lar) : ");
        int size = numaralar.size();
        for(int d = 0; d < size; d++) {
            sb.append(numaralar.get(d));
            if (d != size - 1 ) sb.append(", "); // virgülün en son numaradan sonra yer almaması için...
        }
        sb.append(" }\n");
        return sb.toString();
    }   
}