/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <raper003@umn.edu>
	AskQuestion()
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/

import java.util.*;
import java.util.Scanner;

public class RelationalQuestion extends Question
{
  RelationalQuestion(Animal[] animals, Animal answer)
  {
    super(animals, answer);
  }

  public boolean AskQuestion()
  {
    Scanner s = new Scanner(System.in);

    // offer the player choices
    System.out.println("What do you want to know?");
    System.out.println("\t1. Is it heavier than another animal?");
    System.out.println("\t2. Is it taller than another animal?");
    System.out.println("\t3. Is it longer than another animal?");
    System.out.println("\t4. Is it faster than another animal?");
    System.out.println("\t5. Is it heavier than <x> lbs");
    System.out.println("\t6. Is it taller than <x> feet");
    System.out.println("\t7. Is it longer than <x> feet");
    System.out.println("\t8. Is it faster than <x> mph?");
    System.out.println("\t9. Go back");

    // setting up what will happen for each option the user could enter:
    String strX = s.nextLine();
    while ((!strX.equals("1")) && (!strX.equals("2")) && (!strX.equals("3")) && (!strX.equals("4")) && (!strX.equals("5")) &&
      (!strX.equals("6")) && (!strX.equals("7")) && (!strX.equals("8")) && (!strX.equals("9")))
    {
      System.out.println("Enter a number 1-5"); // taking in user input
      strX = s.nextLine();
    }
    if (strX.equals("9")) { // Go Back
      return false;
    }
    int i = Integer.valueOf(strX).intValue();
    int j;
    if (i < 5)
    {
      System.out.println("Enter your animal to compare");

      j = getIndexByName(s.nextLine());
      while (j < 0)
      {
        System.out.println("I don't have that animal, try again");
        j = getIndexByName(s.nextLine());
      }
      if (i == 1) // Is it Heavier than another animal?
      {
        if (this.answer.getWeight() > this.animals[j].getWeight()) {
          System.out.println("The animal is heaver than a " + this.animals[j].getName());
        } else {
          System.out.println("The animal isn't heaver than a " + this.animals[j].getName());
        }
      }
      else if (i == 2) // Is it taller?
      {
        if (this.answer.getHeight() > this.animals[j].getHeight()) {
          System.out.println("The animal is taller than a " + this.animals[j].getName());
        } else {
          System.out.println("The animal ism't taller than a " + this.animals[j].getName());
        }
      }
      else if (i == 3) // Is it longer?
      {
        if (this.answer.getLength() > this.animals[j].getLength()) {
          System.out.println("It is longer than a " + this.animals[j].getName());
        } else {
          System.out.println("It't not longer than a " + this.animals[j].getName());
        }
      }
      else if (this.answer.getSpeed() > this.animals[j].getSpeed()) {
        System.out.println("The animal is faster than a " + this.animals[j].getName());
      } else {
        System.out.println("The animal isn't faster than a " + this.animals[j].getName());
      }
    }
    else
    {
      System.out.println("Please enter a value for x");
      while (!s.hasNextInt())
      {
        s.nextLine();
        System.out.println("Enter a value for x");
      }
      j = s.nextInt();

      if (i == 5) // Is it heavier than x lbs?
      {
        if (this.answer.getWeight() > j) {
          System.out.println("The animal is heaver than " + j + " pounds");
        } else {
          System.out.println("The animal is not heaver than " + j + " pounds");
        }
      }
      else if (i == 6) // is it taller then x feet?
      {
        if (this.answer.getHeight() > j) {
          System.out.println("The animal is taller than " + j + "feet");
        } else {
          System.out.println("The animal is not taller than " + j + "feet");
        }
      }
      else if (i == 7) // is it longer than x feet
      {
        if (this.answer.getLength() > j) {
          System.out.println("The animal is longer than " + j + "feet");
        } else {
          System.out.println("The animal is not longer than " + j + "feet");
        }
      }
      else if (this.answer.getSpeed() > j) {
        System.out.println("The animal is faster than " + j + " mph.");
      } else {
        System.out.println("The animal is not faster than " + j + " mph.");
      }
    }
    return true;
    /*
      Setup a new scanner to read input from the player

      If they typed in 9, then return false (this question should
      not count against the players 20).

      If they entered 1-4 then prompt the user to input the name of
      another animal to compare, and find its index using the "getIndexByName()"
      method inherited from Question.java.

      If they entered 5-8, prompt them to enter a value for x.

      Then call the appropriate functions of the "answer" variable,
      passing in x or the other animal as needed.

      Do the proper comparison relative to the inputs 1-8, and
      print the result to the terminal. Then return true.
    */
  }
}
