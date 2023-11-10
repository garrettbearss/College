//main.cpp
//Garrett Bearss
#include "point.hpp"
#include <iostream>
using namespace std;

int main () {

    point a;
    point b,c;
    point d(3, 4);
    point e;
    
    a.init(3,4);
    b.init(2,2);

    a.print(std::cout);
    std::cout<<endl;
    a.setx(30);
    std::cout << a.gety() << std::endl;

    c = a.add(b);
    c = a + b;
    c = a.operator+(b);
    
    a.print(std::cout); 
    std::cout<< std::endl;
    b.print(std::cout); 
    std::cout<< std::endl;
    c.print(std::cout); 
    std::cout<< std::endl;
    d.print(std::cout);
    std::cout<< std::endl;

    std::cout << a;

    //std::cout.operator<<(a);
    
    //operator<<(point, std::cout);

    std::cout << a << std::endl;

    std::cout << a.dist(b);

    //operator<<(operator<<(std::cout, a), std::endl);
    
    return 0;
}