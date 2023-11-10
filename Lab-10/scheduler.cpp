// Garrett Bearss
// 3/23/2023
// scheduler.cpp
#include <iostream>
#include <queue>
#include <vector>
#include <random>
#include <ctime>
#include "state.hpp"

using std::cout;
using std::vector; 
using std::queue; 
using std::rand; 
using std::time;

int main() {
    srand(time(nullptr));
    Process protoProcess;
    const int numProcess = 4;
    vector<Process *> processes;
    queue<Process *> readyQ;
    queue<Process *> blockQ;

    // For each process that needs to get added, clone the base process
    for(int i = 0; i < numProcess; i++){
        processes.push_back(protoProcess.clone());
    }
    // For each Process in process, report it, then create the process and push it into the ready queue
    for(auto p: processes){
        cout << p->report();
        p->create();
        readyQ.push(p);
    }

    cout << "\n-------- scheduler running ---------\n";

    // If there is still a process that can be executed
    while(!readyQ.empty() || !blockQ.empty()){
        int choice;

        if(!readyQ.empty()){
            // Randomly picks a value between 0-2 to allow it to randomly pick an action for a process to partake in 
            choice = rand() % 3;

            Process *p = readyQ.front();
            readyQ.pop();
            cout << "Dispatching...\n";
            p->dispatch();
            
            switch(choice){
                // If the process will be suspended
                case 0:
                    cout << "Suspending...\n";
                    p->suspend();
                    readyQ.push(p);
                    break;
                case 1:
                    // If the process will be blocked
                    cout << "Blocking...\n";
                    p->block();
                    blockQ.push(p);
                    // Prints to the user that the queue is empty
                    if(readyQ.empty()){
                      cout << "\nThe ready queue is empty\n";
                    }
                    break;
                case 2:
                    // If the process will exit
                    cout << "Exiting...\n";
                    p->exit();
                    // Prints to the user that the ready queue is empty, only if it's not the last process between both ready queue and block queue
                    if(readyQ.empty() && !blockQ.empty()){
                      cout << "\nThe ready queue is empty\n";
                    }
                    break;
                // Should theoretically never get into this
                default:
                    cout << "Error\n";
                    return 1;
            }

            cout << '\n';
        }

        // If there is a process within the blocked queue
        if(!blockQ.empty()){
            // Once again randomly set a value between 0-2
            choice = rand() % 3;
            // Unblocks a process in the blocked queue
            if(choice == 0) {
                cout << "Unblocking...\n";
                Process *p = blockQ.front();
                blockQ.pop();
                p->unblock();
                readyQ.push(p);
                cout << '\n';
            }
        }
    }

    cout << "all processes exited.\n"
    << "--------- scheduler done ---------\n";
}