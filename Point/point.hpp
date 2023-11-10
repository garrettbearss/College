// point.hpp
// Garrett Bearss

#ifndef CS2_POINT_HPP_
#define CS2_POINT_HPP_

#include <iostream>

class point {
    public:
        point(double, double);
        point();

        void init(double, double);
        void print(std::ostream&);

        double getx();
        double gety();

        void setx(double);
        void sety(double);

        point add(point);
        point operator+(point);
        point operator-(point);

        double dist(point);

        //friend std::ostream& operator<<(std::ostream&, point);

    private:
        double x, y;
};

std::ostream& operator<<(std::ostream&, point);

#endif