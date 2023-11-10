// Garrett Bearss
// 4/ /2023
// coffeeShack.hpp
// built off of drink.hpp
// drink class to be used in Coffee Shack lab
// Mikhail Nesterenko
// 11/7/2022

#include <string>
#include <vector>
#include <iostream>
#include <list>
using std::cout;
using std::cin;
using std::string;
using std::vector;
using std::list;

enum class DrinkType {small, medium, large};

class Drink{
public:
   Drink(DrinkType type=DrinkType::small, int price=0):
                 type_(type), price_(price){}
   // Returns the price of a drink 
   virtual int getPrice() const{
     return price_;
   }
   // Returns the name of a drink
   virtual string getName() const{
    switch(type_){
    // If the drink is a large
    case DrinkType::large:
      return "large coffee with ";
    // If the drink is a medium
    case DrinkType::medium:
      return "medium coffee with ";
    // If the drink is a small
    default:
      return "small coffee with ";
    }
  }
private: 
   int price_;
   DrinkType type_;
};

// Adds sugar to a person's drink
class Sugar: public Drink{
  public:
  // Default constructor
  Sugar(const Drink* wrapped):wrapped_(wrapped){}
  // Gets the price associated with adding sugar
  int getPrice() const override{
    return wrapped_->getPrice() +1;
  }
  // Returns the name + sugar
  string getName() const override{
    return wrapped_->getName() + "sugar, ";
  }
  private:
  // Points to the drink class in which sugar is being added to
  const Drink *wrapped_;
};

// Adds cream to a person's drink
class Cream: public Drink{
  public:
  // Default constructor
  Cream(const Drink* wrapped):wrapped_(wrapped){}
  // Returns the price associated with adding cream
  int getPrice() const override{
    return wrapped_->getPrice() +2;
  }
  // Returns the name + cream
  string getName() const override{
    return wrapped_->getName() + "cream, ";
  }
  private:
  // Points to the drink class in which cream is being added to
  const Drink *wrapped_;
};

// Adds honey to a person's drink
class Honey: public Drink{
  public:
  // Default constructor
  Honey(const Drink* wrapped):wrapped_(wrapped){}
  // Returns the price associated with adding honey
  int getPrice() const override{
    return wrapped_->getPrice() +3;
  }
  // Returns the name + honey
  string getName() const override{
    return wrapped_-> getName() + "honey, ";
  }
  private:
  // Points to the drink class in which honey is being added to
  const Drink *wrapped_;
};

// Forward declaration of class Customer
class Customer;

// Barista class which makes the drinks for customers
class Barista{
  public:
  // Constructor
  Barista(Barista *next = nullptr):next_(next){}
  // Depending on the input it will decide which derived class of Barista will make the drink
  virtual Drink* makeDrink(char choice, list<Drink *> &drinks){
    return next_->makeDrink(choice, drinks);
  }
  // Registers a customer object to the barista object
  void registerCustomer(Customer *customer){
    customers_.push_back(customer);
  }
  // Erases a customer object from the barista's to do list
  void removeCustomer(int num){
    customers_.erase(customers_.begin() + num);
  }
  // Notifies all customers assigned to the barista
  void notifyCustomers() const;
  // Picks a random customer in the vector, makes their drink then erases them from the vector
  void completeOrder();
  // Returns the name of the customer currently being worked on
  string getCustomerName();
  // Returns true if the barista has made all of the orders
  bool finished(){
    return customers_.empty();
  }
  // Gathers what the customer wants to add to a drink
  char askOrder(){
    char choice;
    cout << "Would you like to add [s]ugar, [c]ream, [h]oney, or [d]one? ";  
    cin >> choice;
    return choice;
  }
  protected:
  // Holds all of the customers assigned to a barista
  static vector<Customer *> customers_;
  // Keeps tracks of what customer is currently being attended to
  int index_;
  private:
  // Points to the next barista
  Barista *next_;
};

// Forward declaration of vector customers_
vector<Customer *> Barista::customers_;

