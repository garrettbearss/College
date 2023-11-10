// WordOccurrence.cpp
// An object that contains a string and the number of the times it appears in a txt file
// Garrett Bearss
// 1/26/2023

#include <iostream>
#include "WordList.hpp"

using std::string;
using std::cout; 
using std::endl;

// Constructor
WordOccurrence::WordOccurrence(const string& word, int num){
  word_ = word;
  num_ = num;
}

// Match word
bool WordOccurrence::matchWord(const string &word){
  return (this->getWord()== word);
}

// Increment
void WordOccurrence::increment(){
  ++num_;
}

// Get word
string WordOccurrence::getWord() const{
  return word_;
}

// Get Number
int WordOccurrence::getNum() const{
  return num_;
}

// Both of these are needed in order to std::sort
// Equal
bool equal(const WordOccurrence& lhs, const WordOccurrence& rhs){
  return(lhs.num_ == rhs.num_ && lhs.word_ == rhs.word_);
}

// Compare 
bool operator<(WordOccurrence const & lhs, WordOccurrence const & rhs){
  return lhs.num_ < rhs.num_;
}