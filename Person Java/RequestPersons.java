/////////////////////////////////////////////////////////////////////////////////
// Angel G. Romero Rosario
// 801-18-2064
// This program asks the user the names and age of the persons it wants to create a database
// It later prints out all the persons in a orderly fashion
// Main
////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner; 


public class RequestPersons {
  public static void main(String[] args) {
    
    Scanner UserInput = new Scanner(System.in); //Create input reader

    System.out.println("Enter how many persons u want to enter into the database: ");  //Ask user 
    int quantity = UserInput.nextInt();         //Array size

    UserInput.nextLine();                       //Skips everything

    DBPerson[] People = new DBPerson[quantity]; //Create person object
    String Name; int Age=0;

    for(int i = 0; i < quantity ; i++, UserInput.nextLine()){

      Name = DBPerson.readName(UserInput); //Reads the person's name
      Age = DBPerson.readAge(UserInput);   //Reads the persons age
      People[i] = new DBPerson(Name, Age); //Create Object
    } 

    DBPerson.PrintDataBase(People); //Ask the user if it wants the DB to be printed

    UserInput.close();              //Close the input scanner

    System.out.println("End of program");
    System.out.println(" ");
  }
}
 