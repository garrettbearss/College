// string.cpp
// Garrett Bearss
#include "string.hpp"
#include <iostream>
#include <cassert>
#include <vector>

String::String(){
  stringSize = 1;
  str = new char[stringSize];
  str[0] = 0;
}

String::String(char c){
  if(c == '\0'){
    stringSize = 1;
    str = new char[stringSize];
    str[0] = 0;
  }
  else{
    stringSize = 2;
    str = new char[stringSize];
    str[0] = c;
    str[1] = 0;
  }
}

String::String(const char c[]){
  int i = 0;
  stringSize = 0;
  while(c[i] != 0){
    stringSize++;
    i++;
  }
  stringSize++;
  i = 0;
  str = new char[stringSize];
  str[length()] = 0;
  for(int j = 0; j < stringSize; j++){
    if(j+1 == stringSize){
      str[j] = 0;
    }
    else{
      str[j] = c[j];
    }
  }
}

String::String(const String& s){
  stringSize = s.length()+1;
  str = new char[stringSize];
  for(int i = 0; i < s.length(); i++){
    str[i] = s.str[i];
  }
  str[length()] = 0;
}

String::~String(){
  delete[] str;
}

void String::swap(String& s){
  int stringSizeTemp = s.capacity()+1;
  s.stringSize = stringSize;
  stringSize = stringSizeTemp;

  char *temp = s.str;
  s.str = str;
  str = temp;
}

String& String::operator=(String s){
  swap(s);
  return *this;
}

int String::length() const{
  return stringSize-1;
}

int String::capacity() const{
  return stringSize-1;
}

char& String::operator[](int n){
  assert(n >= 0);
  assert(n <= stringSize);
  return str[n];
}

char String::operator[](int n) const{
  assert(n >= 0);
  assert(n <= stringSize);
  return str[n];
}

String& String::operator+=(const String& s){
  stringSize += s.length();
  char* temp = new char[stringSize];
  int i = 0;
  while(str[i] != 0){
    temp[i] = str[i];
    i++;
  }
  int count = 0;
  while(s.str[count] != 0){
    temp[i] = s.str[count];
    i++;
    count++;
  }
  delete[] str;
  str = temp;
  return *this;
}

bool String::operator==(const String& s) const{
  int i = 0;
  while((str[i] != 0) && (str[i] == s.str[i])){
    i++;
  }
  return str[i] == s.str[i];
} 

bool String::operator<(const String& s) const{
  int i = 0;
  while((str[i] != 0) && (str[i] == s.str[i] )){
    i++;
  }
  return str[i] < s.str[i];
}

String String::substr(int start, int end) const{
  String result;
  if((start < 0) || (start >= length())){
    return String();
  }
  if(stringSize <= 0){
    return String();
  }
  if(start == end){
    result = str[start];
    return result;
  }
  int i = start;
  while(i <= end){
    if(i >= length()){
      break;
    }
    result.str[i-start] = str[i]; 
    result.stringSize++;
    i++;
  }
  result[i-start] = 0;
  return result;
}

int String::findch(int start, char c) const{
  int i = start;
  if(start > length()){
    return -1;
  }
  while(str[i] != 0){
    if(str[i] == c){
      return i;
    }
    i++;
  }
  return -1;
}

int String::findstr(int start, const String& s) const{
  int index = -1;
  int count = start;
  while(str[count] != 0){
    if(str[count] == s[0]){
      index = count;
      for(int j = 0; j < s.length(); j++){
        if(str[count + j] != s[j]){
          index = -1;
        }
      }
      if(index == count){
        return index;
      }
    }
    count++;
  }
  return index;
}

std::vector<String> String::split(char ch) const{
  /*std::vector<String> result;
  int i = 0;
  int start = 0;
  while(i != -1){
    i = findch(start, ch);
    if(i == -1){
      result.push_back(substr(start, length()));
    }
    else if(start == i){
      result.push_back("");
    }
    else{
      result.push_back(substr(start, i-1));
    }
    start = i + 1;
  }
  return result;*/
  std::vector<String> result;
  String temp;
  if (ch == '\0'){
    for (int i = 0; i < length(); i++){
      result.push_back(str[i]);
    }
    return result;
  }

  for (int i = 0; i < length(); i++){
    if (str[i] != ch){
      temp = temp + str[i];
    }
    else{
      result.push_back(temp);
      if(str[i+1] != str[i]){
	      temp = str[++i];
      }
      else{
	      String temp2;
	      temp = temp2;
      }
    }
  }
  return (result.push_back(temp), result);
}

std::ostream& operator<<(std::ostream& out, const String& s){
  out << s.str;
  return out;
}

std::istream& operator>>(std::istream& in, String& s){
  in >> s.str;
  return in;
}

String operator+(String lhs, const String& rhs){
  return lhs += rhs;
}

bool operator==(const char lhs[], const String& rhs){
  return String(lhs) == rhs;
}

bool operator==(char lhs, const String& rhs){
  return String(lhs) == rhs;
}

bool operator<(const char lhs[], const String& rhs){
  return String(lhs) < rhs;
}

bool operator<(char lhs, const String& rhs){
  return String(lhs) < rhs;
}

bool operator<=(const String& lhs, const String& rhs){
  return (lhs < rhs) || (lhs == rhs);
}

bool operator!=(const String& lhs, const String& rhs){
  return !(lhs == rhs);
}

bool operator>=(const String& lhs, const String& rhs){
  return !(lhs < rhs);
}

bool operator>(const String& lhs, const String& rhs){
  return rhs < lhs;
}
