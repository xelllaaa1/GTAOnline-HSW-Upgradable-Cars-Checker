import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;

public class HaosCars
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        HaosCars obj = new HaosCars();
        obj.setBonusWeekCars(scanner);
        obj.checkCars();
        obj.printCarsToBuy();
        scanner.close();
    }

    private ArrayList<String> HSWCars = new ArrayList<>(List.of("S95","AstronCustom","CycloneII","ArbiterGT",
    "WeaponizedIgnus","TurismoClassic","SentinelXS", "Banshee","HakuchouDrag","DevesteEight","BriosoR/A",
    "StrilingGT","VigeroZX","EntityMT","IssiRally","ItaliGTOStingerTT","MonstroCiti","BuffaloEVX",
    "LaCoureuse","VigeroZXConvertible","Vivanite","Niobe","EurosX32","BansheeGTS","FireboltASP"));
    private ArrayList<String> bonusWeekCars = new ArrayList<>();
    private ArrayList<String> carsToBuy = new ArrayList<>();
    
    public void setBonusWeekCarsLogic()
    {
        
    }

    public ArrayList<String> setBonusWeekCars (Scanner input)
    {
        System.out.print("\nEnter the amount of cars you want to check: ");
        int choice = 1;

        while (true)
        {
            if (input.hasNextInt())
            {
                choice = input.nextInt();
                input.nextLine();

                if (choice >= 0)
                {
                    for (int i = 1; i <= choice; i++)
                    {
                        System.out.print("Enter car name: ");
                        String carName = input.nextLine();
                        bonusWeekCars.add(carName);
                    }
                    
                    break;    
                }

                else
                {
                    System.out.println("Invalid input. Choice cannot be negative.");
                    System.out.print("Try again: ");
                }
            }
            else
            {
                System.out.println("Invalid input. Choice cannot contain non-numeric values."); 
                System.out.print("Try again: ");
                input.next();
            }
        }

        System.out.println("\nYou have entered: " + bonusWeekCars);
        return bonusWeekCars;
    }

    public ArrayList<String> checkCars ()
    {
        HashSet<String> hswSet = new HashSet<>(HSWCars);

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
