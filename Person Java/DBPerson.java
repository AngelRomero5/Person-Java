/////////////////////////////////////////////////////////////////////////////////
// Angel G. Romero Rosario
// 801-18-2064
// This program asks the user the names and age of the persons it wants to create a database
// It later prints out all the persons in a orderly fashion
// DBPerson
////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.util.InputMismatchException;

public class DBPerson extends Person {

    public DBPerson(String name) {          //Constructor
        super(name);                
    }

    public DBPerson(String name, int age){ //Constructor
		super(name);
		super.age = age;
	}

    //A function made for checking if the name input is correct
    //It accepts only alphabetic characters a ', '(coma), and a blank space
    public static Boolean readStr (StringBuffer word){

        for(int i = 0; i < word.length(); i++){

         if(!(Character.isAlphabetic(word.charAt(i)))){ //Alphabetic
 
            if(word.charAt(i) == ',' && word.charAt(i+1) == ' '){
                i++;
                continue; //Goes to next iteration, skips coma and space
                
            }
            else return false;
          }
        }
        return true;
    }


    //This function ask the user for the name and it saves it in the People array
    public static String readName (Scanner UserInput){

        Boolean failCheck = true;
        StringBuffer Name = new StringBuffer();

        try {

            cout("Enter name: ");                   //Ask first the person name
            Name.append(UserInput.nextLine());     //Save it on Name variable
            Name.insert(0, ", ");                  //Insert a coma and a space
            cout("Enter Last-Name: ");             //Ask the lastname
            Name.insert(0, UserInput.nextLine());  //Save it on Name variable
    
    
            if(readStr(Name)) return Name.toString(); //Return name variable
    
            else throw new InputMismatchException();
    
        }catch(InputMismatchException e){          //Throw exception if entered invalid character  
    
            while(failCheck){

              Name.delete(0, Name.length());        //Deletes content on Name variable
    
              cout("Wrong input. Enter a valid name and last-name: "); //Ask again the name
              Name.append(UserInput.nextLine());     //Save it on Name variable
              Name.insert(0, ", ");                  //Insert a coma and a space
              cout("Enter Last-Name: ");             //Ask the lastname
              Name.insert(0, UserInput.nextLine());  //Save it on Name variable
             
              if(readStr(Name)) {
                return Name.toString();            //Return name variable
              }
            }
            return " ";
          }
          //System.out.println(People.getName());
    }


    //Ask user for the person's name and saves it in age variable
    public static int readAge (Scanner UserInput){

          Boolean failCheck = true;
          int age = 0;
        
          while(failCheck){
        
            try{
              
              cout("Enter the age: ");    //Ask user for person name
              age = UserInput.nextInt();  //Saves it on age variable
              if(age % 1 == 0){           //If its a number, returns age
                return age;
              }
      
            }catch(InputMismatchException e){ //Throw exception
      
                UserInput.next();             //Skips entered bad input
                cout("Wrong input.");
            }
          }
          return 0;
    }

    
    //This function prints out all of the persons names and age stored
    //in the database in an orderly fashion
    public static void PrintDataBase(DBPerson People[]){

        Scanner input = new Scanner(System.in); //Input scanner

        //Ask user if it wants to print the data base info
        cout("Do you wish to print all the persons from the DB?[y, n]: ");
        String Response = input.nextLine();  //Saves it in Response
        String n = "-";                      //Table

        if(Response.equals("y") || Response.equals("Y")){ //If response is yess

            cout("\nPrinting Last Name, First Name and age: \n");
            cout(n.repeat(30));

            for(int i = 0; i < DBPerson.getNum(); i++){    //Print all the persons
                System.out.print(People[i].toString(i+1)); //Name
                System.out.print(" ");                     //Space between Name and age
                System.out.println(People[i].getAge());    //Age
            }
            cout(n.repeat(30));
        }
        input.close(); //Close input scanner
    }

    //String output function
    public static void cout (String line) {
        System.out.println(line);
    }
    
    //Prints the person's name
    public String toString(int i){
		return "Person " + i + ": " + name;
	}

}
