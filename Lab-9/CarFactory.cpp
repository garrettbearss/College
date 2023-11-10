// Garrett Bearss
// CarFactory.cpp
// 3/16/2023
// implementation of carFactory
// Mikhail Nesterenko
// 7/16/2014

#include <array>
#include <cstdlib>
#include "CarFactory.hpp"


// product methods

Ford::Ford(){
   //static const std::array<std::string, 4>
   //   models = {"Focus", "Mustang", "Explorer", "F-150"};
   // Allows the use of getModels in order to generate a buyer's randomly selected wants
   static const std::array<std::string, 4> models = Ford::getModels();
   make_ = "Ford";
   model_ = models[rand() % models.size()];
}

Toyota::Toyota(){
   //static const std::array<std::string, 5>
   //   models = {"Corolla", "Camry", "Prius", "4Runner", "Yaris"};
   // Allows the use of getModels in order to generate a buyer's randomly selected wants
   static const std::array<std::string, 5> models = Toyota::getModels();
   make_ = "Toyota";
   model_ = models[rand() % models.size()];
}


// factory methods
Car* CarFactory::requestCar() {
	++numCarsInProduction_;
	return makeCar();
}

Car* FordFactory::makeCar() {
	return new Ford();
}

Car* ToyotaFactory::makeCar() {
	return new Toyota();
}