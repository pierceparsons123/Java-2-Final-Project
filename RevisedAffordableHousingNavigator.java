package cs143.ppparsons;

import java.util.ArrayList;
import java.util.Scanner;




public class RevisedAffordableHousingNavigator {
  
 // list of housing programs
  
 static ArrayList<String> housingPrograms = new ArrayList<String>();
  
 // ZIP code lists for each area
 
  static ArrayList<String> everettZips = new ArrayList<String>();
 
 // stores king county zipcodes
 
static ArrayList<String> kingCountyZips = new ArrayList<String>();
 
 // store skagit county zip codes


 static ArrayList<String> skagitCountyZips = new ArrayList<String>();
 
  // saved favorite resources
  
 static ArrayList<String> favorites = new ArrayList<String>();
  
 public static void main(String[] args) {
       Scanner scnr = new Scanner(System.in);
       int choice = 0;
       
// load starting data
      
 initPrograms();
     // method containing everett zipcodes
  initEverettZips();
      // method containing king county zipcodes
 initKingCountyZips();
      // method containing skagit county zipcodes
 initSkagitCountyZips();
      // menu title for program
       System.out.println("**************************************************************");
       System.out.println("*               Affordable Housing Navigator                 *");
       System.out.println("**************************************************************");
      
 // main menu loop
 while (choice != 7) {
           System.out.println();	// displays menu options
           System.out.println("Main Menu");
           System.out.println("1. Rent Affordability Calculator");
           System.out.println("2. Browse Housing Assistance Programs");
           System.out.println("3. Housing Waitlist Estimator");
           System.out.println("4. Tenant Rights Information");
           System.out.println("5. Find Local Housing Resources");
           System.out.println("6. View Favorites");
           System.out.println("7. Exit");
           System.out.print("Enter your choice: ");
           choice = scnr.nextInt();
           scnr.nextLine();
      // statement for the menu for the user to choose which option they want to view .    
 switch (choice) {
               case 1:
                   rentCalculator(scnr); // sends user to the rent calculator 
                   break;
               case 2:
                   browsePrograms(scnr); // sends user to the to the housing assistance options 
                   break;
               case 3:
                   waitlistEstimator(scnr); // sends user to the waitlist section 
                   break;
               case 4:
                   tenantRights(scnr); //  sends user to the tenant rights section
                   break;
               case 5:
                   localResources(scnr); // sends user to the local resources section
                   break;
               case 6:
                   viewFavorites(); // user can view saved options.
                   break;
               case 7:
                   System.out.println("Thank you for using the program."); // ending prompt to user.
                   break;
               default:
                   System.out.println("Invalid choice."); // if the user doesn't input a valid choice.
           }
       }
       scnr.close();
   }
  
