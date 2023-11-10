#ifndef UTILITIES_HPP
#define UTILITIES_HPP
#include <iostream>
#include <fstream>
#include "stack.hpp"
#include "../string/string.hpp"

String toPost(std::ifstream&);
void toAssembly(const String&);
String evaluate(const String&, const String&, const String&, bool[]);
String intToString(int);
bool ifOp(String);
String findOp(String);

#endif