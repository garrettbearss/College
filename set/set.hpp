// set.hpp 
// Garrett Bearss

#ifndef CS2_SET_HPP_
#define CS2_SET_HPP_

#include <iostream>
#include <initializer_list>

const int DOMAIN = 6400;

class set{
  public:
    set();
    set(int);
    set(int,int);
    set(int,int,int);
    set(std::initializer_list<int>);

    int card() const;

    bool operator[](int) const;
    set operator+(const set&) const;
    set operator*(const set&) const;
    set operator-(const set&) const;

    bool operator==(const set&) const;
    bool operator<=(const set&) const;

  private:
    bool element[DOMAIN];
};

set operator+(int, const set&);
set operator*(int, const set&);
set operator-(int, const set&);
bool operator==(int, const set&);
bool operator<=(int, const set&);

bool operator!=(int, const set&);
bool operator< (int, const set&);
bool operator=>(int, const set&);
bool operator> (int, const set&);

std::ostream& operator<<(std::ostream&, const set&);
std::iostream& operator>>(std::iostream&, set&);

#endif