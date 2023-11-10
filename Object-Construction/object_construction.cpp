// Garrett Bearss
#include <iostream>
#include "object_construction.hpp"

object_construction::object_construction(){
  std::cout<< "Called the default constructor" << std::endl;
}

object_construction::object_construction(const object_construction& b){
  std::cout<< "Called the copy constructor" << std::endl;
}

object_construction::object_construction(int b){
  std::cout<< "Called the assignment constructor" << std::endl;
}

object_construction::~object_construction(){
  std::cout<< "Called the destructor" << std::endl;
}