// bigint.cpp
// Version: 8
// Garrett Bearss
#include "bigint.hpp"

// bigint() - initialize bigint to zero
bigint::bigint(){
  for(int i = 0; i < CAPACITY; i++){
    array[i] = 0;
  }
}

// bigint(int) - initialize bigint to passed in int
bigint::bigint(int num) : bigint(){
  int digit;
  int index = 0;
  // Peels off each digit off num and stores it in the array
  while(num != 0){
    digit = num % 10;
    array[index] = digit;
    num = num / 10;
    index++;
  }
}

// bigint(const char num[]) - initalize bigint to a set of chars
bigint::bigint(const char num[]) : bigint(){
  int  length = 0;
  // Finds the length of the number
  while (num[length] != 0){
    length++;
  }
  // Takes each char from the num[] and converts it to an int and then places it into the array
  for(int i = 0; i < length; i++)
  {
    char ch = num[i];
    int number = int(ch) - int('0');
    array[length-1-i] = number;
  }
}

// debugPrint - prints each part of the array
void bigint::debugPrint(std::ostream& out) const{
  out << "|";
  for(int i = CAPACITY-1; i >= 0; i--){
    out << array[i] << "|";
  }
}

// getArrayIndex - gets the value from the array based on the index passed in
int bigint::getArrayIndex(int num){
  return array[num];
}

// operator== - allows you to compare if two bigints or int is the same value
bool bigint::operator==(const bigint& b) const{
  bool result = true;
  for(int i = CAPACITY-1; i >= 0; i--){
    if(array[i] != b.array[i]){
      result = false;
    }
  }
  return result;
}

// operator<< - allows you to print a bigint
std::ostream& operator<<(std::ostream& out, bigint b){
  bool skip = true;
  int count = 0;
  for(int i = CAPACITY-1; i>= 0; i--){
    // If you have found a value that isn't a leading zero
    if(b.getArrayIndex(i) != 0 || i == 0){
      skip = false;
    }
    if(skip == false){
      if(count != 80){
        out << b.getArrayIndex(i);
        count++;
      }
      else{
        out<< std::endl;
        count = 1;
        out << b.getArrayIndex(i);
      }
    }
  }
  return out;
}

// operator+ - allows you to add a value to a bigint
bigint bigint::operator+(const bigint& b) const{
  bigint result(0);
  int remainder;
  for(int i = 0; i < CAPACITY; i++){
    // Checks to see if the number being added is greater or equal to 10
    if(array[i] + b.array[i] + result[i] >= 10){
      // Gets the remainder
      remainder = (array[i] + b.array[i] + result.array[i])%10;
      // Stores the remainder in the current position
      result.array[i] = remainder;
      // If there is another digit place above the current one, then set it to one
      if(i + 1 < CAPACITY){
        result.array[i+1] = 1;
      }
    }
    // If the numbers beings added isn't greater than 10
    else{
      result.array[i] += array[i] + b.array[i];
    }
  }
  return result;
}

bigint operator+(int a, const bigint& b){
  return bigint(a) + b; 
}

// operator[] - returns the i-th digit passed into the method
int bigint::operator[](int a) const{
  if(a > 0 || a < CAPACITY){
    return array[a];
  }
  return 0;
}

// operator>> - reads numbers to create a bigint until a semi colon is reached
std::istream& operator>>(std::istream& in, bigint& b){
  int count = 0;
  char ch;
  char tempArray[CAPACITY];
  for(int i = 0; i < CAPACITY; i++){
    tempArray[i] = 0;
  }
  in >> ch;
  while(!in.eof() && ch != ';'){
    tempArray[count] = ch;
    count++;
    in >> ch;
  }
  b = bigint(tempArray);
  return in;
}

// operator* - multiplies bigint to a value
bigint bigint::operator*(const bigint& b) const{
  bigint result(0);
  for(int i = 0; i < CAPACITY - 1; i++){
    result = result + ((timesDigit(b.array[i])).times10(i));
  }
  return result;
}

bigint operator*(int num, const bigint& b){
  bigint result;
  return result = bigint(num) * b;
}

// timesDigit - multiplies the bigint to a single integer value 0 - 9
bigint bigint::timesDigit(int num) const{
  int remainder = 0;
  int count = 0;
  bigint result(0);
  if(num > 9 || num < 0){// If the number isn't in the allowed values
    return result;
  }
  else{
    for(int i = 0; i < CAPACITY; i++){
      remainder = (array[i] * num) + result.array[i];
      while(remainder >= 10){ // If the product is greater than or equal to 10 it will cut down the number by increments of 10
        remainder = remainder - 10;
        count++;
      }
      if(count > 0){// For each pair of 10 it adds it to the result array
        result.array[i] = remainder;
        result.array[i+1] = count;
        count = 0;
      }
      else{// If no pairs of 10 where found
        result.array[i] = remainder;
      }
    } 
  }
  return result;
}

// times10 - multiplies the bigint by 10^ the input int
bigint bigint::times10(int num) const{
  bigint result;
  if(num < 0){// If the value isn't in the allowed values
    return result;
  }
  for(int i = 0; i < CAPACITY - (num + 1); i++){
    result.array[i + num] = array[i];
  }
  for(int j = 0; j < num; j++){
    result.array[j] = 0;
  }
  return result;
}