// fileio.cpp
// Garrett Bearss
// Version: 2
/*#include <iostream> 
#include <fstream>
#include <cstdlib>
#include "bigint.hpp"

std::ifstream file1 ("fileio-text.txt");
std::ifstream file2 ("fileio-data-1.txt");

void printUpToSpace(){
  char ch;
  while(file1.get(ch)){
    if(ch != ' ' && ch != '\t' && ch != '\n' && ch != '\r'){
      std::cout << ch;
    }
    else{
      std::cout << std::endl;
      break;
    }
  }
}

void printTwoInts(){
  char ch;
  int array[2];
  int count = 0;
  int num1 = 0;
  int num2 = 0;
  int temp;
  int result;
  while(file2.get(ch)){
    if(ch != ';'){
      array[count] = int(ch) - int('0');
      count++;
    }
    else{
      break;
    }
  }
  if(count  == 1){
    num1 = array[0];
  }
  else{
    num1 = (array[0]*10) + array[1];
  }
  count = 0;
  array[0] = 0;
  array[1] = 0;
  while(file2.get(ch)){
    if(ch != ';' && ch != ' '){
      array[count] = int(ch) - int('0');
      count++;
    }
    else if(ch != ' '){
      break;
    }
  }
  if(count  == 1){
    num2 = array[0];
  }
  else{
    num2 = (array[0]*10) + array[1];
  }
  result = num1 + num2;
  std::cout << "Result: " << result << std::endl;
}

int main() {
  if(!file1.is_open()) {
      std::cout << "Unable to open file\n";
      return 1;
  }
  else{
    printUpToSpace();
  }
  file1.close();

  if(!file2.is_open()) {
      std::cout << "Unable to open file\n";
      return 1;
  }
  else{
    printTwoInts();
  }
  file2.close();
  return 0;

}*/