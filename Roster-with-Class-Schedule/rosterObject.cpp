// Garrett Bearss
// rosterObject.cpp
// 2/9/2023
// vector and list algorithms with objects in containers
// Mikhail Nesterenko
// 9/10/2018

#include <fstream>
#include <iostream>
#include <vector>
#include <list>
#include <string>
#include <cstdlib>
#include <algorithm>

using std::ifstream;
using std::string; using std::getline;
using std::list; using std::vector;
using std::cout; using std::endl;
using std::move;


class Student{
public:
  Student(string firstName, string lastName): 
    firstName_(firstName), lastName_(lastName) {}

  // move constructor, not really needed, generated automatically
  Student(Student && org):
    firstName_(move(org.firstName_)), lastName_(move(org.lastName_)){}
  
  // force generation of default copy constructor
  Student(const Student & org) = default;
   
  string print() const {
    std::string result = firstName_ + " " + lastName_ + ": ";
    for(auto& course : coursesList_) {
      result += course + " ";
    } 
    return result;
  }

  // Allows you to set the course list of student by passing in a list of strings containing their classes
  void setCoursesList(list<string> cList) {
    coursesList_ = cList;
  }
  

  // needed for unique() and for remove()
  friend bool operator== (Student left, Student right){
      return left.lastName_ == right.lastName_ && left.firstName_ == right.firstName_;
  }

  // needed for sort()
  friend bool operator< (Student left, Student right){
      return left.lastName_ < right.lastName_ || (left.lastName_ == right.lastName_ && left.firstName_ < right.firstName_);
  }  
private:
  list<string> coursesList_;
  string firstName_;
  string lastName_;
};




// reading a list from a fileName
void readRoster(list<Student>& roster, string fileName);  
// printing a list out
void printRoster(const list<Student>& roster); 
// Gets all the courses the student is currently enrolled in
list<string> getCourses(Student, vector <list<Student>>);

int main(int argc, char* argv[]){
  if (argc <= 1) {
    cout << "usage: " << argv[0] << " list of courses, dropouts last" << endl; exit(1);
  }

  // vector of courses of students
  vector <list<Student>> courseStudents; 

  for(int i=1; i < argc-1; ++i){
    list<Student> roster;
    readRoster(roster, argv[i]);  
    //cout << "\n\n" << argv[i] << "\n";  
    //printRoster(roster);
    courseStudents.push_back(move(roster)); 
  }


  // reading in dropouts
  list<Student> dropouts; 
  readRoster(dropouts, argv[argc-1]); 
  //cout << "\n\n dropouts \n"; printRoster(dropouts);

  list<Student> allStudents;  // master list of students

  // Insted of splicing, copy the values into allstudents
  for(auto& lst : courseStudents){
    //allStudents.splice(allStudents.end(),lst);
    // copy rather than moving out of lst
    allStudents.insert(allStudents.end(), lst.begin(), lst.end());
  }


  //cout << "\n\n all students unsorted \n"; 
  //printRoster(allStudents);

  allStudents.sort(); // sorting master list
  //cout << "\n\n all students sorted \n"; printRoster(allStudents);

  allStudents.unique(); // eliminating duplicates
  //cout << "\n\n all students, duplicates removed \n"; printRoster(allStudents);
   
  for (const auto& str : dropouts){  // removing individual dropouts
    allStudents.remove(str);
  }
  //cout << "\n\n all students, dropouts removed \n"; 
  //printRoster(allStudents);

  // For each student in allStudents, get the student's name and then their corresponding courses and store it in a new list of strings and set each student's coursesList to the retreived one
  for(auto& student : allStudents){
    // Gets all the courses of a student and then set's the student objects course list to the list provided by getCourses
    list<string> courseList = getCourses(student, courseStudents);
    student.setCoursesList(courseList);
  }
  printRoster(allStudents);
}


void readRoster(list<Student>& roster, string fileName){
  ifstream course(fileName);
  string first, last;
  while(course >> first >> last){
    roster.push_back(Student(first, last));
  }
  course.close();
}

// printing a list out
void printRoster(const list<Student>& roster){
  cout << "All Students, dropouts removed, sorted" << endl;
  cout << "firstName lastName: courses currently enrolled" << endl;
  for(const auto& student : roster)
    cout << student.print() << endl;
}

// Finds all instances of where a student's name is within a textfile and then adds the corresponding course to their course list
list<string> getCourses(Student stud, vector <list<Student>> courseStudents){
  list<string> coursesList;
  // Loop through the size of the vector checking to see if any of the courses match with the students and if so add that course to the student's list of courses
  for(vector<int>::size_type i = 0; i < courseStudents.size(); ++i){
    list<Student> studentList = courseStudents[i];
    // If the student exists within a certain course, add that course to it's list of courses
    if(std::find(studentList.begin(), studentList.end(), stud) != studentList.end()){
      // Add the course to the list of courses
      coursesList.push_back("CS" + std::to_string(i + 1));
    }
  }
  return coursesList;
}