// Garrett Bearss
// 2/23/2023
// oranges.cpp
// selecting oranges
// converting vectors to multimaps
// Mikhail Nesterenko
// 9/26/2022

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <vector>
#include <string>
#include <map>

using std::cin; 
using std::cout; 
using std::endl;
using std::string;
using std::vector;
using std::multimap;
using std::pair;

enum class Variety {orange, pear, apple};
vector<string> colors = {"red", "green", "yellow"};

struct Fruit{
   Variety v;
   string color; // red, green or orange
};


int main(){
   srand(time(nullptr));
   //vector <Fruit> tree(rand()%100+1);
   multimap<Variety, Fruit> tree;

   // random fruit and color selection
   /*
   for(auto f=tree.begin(); f!=tree.end(); ++f){
      f->v = static_cast<Variety>(rand() % 3);
      f->color = colors[rand()%3];
   }
   */
   // Calculates the number of fruit
   int count = rand()%100+1;
   // Populates the multimap with random types of fruit
   for(int i = 0; i < count; ++i){
     Fruit temp;
     temp.v = static_cast<Variety>(rand()%3);
     temp.color = colors[rand()%3];
     tree.emplace(temp.v, temp);
   }

   // printing colors of oranges
   cout << "Colors of the oranges: ";
   /*
   for(auto f=tree.begin(); f!=tree.end(); ++f)
      if(f->v == Variety::orange) cout << f->color << ", ";
   cout << endl;
   */
   // Traverses the multimap, taking only fruit that are oranges and printing the color of the oranges
   for(auto fruit = tree.lower_bound(Variety::orange); fruit != tree.upper_bound(Variety::orange); ++fruit){
     cout << fruit->second.color << ", ";
   }
   cout << endl;
}