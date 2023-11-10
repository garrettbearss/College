// logentry.cpp
// Version: 2
// Garrett Bearss

#include <iostream>
#include <vector> 

#include "string.hpp" 
#include "logentry.hpp"

Date::Date(){
  day = '\0';
  month = '\0';
  year = 0;
}

Date::Date(String temp){
  day = temp.substr(1, 2);
  month = temp.substr(3, 7);
  int count = 0;
  int i = 0;
  String string_temp = temp.substr(8, 11);
  while(string_temp[i] != 0){
    count = (string_temp[i] - '0') + (count * 10);
    i++;
  }
  year = count;
}

String Date::getMonth() const{
  return month;
}

String Date::getDay() const{
  return day;
}

int Date::getYear() const{
  return year;
}

Time::Time(){
  hour = 0;
  minute = 0;
  second = 0;
}

Time::Time(String s){
  int count = 0;
  int i = 0;
  String string_temp = s.substr(13,14);
  while(string_temp[i] != 0){
    count = (string_temp[i] - '0') + (count * 10);
    i++;
  }
  hour = count;
  count = 0;
  i = 0;
  string_temp = s.substr(16,17);
  while(string_temp[i] != 0){
    count = (string_temp[i] - '0') + (count * 10);
    i++;
  }
  minute = count;
  count = 0;
  i = 0;
  string_temp = s.substr(19,20);
  while(string_temp[i] != 0){
    count = (string_temp[i] - '0') + (count * 10);
    i++;
  }
  second = count;
}

int Time::getHour() const{
  return hour;
}

int Time::getMinute() const{
  return minute;
}

int Time::getSecond() const{
  return second;
}

LogEntry::LogEntry(String s) {
    std::vector<String> vec = s.split(' ');
    if(vec.size() != 10){
      return;
    }
    host = vec[0];
    date = vec[3];
    time = vec[3];
    request = vec[5] + vec[6] + vec[7];
    status = vec[8];
    String temp = vec[9].substr(0, vec[9].length());
    if(temp == '-'){
      number_of_bytes = 0;
    }
    else{
      int i = 0;
      int count = 0;
      while(temp[i] != 0){
        count = (temp[i] - '0') + (count * 10);
        i++;
      }
      number_of_bytes = count;
    }
}

Date LogEntry::getDate() const{
  return date;
}

String LogEntry::getHost() const{
  return host;
}

Time LogEntry::getTime() const{
  return time;
}

String LogEntry::getStatus() const{
  return status;
}

String LogEntry::getRequest() const{
  return request;
}

int LogEntry::getBytes() const{
  return number_of_bytes;
}

std::vector<LogEntry> parse(std::istream& in) {
    std::vector<LogEntry> result;
    char *temp = new char[300];
    while(!in.eof()){
      in.getline(temp, 300);
      String s = String(temp);
      if(s != ""){
        result.push_back(s);
      }
    }
    delete[] temp;
    return result;
}

/*const int BUF_SIZE = 500;
std::vector<LogEntry> parse(std::istream& in) {
  std::vector<LogEntry> result;
  char buf[BUF_SIZE];
  while (!in.eof()) {       
    in.getline(buf, BUF_SIZE);
    String line = String(buf);
    //std::cout << "line = " << line << std::endl;
    if (line != "") 
      result.push_back(LogEntry(line));    
  }
  return result;
}*/

void output_all(std::ostream& out, const std::vector<LogEntry> & v) {
  for(unsigned int i = 0; i < v.size(); i++){
    out << v[i].getHost() << " " << v[i].getDate().getDay() << v[i].getDate().getMonth() << v[i].getDate().getYear() << " " << v[i].getTime().getHour() << ":" << v[i].getTime().getMinute() << ":" << v[i].getTime().getSecond() << " " << v[i].getRequest() << " " << v[i].getStatus() << " " << v[i].getBytes() << std::endl;
  }
}

void by_host(std::ostream& out, const std::vector<LogEntry>& v) {
  for(unsigned int i = 0; i < v.size(); i++){
    out << v[i].getHost() << std::endl;
  }
}

int byte_count(const std::vector<LogEntry> & v) {
    int result = 0;
    for(unsigned int i = 0; i < v.size(); i++){
      result += v[i].getBytes();
    }
    return result;
}