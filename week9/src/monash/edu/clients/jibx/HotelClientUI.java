package monash.edu.clients.jibx;

import java.util.Scanner;
import java.rmi.RemoteException;

/**
 * Write a description of class HotelClientUI here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotelClientUI {
  // instance variables - replace the example below with your own
  private HotelClient client;

  public static void main(String args[]) throws RemoteException {
    HotelClientUI ui = new HotelClientUI();
    ui.displayMenu();

  }

  /**
   * Constructor for objects of class HotelClientUI
   */
  public HotelClientUI() {
    client = new HotelClient();
  }

  public void displayMenu() {
    Scanner console = new Scanner(System.in);
    char choice = 'Z';
    String input = "";
    do {

      System.out.println("\n\t\tA. Cities\n");
      System.out.println("\n\t\tB. Hotels\n");
      System.out.println("\n\t\tC. Rates\n");
      System.out.println("\n\t\tX. Exit\n");
      System.out.print("\t\t");
      input = console.nextLine();
      if (input.trim().length() == 1)
        choice = input.charAt(0);
      else
        choice = 'Z';
      switch (choice) {
      case 'A':
      case 'a': {
        String[] cities = client.cities();
        for (int i = 0; i < cities.length; i++)
          System.out.println("\t\t" + cities[i]);
        break;
      }
      case 'B':
      case 'b': {
        System.out.print("\n\t\tPlease enter city: ");
        input = console.nextLine();
        String[] hotels = client.hotels(input);
        for (int i = 0; i < hotels.length; i++)
          System.out.println("\t\t" + hotels[i]);
        break;
      }
      case 'C':
      case 'c': {
        System.out.print("\n\t\tPlease enter hotel: ");
        input = console.nextLine();
        System.out.println("\t\t" + client.rates(input));
        break;
      }
      case 'X':
      case 'x': {
        System.out.println("\n\t\tGoodbye!");
        break;
      }
      default: {
        System.out.println("\n\t\tInvalid Input - please try again!");
      }
      }
    } while (choice != 'X' && choice != 'x');

  }

}
