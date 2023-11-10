// main.cpp
// Lab1 for CS 44001
// Program takes two .txt files as it's aguements and compares the two strings. If they are different it prints the two lines and shows where the difference starts with a ^ being displayed below the first difference.
// Garrett Bearss
// 01/20/2023

#include <iostream>
#include <string>
#include <iostream>
#include <fstream>

using std::cout; 
using std::endl;
using std::string;
using std::ifstream;

int main(int argc, char* argv[]){
  // Checks to make sure there is the correct number of aguments
  if(argc > 3 || argc < 3){
    cout << "NOT ENOUGH ARGUMENTS" << endl;
    return -1;
  }

  // Sets up the variables
  int lineNumber = 1;
  const int spaceDif = 5;
  string fileName = argv[1];
  string line1;
  string line2;
  ifstream file1(argv[1]);
  ifstream file2(argv[2]);

  // While there is still a line to read
  while(!file1.eof() || !file2.eof()){
    // If there are no more lines to read in file #1
    if(file1.eof()){
      line1 = "";
      getline(file2, line2);
    }
    // If there are no more lines to read in file #2
    else if(file2.eof()){
      getline(file1, line1);
      line2 = "";
    }
    // If there are still lines to read from both files
    else{
      getline(file1, line1);
      getline(file2, line2);
    }
    // If the lines don't match
    if(line1 != line2){
      // Determine the longest length between both of the lines
      int longerLength = line1.length() > line2.length() ? line1.length() : line2.length();
      // Used to store the number of spaces need to print before the ^
      int numSpaces = 0;
      // Determines where the first difference occurs between the lines
      for(int i = 0; i < longerLength; ++i){
        if(line1[i] != line2[i]){
          numSpaces = i;
          i = longerLength;
        }
      }
      
      // Contains the spaces needed to be printed before the ^
      string spaces(numSpaces += spaceDif + fileName.length(), ' ');
      
      // Prints the difference
      cout << argv[1] << ": " << lineNumber << ": " << line1 << endl;
      cout << argv[2] << ": " << lineNumber << ": " << line2 << endl;
      cout << spaces << "^" << endl;
    }
    ++lineNumber;
  }
}