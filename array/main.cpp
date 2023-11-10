#include <iostream>
#include "array.hpp"

void foo(darray x){
  x[0] = 10;
}

void bar(const darray& y){
  std::cout << y[0];
}

int main() {
  /*darray a(10), b(20), c(4);

  darray d(a);

  std::cout<< a[0];
  a[0] = 10;

  a = b = c;

  a = a;*/

  darray vec1<int>(10);
  darray vec2<char>(100);

  vec1[0] = 5;
  vec1.resize(10);

  return 0;
}