// Garrett Bearss
// 4/ /2023
// coffeeShack.cpp
#include "coffeeShack.hpp"
#include <ctime>
#include <random>

int main(){
  srand(time(nullptr));
  // Number of customers to be served
  const int numCustomers = 4;
  JuniorBarista *barista = new JuniorBarista(new SeniorBarista(new Manager));
  // Number of customers who had their order complete
  int servedCustomers = 0;
  // Runs while there is still customers to serve or the barista isn't finished
  while(servedCustomers != numCustomers || !barista->finished()){
    // Picks a random customer to work on
    int workon = rand()%3;
    if(workon == 0 && servedCustomers != numCustomers){
      char choice;
      list<Drink *> drinks;
      string name;
      barista->makeDrink(choice, drinks);
      cout << "Can I get your name? ";
      cin >> name;
      Customer *customer = new Customer(name, barista, drinks.back());
      servedCustomers++;
    }
    else if(workon == 1 && !barista->finished()){
      barista->completeOrder();
    }
  }
  return 0;
}