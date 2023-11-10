// set.cpp
// Garrett Bearss

#include "set.hpp"

bool isValid(int x){
  return (x >= 0) && (x < DOMAIN);
}

set::set(){
  for(int i = 0; i<DOMAIN; i++){
    element[i] = false;
  }
}

set::set(int arg1) : set() {
  if(isValid(arg1)){
    element[arg1] = true;
  }
}

set::set(int arg1, int arg2) : set(), set(arg1), set(arg2){

}

set::set(int arg1, int arg2, int arg3) : set(), set(arg1), set(arg2), set(arg3){

}

set::set(std::initializer_list<int> lst) : set() {
  for(int i : lst) {
    if(isValid(i)){
      element[i] = true;
    }
  }
}

bool set::operator[](int i) const{
  if(isValid(i)){
    return element[i];
  }
  return false;
}

set set::operator+(const set& rhs) const {
  set result;
  for(int i = 0; i < DOMAIN; i++){
    result.element[i] = element[i] || rhs.element[i];
  }
  return result;
}

set operator+(int lhs, const set& rhs){
  return set(lhs) + rhs;
}

set set::operator*(const set& rhs) const {
  set result;
  for(int i = 0; i < DOMAIN; i++){
    result.element[i] = element[i] && rhs.element[i];
  }
  return result;
}

set operator*(int lhs, const set& rhs){
  return set(lhs) * rhs;
}

set set::operator-(const set& rhs) const {
  set result;
  for(int i = 0; i < DOMAIN; i++){
    result.element[i] = element[i] && !rhs.element[i];
  }
  return result;
}

set operator-(int lhs, const set& rhs){
  return set(lhs) - rhs;
}

bool set::operator==(const set& rhs) const {
  for(int i = 0; i < DOMAIN; i++){
    if(!(element[i] && rhs.element[i])){
      return false;
    }
  }
  return true;
}

bool operator !=(const set& lhs, const set& rhs) {
  return !(lhs == rhs);
}

bool set::operator<=(const set& rhs) const {
  for(int i = 0; i < DOMAIN; i++){
    if(element[i] && !rhs.element[i]){
      return false;
    }
  }
  return true;
}

bool operator<=(const set& lhs, const set& rhs) {
  return lhs <= rhs && lhs != rhs;
}

bool operator>=(const set& lhs, const set& rhs) {
  return rhs <= lhs;
}

bool operator>(const set& lhs, const set& rhs) {
  return !(lhs <= rhs);
}

bool operator==(int lhs, const set& rhs){
  return set(lhs) == rhs;
}

std::ostream& operator<<(std::ostream& out, const set& rhs){
  bool printComma = false;
  out << "{";
  for(int i = 0; i < DOMAIN; i++){
    if(rhs[i]){
      if(printComma){
        out << ", ";
      }
      out << i;
      printComma = true;
    }
    out << "}";
    return out;
  }
}

std::istream& operator>>(std::istream& in, set& rhs){
  rhs = set();
  int num;
  while(!in.eof()){
    in >> num;
    rhs = rhs + set(num);
  }
  return in;
}