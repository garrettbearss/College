//main.cpp
// Garrett Bearss
#include "bigint.hpp"
#include <cassert>
#include <iostream>
#include <fstream>

/*int main() {
  // Milestone #1 Testing
  bigint a = bigint(128);
  bigint b = bigint(299793);
  bigint c = bigint();
  bigint d = bigint(128);
  bigint e = bigint("101");
  bigint f = bigint("123456789");
  bigint g = bigint("123456789012345678901234567890123456789012345678901234567890123456789012345678901");

  a.debugPrint(std::cout);
  std::cout<< std::endl;

  b.debugPrint(std::cout);
  std::cout<< std::endl;

  c.debugPrint(std::cout);
  std::cout<< std::endl;

  e.debugPrint(std::cout);
  std::cout<< std::endl;

  std::cout << a << std::endl;
  f.debugPrint(std::cout);
  std::cout<< std::endl;
  
  std::cout << f << std::endl;

  assert(c == 0);
  assert(e == 101);
  std::cout << g << std::endl;*/

  // Milestone #2 Testing - add.cpp
    /*std::ifstream in("data1-1.txt");
    // Checks to see if the file could be opened
    if(!in) {
        std::cerr << "Could not open data1-1.txt, exiting." << std::endl;
        exit(1);
    }
    // Creates some bigint variables 
    bigint a;
    bigint b;
    bigint result;
    // While - able to create two new bigint variables
    while(in >> a && in >> b){
      // Prints the 1st bigint read in from the file
      std::cout << "a: " << a << std::endl;
      // Prints the 2nd bigint read in from the file
      std::cout << "b: " << b << std::endl;
      // Stores the result of adding the two bigints
      result = a + b;
      // Prints the result to the screen
      std::cout << "result: " << result << std::endl;
    }
    // Closes the file
    in.close();
    return 0;*/

  // Milestone #2 Testing
     /*bigint threeDigit(101);
     bigint twoDigit(86);
     bigint oneDigit(9);
     bigint zero(0);
     bigint result;

     // #1
     result = threeDigit + threeDigit;
     assert(result == 202);

     // #2
     result = threeDigit + twoDigit;
     assert(result == 187);

     // #3
     result = threeDigit + oneDigit;
     assert(result == 110);

     // #4
     result = threeDigit + zero;
     assert(threeDigit == 101);

     // #5
     result = twoDigit + twoDigit;
     assert(result == 172);


     // #6
     result = twoDigit + oneDigit;
     assert(result == 95);

     // #7
     result = twoDigit + zero;
     assert(result == 86);

     // #8
     result = oneDigit + oneDigit;
     assert(result == 18);

     // #9
     result = oneDigit + zero;
     assert(result == 9);

     // #10
     result = zero + zero;
     assert(result == 0);

    // Setup Fixture #2
    bigint threeToFour(555);
    bigint twoToThree(55);
    bigint oneToTwo(5);

    // #11
    result = threeToFour + threeToFour;
    assert(result == 1110);

    // #12
    result = twoToThree + twoToThree;
    assert(result == 110);

    // #13
    result = oneToTwo + oneToTwo;
    assert(result == 10);

    // #14
    result = oneToTwo + zero;
    assert(result == 5);

    // #15
    result = threeToFour + 445;
    assert(result == 1000);

    // #16
    result = twoToThree + 45;
    assert(result == 100);

    // #17
    result = oneToTwo + 5;
    assert(result == 10);

    // #18
    result = oneToTwo + 0;
    assert(result == 5);

    // #19
    result = 445 + threeToFour;
    assert(result == 1000);

    // #20
    result = 45 + twoToThree; 
    assert(result == 100);

    // #21
    result = 5 + oneToTwo;
    assert(result == 10);

    // #22
    result = 0 + oneToTwo;
    assert(result == 5);

    // #23
    result = 101 + 101;
    assert(result == 202);

    // #24
    result = 0 + 101;
    assert(result == 101);

    // #25
    result = 0 + 0;
    assert(result == 0);*/

  // Milestone #3 Testing - multiply.cpp
    /*std::ifstream in("fileio-data-1.txt");
    //std::ifstream in("data1-1.txt");
    // Checks to see if the file could be opened
    if(!in) {
        std::cerr << "Could not open data1-1.txt, exiting." << std::endl;
        exit(1);
    }
    // Creates some bigint variables 
    bigint a;
    bigint b;
    bigint result;
    // While - able to create two new bigint variables
    while(in >> a && in >> b){
      // Prints the 1st bigint read in from the file
      std::cout << "a: " << a << std::endl;
      // Prints the 2nd bigint read in from the file
      std::cout << "b: " << b << std::endl;
      // Stores the result of adding the two bigints
      result = a * b;
      // Prints the result to the screen
      std::cout << "result: " << result << std::endl;
    }
    // Closes the file
    in.close();
    return 0;*/
  
  // Milestone #3 Testing - test_multiply.cpp
     /*bigint threeDigit(666);
     bigint twoDigit(11);
     bigint oneDigit(5);
     bigint zero(0);
     bigint result;

     // #1
     result = threeDigit * threeDigit;
     assert(result == 443556);

     // #2
     result = threeDigit * twoDigit;
     assert(result == 7326);

     // #3
     result = threeDigit * oneDigit;
     assert(result == 3330);

     // #4
     result = threeDigit * zero;
     assert(result == 0);

     // #5
     result = twoDigit * twoDigit;
     assert(result == 121);


     // #6
     result = twoDigit * oneDigit;
     assert(result == 55);

     // #7
     result = twoDigit * zero;
     assert(result == 0);

     // #8
     result = oneDigit * oneDigit;
     assert(result == 25);

     // #9
     result = oneDigit * zero;
     assert(result == 0);

     // #10
     result = zero * zero;
     assert(result == 0);

    // Setup Fixture #2
    bigint hundred(100);
    bigint ten(10);
    bigint one(1);

    // #11
    result = hundred * hundred;
    assert(result == 10000);

    // #12
    result = ten * ten;
    assert(result == 100);

    // #13
    result = one * one;
    assert(result == 1);

    // #14
    result = one * zero;
    assert(result == 0);

    // #15
    result = hundred * 445;
    assert(result == 44500);

    // #16
    result = ten * 45;
    assert(result == 450);

    // #17
    result = one * 5;
    assert(result == 5);

    // #18
    result = one * 0;
    assert(result == 0);

    // #19
    result = 445 * hundred;
    assert(result == 44500);

    // #20
    result = 45 * ten;
    assert(result == 450);

    // #21
    result = 5 * 2;
    assert(result == 10);

    // #22
    result = 0 * one;
    assert(result == 0);

    // #23
    result = 101 * 101;
    assert(result == 10201);

    // #24
    result = 0 * 101;
    assert(result == 0);

    // #25
    result = 0 * 0;
    assert(result == 0);*/

  // Milestone #3 Testing - test_times_10.cpp
  /*bigint five(5);
  bigint twenty(20);
  bigint zero(0);
  bigint one(1);
  bigint num(12345);
  bigint result;

  // #1
  result = five.times10(1);
  assert(result == 50);

  // #2
  result = five.times10(2);
  assert(result == 500);

  // #3
  result = five.times10(0);
  assert(result == 5);

  //#4
  result = five.times10(8);
  assert(result == 500000000);

  // #5
  result = twenty.times10(1);
  assert(result == 200);

  // #6
  result = twenty.times10(2);
  assert(result == 2000);

  // #7
  result = twenty.times10(0);
  assert(result == 20);

  // #8
  result = twenty.times10(8);
  assert(result == 2000000000);

  // #9
  result = one.times10(1);
  assert(result == 10);

  // #10
  result = one.times10(2);
  assert(result == 100);

  // #11
  result = one.times10(0);
  assert(result == 1);

  // #12
  result = one.times10(7);
  assert(result == 10000000);

  // #13
  result = zero.times10(1);
  assert(result == 0);

  // #14
  result = zero.times10(0);
  assert(result == 0);

  // #15
  result = zero.times10(2);
  assert(result == 0);

  // #16
  result = zero.times10(9);
  assert(result == 0);
  
  // #17
  result = num.times10(0);
  assert(result == 12345);

  // #18
  result = num.times10(1);
  assert(result == 123450);

  // #19
  result = num.times10(2);
  assert(result == 1234500);

  // #20
  result = num.times10(5);
  assert(result == 1234500000);*/

  // Milestone #3 Testing - test_times_digit.cpp
  /*bigint five(5);
  bigint twenty(20);
  bigint zero(0);
  bigint one(1);
  bigint num(12345);
  bigint result;

  // #1
  result = five.timesDigit(1);
  assert(result == 5);

  // #2
  result = five.timesDigit(2);
  assert(result == 10);

  // #3
  result = five.timesDigit(0);
  assert(result == 0);

  //#4
  result = five.timesDigit(9);
  assert(result == 45);

  // #5
  result = twenty.timesDigit(1);
  assert(result == 20);

  // #6
  result = twenty.timesDigit(2);
  assert(result == 40);

  // #7
  result = twenty.timesDigit(0);
  assert(result == 0);

  // #8
  result = twenty.timesDigit(9);
  assert(result == 180);

  // #9
  result = one.timesDigit(1);
  assert(result == 1);

  // #10
  result = one.timesDigit(2);
  assert(result == 2);

  // #11
  result = one.timesDigit(0);
  assert(result == 0);

  // #12
  result = one.timesDigit(9);
  assert(result == 9);

  // #13
  result = zero.timesDigit(1);
  assert(result == 0);

  // #14
  result = zero.timesDigit(2);
  assert(result == 0);

  // #15
  result = zero.timesDigit(0);
  assert(result == 0);

  // #16
  result = zero.timesDigit(9);
  assert(result == 0);

  // #17
  result = num.timesDigit(1);
  assert(result == 12345);

  // #18
  result = num.timesDigit(2);
  assert(result == 24690);

  // #19
  result = num.timesDigit(0);
  assert(result == 0);

  // #20
  result = num.timesDigit(9);
  assert(result == 111105);
}*/

