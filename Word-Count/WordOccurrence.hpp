// WordOccurrence.hpp
// Garrett Bearss
// 1/26/2023

class WordOccurrence {
public:
    WordOccurrence(const std::string& word="", int num=0);
    bool matchWord(const std::string &); // returns true if word matches stored
    void increment(); // increments number of occurrences
    std::string getWord() const; 
    int getNum() const;
    friend bool equal(const WordOccurrence&, const WordOccurrence&);
    friend bool operator<(WordOccurrence const&, WordOccurrence const&);

private:
    std::string word_;
    int num_;
};