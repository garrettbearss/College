// Garrett Bearss
// 2/23/2023
// apples.cpp
// sorting apples
// non STL-algorithm code to be replaced by algorthms
// Mikhail Nesterenko
// 09/26/2022

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <vector>
#include <deque>
#include <string>
#include <algorithm>

using std::cin; 
using std::cout; 
using std::endl;
using std::string;
using std::vector; 
using std::deque;

struct Apples{
   double weight; // oz
   string color;  // red or green
   void print() const { cout << color << ", " <<  weight << endl; }
};



int main(){
   srand(time(nullptr));
   const double minWeight = 8.;
   const double maxWeight = 3.;

   cout << "Input crate size: ";
   int size;
   cin >> size;

   vector <Apples> crate(size);

   // assign random weight and color to apples in the crate
   // replace with generate()
   /*
   for(auto it = crate.begin(); it != crate.end(); ++it){
      it->weight = minWeight + 
	           static_cast<double>(rand())/RAND_MAX*(maxWeight - minWeight);
      it->color = rand() % 2 == 1 ? "green" : "red";
   }
   */
   // Generates randomly weigheted and colored apples to the vector crate
   generate(crate.begin(), crate.end(), [=](){
     Apples temp;
     temp.weight = minWeight + static_cast<double>(rand())/RAND_MAX*(maxWeight - minWeight);
     temp.color = rand() % 2 == 1 ? "green" : "red";
     return temp;
   });

    // for_each() possibly
   /*
   cout << "all appleas"<< endl;
   for(const auto &e: crate) {
      e.print();
   }
   */
   // For each apple in crate, print it
   for_each(crate.begin(), crate.end(), [](const Apples& temp){
     temp.print();
   });
   cout << endl;
   
   cout << "Enter weight to find: ";
   double toFind;
   cin >> toFind;

   // count_if()
   /*
   int cnt = 0;
   for(auto it = crate.cbegin(); it != crate.cend(); ++it) 
      if(it->weight > toFind) ++cnt;

   cout << "There are " << cnt << " apples heavier than " 
	<< toFind << " oz" <<  endl;
   */
   int count = count_if(crate.begin(), crate.end(), [toFind](Apples temp){
     return temp.weight > toFind;
   });
   cout << "There are " << count << " apples heavier than " << toFind << " oz" <<  endl;

   // find_if()
   /*
   cout << "at positions ";
   for(int i=0; i < size; ++i)
      if(crate[i].weight > toFind)
	 cout << i << ", ";
   cout << endl;
   */
   cout << "at positions ";
   // Sets an iterator to the beginning of the vector
   auto it = crate.begin();
   // While the iterator isn't at the end of the vector, find a new value that matches the weight to find and print it's position
   while(it != crate.end()){
     it = find_if(++it, crate.end(), [toFind](Apples temp){
       return temp.weight > toFind;
     });
     if(it != crate.end()){
        cout << it - crate.begin() << ", ";
     }
   }
   cout << endl;

   // max_element()
   /*
   double heaviest = crate[0].weight;
   for(int i=1; i < size; ++i)
      if(crate[i].weight > heaviest) heaviest = crate[i].weight; 
   cout << "Heaviest apple weighs: " << heaviest << " oz" << endl;
   */
   // max_element find's the apple with the greatest weight within the vector, then stores that apples weight
   double heaviest = max_element(crate.begin(), crate.end(), [](const Apples& lhs, const Apples& rhs){
     return lhs.weight < rhs.weight; 
   })->weight; 
   cout << "Heaviest apple weighs: " << heaviest << " oz" << endl;

   // for_each() or accumulate()
   /*
   double sum = 0;
   for(int i=0; i < size; ++i)
      sum += crate[i].weight;
   cout << "Total apple weight is: " << sum << " oz" << endl;
   */
   double sum = 0.0;
   // For each apple in the crate, add it's weight to the sum of weights
   for_each(crate.begin(), crate.end(), [&sum](const Apples temp){
     sum += temp.weight;
   });
   cout << "Total apple weight is: " << sum << " oz" << endl;

   // transform();
   /*
   cout << "How much should they grow: ";
   double toGrow;
   cin >> toGrow;
   for(int i=0; i < crate.size(); ++i)
      crate[i].weight += toGrow;
   */
   cout << "How much should they grow: ";
   double toGrow;
   cin >> toGrow;
   // Goes through the vector and adds toGrow to each of the apple's weights
   transform(crate.begin(), crate.end(), crate.begin(), [toGrow](Apples temp){
     Apples temp2;
     temp2.color = temp.color;
     temp2.weight = temp.weight + toGrow;
     return temp2;
   });

   // Printing the newly changed apples
   for_each(crate.begin(), crate.end(), [](const Apples& temp){
     temp.print();
   });
   cout << endl;

   // remove_if()
   cout << "Input minimum acceptable weight: ";
   double minAccept;
   cin >> minAccept;
   // Returns iterators where the apples don't meet the required min weight 
   crate.erase(remove_if(crate.begin(), crate.end(), [minAccept](const Apples& temp){
     return temp.weight < minAccept;
   }), crate.end());

   // Printing the newly changed crate
   for_each(crate.begin(), crate.end(), [](const Apples& temp){
     temp.print();
   });
   cout << endl;

   // removing small apples
   // nested loops, replace with a single loop modification idiom
   /*
   bool removed;
   do{
      removed = false;
      for(auto it = crate.begin(); it != crate.end(); ++it)
	 if(it->weight < minAccept){
	    crate.erase(it);
	    removed = true;
	    break;
       }
   }while(removed);
   cout << "removed " << size - crate.size() << " elements" << endl;
   */
   cout << "removed " << size - crate.size() << " elements" << endl;

   // bubble sort, replace with sort()
   /*
   bool swapped;
   do{
      swapped = false;
      for(int i=0; i < crate.size()-1; ++i)
	 if(crate[i].weight > crate[i+1].weight){
	    std::swap(crate[i], crate[i+1]);
	    swapped = true;
	 }
   }while(swapped);
   */
   // Goes through the vector and checks to see if the lhs is less than the rhs, if it isn't swap the places within the vector
   sort(crate.begin(), crate.end(), [](const Apples& lhs, const Apples& rhs) -> bool{
     return lhs.weight < rhs.weight;
   });

   // for_each() possibly
   /*
   cout << "sorted remaining apples"<< endl;
   for(const auto &e: crate) {
      e.print();
   }
   */
   // Printing the newly changed crate
   for_each(crate.begin(), crate.end(), [](const Apples& temp){
     temp.print();
   });
   cout << endl;
}