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
        obj.userInterface(scanner);
        scanner.close();
    }

    private ArrayList<String> HSWCars = new ArrayList<>(List.of("S95","AstronCustom","CycloneII","ArbiterGT",
    "WeaponizedIgnus","TurismoClassic","SentinelXS", "Banshee","HakuchouDrag","DevesteEight","BriosoR/A",
    "StrilingGT","VigeroZX","EntityMT","IssiRally","ItaliGTOStingerTT","MonstroCiti","BuffaloEVX",
    "LaCoureuse","VigeroZXConvertible","Vivanite","Niobe","EurosX32","BansheeGTS","FireboltASP"));
    private ArrayList<String> bonusWeekCars = new ArrayList<>();
    private ArrayList<String> carsToBuy = new ArrayList<>();

    public void userInterface (Scanner scanner)
    {
        while (true)
        {
            System.out.println("\nDiscounted HSW Cars");
            System.out.println("1. See HSW-Upgradable Car List.");
            System.out.println("2. Enter cars.");
            System.out.println("3. Exit.");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt())
            {
                int menuChoice = scanner.nextInt();
                switch (menuChoice)
                {
                    case 1:
                    System.out.println("\nHSW-Upgradable Cars: ");
                    System.out.println(HSWCars);
                    break;
    
                    case 2:
                    setBonusWeekCars(scanner);
                    checkCars();
                    printCarsToBuy();
                    break;
    
                    case 3:
                    return;
    
                    default:
                    System.out.println("Invalid option. Enter 1, 2, or 3. Try again.");
                }
            }
            else
            {
                System.out.println("Invalid option. Choice cannot contain non-numeric values. Try again.");
                scanner.next();
            }
        }
    }

    public ArrayList<String> setBonusWeekCars (Scanner scanner)
    {
        System.out.print("\nEnter the amount of cars you want to check: ");
        int bonusWeekCarsAmount = 1;
        
        while (true)
        {
            if (scanner.hasNextInt())
            {
                System.out.println("\nPlease enter car names in lowercase with no spaces.");
                bonusWeekCarsAmount = scanner.nextInt();
                scanner.nextLine();

                if (bonusWeekCarsAmount >= 0)
                {
                    for (int i = 1; i <= bonusWeekCarsAmount; i++)
                    {
                        System.out.print("Enter car name: ");
                        String carName = scanner.nextLine();
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
                scanner.next();
            }
        }

        System.out.println("\nYou have entered: " + bonusWeekCars);
        return bonusWeekCars;
    }

    public ArrayList<String> checkCars ()
    {
        HashSet<String> hswSet = new HashSet<>();

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
