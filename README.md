# SlotMachineSimulation
A slot machine is a gambling device that the user inserts money into then pulls a lever (or presses a button). The slot machine then displays a set of random images. If two or more of the images match, the user wins an amount of money that the slot machine dispenses back to the user.
 This is a program  that simulates a slot machine. The program  contains at 3 methods in addition to the main method – one void method and one value-returning method – . When the program runs, it  does  the following:
• Ask the user to enter the amount of money he or she chooses to bet into the slot machine. You should validate this input to make sure the user enters a positive value for the bet amount.
• Instead of displaying images, the program will randomly select a word from the following list: Cherries, Oranges, Grapes, Lemons, Bars, Sevens. To select a word, the program will generate a random number in the range of 0 through 5. If the number is 0, the selected word is Cherries; if the number is 1, the selected word is Oranges; and so forth. The program should randomly select a word from this list three times and display all three of the words.
• If none of the randomly selected words match, the program will inform the user that he or she has won $0. If two of the words match, the program will inform the user that he or she has won two times the amount entered. If three of the words match and they are something other than sevens, the program will inform the user that he or she has won three times the amount entered. If three of the words match and they are sevens, the program will inform the user that he or she has won five times the amount entered.
• The program  asks whether or not the user wants to play again. If so, these steps are repeated. If not, the program displays the total amount of money entered into the slot machine for this session, the total amount won this session, and the net loss/gain.
• In addition, the program  keeps a record of the highest gain ever achieved while playing the game. The value will be written to a file between game sessions, so that it can be read from the file with each new session. If the user exceeds the record gain, a message indicating this is a record gain should be displayed, the value of the previous record gain should be displayed, and the new record gain should be stored. (Hint: If the file doesn’t exist, no record has been set yet.)
