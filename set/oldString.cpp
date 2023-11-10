// string.cpp
// Milestone #1
// Garrett Bearss
/*#include "string.hpp"
#include <iostream>
#include <cassert>

String::String(){
  str[0] = 0;
}

String::String(char ch){
  str[0] = ch;
  str[1] = 0;
}

int String::capacity() const{
  return STRING_SIZE-1;
}

String::String(const char s[]){
  int i = 0;
  while(s[i] != 0){
    if(i >= capacity()){
      break;
    }
    str[i] = s[i];
    i++;
  }
  str[i] = 0;
}

int String::length() const{
  int result = 0;
  while(str[result] != 0){
    result++;
  }
  return result;
}

// REQUIRES: 0<= i < length()
char String::operator[](int i) const{
  assert(i >= 0);
  assert(i < length());
  return str[i];
}

char& String::operator[](int i) {
  assert(i >= 0);
  assert(i <= length());
  return str[i];
}

// Comment out
String String::operator+(const String& rhs) const{
  String result(s);
  int offset = length();
  int i = 0;
  while(rhs.s[i] != 0){
    if(offset + i >= capacity()){
      break;
    }
    result.s[offset+i] = rhs.s[i];
    i++;
  }
  result.s[offset+i] = 0;
  return result;
}

String operator+(char lhs, const String& rhs){
  return String(lhs) + rhs;
}

String operator+(const char[] lhs, const String& rhs){
  return String(lhs) + rhs;
}
// Comment out (not sure if this is how it ends)

String& String::operator+=(const String& rhs){
  int offset = length();
  int rhsLen = rhs.length();
  int i = 0;
  while(i < rhsLen){
    str[offset+i] = rhs.str[i];
    i++;
  }
  str[offset+i] = 0;
  return *this;
}

String operator+(String lhs, const String& rhs) {
  return lhs += rhs;
}

bool String::operator==(const String& rhs) const{
  int i = 0;
  while((str[i] != 0) && (str[i] == rhs.str[i])){
    i++;
  }
  return str[i] == rhs.str[i];
}

bool operator==(char lhs, const String& rhs){
  return String(lhs) == rhs;
}

bool operator==(const char lhs[], const String& rhs){
  return String(lhs) == rhs;
}

bool String::operator<(const String& rhs) const {
  int i = 0;
  while((str[i] != 0) && (str[i] == rhs.str[i] )){
    i++;
  }
  return str[i] < rhs.str[i];
}

bool operator<(char lhs, const String& rhs){
  return String(lhs) < rhs;
}

bool operator<(const char lhs[], const String& rhs){
  return String(lhs) < rhs;
}

bool operator!=(const String& lhs, const String& rhs){
  return !(lhs == rhs);
}

bool operator>(const String& lhs, const String& rhs){
  return rhs < lhs;
}

bool operator<=(const String& lhs, const String& rhs){
  return (lhs < rhs) || (lhs == rhs);
}

bool operator>=(const String& lhs, const String& rhs){
  return !(lhs < rhs);
}

std::ostream& operator<<(std::ostream& out, const String& rhs){
  out << rhs.str;
  return out;
}

// Not a friend function, comment out
std::istream& operator>>(std::istream& in, String& rhs){
  char buffer[STRING_SIZE];
  in >> buffer;
  rhs = String(buffer);
  return in;
}
// Comment out

std::istream& operator>>(std::istream& in, String& rhs){
  in >> rhs.str;
  return in;
}

String String::substr(int start, int len) const{
  String result;
  if((start < 0) || (start >= length())){
    return String();
  }
  if(len <= 0){
    return String();
  }
  int i = start;
  while(i < start+(len-start)){
    if(i >= length()){
      break;
    }
    result.str[i-start] = str[i]; 
    i++;
  }
  result[i-start] = 0;
  return result;
}

int String::findch(int start, char ch) const{
  int i = start;
  while(str[i] != 0){
    if(str[i] == ch){
      return i;
    }
    i++;
  }
  return -1;
}

int String::findstr(int start, const String& s) const{
  int i = start;
  int count1 = 0;
  bool truth = true;
  while(str[i] != 0){
    count1 = 0;
    if(str[i] == s[count1]){
      for(int j = i; j < s.length(); j++){
        if(!(str[j] == s[count1])){
          truth = false;
        }
      }
      if(truth){
        return i;
      }
    }
    i++;
  }
  return -1;
}
*/