public abstract class Vehicle
{
    private String brand; 
    private String model;
    private int year;
    private int speed;

    public abstract double calculationPrice();
    public abstract void priceInfo();
    public abstract void all();
    public abstract void rentProcess();
    public abstract void discount();

    public Vehicle(String brand, String model, int year, int speed, double hourFe)
    {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = speed;
    }

    public void showInfo(String brand, String model){
        System.out.println("Marka: " + brand);
        System.out.println("Model: " + model);
    }


    public void showInfo(String brand, String model, int year, int speed, double hourFe){
        System.out.println("Marka: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Yil: " + year);
        System.out.println("En yuksek hiz: " + speed);
        System.out.println("Saatlik fiyati: "+ hourFe);
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
}