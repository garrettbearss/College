// Garrett Bearss
// 2/16/2023
// rosterMap_Set.cpp
// vector and list algorithms with objects in containers
// Mikhail Nesterenko
// 9/10/2018

#include <fstream>
#include <iostream>
#include <vector>
#include <list>
#include <string>
#include <cstdlib>
#include <map>
#include <set>

using std::ifstream;
using std::string; 
using std::getline;
using std::list; 
using std::vector;
using std::cout; 
using std::endl;
using std::move;
using std::map;
using std::set;
using std::multiset;


class Student{
public:
   Student(string firstName, string lastName): 
      firstName_(firstName), lastName_(lastName) {}
 
   // move constructor, not really needed, generated automatically
   Student(Student && org) noexcept:
      firstName_(move(org.firstName_)),
      lastName_(move(org.lastName_))
   {}
  
   // force generation of default copy constructor
   Student(const Student & org) = default;
   
  string print() const {return firstName_ + ' ' + lastName_;}

    // needed for unique() and for remove()
   friend bool operator== (Student left, Student right){
      return left.lastName_ == right.lastName_ &&
	     left.firstName_ == right.firstName_;
   }

   // needed for sort()
   friend bool operator< (Student left, Student right){
      return left.lastName_ < right.lastName_ ||
	     (left.lastName_ == right.lastName_ && 
	      left.firstName_ < right.firstName_);
   }
private:
   list<string> courses_;
   string firstName_;
   string lastName_;
};

// Adds a student and their courses to the map
void addStud(map<Student, list<string>> &studCourseList, string file);

// Adds a student to the set
void addStud(set<Student> &studSet, string file);

// reading a list from a fileName
void readRoster(list<Student>& roster, string fileName);  
// printing a list out
void printRoster(const list<Student>& roster); 

// Prints the contents of the map
void printStudCourseList(map<Student, list<string>> studCourseList);

// Prints the contents of the set
void printStudSet(set<Student> studSet);

// Allows you to print a value from the list of courses
string printFromList(list<string>);

// Deletes a student's info from the map
void deleteStud(map<Student, list<string>> &studCourseList, string file);

// Deletes a student from the set
void deleteStud(set<Student> &studSet, string file);

int main(int argc, char* argv[]){
   if (argc <= 1){ cout << "usage: " << argv[0] << " list of courses, dropouts last" << endl; exit(1);}

   // vector of courses of students
   /*
   vector <list<Student>> courseStudents; 

   for(int i=1; i < argc-1; ++i){
      list<Student> roster;
      readRoster(roster, argv[i]);  
      cout << "\n\n" << argv[i] << "\n";  
      printRoster(roster);
      courseStudents.push_back(move(roster));
    */
    // Creation of the map
    map<Student, list<string>> studCourseList;
    // Adds all the students and their couses to the map
    for(int i = 1; i < argc - 1; ++i){
      addStud(studCourseList, argv[i]);
    }
    // Deletes and student who is a dropout from the map
    deleteStud(studCourseList, argv[argc-1]);
    // Prints the map
    printStudCourseList(studCourseList);

    // Part 2 of the lab
    cout << endl;
    cout << "Part #2 - sets" << endl;
    // Creation of the multiset
    set<Student> studSet;
    for(int i = 1; i < argc - 1; ++i){
      //cout << "Invoking add stud" << endl;
      addStud(studSet, argv[i]);
    }
    //cout << "Invoking delete" << endl;
    deleteStud(studSet, argv[argc-1]);
    //cout << "Invoking Print" << endl;
    printStudSet(studSet);

    /*
   // reading in dropouts
   list<Student> dropouts; 
   readRoster(dropouts, argv[argc-1]); 
   cout << "\n\n dropouts \n"; printRoster(dropouts);

   list<Student> allStudents;  // master list of students
 
   for(auto& lst : courseStudents) 
     allStudents.splice(allStudents.end(),lst);

   cout << "\n\n all students unsorted \n"; 
           printRoster(allStudents);

   allStudents.sort(); // sorting master list
   cout << "\n\n all students sorted \n"; printRoster(allStudents);

   allStudents.unique(); // eliminating duplicates
   cout << "\n\n all students, duplicates removed \n"; printRoster(allStudents);
   
   for (const auto& str : dropouts)  // removing individual dropouts
      allStudents.remove(str);
   cout << "\n\n all students, dropouts removed \n"; printRoster(allStudents);
  */
}

