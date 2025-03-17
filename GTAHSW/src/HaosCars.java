import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HaosCars
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        HaosCars obj = new HaosCars();
        obj.setHSWCars();
        obj.setBonusWeekCars(scanner);
        obj.checkCars();
        obj.printCarsToBuy();
        scanner.close();
    }

    private ArrayList<String> HSWCars = new ArrayList<>();
    private ArrayList<String> bonusWeekCars = new ArrayList<>();
    private ArrayList<String> carsToBuy = new ArrayList<>();
    
    public ArrayList<String> setBonusWeekCars (Scanner input)
    {
        System.out.print("\nEnter the amount of cars you want to check: ");
        int choice = 1;
        choice = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= choice; i++)
        {
            System.out.print("Enter car name: " );
            String carName = input.nextLine();
            bonusWeekCars.add(carName);    
        }

        System.out.println("\nYou have entered: " + bonusWeekCars);
        return bonusWeekCars;
    }

    public void setHSWCars()
    {
        HSWCars.add("S95");
        HSWCars.add("AstronCustom");
        HSWCars.add("CycloneII");
        HSWCars.add("ArbiterGT");
        HSWCars.add("WeaponizedIgnus");
        HSWCars.add("TurismoClassic");
        HSWCars.add("SentinelXS");
        HSWCars.add("Banshee");
        HSWCars.add("HakuchouDrag");
        HSWCars.add("DevesteEight");
        HSWCars.add("BriosoR/A");
        HSWCars.add("StrilingGT");
        HSWCars.add("VigeroZX");
        HSWCars.add("EntityMT");
        HSWCars.add("IssiRally");
        HSWCars.add("ItaliGTOStingerTT");
        HSWCars.add("MonstroCiti");
        HSWCars.add("BuffaloEVX");
        HSWCars.add("LaCoureuse");
        HSWCars.add("VigeroZXConvertible");
        HSWCars.add("Vivanite");
        HSWCars.add("Niobe");
        HSWCars.add("EurosX32");
        HSWCars.add("BansheeGTS");
        HSWCars.add("FireboltASP");
    }

    public ArrayList<String> checkCars ()
    {
        Set<String> hswSet = new HashSet<>();

        for (String HSWCar : HSWCars)
        {
            hswSet.add(HSWCar.toLowerCase());
        }

        for (String bonusCar : bonusWeekCars)
        {
            if (hswSet.contains(bonusCar))
            {
                carsToBuy.add(bonusCar);
            }
        }

        return carsToBuy;
    }

    public void printCarsToBuy ()
    {
        if (carsToBuy.isEmpty())
        {
            System.out.println("\nNo HSW-Upgradable Cars With Discounts This Week.");
        }

        else
        {
            System.out.println("\nHSW-Upgradable Cars With Discounts This Week: " +  carsToBuy);
        }
    }
}
