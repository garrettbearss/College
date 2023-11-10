// Garrett Bearss
// 2/23/2023
// peaches.cpp
// jamming peaches
// non STL-algorithm code to be replaced by algorthms
// Mikhail Nesterenko
// 9/30/2021

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <vector>
#include <deque>
#include <string>
#include <algorithm>
#include <functional>
#include <numeric>

using std::cin; 
using std::cout; 
using std::endl;
using std::string;
using std::vector; 
using std::deque;
using std::placeholders::_1;

struct Peaches{
   double weight; // oz
   bool ripe;  // ripe or not
   void print() const { cout << (ripe?"ripe":"green") << ", " <<  weight << endl; }
};

// Used as the binder function
bool weightCheck(Peaches temp, double max);

int main(){
   srand(time(nullptr));
   const double minWeight = 3.;
   const double maxWeight = 8.;

   cout << "Input basket size: ";
   int size;
   cin >> size;

   vector <Peaches> basket(size);

   // assign random weight and ripeness peaches in the basket
   // replace with generate()
   /*
   for(auto it = basket.begin(); it != basket.end(); ++it){
      it->weight = minWeight + 
	           static_cast<double>(rand())/RAND_MAX*(maxWeight - minWeight);
      it->ripe = rand() % 2;
   }
   */
   // Generates randomly weighted peaches and status of how ripe they are and stores it in the basket
   generate(basket.begin(), basket.end(), [=](){
     Peaches temp;
     temp.weight = minWeight + static_cast<double>(rand())/RAND_MAX*(maxWeight - minWeight);
     temp.ripe = rand() % 2;
     return temp;
   });

   
   // for_each() possibly
   /*
   cout << "all peaches"<< endl;
   for(const auto &e: basket) {
      e.print(); 
   }
   */
   cout << "all peaches" << endl;
   for_each(basket.begin(), basket.end(), [](const Peaches& temp){
     temp.print();
   });

   // moving all the ripe peaches from basket to peck
   // remove_copy_if() with back_inserter()/front_inserter() or equivalents
   /*
   deque<Peaches> peck;
   for(auto it=basket.begin(); it != basket.end();)
      if(it->ripe){
	 peck.push_front(std::move(*it));
	 it=basket.erase(it);
      }else
	 ++it;
   */
   deque<Peaches> peck;
   // Returns all the places in which the peaches are ripe
   remove_copy_if(basket.begin(), basket.end(), back_inserter(peck), [](Peaches& temp) -> bool {
     return temp.ripe == false; 
   });
   // Erases any peaches that arn't ripe from the basket
   basket.erase(remove_if(basket.begin(), basket.end(), [](Peaches& temp){
     return temp.ripe;
   }), basket.end());

   cout << endl;
  
   // for_each() possibly
   /*
   cout << "peaches remaining in the basket"<< endl;
   for(const auto &e: basket) {
      e.print(); 
   }
   */
   cout << "peaches remaining in the basket" << endl;
   for_each(basket.begin(), basket.end(), [](const Peaches& temp){
     temp.print();
   });

   cout << endl;

   // for_each() possibly
   /*
   cout << "peaches moved to the peck"<< endl;
   for(const auto &e: peck) {
      e.print();
   } 
   */
   cout << "peaches moved to the peck" << endl;
   for_each(peck.begin(), peck.end(), [](const Peaches& temp){
     temp.print();
   });


   // prints every "space" peach in the peck
   const int space=3; 
   cout << "\nevery " << space << "\'d peach in the peck"<< endl;

   // replace with advance()/next()/distance()
   // no explicit iterator arithmetic
   /*
   auto it=peck.cbegin(); int i = 1;   
   while(it != peck.cend()){
      if(i == space){
	 it->print();
	 i=0;
      }
      ++i; 
      ++it;
   }
   */
   // For each peach in the peck, select the peach in every 3rd spot, and countine to move the iterator till at the end
   for(auto it = next(peck.begin(), space-1); distance(it, peck.end()) > space - 3;){
     it->print();
     advance(it, space);
   }

   // putting all small ripe peaches in a jam
   // use a binder to create a functor with configurable max weight
   // accumulate() or count_if() then remove_if()
   /*
   const double weightToJam = 10.0;
   double jamWeight = 0; 
   for(auto it=peck.begin(); it != peck.end();)
      if(it->weight < weightToJam){
	 jamWeight += it->weight;
	 it=peck.erase(it);
      }else
	 ++it;
   */
   const double weightToJam = 10.0;
   double jamWeight = 0.0;
   /*
   // For each of the peaches in the basket, add up their weight
   for_each(basket.begin(), basket.end(), [&jamWeight](const Peaches temp){
     jamWeight += temp.weight;
   });
   */
   // For each of the peaches in the basket, cehck if they are good to add to the jam, if not skip it
   jamWeight = accumulate(basket.begin(), basket.end(), 0.0, [weightToJam](double sum, const Peaches& temp){
     // If the peach is good to use for the jam
     if(weightCheck(temp, weightToJam)){
       return sum + temp.weight;
     }
     // Skip the peach because it can't go into the jam
     else{
       return sum;
     }
   });
   // Then remove the peaches from the basket that were used up to make the Jam
   basket.erase(remove_if(basket.begin(), basket.end(), bind(weightCheck, _1, weightToJam)), basket.end());
   cout << "Weight of jam is: " << jamWeight << endl;

}

bool weightCheck(Peaches temp, double max){
  return temp.weight < max;
}