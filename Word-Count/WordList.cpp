// WordList.cpp
// Object that holds a list of WordOccurences
// Garrett Bearss
// 1/26/2023

#include <iostream>
#include <algorithm>
#include "WordList.hpp"

using std::string;
using std::cout; 
using std::endl;

// Default constructor
WordList::WordList(){
  wordArray_ = nullptr;
  size_ = 0;
}

// Copy constructor
WordList::WordList(const WordList& list1){
  size_ = list1.size_;
  wordArray_ = new WordOccurrence[size_];
  for(int i = 0; i < size_; ++i){
    wordArray_[i] = list1.wordArray_[i];
  }
}

// Destructor
WordList::~WordList(){
  delete [] wordArray_;
}

// Swap
void swap(WordList& lhs, WordList& rhs) {
  int tempSize = lhs.size_;
  lhs.size_ = rhs.size_;
  rhs.size_ = tempSize;

  WordOccurrence *tempPtr = lhs.wordArray_;
  lhs.wordArray_ = rhs.wordArray_;
  rhs.wordArray_ = tempPtr;
}

// Overloaded assignment
WordList& WordList::operator=(WordList rhs){
  swap(*this, rhs);
  return (*this);
}

// Equal
bool equal(const WordList& lhs, const WordList& rhs) {
  if(lhs.size_ == rhs.size_){
    for(int i = 0; i < lhs.size_; ++i){
      if(lhs.wordArray_[i].getWord() != rhs.wordArray_[i].getWord()){
        return false;
      }
    }
    return true;
  }
  else{
    return false;
  }
}

// Addword
void WordList::addWord(const string & word){
  // Checks to see if the word already exists within the list
  for(int i = 0; i < size_; ++i){
    // If the word is already in the list, then increment the number attached to that word
    if(wordArray_[i].matchWord(word)){
      wordArray_[i].increment();
      return;
    }
  }
  // If the word was not found in the list, add it to the list
  // Create a new WordOccurence for the new word
  WordOccurrence *tempArray = new WordOccurrence[size_+1];
  // Copy the values over based on the current items in the word array
  for(int i=0; i < size_; ++i){
    tempArray[i] = wordArray_[i];
  }
  // If the array previously held a value of some kind
  if(size_ > 0){
    delete [] wordArray_;
  }
  // Add the new word occurence of the word into the newly made space in the wordArray
  tempArray[size_] = WordOccurrence(word, 1);
  ++size_;
  wordArray_ = tempArray;
}

// Print
void WordList::print() {
  // Sorts the wordArray from least to most common occurence
  std::sort(wordArray_, wordArray_ + size_);
  // Loop through the wordArray printing both the word and the number tracking the occurence of that item
  for(int i = 0; i < size_; ++i){
    WordOccurrence tempWord = wordArray_[i];
    cout << tempWord.getWord() << " " << tempWord.getNum() << endl;
  }
}