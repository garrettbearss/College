//point.cpp
// Garrett Bearss
#include "point.hpp"

point::point(){
  x = 0;
  y = 0;
}

point::point(double nx, double ny){
  x = nx;
  y = ny;
}

void point::init(double nx, double ny) {
    x = nx;
    y = ny;
}

double point::getx() {
    return x;
}

double point::gety() {
    return y;
}

void point::setx(double nx) {
    x = nx;
}

void point::sety(double ny) {
    y = ny;
}

point point::add(point rhs) {
    point result;

    result.x = x + rhs.x;
    result.y = y + rhs.y;

    result.setx( getx() + rhs.getx() );
    result.sety( gety() + rhs.gety() );

    return result;
}

point operator+(point rhs){
    point result;

    result.setx( getx() + rhs.getx() );
    result.sety( gety() + rhs.gety() );

    return result;
}

double point::dist(point rhs) {
  double result;

  return result;
}

void point::print(std::ostream& out) {
    out << "(" << x << ", " << y << ")"; 
}

std::ostream& operator<<(std::ostream& out, point rhs) {
  rhs.print(out);
  return out;
}

/*std::ostream& operator<<(std::ostream& out, point rhs){
  out << "(" << rhs.x << ", " << rhs.y << ")";
  return out;
}*/