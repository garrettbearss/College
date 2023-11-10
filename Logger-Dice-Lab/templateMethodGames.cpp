// Garrett Bearss
// templateMethodGames.cpp
// 3/9/2023
// Games, Template Method example
// Mikhail Nesterenko
// 2/4/2014

#include <ctime>
#include <cstdlib>
#include <iostream>

using std::cout; 
using std::cin;
using std::endl;
using std::string;

// template for any game where players take 
// turns to make moves
// and there is a winner
class Game{
public:
   Game():playersCount_(0), movesCount_(0), playerWon_(noWinner){}

   // template method
   void playGame(const int playersCount = 0) {
      playersCount_ = playersCount;
      movesCount_=0;

      initializeGame();

      for(int i=0; !endOfGame(); i = (i+1) % playersCount_ ){
	 makeMove(i);
	 if (i==playersCount_-1) 
	    ++movesCount_; 
      }
      printWinner();
   }

   virtual ~Game(){}

protected:
   // primitive operations
   virtual void initializeGame() = 0;
   virtual void makeMove(int player) = 0;
   virtual void printWinner() = 0;
   virtual bool endOfGame() { return playerWon_ != noWinner;} // this is a hook
                   // returns true if winner is decided
   static const int noWinner=-1;

   int playersCount_;
   int movesCount_;
   int playerWon_;
};

// Monopoly - a concrete game implementing primitive 
// operations for the template method
class Monopoly: public Game {
public:  
   // implementing concrete methods
   void initializeGame(){
      playersCount_ = rand() % numPlayers_ + 1 ; // initialize players
   }

   void makeMove(int player) {
      if (movesCount_ > minMoves_){ 
	 const int chance = minMoves_ + rand() % (maxMoves_ - minMoves_);
	 if (chance < movesCount_) playerWon_= player;
      }
   }

   void printWinner(){
      cout << "Monopoly, player "<< playerWon_<< " won in "
	   << movesCount_<< " moves." << endl;
   }

private:
   static const int numPlayers_ = 8; // max number of players
   static const int minMoves_ = 20; // nobody wins before minMoves_
   static const int maxMoves_ = 200; // somebody wins before maxMoves_
};

// Chess - another game implementing
// primitive operations
class Chess: public Game {
public:
   void initializeGame(){
      playersCount_ = numPlayers_; // initalize players
      for(int i=0; i < numPlayers_; ++i) 
	     experience_[i] = rand() % maxExperience_ + 1 ; 
   }

   void makeMove(int player){
      if (movesCount_ > minMoves_){
	 const int chance = (rand() % maxMoves_) / experience_[player];
	 if (chance < movesCount_) playerWon_= player;
      }
   }

   void printWinner(){
      cout << "Chess, player " << playerWon_ 
	   << " with experience " << experience_[playerWon_]
	   << " won in "<< movesCount_ << " moves over"
	   << " player with experience " << experience_[playerWon_== 0 ? 1:0] 
           << endl;
   }

private:
   static const int numPlayers_ = 2;
   static const int minMoves_ = 2; // nobody wins before minMoves_
   static const int maxMoves_ = 100; // somebody wins before maxMoves_
   static const int maxExperience_ = 5; // player's experience
                              // the higher, the greater probability of winning
   int experience_[numPlayers_]; 
};

class Dice:public Game{
  public:
  // Initalizes the private variables of Game
  void initializeGame(){
    // Sets the player count to 2
    playersCount_ = numPlayers_;
  }

  // Rolls 5 dice and prints the total to the player in the sequence they were rolled
  void roll(int &currentScore, string playerRolling, string theirScore){
    int score = 0;
    cout << playerRolling; 
    // Randonly generate 5 values, printing each one out and adding it to the score of the current player
    for(int i = 0; i < 5; ++i){
      int roll = rand() % 6 + 1;
      score += roll;
      cout << roll << " ";
    }
    cout << ", " << theirScore << "= " << score << endl;
    currentScore = score;
  }

  // Checks to see if the max round has been reached, if not then roll for each player
  void makeMove(int player){
    // Returns if the max round has been reached
    if(movesCount_ >= maxMoves_){
      maxTurnsReached = true;
      return;
    }
    // Prints the start of a round
    if(player == comp){
      cout << "Round " << movesCount_+1 << ": ";
    }
    // If the player wants to roll during a turn
    if(player == user && !userTurnEnded){
      roll(playerScore, "You rolled: ", "your score ");
    }
    // If the computer wants to roll during a turn
    else if(player == comp && !computerTurnEnded){
      roll(computerScore, "Computer rolled: ", "computer's score ");
    }
    // If the computer had passed in a previous round
    else if(player == comp && computerTurnEnded){
      cout << "Computer rolled: passed" << endl; 
    }
    // If the current round isn't the last round
    if(movesCount_ < maxMoves_ - 1){
      // Randomly determines if the computer ends it's turn
      if(player == comp && !computerTurnEnded){
        computerTurnEnded = rand() % 2;
      }
      // Prompts the user to ask weither or not they want to take another turn
      if(player == user && !userTurnEnded){
        cout << "Roll again? [y/n] ";
        char again; 
        cin >> again;
        userTurnEnded = again != 'y';
        cout << endl;
      }
    }
  }

  // Prints to the user weither they won or lost the game
  void printWinner(){
    // If the player score is higher than the computer score, you win
    if(playerScore > computerScore){
      cout << "You won!" << endl;
    }
    // If the computer score is higher than the player score, you lose
    else{
      cout << "You lose!" << endl;
    }
  }

  // Checks to see if the end of the game has been reached
  bool endOfGame(){
    // Returns true if there is a winner, the max turn was reached, or both players have ended their turn
    return (playerWon_ != noWinner) || maxTurnsReached || (userTurnEnded && computerTurnEnded);
  }

  private:
  // Sets the computer to be the first player
  const int comp = 0;
  // Sets the user to be the second player
  const int user = 1;
  // Sets the number of players in the game to 2
  static const int numPlayers_ = 2;
  // Sets the number of min turns to be 1
  static const int minMoves_ = 1;
  // Sets the number of max turns to be 3
  static const int maxMoves_ = 3;
  // Sets the user's start score to 0
  int playerScore = 0;
  // Sets the computer's start score to 0
  int computerScore = 0;
  // Keeps track to see if the game has reached round 3
  bool maxTurnsReached = false;
  // Keeps track to see if the user has passed
  bool userTurnEnded = false;
  // Keeps track to see if the computer has passed
  bool computerTurnEnded = false;
};

int main() {
   srand(time(nullptr));

   Game* gp = nullptr;

   /*
   // play chess 8 times
   for (int i = 0; i < 8; ++i){ 
      gp = new Chess;
      gp->playGame(); 
      delete gp;
   }
      

   // play monopoly 8 times
   for (int i = 0; i < 8; ++i){
      gp = new Monopoly;
      gp->playGame(); 
      delete gp;
   }
   */

  // Sets the game pointer to the dice game
  gp = new Dice;
  // Has the game pointer play the dice game
  gp->playGame();
  // Deletes the game pointer
  delete gp;
}