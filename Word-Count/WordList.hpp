// WordList.hpp
// Garrett Bearss
// 1/26/2023

#include "WordOccurrence.hpp"

class WordList{
public:
    // add copy constructor, destructor, overloaded assignment
    WordList(); // Default constructor
    WordList(const WordList&); // Copy constructor
    ~WordList(); // Destructor
    WordList& operator=(WordList); // Overloaded Assignment
    // implement comparison as friend
    friend bool equal(const WordList&, const WordList&);
    friend void swap(WordList&, WordList&);
    void addWord(const std::string &);
    void print();

private:
    WordOccurrence *wordArray_; // a dynamically allocated array of WordOccurrences
                                // may or may not be sorted
    int size_;
};