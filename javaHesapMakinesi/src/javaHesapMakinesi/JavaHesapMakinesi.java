package javaHesapMakinesi;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaHesapMakinesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sayi1, sayi2, sonuc = 0;
        char operator;
        boolean devamEt = true;
        
        Map<String, Double> islemGecmisi = new HashMap<>();
        
        while(devamEt) {
            System.out.print("İlk sayıyı girin: ");
            sayi1 = scanner.nextDouble();
            System.out.print("İkinci sayıyı girin: ");
            sayi2 = scanner.nextDouble();
            System.out.print("Bir işlem seçin (+, -, *, /, ^, mod, sqrt, date, convert) veya çıkmak için 'q' tuşuna basın: ");
            operator = scanner.next().charAt(0);
            
            switch(operator) {
                case '+':
                    sonuc = sayi1 + sayi2;
                    break;
                case '-':
                    sonuc = sayi1 - sayi2;
                    break;
                case '*':
                    sonuc = sayi1 * sayi2;
                    break;
                case '/':
                    if(sayi2 == 0) {
                        System.out.println("Sıfıra bölme hatası!");
                        continue;
                    }
                    sonuc = sayi1 / sayi2;
                    break;
                case '^':
                    sonuc = Math.pow(sayi1, sayi2);
                    break;
                case 'm':
                    sonuc = sayi1 % sayi2;
                    break;
                case 's':
                    sonuc = Math.sqrt(sayi1);
                    break;
                case 'd':
                    System.out.print("Tarih aralığı belirleyin (örn: 21.04.2023-22.04.2023): ");
                    String tarihAraligi = scanner.next();
                    String[] tarihler = tarihAraligi.split("-");
                    if(tarihler.length != 2) {
                        System.out.println("Geçersiz tarih aralığı!");
                        continue;
                    }
                    String tarih1 = tarihler[0];
                    String tarih2 = tarihler[1];
                    long gunSayisi = gunSayisiHesapla(tarih1, tarih2);
                    System.out.println(tarihAraligi + " arasında " + gunSayisi + " gün var.");
                    break;
                case 'c':
                    System.out.print("Dönüştürme işlemi seçin (1: Celcius to Fahrenheit, 2: Fahrenheit to Celcius): ");
                    int secim = scanner.nextInt();
                    if(secim != 1 && secim != 2) {
                        System.out.println("Geçersiz seçim!");
                        continue;
                    }
                    if(secim == 1) {
                        sonuc = celciusToFahrenheit(sayi1);
                        System.out.println(sayi1 + " °C = " + sonuc + " °F");
                    } else {
                        sonuc = fahrenheitToCelcius(sayi1);
                                                System.out.println(sayi1 + " °F = " + sonuc + " °C");
                    }
                    break;
                case 'q':
                    devamEt = false;
                    break;
                default:
                    System.out.println("Geçersiz işlem seçimi!");
                    continue;
            }
            
            System.out.println("Sonuç: " + sonuc);
            String islem = sayi1 + " " + operator + " " + sayi2 + " = " + sonuc;
            islemGecmisi.put(islem, sonuc);
        }
        
        if(islemGecmisi.size() > 0) {
            System.out.println("Yapılan işlemler:");
            for(Map.Entry<String, Double> entry : islemGecmisi.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
        
        scanner.close();
    }
    
    public static long gunSayisiHesapla(String tarih1, String tarih2) {
                return 0;
    }
    
    public static double celciusToFahrenheit(double celcius) {
        return (celcius * 9 / 5) + 32;
    }
    
    public static double fahrenheitToCelcius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

                       
