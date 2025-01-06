import java.util.Scanner;

public class User
{
    private String name;
    private String surname;
    private String phoneNum;
    
    Scanner keyboard=new Scanner(System.in);
    
    public User(String name, String surname, String phoneNum)
    {
        this.name=name;
        this.surname=surname;
        this.phoneNum=phoneNum;
    }
    
    public void createUser()
    {
        System.out.println("Kullanıcı oluşturuluyor.");
        System.out.print("Adınızı giriniz: ");
        this.name=keyboard.nextLine();
        System.out.println();
        System.out.print("Soyadınızı giriniz: ");
        this.surname=keyboard.nextLine();
        System.out.println();
        System.out.print("Telefon numaranızı giriniz: ");
        this.phoneNum=keyboard.nextLine();
        System.out.println();
    }
    
    public void printInfo()
    {
        System.out.println("Ad: "+name);
        System.out.println("Soyad: "+surname);
        System.out.println("Telefon numarasi: "+phoneNum);
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getPhoneNum() 
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) 
    {
        this.phoneNum = phoneNum;
    }
}