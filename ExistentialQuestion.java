/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <raper003@umn.edu>
	AskQuestion()
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/

import java.util.*;
import java.util.Scanner;

public class ExistentialQuestion extends Question {

  ExistentialQuestion(Animal[] animals, Animal answer)
  {
    super(animals, answer);
  } // ExistentialQuestion

  public boolean AskQuestion()
  {
    Scanner s = new Scanner(System.in);

    // offer choices to player
    System.out.println("What do you want to know?");
    System.out.println("\t1. Does it have <x>?");
    System.out.println("\t2. Can it <x>?");
    System.out.println("\t3. Is it <x>?");
    System.out.println("\t4. Does it eat <x>?");
    System.out.println("\t5. Go back");

    // setting up what will happen for each option the user could enter:
    String strA = s.nextLine();
    while ((!strA.equals("1")) && (!strA.equals("2")) && (!strA.equals("3")) && (!strA.equals("4")) && (!strA.equals("5")))
    {
      System.out.println("Enter a number 1-5"); // taking in user input
      strA = s.nextLine();
    } // while
    if (strA.equals("5")) { // go back
      return false;
    } // if
    System.out.println("Enter something for x");
    String strB = s.nextLine();

    if (strA.equals("1")) // does it have x?
    {
      if (this.answer.hasX(strB)) {
        System.out.println("The animal has " + strB);
      } // if
      else {
        System.out.println("The animal doesn;t have " + strB);
      } // else
    } // if
    else if (strA.equals("2")) // can it x?
    {
      if (this.answer.canX(strB)) {
        System.out.println("The animal can" + strB);
      } // if
      else {
        System.out.println("The animal can't " + strB);
      } // else
    } // else if
    else if (strA.equals("3")) // is it x?  The user is not guessing the animal here, they are simply asking a specific is it question (e.g. is it black?)
    {
      if (this.answer.isX(strB)) {
        System.out.println("The animal is " + strB);
      } // if
      else {
        System.out.println("The animal is not " + strB);
      } // else
    } // else if
    else if (this.answer.eatsX(strB)) { // does it eat x?
      System.out.println("The animal eats these things: " + strB);
    } // else if
    else {
      System.out.println("The animal does not eat " + strB);
    } // else
    return true;

    /*
      Setup a new scanner to read input from the player

      If they typed in 5, then return false (this question should
      not count against the players 20).

      otherwise, prompt the user to enter an input for x and
      call the appropriate functions of the "answer" variable,
      passing in x.

      Print the result to the terminal, and return true.

      Hint: if the user typed in 3, then you will probably need to call
      answer.isX(something here);
    */
  } // AskQuestion
} // ExistentialQuestion class
