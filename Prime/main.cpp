// Garrett Bearss
// Algorithm for Problem 2a
#include <iostream>
#include <vector>
#include <cmath>

void displayVector(std::vector<int> v);
std::vector<int> findPrimes(int l, int h, std::vector<int> v);
bool isPrime(int n, std::vector<int> v);

int main() {
  int low, high;
  std::vector<int> primeNumbers = {2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
  std::vector<int> result;
  std::cout << "Enter the lower bound: ";
  std::cin >> low;
  std::cout << "Enter the upper bound: ";
  std::cin >> high;
  primeNumbers = findPrimes(low, high, primeNumbers);
  std::cout << std::endl;
  displayVector(primeNumbers);
} 

std::vector<int> findPrimes(int l, int h, std::vector<int> v){
	std::vector<int> allNumbers = {l};
  std::vector<int> possibleFactors;
  for(int i = l+1; i <= h; i++){
    allNumbers.push_back(i);
  }
  int squareRoot = sqrt(h);
  if(squareRoot <= 100){
    for(int i = 2; i < squareRoot; i++){
      if(isPrime(i, v)){
        possibleFactors.push_back(i);
      }
    }
  }
  else{
    for(int i = 0; i < v.size(); i++){
      possibleFactors.push_back(v[i]);
    }
  }
  for(int i = 0; i < possibleFactors.size(); i++){
    int j = 0;
    while(j < allNumbers.size()){
      if((allNumbers[j]%possibleFactors[i]) == 0){
        allNumbers.erase(allNumbers.begin()+j);
        j++;
      }
      else{
        j++;
      }
    }
  }
  return allNumbers;
}

bool isPrime(int n, std::vector<int> v){
  bool result = false;
	for(int i = 0; i < v.size(); i++){
    if(n == v[i]){
      result = true;
    }
	}
  return result;
}

void displayVector(std::vector<int> v){
  for(int i = 0; i < v.size(); i++){
    if(i == v.size()-1){
      std::cout << v[i] << std::endl;
    }
    else{
      std::cout << v[i] << " ";
    }
  }
}