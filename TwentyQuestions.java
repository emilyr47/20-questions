/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <raper003@umn.edu>
	main(String[] args)
	playLoop(Animal[] animals, Animal answer)
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/

import java.io.File;
import java.util.*;

public class TwentyQuestions
{
  private static Scanner a;

  public static void main(String[] args)
  {
    /*
      Please familiarize yourself with the methods
      available to you from Java's File class.
      https://docs.oracle.com/javase/7/docs/api/java/io/File.html

      Some of them you may find useful are:

      the constructor:
      File fileVar = new File("filepath");

      fileVar.listFiles();
      returns an array of File objects within the folder
      represented by "fileVar".
    */
    /*
			Step 1: open the animal folder "../animals"
			note that we are in the src folder, so the "../"
			first takes us back to the project4 directory, and then
			into the "animals" folder
		*/

		/*
			Step 2: make a new array of Animal objects to represent all
			of the .txt files we will read in. This is done similar to how you
			created an array of Rational2's in lab 9.

			Note that you CANNOT make any assumptions about the length of the
			array. I.e., you cannot assume there will only be "x" number of animals.
			You must figure out a way to get the number of .txt files in the "../animals"
			and make the array that length.
		*/

		/*
			Step 3: use a loop to initialize every array position to a new
			instance of the Animal class. Pass in a .txt file to the Animal
			constructor as you do.

			Note, it does not matter which order the .txt files end up in the
			array, so long as every .txt file corresponds to exactly one position
			in the array.
		*/

		/*
			Step 4: Print out some kind of welcome message and perhaps
			explain the rules a bit.
		*/

		/*
			Step 5: Either paste in the randomInt method from previous labs,
			or use Java's Random class to generate a random index for your
			animal array.

			Create a new Animal variable and set it equal to the array element
			at the aformentioned random index. This will be the "answer" that
			players are trying to guess.
		*/

		/*
			Step 6: Pass the animal array, and the answer into the playLoop method.
		*/

    File myFile = new File("../animals/");

    Animal[] arrayOfAnimal = new Animal[myFile.listFiles().length];
    for (int i = 0; i < arrayOfAnimal.length; i++) {
      arrayOfAnimal[i] = new Animal(myFile.listFiles()[i]);
    } // for
    System.out.println("Welcome to 20 Questions!");
    System.out.println("I am thinking of an animal in my head and you have to guess what it is within 20 questions.  They have to be yes or no questions.");
    System.out.println("Are you ready to start? Enter yes OR no");

    a = new Scanner(System.in);

    String strP = a.nextLine();
    while ((!strP.equals("no")) && (!strP.equals("yes")))
    {
      System.out.println("Enter yes OR no");
      strP = a.nextLine();
    } // while
    if (strP.equals("no"))
    {
      System.out.println("Bye");
      return;
    } // if
    int j = new Random().nextInt(arrayOfAnimal.length);
    playLoop(arrayOfAnimal, arrayOfAnimal[j]);
  } // main

  private static void playLoop(Animal[] animals, Animal answer)
  {
    int i = 20;
    if (a == null) {
      a = new Scanner(System.in);
    } // if
    while (i > 0)
    {
      System.out.println("Question " + (21 - i));
      if (i < 6)
      {
        System.out.println("You have" + i + " questions left");
      } // if
      System.out.println("What do you want to do?");
      System.out.println("1. Ask a relational question e.x. is it slower than, is it stronger than, etc.");
      System.out.println("2. Ask an existential question e.x. can it, does it, etc.");
      System.out.println("3. Make a guess");
      System.out.println("4. Search for an animal");
      System.out.println("5. Quit");

      String strP = a.nextLine();
      while ((!strP.equals("1")) && (!strP.equals("2")) && (!strP.equals("3")) && (!strP.equals("4")) && (!strP.equals("5")))
      {
        System.out.println("Enter one of the number options");
        strP = a.nextLine();
      } // while
      System.out.println("");
      if (strP.equals("5"))
      {
        System.out.println("Bye");
        return;
      } // if
      Object newObject;
      if (strP.equals("4"))// this doesn't count towards the user's 20 questions
      {
        System.out.println("Enter your animal");

        newObject = a.nextLine();

        int j = -1;
        for (int k = 0; k < animals.length; k++) {
          if (animals[k].getName().equals(newObject))
          {
            j = k;
            break;
          } // if
        } // for
        if (j < 0)
        {
          System.out.println("That animal is not in my library");
        } // if
        else
        {
          System.out.println(animals[j]);
        } // else
      } // if
      else if (strP.equals("3"))
      {
        System.out.println("Enter your guess");

        newObject = a.nextLine();
        if (answer.getName().equals(newObject))
        {
          System.out.println("Congrats.  The animal was actually " + (String)newObject);
          return;
        } // if
        System.out.println("Sorry that's not correct.  The animal you guessed was " + (String)newObject);
        i--;
      } // else if
      else if (strP.equals("2"))
      {
        ExistentialQuestion whatever = new ExistentialQuestion(animals, answer);
        if (whatever.AskQuestion()) {
          i--;
        } // if
      } // else if
      else
      {
        newObject = new RelationalQuestion(animals, answer);
        if (((RelationalQuestion)newObject).AskQuestion()) {
          i--;
        } // if
      } // else
    } // while
    System.out.println("You have already used all of your 20 questions.  Make one final guess:");
    if (answer.getName().equals(a.nextLine())) { // if the user's input is equal to the "answer" string
      System.out.println("Congrats.  You correctly guessed the animal");
    } // if
     else {
      System.out.println("Bummer, the correct animal was actually " + answer.getName());
      System.out.println("Thanks for playing, better luck next time.  Bye!");
    } // else
  } // playLoop
} // TwentyQuestions class
