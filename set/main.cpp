// main.cpp
// Garrett Bearss

#include <iostream>
#include "set.hpp"

int main() {
  set a, b, c;
  set d(3), e(3, 2);

  set f = {3, 4, 5, 6, 7, 10};

  a = set(2);
  a = set();

  std::cout<< a.card();

  c = a + b;
  c = 3 + b;
  c <= b;
  c > b;
  c != b;
  3 != b;

  c = set(1, 3, 4);

  if(c[3]){
    std::cout << "c has 3";
  }
  //c.operator[](3);

  return 0;
}