package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // km bilgisini alan blok
        System.out.print("Mesafeyi km türünden giriniz: ");
        int km = input.nextInt();

        // yaş bilgisi alan blok
        System.out.print("Yaşınızı giriniz: ");
        int age = input.nextInt();

        // yolculuk tipi bilgisi alan blok
        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş): ");
        int type = input.nextInt();

        // km veya yaş 0 dan küçükse veya yolculuk tipi girdisi 1 veya 2 değilse kullanıcı hata mesajı alacak.
        if (km <= 0 || age <= 0 || (type != 1 && type != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
        } else {
            double base_amount = km * 0.10; // km başına 0.10 tl
            double discound_age = 0;

            // yaş indirimi hesabı
            if (age < 12)
                discound_age = base_amount * 0.50; //12 yaşından küçükse yüzde 50 indirim.
            else if (age >= 12 && age <= 24)
                discound_age = base_amount * 0.10; //12-24 yaş arası yüzde 10 indirim.
            else if (age > 65)
                discound_age = base_amount * 0.30; //65 yaşından büyükse yüzde 30 indirim.


            double new_amount = base_amount - discound_age; //tek yön uçuşlar için son fiyat hesaplaması

            // yolculuk tipine göre indirim hesaplayan blok
            if (type == 2) {
                double type_discount = new_amount * 0.20; //yüzde 20'lik gidiş dönüş bilet indirimi hesabı
                new_amount = (new_amount - type_discount) * 2; //indirim sonrası hem gidiş hem dönüş için toplam tutar hesabı.
            }

            System.out.println("Toplam Tutar = " + new_amount + " TL"); //toplam tutarı ekrana yazdıran kod bloğu
        }
    }
}
