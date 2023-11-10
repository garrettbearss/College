#include "utilities.hpp"
//#include "../string/string.hpp" 
#include "string.hpp"
#include <iostream>
#include "stack.hpp"
#include <vector>

String toPost(std::ifstream& in){
  stack<String> s;
  String left;
  String right;
  String operat;
  String temp;
  String result;
  char token[300];

  while (!in.eof()){
    in >> token;
    temp = String(token);
    if(in.eof()) {
      break;
    }
    if(temp == ";"){
      result = s.top();
      break;
    } 
    else if(temp == ")"){
      right = s.pop();
      operat = s.pop();
      left = s.pop();
      s.push(left + right + operat);
    } 
    else{
      if(temp != "("){
        s.push(temp + ' ');
      }
    }
  }
  return result;
}

String intToString(int i){
  char ch = i + '0';
  return String(ch);
}

bool ifOp(String op){
  bool result = false;
  if(op == "*" || op == " *" || op == "* "){
    result = true;
  }
  else if(op == "/" || op == " /" || op == "/ "){
    result = true;
  }
  else if(op == "+" || op == " +" || op == "+ "){
    result = true;
  }
  else if(op == "-" || op == " -" || op == "- "){
    result = true;
  }
  return result;
}

String findOp(String op){
  String result;
  if(op == "*" || op == " *" || op == "* "){
    result = "MU";
  }
  else if(op == "/" || op == " /" || op == "/ "){
    result = "DV";
  }
  else if(op == "+" || op == " +" || op == "+ "){
    result = "AD";
  }
  else if(op == "-" || op == " -" || op == "- "){
    result = "SB";
  }
  return result;
}

void toAssembly(const String& str){
  stack<String> result;
  std::vector<String> vect = str.split(' ');
  String left;
  String right;
  unsigned int loc = 0;
  bool n[vect.size()];

  for(unsigned int i = 0; i < vect.size(); ++i)
    n[i] = false;

  while((vect.at(loc) != " ")&&(vect.at(loc) != "")&&(loc < vect.size() - 1))
    {
      String t = vect.at(loc);
      ++loc;
      if(!ifOp(t)){
        result.push(t);
      } 
      else{
        right = result.pop();
        left  = result.pop();
        result.push(evaluate(left, t, right, n));
      }
    }
}

String evaluate(const String& lhs, const String& oper, const String& rhs, bool n[]){
  String result;
  String operat;
  String load;
  String store;
  load = "LD";
  store = "ST";
  int i = 0;
  while(n[i]){
    i++;
  }
  n[i] = true;
  result = "TMP" + intToString(i + 1);
  operat = findOp(oper);
  std::cout << "    " << load << "          " << lhs << '\n';
  std::cout << "    " << operat << "          " << rhs << '\n';
  std::cout << "    " << store << "          " << result << '\n';
  return result;
}