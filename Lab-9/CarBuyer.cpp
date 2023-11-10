// Garrett Bearss
// CarBuyer.cpp
// 3/16/2023
// needed for lab
// Mikhail Nesterenko
// 3/18/2022

#include <iostream>
#include <vector>
#include <cstdlib>
#include "CarFactory.hpp"

using std::vector;
using std::cout; 
using std::endl;
using std::string;

class CarLot{
public:
   CarLot();
   //Car *testDriveCar(){return car4sale_;}
   // Returns a random car from the car lot vector
   Car* nextCar(){
     return carLot_[rand()%lotSize()];
   }

   // if a car is bought, requests a new one
   Car *buyCar(Car *bought){ 
      //Car *bought = car4sale_;
      //car4sale_ = factories_[rand()%factories_.size()]->requestCar();
      // Loop attempts to find the location of the car being bought
      for(int i = 0; i < lotSize(); ++i){
        // If you found the location of the car being bought
        if(carLot_[i] == bought){
          // Generate a new car at it's location in the vector
          carLot_[i] = factories_[rand()%factories_.size()]->requestCar();
          // Incase there is two of the same car in the car lot
          break;
        }
      }
      // Return the car being sold
      return bought;
   }

   // Returns the size of the car lot
   int lotSize(){
     return 8;
   }
		     
private:
   //Car *car4sale_; // single car for sale at the lot
   vector<Car*> carLot_;
   vector<CarFactory *> factories_;
};

CarLot::CarLot(){
   // creates 2 Ford factories and 2 Toyota factories 
   factories_.push_back(new FordFactory());   
   factories_.push_back(new ToyotaFactory());
   factories_.push_back(new FordFactory());
   factories_.push_back(new ToyotaFactory());

   // gets the first car for sale
   // car4sale_ = factories_[rand() % factories_.size()] -> requestCar();
   // Pushes 8 different cars onto the vector car lot 
   for(int i = 0; i < lotSize(); ++i){
     carLot_.push_back(factories_[rand() % factories_.size()] -> requestCar());
   }
}

CarLot *carLotPtr = nullptr; // global pointer instantiation

// test-drives a car
// buys it if Toyota
/*
void toyotaLover(int id){
   if(carLotPtr == nullptr){
      carLotPtr = new CarLot();
    }

   //Car *toBuy = carLotPtr -> testDriveCar(); 
   // Generates a car to buy for the customer
   Car *toBuy = carLotPtr->nextCar();

   cout << "Jill Toyoter" << id << endl;
   cout << "test driving " << toBuy->getMake() << " " << toBuy->getModel();

   if(toBuy->getMake() == "Toyota"){
      cout << " love it! buying it!" << endl;
      //carLotPtr -> buyCar();
      // Updated buyCar()
      carLotPtr->buyCar(toBuy);
   } 
   else{
      cout << " did not like it!" << endl;
    }
}
*/

// test-drives a car
// buys it if Ford
/*
void fordLover(int id){
   if(carLotPtr == nullptr){
      carLotPtr = new CarLot();
    }

   //Car *toBuy = carLotPtr -> testDriveCar();
   // Generates a car to buy for the customer
   Car *toBuy = carLotPtr->nextCar();
   
   cout << "Jack Fordman " << id << endl;
   cout << " test driving " << toBuy->getMake() << " " << toBuy->getModel();
   
   if(toBuy->getMake() == "Ford"){
      cout << " love it! buying it!" << endl;
      //carLotPtr -> buyCar();
      // Updated buyCar()
      carLotPtr->buyCar(toBuy);
   } 
   else{
    cout << " did not like it!" << endl;
   }
}
*/

// Sees if the buyer is able to purchase any of the cars in the car lot
void testDriving(int id, string make, string model){
  // If the carlor hasn't been intialized yet
  if(carLotPtr == nullptr){
    carLotPtr = new CarLot();
  }
  // Loop through the size of the lot and look to see if there is a car for the buyer's specific wants
  for(int i = 0; i < carLotPtr->lotSize(); ++i){
    Car *toBuy = carLotPtr->nextCar();

    cout << "Buyer #" << id << endl;
    cout << "test driving " << toBuy->getMake() << " " << toBuy->getModel();
    // If you found a car that matches the buyer's desires
    if(toBuy->getMake() == make && toBuy->getModel() == model){
      cout << " love it! buying it!" << endl;
      carLotPtr->buyCar(toBuy);
      return;
    }
    // If you didn't find a car for the buyer
    else{
      cout << " did not like it!" << endl;
    }
  }
}

int main(){
   srand(time(nullptr));

   /*
   const int numBuyers=20;
   for(int i=0; i < numBuyers; ++i){
    if(rand()% 2 == 0){
	    toyotaLover(i);
    }
    else{
	    fordLover(i); 
    }
   }
   */

   const int numBuyers=20;
   // Loops through the number of buyers trying to locate them a car
   for(int i = 0; i < numBuyers; ++i){
     // Randomly determines if the buyer is looking for a ford or a toyota
     string make = rand()%2 == 0 ? "Ford" : "Toyota";
     // Randomly determines what the models if for the car 
     string model = make == "Ford" ? Ford::getModels()[rand() % 4] : Toyota::getModels()[rand() % 5];
     // Attempts to find a car for the buyer
     testDriving(i, make, model);
   }
}