/*
void readRoster(list<Student>& roster, string fileName){
   ifstream course(fileName);
   string first, last;
   while(course >> first >> last)
      roster.push_back(Student(first, last));
   course.close();
}

// printing a list out
void printRoster(const list<Student>& roster){
  cout << "All Students" << endl;
  cout << "firstName lastName: courses currently enrolled" << endl;
   for(const auto& student : roster)
      cout << student.print() << endl;
}
*/

// Reads in the student file to get the name and course and adds it to the map
void addStud(map<Student, list<string>> &studCourseList, string file){
  ifstream courseID(file);
  string s1;
  string s2;
  // While there is something to read in from the files
  while(courseID >> s1 >> s2){
    // Get the course name from the file
    string course = file.substr(0, file.length() - 4);
    // Converts it to uppercase lettering
    for(auto & s: course){
      s = toupper(s);
    }
    // Add student and the courses associated to their name
    studCourseList[Student(s1, s2)].push_back(course);
  }
  // Close the file stream
  courseID.close();
}

// Adds a student object to the set
void addStud(set<Student> &studSet, string file){
  //cout << "Inside add Stud" << endl;
  ifstream courseID(file);
  string s1; 
  string s2;
  int i = 0;
  while(courseID >> s1 >> s2){
      studSet.insert(Student(s1,s2));
  }
  courseID.close();
}

// Allows you to print the second part from the map by using this function to construct the value out of the list of strings
string printFromList(const list<string> list){
  string s1 = "";
  // Build up the string by traversing through the list
  for(const auto item: list){
    s1 += item + " ";
  }
  return s1;
}

// Prints the student's first and last name and the courses associated with that student from the map
void printStudCourseList(map<Student, list<string>> studCourseList){
  cout << "All Students" << endl;
  cout << "firstName lastName: courses currently enrolled" << endl;
  // Traverse the map to print student's name and the courses they are enrolled
  for(map<Student, list<string>>::iterator it = studCourseList.begin(); it != studCourseList.end(); ++it){
    cout << it->first.print() << ": " << printFromList(it->second) << endl;
  }
}

// Prints the student objects located in the set
void printStudSet(set<Student> studSet){
  cout << "Currently Enrolled Students" << endl;
  // For each element in the set, print out the first and last name of the students
  for(const Student e: studSet){
    //cout << "Printing student" << endl;
    cout << e.print() << endl;
  }
}

// Removes a student from the map
void deleteStud(map<Student, list<string>> &studCourseList, string file){
  ifstream courseID(file);
  string s1;
  string s2;
  // While there is values to read in from the txt file
  while(courseID >> s1 >> s2){
    // Deletes the student from the map based on the read in name
    studCourseList.erase(Student(s1, s2));
  }
  // Closes the file stream
  courseID.close();
}

// Removes a student from the set
void deleteStud(set<Student> &studSet, string file){
  ifstream courseID(file);
  string s1;
  string s2;
  // While there is values to read in from the txt file
  while(courseID >> s1 >> s2){
    Student temp(s1, s2);
    // If that Student is in the dropouts list, remove it from the set
    set<Student>::iterator it2;
    // Traverses the set searching for if the student exists in the set
    for(auto it = studSet.begin(); it != studSet.end();){
      // If the student exists set a temp iterator to before the deletion and then erase the value and countine from the temp iterator
      if(temp == *it){
        it2 = it;
        ++it2;
        studSet.erase(it);
        it = it2;
      }
      else{
        ++it;
      }
    }
  }
}