///////////////////////////////////////////////////////////////////////////
//  bug1.cpp
//   
// 
//   Created by jmaletic on 9/9/13.
// 
//   This code prints out a sets of random numbers, no duplicates per set.
//
//   There is a bug in this code.  It compiles but seems to get into an infinit loop.
//   Find the bug.
//
//   Step 1: Compile the program clang++ -Wall bug1.cpp -o buggy
//           Run it ./buggy  ctrl c to break it.
//   Step 2: Read over the code and figure out what it does a bit.
//           Insert print statements into the different loops to 
//           determine where the infinite loop is occurring.
//           Start in the main and work down the call stack.
//   Step 3: Once you figure out what loop is the problem try to 
//           figure out what it is supposed to do and why its broken.
//   Step 4: Make the fix and compile/run the program
//   Step 5: Does it work?  



#include <iostream>
#include <cstdlib>

const int MAX             = 6;
const int SIZE_OF_SAMPLES = 3;
const int REP             = 5;

bool inArray     (int[], int, int  );
void UniqRandInt (int,   int, int[]);



///////////////////////////////////////////////////////////////////////////
int main() {
//    std::cerr<<"in main\n";

    int arr[SIZE_OF_SAMPLES];
    
    srand(9809);  //Seed random number generator.
    

    for (int i = 0; i < REP; i++) {
        UniqRandInt(MAX, SIZE_OF_SAMPLES, arr);
        for(int j = 0; j < SIZE_OF_SAMPLES; j++) {
            std::cout << arr[i] << " ";
        }
        std::cout << std::endl;
    }
    return 0;
}

///////////////////////////////////////////////////////////////////////////
// result[n] will be initialized with a set of random numbers, no duplicates
//           Values between 0 and max.
// 
void UniqRandInt(int max, int n, int result[]) {

    int cntr = 0, r;

    while(cntr < n) {

        r = rand();  //Get random number
        r = r % (max + 1);
        if (!inArray(result, cntr, r)) {
            result[cntr] =  r;
            cntr++;
        }
    }
    return;
}

///////////////////////////////////////////////////////////////////////////
// Check if x is included in array[] of arrSize.
// Returns: 1 if x is a member
//           0 if x is not a member
// 
bool inArray(int array[], int arrSize, int x) {
    for (int i = 0; i < arrSize; ++i) {
        if (array[i] == x) {
            return true;
        }
    }
    return false;
}