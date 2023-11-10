// bigint.hpp
// Version: 7
// Garrett Bearss

#ifndef CS2_BIGINT_HPP_
#define CS2_BIGINT_HPP_

#include <iostream>
#include <fstream>
const int CAPACITY = 200;

class bigint{
  public:
    bigint();
    bigint(int);
    bigint(const char[]);

    void debugPrint(std::ostream&) const;

    bool operator==(const bigint&) const;
    bigint operator+(const bigint&) const;
    bigint operator*(const bigint&) const;
    bigint timesDigit(int) const;
    bigint times10(int) const;
    int operator[](int) const;

    int getArrayIndex(int);
  private:
    int array[CAPACITY];
};

bigint operator+(int, const bigint&);
bigint operator*(int, const bigint&);
std::istream& operator>>(std::istream&, bigint&);
std::ostream& operator<<(std::ostream&, bigint);

#endif