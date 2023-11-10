#include "array.hpp"
#include <cstdlib>

darray::darray(int n) : darray() {
  if (n <= 0) return;
  cap = n;
  ptr = new int[cap];
}

int darray::operator[](int i)const {
  assert(i>=0);
  assert(i<cap);
  return ptr[i];
}

int& darray::operator[](int i){
  assert(i>=0);
  assert(i<cap);
  return ptr[i];
}

darray::darray(const darray& actual) {
  cap = actual.cap;
  ptr = new int[cap];
  for(int i = 0; i<cap; i++){
    ptr[i] = actual.ptr[i];
  }
}

darray::~darray(){
  delete[] ptr;
}

// Version 1
darray& darray::operator=(const darray& rhs) {
  if(ptr == rhs.ptr){
    return *this;
  }
  delete[] ptr;
  cap = rhs.cap;
  ptr = new int[cap];
  for(int i = 0; i < cap; i++){
    ptr[i] = rhs.ptr[i];
  }
  return *this;
}

// Version 2
darray& darray::operator=(darray rhs){
  swap(rhs);
  return *this;
}

void darray::swap(darray& rhs){
  int captemp = rhs.cap;
  rhs.cap = cap;
  cap = captemp;

  int *temp = rhs.ptr;
  rhs.ptr = ptr;
  ptr = temp;
}

// Requires: n >= 0
void darray::resize(int newCapacity){
  int smaller = cap;
  if(newCapacity < smaller){
    smaller = newCapacity;
  }
  cap = newCapacity;
  int *temp = new int [cap];
  for(int i = 0; i < smaller; i++){
    temp[i] = ptr[i];
  }
  delete[] ptr;
  ptr = temp;
}