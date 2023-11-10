// Garrett Bearss
// 4/20/2023
// observer.cpp
// observer pattern using a signup registry
// Mikhail Nesterenko
// 4/22/2014

#include <set>
#include <map>
#include <iostream>
#include <string>
#include <algorithm>

using std::cout; 
using std::endl;
using std::map; 
using std::set;
using std::string;

class Observer;
class Subject;

class EventRegistry{
public:
   // Changed the Subject class to a string that could then be passed in to use as a key
   static void registerObserver(const string&, Observer*);
   // Changed the Subject class to a string that could then be passed in to use as a key
   static void deregisterObserver(const string&, Observer*);
   // Changed the Subject class to a string that could then be passed in to use as a key
   static void handleMessage(const string&);
private:
   static map<string, set<Observer*>> observerMap_;
};

// Forward Declaration of the map holding the observers
map<string, set<Observer*>> EventRegistry::observerMap_;

class Observer{
public:
   Observer(const string &name): name_(name){}
   string getName() const {return name_;}
   // Changed the Subject class to a string that could then be passed in to use as a key
   void subscribe(const string &s) {EventRegistry::registerObserver(s, this);}
   // Changed the Subject class to a string that could then be passed in to use as a key
   void unsubscribe(const string &s){EventRegistry::deregisterObserver(s, this);}
   void handleMessage(const string&);
private:
   string name_;
};

class Subject{
public:
   Subject(const string &name): name_(name){}
   string getName() const {return name_;}
   void generateMessage(){
      cout << name_ << " sent a message" << endl;
      EventRegistry::handleMessage(name_);
   }
private:
   string name_;
};

void EventRegistry::registerObserver(const string &s, Observer* o){
   observerMap_[s].insert(o);
   cout << o->getName() << " subscribed to " << s << endl;
}

void EventRegistry::deregisterObserver(const string &s, Observer* o){
   observerMap_[s].erase(o);
   cout << o->getName() << " unsubscribed from " << s << endl;
}

void EventRegistry::handleMessage(const string &s){
   for (auto e: observerMap_[s])
      e->handleMessage(s);
}

void Observer::handleMessage(const string &s){
   cout << name_ << " received message from " << s << endl;
}

// Each time you sub or unsubscribe from a observer or a subject you instead use a string to provide as the key rather than a pointer
int main(){
   Observer olaf("Observer Olaf"), olga("Observer Olga");
   Subject  sue("Subject Sue"),  steve("Subject Steve");

   olaf.subscribe("Subject Sue");
   olaf.subscribe("Subject Steve");
   olga.subscribe("Subject Sue");

   cout << endl;

   sue.generateMessage();
   steve.generateMessage();
   cout << endl;
   
   olga.unsubscribe("Subject Sue");
   sue.generateMessage();   
}