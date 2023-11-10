// Garrett Bearss
// logger.cpp
// 3/9/2023

#include <fstream>  
#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::cin;
using std::endl;
using std::fstream;
using std::ofstream;
using std::atexit;

class Logger {
  public:
    // Instance
    static Logger& instance(){
      static Logger log;
      return log;
    }

    // Appends the string into the destination file
    void report(const string &str){
      Logger::out_ << str << endl;
    }

  private:
  // Constructor
  Logger();

  // Disallowing object copying
  Logger& operator=(const Logger&) = delete;
  Logger(const Logger&) = delete;

  // Closes the stream
  static void closeOut();

  // The file stream
  ofstream out_;
};

// Constructor
Logger::Logger(){
  // Opens the txt file and gets an fstream that appends to the end of the file
  out_.open("log.txt", fstream::out | fstream::app);
  // When the object falls out of scope, close the stream
  atexit(closeOut);
}

// Closes the stream and confirms it was closed to the user
void Logger::closeOut(){
  // Closes the stream
  Logger::instance().out_.close();
  cout << "Stream closed out." << endl;
}

void test1(string str){
  Logger::instance().report(str);
}

void test2(){
  Logger::instance().report("test2() working as intended...");
}

// Tests the appending of the log.txt file
int main (){
  string str;
  cout << "Enter the first string you want added to the log.txt file: ";
  cin >> str;
  test1(str);
  cout << "Invoking test2 function..." << endl;
  test2();
}