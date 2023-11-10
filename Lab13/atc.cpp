// Garrett Bearss
// 4/20/2023
// atc.cpp
// mediator-based air traffic control
// Mikhail Nesterenko
// 11/30/2022

#include <iostream>
#include <set>
#include <vector>
#include <string>
#include <cstdio>
#include <ctime>
#include <algorithm>
#include <map>

// for timed sleep
#include <thread>
#include <chrono>


using std::cout; 
using std::cin; 
using std::endl;
using std::string;
using std::map;

// abstract mediator
class Controller{
public:
   virtual void join(class Flight*)=0;
   virtual void leave(class Flight*)=0;
   virtual void broadcast() = 0;
   virtual void observe() = 0;
};


// concrete mediator
// tower, runway clearance
class Tower: public Controller{
public:
   void join(class Flight*) override; 
   void leave(class Flight*) override;
   void broadcast() override;
   void observe() override;
private:
   std::set<class Flight*> waiting_;
};

// Holds the name that's to be printed when the plane is clear to take off/ land
class PlaneLogo{
  public:
    virtual string name() = 0;
};

// JetBlue version
class JetBlue: public PlaneLogo{
  public:
    string name() override {return "JETBLUE";}
};

// Iberia version
class Iberia: public PlaneLogo{
  public:
    string name() override {return "IBERIA";}
};

// Delta version
class Delta: public PlaneLogo{
  public:
    string name() override {return "DELTA";}
};

// AirFrance version
class AirFrance: public PlaneLogo{
  public:
    string name() override {return "AIRFRANCE";}
};

// Lufthansa version
class LuftHansa: public PlaneLogo{
  public:
    string name() override {return "LUFTHANSA";}
};

// KLM version
class KLM: public PlaneLogo{
  public:
    string name() override {return "KLM";}
};

// Aeroflot version
class Aeroflot: public PlaneLogo{
  public:
    string name() override {return "AEROFLOT";}
};

class United: public PlaneLogo{
  public:
    string name() override {return "UNITED";}
};

// The factory that creates the different PlaneLogo class or objects
class PlaneLogoFactory{
  public:
    static PlaneLogo *setPlaneLogo(string name){
      // If the name of the company doesn't exist in the map
      if(planelogos_.find(name) == planelogos_.end()){
        if(name == "JetBlue"){
          planelogos_[name] = new JetBlue;
        }
        else if(name == "Iberia"){
          planelogos_[name] = new Iberia;
        }
        else if(name == "Delta"){
          planelogos_[name] = new Delta;
        }
        else if(name == "AirFrance"){
          planelogos_[name] = new AirFrance;
        }
        else if(name == "LuftHansa"){
          planelogos_[name] = new LuftHansa;
        }
        else if(name == "KLM"){
          planelogos_[name] = new KLM;
        }
        else if(name == "Aeroflot"){
          planelogos_[name] = new Aeroflot;
        }
        else if(name == "United"){
          planelogos_[name] = new United;
        }
      }
      return planelogos_[name];
    }
  private:
    static map<string, PlaneLogo *> planelogos_;
};

// Forward declaration of map
map<string, PlaneLogo *> PlaneLogoFactory::planelogos_;

// abstract colleague
class Flight{
public:
   Flight(Controller *controller):controller_(controller), status_(Status::waiting){
      task_ = rand() % 2 ? Task::taxiing : Task::approaching;
      controller_->join(this);
   }

   void receive(const string &msg){
      if(msg.find(flightName_) != string::npos || msg.find("all") != string::npos){
        if(msg.find("clear") != string::npos){
          cout << flightName_ << " roger that, ";
          cout << (task_ == Task::taxiing ? "taking off" : "landing") << endl;
          status_ = Status::cleared;
        } 
        else if(msg.find("status") != string::npos){
          cout << flightName_<< (status_ == Status::waiting ? " waiting to " : " cleared to ")<< (task_ == Task::taxiing ? "take off" : "land") << endl;
        } 
        else{
          cout << "Tower, this is " << flightName_ << " please repeat." << endl;
        }
      }
   }

   bool isCleared() const {return status_ == Status::cleared;}

   void proceed(){
      std::this_thread::sleep_for(std::chrono::seconds(rand()%3+1)); // wait a while    
      cout << "..." << planeLogo_->name() << flightNo_ << (task_ == Task::taxiing ? " takes off..." : " lands...")<< ". Have a good day!" << endl; 
      controller_->leave(this);
   }

protected:
   string flightNo_;
   string flightName_;
   string company_;
   PlaneLogo *planeLogo_;
   Controller *controller_;
   enum class Task {taxiing, approaching};  Task task_;
   enum class Status {waiting, cleared};    Status status_;
};

// concrete colleagues
// Modified to seperate the different parts needed for printout
class Airbus: public Flight{
public:
   Airbus(Tower *tower): Flight(tower){
      static const std::vector<string> companies = {"AirFrance", "KLM", "Aeroflot", "Lufthansa"};
      flightNo_ = std::to_string(rand() % 1000);
      company_ = companies[rand() % companies.size()];
      flightName_ = company_ + flightNo_;
      planeLogo_ = PlaneLogoFactory::setPlaneLogo(company_);
      cout << flightName_ << " requesting " << (task_ == Task::taxiing ? "takeoff" : "landing") << endl;
   }
};

// Modified to seperate the different parts needed for printout
class Boeing: public Flight{
public:
   Boeing(Tower *tower): Flight(tower){
      static const std::vector<string> companies = {"Delta", "United", "JetBlue"};
      flightNo_ = std::to_string(rand() % 1000);
      company_ = companies[rand() % companies.size()];
      flightName_ = company_ + flightNo_;
      planeLogo_ = PlaneLogoFactory::setPlaneLogo(company_);
      cout << flightName_ << " requesting " << (task_ == Task::taxiing ? "takeoff" : "landing") << endl;
   }
};


// member functions for Tower
void Tower::broadcast(){
   cout << "Tower: ";
   string msg;
   getline(cin,msg);
   if(!msg.empty())
      for(auto f: waiting_) f->receive(msg);
}


void Tower::observe(){
   auto findCleared = [](Flight *f){return f->isCleared();};
   
   auto toProceed = std::find_if(waiting_.begin(),waiting_.end(), findCleared);
   
   while (toProceed != waiting_.end()){ // found a cleared flight
      (*toProceed) -> proceed();
      toProceed = std::find_if(waiting_.begin(), waiting_.end(), findCleared);
      if(toProceed != waiting_.end())
	 cout << "MAYDAY! MAYDAY! MAYDAY! " << endl; // more than a single flight cleared
   }
}


void Tower::join(Flight *f){
   waiting_.insert(f);
}


void Tower::leave(Flight *f){
   waiting_.erase(f);
   delete f;
}

int main(){
   srand(time(nullptr));
   Tower jfk;

   new Boeing(&jfk);
   new Airbus(&jfk);
   new Boeing(&jfk);
   new Airbus(&jfk);

   while(true){
      jfk.broadcast();
      jfk.observe();
      if(rand() % 2){
	     if(rand() % 2){
	       new Boeing(&jfk);
       }
	     else
	       new Airbus(&jfk);
       }
   }
}