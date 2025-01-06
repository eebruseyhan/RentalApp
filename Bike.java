import java.util.Scanner;

public class Bike extends Vehicle {
    private double bikePrice; 
    private int listNumber;
    private double hourFe;
    private double time;
    final private double startingFee = 10.0;
    private int input;

    Scanner keyboard = new Scanner(System.in);

    public Bike(String brand, String model, int year, int speed, double hourFe) {
        super(brand, model, year, speed, hourFe);
    }

    @Override
    public void rentProcess() {
        System.out.println("Bisiklet kiralama işlemi başlatıldı.");
    }


    public void bikeList() {
        System.out.println();
        System.out.println("Bisiklet listesi:");
        System.out.println("1) Bianchi Sehir bisikleti");
        System.out.println("2) Carraro Dag bisikleti");
        System.out.print("Hakkında bilgi almak istediğiniz bisikletin numarasını giriniz: ");
        listNumber = keyboard.nextInt();
    }

    public void bikeInfo() {
        System.out.println("Kiralanacak bütün bisikletlerin başlangıç ücreti " + startingFee + " TL dir");

        switch (listNumber) {
            case 1:
                System.out.println();
                Bike bike1 = new Bike("Bianchi", "Şehir Bisikleti", 2021, 30, 10.0);
                hourFe = 10.0;
                bike1.showInfo("Bianchi", "Şehir Bisikleti");
                break;

            case 2:
                System.out.println();
                Bike bike2 = new Bike("Carraro", "Dağ Bisikleti", 2022, 20, 5.0);
                hourFe = 5.0;
                bike2.showInfo("Carraro", "Dağ Bisikleti", 2022, 20, 5.0);
                break;

            default:
                System.out.println("Geçersiz giriş yaptınız.");
                break;
        }
    }
   
    
    @Override
    public double calculationPrice() {
        bikePrice = startingFee + (time * hourFe);
        return bikePrice;
    }

    public double calculationPrice(double time) {
        bikePrice = startingFee + (time * this.hourFe);
        return bikePrice;
    }

    @Override
    public void discount() {
        System.out.println();
        System.out.println("Öğrencilere %25 indirim vardır.");
        System.out.print("Öğrenci iseniz 1, değilseniz 2 yazınız: ");
        input = keyboard.nextInt();

        switch (input) {
            case 1:
                this.bikePrice *= 0.75;
                System.out.println("İndirimli bisiklet ücreti: " + this.bikePrice);
                break;

            case 2:
                System.out.println("İndirim uygulanmamıştır.");
                break;

            default:
                System.out.println("Geçersiz giriş yaptınız.");
                break;
        }
    }

    @Override
    public void priceInfo() {
        System.out.println();
        System.out.println(this.bikePrice + " TL tutan ücreti gönderiniz.");
        System.out.println("Bizi tercih ettiğiniz için teşekkür ederiz.");
        
    }


    @Override
    public void all() {
            rentProcess();
            bikeList();
            bikeInfo();
    
            System.out.print("Kullanmak istediğiniz süreyi saat cinsinden yazınız: ");
            double timeInput = keyboard.nextDouble();
            bikePrice = calculationPrice(timeInput);
    
            System.out.println("Hesaplanan ücret: " + bikePrice);
            discount();
        }
    

    }

