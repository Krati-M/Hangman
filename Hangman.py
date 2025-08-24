def Hangman(word):
  #All the varibles and lists
  letters = []
  lives = 9
  game_over = False
  game_won = False
  letters_guessed = []
  spaced_letters = []
  guessed = 0
  word.lower()
  
  print("Hello! Welcome to Hangman.")
  
  #Making the word lists
  for i in range(len(word)):
    letters.append(word[i])
  for i in letters:
      spaced_letters.append("_")
    
  while game_over == False or game_won == False:
    guessed = 0
    
    #Start of each round
    for i in spaced_letters:
      print(i, end = " ")
    print("\nYou have " + str(lives) + " lives.")
    guess = input("Guess: ")
    
    #Check if the guessed letter is correct or incorrect
    if guess in letters:
      if guess in spaced_letters:
        print("You already guessed this letter correctly.")
      else: 
        print(guess, "is in the word.")
        for i in range(len(letters)):
          if letters[i] == guess:
            spaced_letters[i] = guess;
    elif guess.isalpha() == False or len(guess) > 1:
      print("Make sure to put one letter only.")
    else:
      if guess not in letters_guessed:
        letters_guessed.append(guess)
        print("Sorry! That is not in the word.")
        lives -= 1
      else: 
        print("You already guessed this")
        
    #Checking if the player has won or lost in this round   
    for i in range(len(letters)):
      if letters[i] == spaced_letters[i]:
        guessed += 1
    if guessed == len(letters):
      return print("YOU WON!! The word was", word)
      game_won = True
    if lives == 0:
      return print("YOU LOST!! The word was", word)
      game_over = True
      
print(Hangman("Plane"))
