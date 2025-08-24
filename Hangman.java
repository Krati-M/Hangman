import java.util.*;

public class Hangman{
  private int lives;
  private String word;
  private ArrayList<String> lettersInWord = new ArrayList<String>();
  private ArrayList<String> lettersGuessed = new ArrayList<String>();
  private ArrayList<String> displayWord = new ArrayList<String>();
  private Scanner scanner;
  private Boolean won;
  
  public Hangman(String wordToGuess){
    word = wordToGuess;
    lives = 9;
    won = false;
    scanner = new Scanner(System.in);
    for(int i = 0;i < word.length(); i++){
      lettersInWord.add(word.substring(i, i+1));
      displayWord.add("_");
    }
  }

  public void round(){
    while(lives > 0 && displayWord.contains("_")){
      System.out.println("You have " + lives + " lives left.");
      System.out.print("Current Word: ");
      for(String i : displayWord){
        System.out.print(i + " ");
      }
      System.out.println(" ");
      System.out.print("Enter your guess: ");
      String guess = scanner.nextLine();
      boolean works = checkAns(guess);
      
      if(works){
        boolean guessed = false;
        for(int j = 0; j < lettersInWord.size(); j++){
          if(guess.equals(lettersInWord.get(j))){
            displayWord.set(j, guess);
            guessed = true;
          }
        }
        if(guessed == true){
          System.out.println("You guessed a letter!");
        }
        else{
          System.out.println("You didn't guess any letters.");
          lives--;
        }
        
        System.out.println(" ");
        lettersGuessed.add(guess);
        }
      }
    
      end();
  }

  public boolean checkAns(String guess){
      if(lettersGuessed.contains(guess)){
        System.out.println("You already guessed this letter. Guess another letter. :)");
        System.out.println(" ");
        return false;
      }
      return guess.length() == 1 && Character.isLetter(guess.charAt(0));
    }
  
  public void end(){
    if(lettersInWord.equals(displayWord)){
      System.out.println("You've guessed the word. Congrats!!");
    }
    else{
      System.out.println("You didn't guess the word. It was " + word + " :(");
    }
  }
}
