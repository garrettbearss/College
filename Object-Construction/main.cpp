#include "object_construction.hpp"

int main(){
  /*object_construction();
  object_construction b;
  object_construction f(b);
  object_construction (4);
  b.~object_construction();*/

    int tbl[] = {72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33};

    for (int i = 0; i < 13; i++) {
      std::cout<< (char)tbl[i];
    }
}