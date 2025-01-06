import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int option;
        
        Car car=new Car("","",0,0,0);
        Motorcycle motor=new Motorcycle("","",0,0,0);
        User user=new User("","","");
        Motorcycle.ElectricScooter scooter=motor.new ElectricScooter("","",0,0,0);
        Bike bike=new Bike("","",0,0,0);
        
        Scanner keyboard=new Scanner(System.in);
        
        System.out.println("Araç kiralama uygulamasına hoşgeldiniz.\n");
        System.out.println("Kullanıcı bilgilerinizi giriniz:\n");
        user.createUser();
        System.out.println();
        
        System.out.println("1)Araba\n"
                                + "2)Motorsiklet\n"
                                    + "3)Elektirikli Scooter\n"
                                        + "4)Bisiklet\n");
        System.out.print("Kiralamak istediğiniz araç türünü seçiniz:");
        option=keyboard.nextInt();
        
        switch(option)
        {
            case 1:
                car.all();
                System.out.println();
                user.printInfo();
                car.priceInfo();
                break;
                
            case 2:
                motor.all();
                System.out.println();
                user.printInfo();
                motor.priceInfo();
                
                break;
                
            case 3:
                scooter.all();
                System.out.println();
                user.printInfo();
                scooter.priceInfo();
                
                break;
                
            case 4:
                bike.all();
                System.out.println();
                user.printInfo();
                bike.priceInfo();
                
                break;
        }
        keyboard.close();
    }
    
}