import java.util.Scanner;

public class Motorcycle extends Vehicle
{
    private String driverLicence;
    private double motorPrice;
    private int listNumber;
    private double hourFe;
    private double time;
    private String typeOfGear;
    private int input;
    private String response;
    final private double startingFee=1000.0;
    
    Scanner keyboard=new Scanner(System.in);
    
    public Motorcycle(String brand, String model, int year, int speed, double hourFe)
    {
        super(brand,model,year,speed,hourFe); 
    }

    @Override
    public void rentProcess()
    {
        System.out.println("Motorsiklet kiralama işlemi başlatıldı.");
    }
    
    public void motorcycleList()
    {
        System.out.println();
        System.out.println("Motor listesi:");
        System.out.println("1)Honda PCX"); 
        System.out.println("2)BMW S1000RR");
        System.out.print("Hakkında bilgi almak istediğiniz motorun numarasını giriniz:");
        listNumber=keyboard.nextInt();
    }
    
    public void motorcycleInfo()
    {
        System.out.println("Kiralanacak bütün motorsikletlerin başlangıç ücreti "+startingFee+" TL dir");
        
        switch(listNumber)
        {
            case 1:
                System.out.println();
                Motorcycle motorcycle1=new Motorcycle("Honda","PCX",2024,108,350.0);
                motorcycle1.showInfo("Honda","PCX");
                hourFe=350.0;
                typeOfGear="Otomatik";
                System.out.println("Vites türü: "+typeOfGear);
                
                break;
                
            case 2:
                System.out.println();
                Motorcycle motorcycle2=new Motorcycle("BMW","S1000RR",2023,305,200.0);
                motorcycle2.showInfo("BMW","S1000RR",2023,305,350.0);
                hourFe=200;
                typeOfGear="Manuel";
                System.out.println("Vites türü: "+typeOfGear);
                
                break;
                
            default:
                System.out.println();
                System.out.println("Geçersiz giriş yaptınız!");
                System.exit(0);
        }
    }
    
    
    @Override
    public double calculationPrice() {
        motorPrice = startingFee + (time * hourFe);
        return motorPrice;
    }

    public double calculationPrice(double time) {
        motorPrice = startingFee + (time * this.hourFe);
        return motorPrice;
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
            else if(!(driverLicence.equals("A")||driverLicence.equals("a")))
            {
                throw new Case("Geçersiz girdi! A/a dışındaki ehliyet türleri kabul edilmemektedir.");
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
            System.out.print("Bir daha denemek ister misiniz? (Evet için 'E/e' Hayır için 'H/h'): ");
            response=keyboard.next();
            System.out.println();
        }while(response.equalsIgnoreCase("e"));
    }

    @Override
    public void discount()
    {
        System.out.println();
        System.out.println("Öğrencilere %25 indirim vardır.");
        System.out.print("Öğrenci iseniz 1, degilseniz 2 yazınız: ");
        input=keyboard.nextInt();
        
        switch(input)
        {
            case 1:
                this.motorPrice*=0.75;
                System.out.println("İndirimli motorsiklet ücreti: "+this.motorPrice);
                
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
        System.out.println(this.motorPrice +"TL tutan ücreti gönderiniz");
        System.out.println("Bizi tercih etttiğiniz için teşekkür ederiz.");
    }
    

    
   
    
    @Override
    public void all()
    {
        rentProcess();
        motorcycleList();
        motorcycleInfo();
        calculationPrice();
        driverLicenseCheck();

        System.out.print("Kullanmak istediğiniz süreyi saat cinsinden yazınız: ");
        double timeInput = keyboard.nextDouble();
        motorPrice = calculationPrice(timeInput);

        System.out.println("Hesaplanan ücret: " + motorPrice);

        discount();
    }
    
    public class ElectricScooter extends Vehicle
    {
        private double scooterPrice;
        private int number;
        private double hourFe;
        private double time;
        private int input;
        final private double startingFee=250.0;
        
        
        Scanner keyboard= new Scanner(System.in);
        
        public ElectricScooter(String brand, String model, int year, int speed, double hourFe)
        {
            super(brand,model,year,speed,hourFe);
        }

        @Override
        public void rentProcess()
        {
            System.out.println("Elektrikli scooter kiralama işlemi başlatıldı.");
        }

        public void scooterList()
        {
            System.out.println();
            System.out.println("Elektrikli scooter listesi:");
            System.out.println("1)Onvo OV-RX1"); 
            System.out.println("2)Xiaomi 4 Ultra");
            System.out.print("Hakkında bilgi almak istediğiniz scooterın numarasını giriniz:");
            number=keyboard.nextInt();
        }
        
        public void scooterInfo()
        {                    
            Motorcycle motor=new Motorcycle("","",0,0,0);
            System.out.println("Kiralanacak bütün elektrikli scooterlerın başlangıç ücreti "+startingFee+" TL dir");
            
            switch(number)
            {
                case 1:
                    System.out.println();
                    Motorcycle.ElectricScooter scooter1=motor.new ElectricScooter("Onve","OV-RX1",2022,45,50.0);
                    scooter1.showInfo("Onve","OV-RX1");
                    hourFe=50.0;
                    
                    break;
                
                case 2:
                    System.out.println();
                    Motorcycle.ElectricScooter scooter2=motor.new ElectricScooter("Xiaomi","4 Ultra",25,2024,55.0);
                    scooter2.showInfo("Xiaomi","4 Ultra",2024,25,55.0);
                    hourFe=55.0;
                    
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Geçersiz giriş yaptınız!");
                    System.exit(0);
            }
        }
        
       @Override
        public double calculationPrice() {
        scooterPrice = startingFee + (time * hourFe);
        return scooterPrice;
        }

        public double calculationPrice(double time) {
        scooterPrice = startingFee + (time * this.hourFe);
        return scooterPrice;
        }
        
        @Override
        public void discount()
        {
            System.out.println();
            System.out.println("Öğrencilere %25 indirim vardır.");
            System.out.print("Öğrenci iseniz 1, degilseniz 2 yazınız: ");
            input=keyboard.nextInt();
        
            switch(input)
            {
                case 1:
                    this.scooterPrice*=0.75;
                    System.out.println("İndirimli elektrikli scooter ücreti: "+this.scooterPrice);
                
                    break;
                
                case 2:
                    System.out.println("İndirim uygulanmamıştır.");
                
                    break;
                
                default:
                    System.out.println("Geçersiz giriş yaptınız.");
                
                    break;
            }
        }
    
        public void priceInfo()
        {
            System.out.println(this.scooterPrice +"TL tutan ücreti gönderiniz");
            System.out.println("Bizi tercih etttiğiniz için teşekkür ederiz.");
        }
        
       
        
        @Override
        public void all()
        {
            rentProcess();
            scooterList();
            scooterInfo();
            calculationPrice();

            System.out.print("Kullanmak istediğiniz süreyi saat cinsinden yazınız: ");
            double timeInput = keyboard.nextDouble();
            scooterPrice = calculationPrice(timeInput);
    
            System.out.println("Hesaplanan ücret: " + scooterPrice);
    

            discount();
        }
    }
}