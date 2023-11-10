// Garrett Bearss
// roster.cpp
// 2/9/2023
// vector and list algorithms
// Mikhail Nesterenko
// 3/11/2014

#include <fstream>
#include <iostream>
#include <vector>
#include <list>
#include <string>
#include <cstdlib>
#include <algorithm>

using std::ifstream;
using std::string; 
using std::getline;
using std::list; 
using std::vector;
using std::cout; 
using std::endl;
using std::move;

// reading a list from a fileName
void readRoster(list<string>& roster, string fileName);  

// printing a list out
void printRoster(const list<string>& roster); 

// Prints the student's name followed by the courses they are enrolled in
void printStudentCourseList(vector <list<string>> studentCourseList);

// Goes through each txt file to find the courses a student is in a returns that list of strings to be placed into a student's private variable list
list<string> getStudCourseList(string name, vector <list<string>> courseStudents);


int main(int argc, char* argv[]){
  if (argc <= 1){ 
    cout << "usage: " << argv[0] << " list of courses, dropouts last" << endl; exit(1);
  }

  // vector of courses of students
  vector <list<string>> courseStudents; 
  // Used to store the students attached to their respective courses
  vector <list<string>> studentCourseList;
  for(int i=1; i < argc-1; ++i){
    list<string> roster;
    readRoster(roster, argv[i]);  
    //cout << "\n\n" << argv[i] << "\n";  
    //printRoster(roster);
    courseStudents.push_back(move(roster)); 
  }

  // reading in dropouts
  list<string> dropouts; 
  readRoster(dropouts, argv[argc-1]); 
  //cout << "\n\n dropouts \n"; printRoster(dropouts);

  // master list of students
  list<string> allStudents;  
 
  for(auto& lst : courseStudents){
    //    allStudents.splice(allStudents.end(), lst);
    // copy rather than moving out of lst
    allStudents.insert(allStudents.end(), lst.begin(), lst.end());
  }

  //cout << "\n\n all students unsorted \n"; 
  //printRoster(allStudents);

  // sorting master list
  allStudents.sort();
  //cout << "\n\n all students sorted \n"; 
  //printRoster(allStudents);

  // eliminating duplicates
  allStudents.unique(); 
  //cout << "\n\n all students, duplicates removed \n"; 
  //printRoster(allStudents);

  // removing individual dropouts
  for(const auto& str : dropouts){
    allStudents.remove(str);
  }

  //cout << "\n\n all students, dropouts removed \n"; 
  //printRoster(allStudents);
  for(const auto& studentName : allStudents){
    list<string> scList = getStudCourseList(studentName, courseStudents);
    studentCourseList.push_back(move(scList));
  }
  printStudentCourseList(studentCourseList);
}

// reading in a file of names into a list of strings
void readRoster(list<string>& roster, string fileName){
  ifstream course(fileName);    
  string first, last;
  while(course >> first >> last){
    roster.push_back(move(first + ' ' + last));
  }
  course.close();
}

// printing a list out
void printRoster(const list<string>& roster){
  for(const auto& str : roster){
    cout << str << endl;
  }
}

// How it should be displayed
// All Students
// First name, last name:  courses currently enrolled
void printStudentCourseList(vector <list<string>> studentCourseList){
  cout << "All Students, dropouts removed, sorted" << endl;
  cout << "firstName lastName: courses currently enrolled" << endl;
  // For each string in the studentCourseList, print the colon then print what the iterator's current value till it reaches the end
  for(list<string>& studentCourseList : studentCourseList){
    list<string>::iterator it = studentCourseList.begin();
    cout << *it << ": ";
    ++it;
    // While the iterator isn't at the end of the list
    while(it != studentCourseList.end()){
      cout << *it << " ";  
      ++it;
    }
    cout << endl;
  }
}

// Finds all the courses a student it in and returns the list of courses corresponding 
list<string> getStudCourseList(string name, vector <list<string>> courseStudents){
  list<string> studCourseList;
  // Pushes the student's name into the list, followed by the respective courses of that student
  studCourseList.push_back(name);
  for(vector<int>::size_type i = 0; i < courseStudents.size(); ++i){
    // Creates a list holding each of the student's respective names
    list<string> studList = courseStudents[i];
    // If the studentList currently has that name within the roster
    if(std::find(studList.begin(), studList.end(), name) != studList.end()){
      // Add that course to the respective person via pushing it onto the course list
      studCourseList.push_back("CS" + std::to_string(i+1));
    }
  }
  return studCourseList;
}