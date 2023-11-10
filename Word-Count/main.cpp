// main.cpp
// Lab 2 for CS 44001
// Program takes a txt file then counts the number of times that word has occured throughout the file
// Garrett Bearss
// 1/26/2023

#include <iostream>
#include <fstream>
#include <cctype>
#include "WordList.hpp"

using std::cout;
using std::endl;
using std::string;
using std::ifstream;
using std::noskipws;

int main(int argc, char* argv[]){
  // Checks to make sure there is the correct number of aguments
  if(argc != 2){
    cout << "NOT ENOUGH ARGUMENTS" << endl;
    return -1;
  }
  // There is the correct amount of arguments to run the program
  else{
    char letter;
    string builtWord = "";
    ifstream file1(argv[1]);
    WordList list1;
    // While there are still characters to read in, skipping any white spaces, store it in letter
    while(file1 >> noskipws >> letter){
      // If the char read in from the input stream is alphanumerical, then add it to the currently built/ being built word
      if(isalnum(letter)){
        builtWord += letter;
      }
      // If you have reached a char that is neither a letter nor number, add the word to the wordlist
      else if(builtWord != ""){
        // Add the finished word to the list
        list1.addWord(builtWord);
        // Reset the builtWord variable for further use
        builtWord = "";
      }
    }
    // Print the list of words
    cout << "Word List: " << endl;
    // Invoking the WordList to print the list of words
    list1.print();
  }
}
