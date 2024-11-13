public class GarbageCollectionCheck {
    public static void main(String[] args) {
        Algorithm obj;
        for(int i=0;i<1000000;i++)
        {
            obj = new Algorithm();
            System.out.println("Chal bey");
        }
    }
}
class Algorithm{
    public Algorithm()
    {
        System.out.println("Object is Created");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