// Customer class which orders drinks to be made by a barista
class Customer{
  public:
  // Constructor
  Customer(const string &name, Barista* barista, Drink* drink):name_(name), barista_(barista), drink_(drink){
    barista->registerCustomer(this);
  }
  // The customer checks to see if their drink is finished
  void notify() const;
  // Returns the name of the customer
  string getName() const{
    return name_;
  }
  // Returns the drink ordered by the customer
  Drink* getDrink() const{
    return drink_;
  }
  private:
  string name_;
  Barista *barista_;
  Drink *drink_;
};

// Junior Barista class that only makes simple orders
class JuniorBarista: public Barista{
  public:
  // Constructor
  JuniorBarista(Barista *next = nullptr):Barista(next){}
  // JuniorBarista's version of make drink
  Drink* makeDrink(char choice, list<Drink *> &drinks) override{
    cout << "Welcome to Coffee Shack can I get you [l]arge, [m]edium, [s]mall coffee? ";
    cin >> choice; 
    DrinkType type;
    int price;
    // Decides what type of drink it is
    switch(choice){
      // If the drink should be a large
      case 'l':
        type = DrinkType::large;
        price = 10;
        break;
      // If the drink should be a medium
      case 'm':
        type = DrinkType::medium;
        price = 7;
        break;
      // If the drink should be a small
      case 's':
        type = DrinkType::small;
        price = 5;
        break;
    }
    // Add the new drink to list of drinks
    drinks.push_back(new Drink(type, price));
    choice = this->askOrder();
    // If the customer is done adding to their drink
    if(choice == 'd'){
      // Who is making the drink at the current moment
      cout << "Junior Barista is making the order...\n";
      return drinks.back();
    }
    return Barista::makeDrink(choice, drinks);
  }
};


// Senior Barista class that can make any drink except those with honey
class SeniorBarista: public Barista{
  public:
  // Constructor
  SeniorBarista(Barista *next = nullptr):Barista(next){}
  // SeniorBarista's version of make drink
  Drink* makeDrink(char choice, list<Drink *> &drinks){
    // While there is no honey to be added
    while(choice != 'h'){
      // Depending on the choice it adds that ingredient
      switch(choice){
        // If they want to add sugar to a drink
        case 's':
          drinks.push_back(new Sugar(drinks.back()));
          break;
        // If they want to add cream to a drink
        case 'c':
          drinks.push_back(new Cream(drinks.back()));
          break;
        // If they are done adding to a drink
        case 'd':
          // Who is making the drink at the current moment
          cout << "Senior Barista is making the order...\n";
          return drinks.back();
      }
      // If they haven't finished ordering ask them for another ingredient
      choice = this->askOrder();
    }
    return Barista::makeDrink(choice, drinks);
  }
};

// Manager class that can make any drink
class Manager: public Barista{
  public:
  // Constructor
  Manager(Barista *next = nullptr):Barista(next){}
  // Manager's version of make drink
  Drink* makeDrink(char choice, list<Drink *> &drinks){
    // While the customer is not done adding to the drink
    while(choice != 'd'){
      switch(choice){
        // If they want to add sugar to a drink
        case 's':
          drinks.push_back(new Sugar(drinks.back()));
          break;
        // If they want to add cream to a drink
        case 'c':
          drinks.push_back(new Cream(drinks.back()));
          break;
        // If they want to add honey to a drink
        case 'h':
          drinks.push_back(new Honey(drinks.back()));
          break;
      }
      // If the customer isn't done ordering, ask them for another ingredient
      choice = this->askOrder();
    }
    // Who is making the drink at the current moment
    cout << "Manager is making the order...\n";
    return drinks.back();
  }
};

// Picks a random customer in the vector, makes their drink then erases them from the vector
void Barista::completeOrder(){
  // Randomly picks a spot in the vector
  index_ = rand()%customers_.size();
  cout << getCustomerName() << ", your " << customers_[index_]->getDrink()->getName() << "is ready. It will be $" << customers_[index_]->getDrink()->getPrice() << ", please.\n";
  this->notifyCustomers();
  this->removeCustomer(index_);
}

// Notifies all customers assigned to the barista
void Barista::notifyCustomers() const{
  for(auto customer: customers_){
    customer->notify();
  }
}

// Returns the name of the customer currently being worked on
string Barista::getCustomerName(){
  return customers_[index_]->getName();
}

// The customer checks to see if their drink is finished
void Customer::notify() const{
    cout << name_ << " checks drink for " << barista_->getCustomerName() << "\n";
}