#include <iostream>

int nfact(int n){
  if(n <= 0){
    return 1;
  }
  else{
    return n* nfact(n-1);
  }
}