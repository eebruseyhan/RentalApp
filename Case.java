public class Case extends Exception
{
    public Case()
    {
        System.out.println("Geçersiz bir giriş yaptınız.");
    }
    
    public Case(String message)
    {
        super(message);
    }
}