 // adds housing programs for the start of the program
   public static void initPrograms() {
       housingPrograms.add("Section 8 Housing Voucher");
       housingPrograms.add("Public Housing");
       housingPrograms.add("Emergency Rental Assistance");
       housingPrograms.add("Affordable Housing (LIHTC)");
       housingPrograms.add("Legal Aid / Tenant Advocacy");
   }
   // everett zip codes
   public static void initEverettZips() {
       everettZips.add("98201");
       everettZips.add("98203");
       everettZips.add("98204");
       everettZips.add("98206");
       everettZips.add("98207");
       everettZips.add("98208");
       everettZips.add("98213");
   }
   // sample King County ZIP codes
   public static void initKingCountyZips() {
       kingCountyZips.add("98101");
       kingCountyZips.add("98102");
       kingCountyZips.add("98103");
       kingCountyZips.add("98104");
       kingCountyZips.add("98105");
       kingCountyZips.add("98004");
       kingCountyZips.add("98052");
       kingCountyZips.add("98033");
       kingCountyZips.add("98057");
   }
   // sample skagit County ZIP codes
   public static void initSkagitCountyZips() {
       skagitCountyZips.add("98273");
       skagitCountyZips.add("98221");
       skagitCountyZips.add("98274");
       skagitCountyZips.add("98233");
       skagitCountyZips.add("98257");
       skagitCountyZips.add("98284");
   }
   // functionality 1 calculates affordable rent based on the user’s monthly income
   public static void rentCalculator(Scanner scnr) {
       double income;
       double rent;
       System.out.println();
       System.out.println("Rent Affordability Calculator");
       System.out.print("Enter your monthly income: ");
       income = scnr.nextDouble();
       scnr.nextLine();
       rent = income * 0.30;
       System.out.printf("Recommended maximum rent: $%.2f\n", rent);
   }
   // functionality 2 shows housing programs
   public static void browsePrograms(Scanner scnr) {
       int choice;  // variable for storing ussr input and used 
       System.out.println();
       System.out.println("Housing Assistance Programs");
       for (int i = 0; i < housingPrograms.size(); i++) {
           System.out.println((i + 1) + ". " + housingPrograms.get(i));
       }
       System.out.print("Choose a program number or 0 to return: ");
       choice = scnr.nextInt(); // key board input variable.
       scnr.nextLine();
     // if statement checking 
  if (choice == 0) {
           return;
       }
       else if (choice >= 1 && choice <= housingPrograms.size()) {
           System.out.println("You selected: " + housingPrograms.get(choice - 1));
       }
       else {
           System.out.println("Invalid selection.");
       }
   }
   // functionality 3: estimates wait time for housing based on the placements per month and the amount
   // of applicants ahead of the user
   public static void waitlistEstimator(Scanner scnr) {
       int applicants; // variable to store choice from user number 
       int placements; // variable to store how many placements
       double months; // variable to user chosen months
      // menu of options for waitlist
 System.out.println();
       System.out.println("Housing Waitlist Estimator");
       System.out.print("Applicants ahead of you: ");
       applicants = scnr.nextInt();
       System.out.print("Placements per month: ");
       placements = scnr.nextInt();
       scnr.nextLine();
       if (placements > 0) {
           months = (double) applicants / placements;
           System.out.printf("Estimated wait time: %.1f months\n", months);
       }
       else {
           System.out.println("Placements must be greater than 0.");
       }
   }
   // functionality 4: tenant rights info
   public static void tenantRights(Scanner scnr) {
       int choice = 0;
       while (choice != 5) {
           System.out.println(); // prints subjects on the grounds of tenant rights
           System.out.println("Tenant Rights Information");
           System.out.println("1. Repairs");
           System.out.println("2. Evictions");
           System.out.println("3. Fair Housing");
           System.out.println("4. Security Deposits");
           System.out.println("5. Return");
           System.out.print("Choose a topic: ");
           choice = scnr.nextInt();
           scnr.nextLine();
           if (choice == 1) { // prints details for any requested tenant rights subject
               System.out.println("Landlords must maintain safe housing.");
           }
           else if (choice == 2) {
               System.out.println("Evictions require legal notice.");
           }
           else if (choice == 3) {
               System.out.println("Housing discrimination may be illegal.");
           }
           else if (choice == 4) {
               System.out.println("Security deposits may require itemized deductions.");
           }
           else if (choice == 5) {
               System.out.println("Returning to main menu.");
           }
           else {
               System.out.println("Invalid choice.");
           }
       }
   }
   // functionality 5: finds local resources by region
   public static void localResources(Scanner scnr) {
       String zip;
       String save;
       int choice;
       System.out.println();
       System.out.print("Enter ZIP code: ");
       zip = scnr.nextLine();
       // Everett section
// using if/else statements to check uhsers input
       if (everettZips.contains(zip)) { // prints resources for any requested everett zipcode
           System.out.println("Everett Housing Resources:");
           System.out.println("1. Everett Housing Authority");
           System.out.println("2. Housing Hope");
           System.out.println("3. Catholic Community Services");
           System.out.println("4. Snohomish County Human Services");
           System.out.print("Do you want to save one to favorites? (yes/no): ");
           save = scnr.nextLine();
           if (save.equalsIgnoreCase("yes")) { // If requested, adds an everett resource to favorites
               System.out.print("Enter the number: ");
               choice = scnr.nextInt();
               scnr.nextLine();
               if (choice == 1) {
                   favorites.add("Everett Housing Authority");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 2) {
                   favorites.add("Housing Hope");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 3) {
                   favorites.add("Catholic Community Services");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 4) {
                   favorites.add("Snohomish County Human Services");
                   System.out.println("Saved to favorites.");
               }
               else {
                   System.out.println("Invalid number.");
               }
           }
       }
       // King County section
       else if (kingCountyZips.contains(zip)) { // prints resources for any requested king county zipcode
           System.out.println("King County Housing Resources:");
           System.out.println("1. Seattle Housing Authority");
           System.out.println("2. King County 211");
           System.out.println("3. Solid Ground");
           System.out.println("4. Catholic Community Services");
           System.out.print("Do you want to save one to favorites? (yes/no): ");
           save = scnr.nextLine();
           if (save.equalsIgnoreCase("yes")) { // If requested, adds a king county resource to favorites
               System.out.print("Enter the number: ");
               choice = scnr.nextInt();
               scnr.nextLine();
               if (choice == 1) {
                   favorites.add("Seattle Housing Authority");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 2) {
                   favorites.add("King County 211");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 3) {
                   favorites.add("Solid Ground");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 4) {
                   favorites.add("Catholic Community Services");
                   System.out.println("Saved to favorites.");
               }
               else {
                   System.out.println("Invalid number.");
               }
           }
       }
       // Skagit County section
       else if (skagitCountyZips.contains(zip)) { // prints resources for any requested skagit county zipcode
           System.out.println("Skagit County Housing Resources:");
           System.out.println("1. Skagit Housing Authority");
           System.out.println("2. Community Action of Skagit County");
           System.out.println("3. Northwest Justice Project");
           System.out.println("4. Catholic Community Services");
           System.out.print("Do you want to save one to favorites? (yes/no): ");
           save = scnr.nextLine();
           if (save.equalsIgnoreCase("yes")) { // If requested, adds a skagit county resource to favorites
               System.out.print("Enter the number: ");
               choice = scnr.nextInt();
               scnr.nextLine();
               if (choice == 1) {
                   favorites.add("Skagit Housing Authority");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 2) {
                   favorites.add("Community Action of Skagit County");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 3) {
                   favorites.add("Northwest Justice Project");
                   System.out.println("Saved to favorites.");
               }
               else if (choice == 4) {
                   favorites.add("Catholic Community Services");
                   System.out.println("Saved to favorites.");
               }
               else {
                   System.out.println("Invalid number.");
               }
           }
       }
       else { // runs if a zipcode an invalid (unlisted) zipcode is entered 
           System.out.println("No resources found for that ZIP code.");
       }
   }
   // functionality 6: shows saved favorites
   public static void viewFavorites() {
       System.out.println();
       System.out.println("Favorites");
       if (favorites.size() == 0) {
           System.out.println("No favorites saved.");
       }
       else {
           for (int i = 0; i < favorites.size(); i++) {
               System.out.println((i + 1) + ". " + favorites.get(i));
           }
       }
   }
}

