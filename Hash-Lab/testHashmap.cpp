// Garrett Bearss
// testHashmap.cpp
// 3/2/2023
// demoes hashmap implementation
// Mikhail Nesterenko
// 4/15/2014

#include "hashmap.hpp"
#include <iostream>
#include <string>

using std::cin; using std::cout; using std::endl;
using std::string;

int main() {
   hashmap<int, int> myHash;
   myHash.insert(pair<int,int>(4, 40));
   myHash.insert(make_pair(6, 60));

   // x will have type hashmap<int, int>::value_type*
   auto x = myHash.find(4);
   if (x != nullptr) 
      cout << "4 maps to " << x->second << endl;
   else 
      cout << "cannot find 4 in map" << endl;
   

   myHash.erase(4);

   auto x2 = myHash.find(4);
   if (x2 != nullptr)
      cout << "4 maps to " << x2->second << endl;
   else 
      cout << "cannot find 4 in map" << endl;
   
   myHash[4] = 35;
   myHash[4] = 60;

   auto x3 = myHash.find(4);
   if (x3 != nullptr)
      cout << "4 maps to " << x3->second << endl;
   else 
      cout << "cannot find 4 in map" << endl;

   hashmap<int, string> employees;

   // entering entries with indexing operator
   employees[123] = "Mike";
   employees[345] = "Charlie";
   employees[192] = "Joe";
   employees[752] = "Paul";
   employees[328] = "Peter";
   bool loop = true;
   int num;
   string name;

   while(loop){
   // Populates the map
   cout << "\nEnter new employee number: "; cin >> num;
   cout << "Enter new employee name: "; cin >> name;

   //employees[num] = name; // "unsafe" insert
   employees.insert({num,name});
   cout << "\nEnter (1)true/(0)false if you would like to add another: ";
   cin >> loop;
   }

   loop = 1;
   while(loop){
   // searching map
   cout << "\nEnter employee number to look for: "; cin >> num;
   auto it = employees.find(num);
   if(it != nullptr){
      cout << it->first << ":" << it->second << endl;
   }
   else{
      cout << "Employee not found" << endl;
   }
   cout << "\nEnter (1)true/(0)false if you would like to look for another: ";
   cin >> loop;
   }

   loop = 1;
   while(loop){
   // Removing from a map
   cout << "\nEnter employee number to fire: "; cin >> num;
   employees.erase(num);
   // check if not there
   auto removed = employees.find(num);
   if (removed == nullptr){
      cout << "Employee removed successfully" << endl;
   }
   else{
     cout << "Employee failed to be removed" << endl;
   }
   cout << "\nEnter (1)true/(0)false if you would like to remove another: ";
   cin >> loop;
   }

}