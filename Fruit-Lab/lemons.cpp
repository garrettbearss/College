// Garrett Bearss
// 2/23/2023
// lemons.cpp
// picking the best quality lemons
// converting vectors to priority queue
// Mikhail Nesterenko
// 2/17/2023

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <vector>
#include <queue>

using std::cin; 
using std::cout; 
using std::endl;
using std::string;
using std::vector;
using std::priority_queue;

struct Lemon {
    double quality;
    friend bool operator<(const Lemon& left, const Lemon& right) {
        return left.quality < right.quality;
    }
};

const int maxBoxSize = 30;
const int highestQuality = 10;

int main() {
    srand(time(nullptr));
    vector <Lemon> box(rand() % maxBoxSize + 1); // random box size

    // random quality assingment
    for (auto& lemon : box)
        lemon.quality = static_cast<double>(rand()) / RAND_MAX * highestQuality;

    cout << "Here are the lemons (best first): ";

    // replace this code with priority queue
    /*
    while (!box.empty()) {
        auto bestLemon = box.begin();
        for (auto lemon = bestLemon+1; lemon != box.end(); ++lemon)
            if (*bestLemon < *lemon) bestLemon = lemon;
        cout << bestLemon->quality << ", ";
        box.erase(bestLemon);
    }
    cout << endl;
    */
    // Create the priority queue
    priority_queue<Lemon> lemons; 
    // Populate the queue
    for(auto lemon: box){
      lemons.push(lemon);
    }
    // Print the values in the priority queue from greatest to smallest
    while(!lemons.empty()){
      cout << lemons.top().quality << endl;
      lemons.pop();
    }
}