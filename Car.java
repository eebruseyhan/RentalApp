import java.util.Scanner;

public class Car extends Vehicle
{
    private String driverLicence;
    private double carPrice; 
    private int listNumber;
    private double hourFe;
    private double time;
    private String typeOfGear;
    private int input;
    private String response;
    final private double startingFee=2000.0;

    
    
    Scanner keyboard=new Scanner(System.in);
    
    public Car(String brand, String model, int year, int speed, double hourFe)
    {
        super(brand,model,year,speed,hourFe);
    }

    @Override
    public void rentProcess()
    {
        System.out.println("Araba kiralama işlemi başlatıldı.");
    }


    public void carList()
    {
        System.out.println();
        System.out.println("Araba listesi:");
        System.out.println("1)BMW M3");
        System.out.println("2)Audi A3");
        System.out.print("Hakkında bilgi alamk istediğiniz aracın numarasını giriniz:");
        listNumber=keyboard.nextInt();
    }
    
    public void carInfo()
    {
        System.out.println("Kiralanacak bütün araçların başlangıç ücreti "+startingFee+" TL dir");

        switch(listNumber)
        {
            case 1:
                System.out.println();
                Car car1=new Car("BMW","M3",2021,293,85.0);
                hourFe=85.0;
                typeOfGear="Manuel";
                System.out.println("Vites türü: "+typeOfGear);
                car1.showInfo("BMW","M3");
                
                break;
                
            case 2:
                System.out.println();
                Car car2=new Car("Audi","A3",2023,232,90.0);
                hourFe=90.0;
                typeOfGear="Otomatik";
                System.out.println("Vites türü: "+typeOfGear);
                car2.showInfo("Audi","A3",2023,232,90.0);
                
                break;
                
            default:
                System.out.println("Geçersiz giriş yaptınız.");
                
                break;
        }
    }
    
    @Override
    public double calculationPrice() {
        carPrice = startingFee + (time * hourFe);
        return carPrice;
    }

    public double calculationPrice(double time) {
        carPrice = startingFee + (time * this.hourFe);
        return carPrice;
    }
    
    public void driverLicenseCheck()
    {
        do{
            System.out.println();
        try{
            System.out.println("Ehliyet türünüzü giriniz.");
            driverLicence=keyboard.next();
            
            if(driverLicence.isEmpty())
            {
                throw new Case("Ehliyet türü boş olamaz!");
            }
            else if(!(driverLicence.equals("B")||driverLicence.equals("b")))
            {
                throw new Case("Geçersiz girdi! B/b dışındaki ehliyet türleri kabul edilmemektedir.");
            }
            else
            {
                System.out.println("Geçerli ehliyet türü.");
                break;
            }
        }
        catch(Case specialCase){
            System.out.println();
            System.out.println(specialCase.getMessage());
            }
        
            keyboard.nextLine();
            System.out.println();
            System.out.print("Bir daha denemek ister misiniz? (Evet için 'E/e' Hayir icin 'H/h'): ");
            response=keyboard.next();
            System.out.println();
        }while(response.equalsIgnoreCase("e"));
    }

    @Override
    public void discount()
    {
        System.out.println();
        System.out.println("Öğrencilere %25 indirim vardır.");
        System.out.print("Öğrenci iseniz 1, değilseniz 2 yazınız: ");
        input=keyboard.nextInt();
        
        switch(input)
        {
            case 1:
                this.carPrice*=0.75;
                System.out.println("İndirimli araba ücreti: "+this.carPrice);
                
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

    public void priceInfo()
    {
        System.out.println();
        System.out.println(this.carPrice +"TL tutan ücreti gönderiniz");
        System.out.println("Bizi tercih etttiğiniz için teşekkür ederiz.");
    }
    
    
    
    
    @Override
    public void all()
    {
        rentProcess();
        carList();
        carInfo();
        calculationPrice();
        driverLicenseCheck();

        System.out.print("Kullanmak istediğiniz süreyi saat cinsinden yazınız: ");
            double timeInput = keyboard.nextDouble();
            carPrice = calculationPrice(timeInput);
    
            System.out.println("Hesaplanan ücret: " + carPrice);
        
            
        discount();
    }
}