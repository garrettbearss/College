#include <iostream>
#include <fstream>
#include "utilities.hpp"
#include "../string/string.hpp"

int main(int argc, char *argv[]){
  if(argc != 3 && argc != 2){
    std::cerr << "Too many or too little arguments." << std::endl;
    return 0;
  }
  std::ifstream in(argv[1]);
  if(!in){
    std::cerr << "Couldn't open file." << std::endl;
    return 0;
  }
  std::ifstream infix(argv[1]);
  std::ofstream out(argv[2]);
  int LINE_SIZE = 1024;
  char line[LINE_SIZE];
  if(!out){
    while(!in.eof()){
      String postfix = toPost(in);
      infix.getline(line, LINE_SIZE);
      if(!in.eof()){
        std::cout << "Infix Expression: " << line << std::endl;
        std::cout << "Postfix Expression: " << postfix << std::endl;
        toAssembly(postfix);
      }
    }
  }
  else{
    while(!in.eof()){
      String postfix = toPost(in);
      infix.getline(line, LINE_SIZE);
      if(!in.eof()){
        out << "Infix Expression: " << postfix << std::endl;
        out << "Postfix Expression: " << postfix << std::endl;
        toAssembly(postfix);
      }
    }
    out.close();
  }
  in.close();
  return 0;
}