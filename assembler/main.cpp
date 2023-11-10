#include <iostream>
#include "string.hpp"
#include "stack.hpp"
#include "utilities.hpp"
#include <cassert>

//int main() {
  /*
  #include <iostream>
  #include "stack.hpp"
  #include "../string/string.hpp"
  #include <cassert>
  // test_ctor_default
  //int main(){
    // Setup #1
    stack<int> i;
    stack<char> c;
    stack<String> s;
    stack<double> d;
    // Test #1
    assert(i.empty());
    // Test #2
    assert(c.empty());
    // Test #3
    assert(s.empty());
    // Test #4
    assert(d.empty());
    
    std::cout << "Done test_ctor_default" << std::endl;
    //return 0;
  //}
  */

  /*
  #include <iostream>
  #include "stack.hpp"
  #include "../string/string.hpp"
  #include <cassert>
  // test_push_pop
  //int main(){
    // Setup #1
    stack<int> i;
    stack<char> c;
    stack<String> s;
    stack<double> d;
    int i_result; 
    char c_result;
    String s_result;
    double d_result;
    // Test #1
    i.push(10);
    i_result = i.pop();
    assert(i_result == 10);
    // Test #2
    c.push('c');
    c_result = c.pop();
    assert(c_result == 'c');
    // Test #3
    s.push("Garrett");
    s_result = s.pop();
    assert(s_result == "Garrett");
    // Test #4
    d.push(2.5);
    d_result = d.pop();
    assert(d_result == 2.5);

    std::cout << "Done test_push_pop" << std::endl;
    //return 0;
  //}
  */

  /*
  #include <iostream>
  #include "stack.hpp"
  #include "../string/string.hpp"
  #include <cassert>
  // test_assign
  //int main(){
    // Setup #1
    stack<int> i;
    stack<int> i2;
    stack<char> c;
    stack<char> c2;
    stack<String> s;
    stack<String> s2;
    stack<double> d;
    stack<double> d2;
    // Setup #2
    i.push(1);
    i.push(2);
    i.push(3);
    i.push(4);
    i2.push(4);
    i2.push(3);
    i2.push(2);
    i2.push(1);
    i.swap(i2);
    // Test #1
    assert(i.top() == 1);
    // Test #2
    assert(i2.top() == 4);
    // Setup #3
    c.push('a');
    c.push('b');
    c.push('c');
    c.push('d');
    c2.push('d');
    c2.push('c');
    c2.push('b');
    c2.push('a');
    c.swap(c2);
    // Test #3
    assert(c.top() == 'a');
    // Test #4
    assert(c2.top() == 'd');
    // Setup #4
    s.push("aaa");
    s.push("bbb");
    s.push("ccc");
    s.push("ddd");
    s2.push("ddd");
    s2.push("ccc");
    s2.push("bbb");
    s2.push("aaa");
    s.swap(s2);
    // Test #5
    assert(s.top() == "aaa");
    // Test #6
    assert(s2.top() == "ddd");
    // Setup #5
    d.push(1.1);
    d.push(2.2);
    d.push(3.3);
    d.push(4.4);
    d2.push(4.4);
    d2.push(3.3);
    d2.push(2.2);
    d2.push(1.1);
    d.swap(d2);
    // Test #7
    assert(d.top() == 1.1);
    // Test #8
    assert(d2.top() == 4.4);
    
    std::cout << "Done test_assign" << std::endl;
    //return 0;
  //}
  */

  /*
  #include <iostream>
  #include "stack.hpp"
  #include "../string/string.hpp"
  #include <cassert>
  // test_ctor_copy
  //int main(){
    // Setup #1
    stack<int> i;
    stack<char> c;
    stack<String> s;
    stack<double> d;
    // Setup #2
    i.push(100);
    i.push(101);
    stack<int> i2 = i;
    // Test #1
    assert(i.top() == 101);
    // Test #2
    assert(i2.top() == 101);
    // Test #3
    assert(i.pop() == 101);
    // Test #4
    assert(i2.pop() == 101);
    // Test #5
    assert(i.top() == 100);
    // Test #6
    assert(i2.top() == 100);
    // Test #7
    assert(i.pop() == 100);
    // Test #8
    assert(i2.pop() == 100);
    // Test #9
    assert(i.empty());
    // Test #10
    assert(i2.empty());
    // Setup #3
    c.push('!');
    c.push('%');
    stack<char> c2 = c;
    // Test #11
    assert(c.top() == '%');
    // Test #12
    assert(c2.top() == '%');
    // Test #13
    assert(c.pop() == '%');
    // Test #14
    assert(c2.pop() == '%');
    // Test #15
    assert(c.top() == '!');
    // Test #16
    assert(c2.top() == '!');
    // Test #17
    assert(c.pop() == '!');
    // Test #18
    assert(c2.pop() == '!');
    // Test #19
    assert(c.empty());
    // Test #20
    assert(c2.empty());
    // Setup #4
    s.push("Garrett");
    s.push("Bearss");
    stack<String> s2 = s;
    // Test #21
    assert(s.top() == "Bearss");
    // Test #22
    assert(s2.top() == "Bearss");
    // Test #23
    assert(s.pop() == "Bearss");
    // Test #24
    assert(s2.pop() == "Bearss");
    // Test #25
    assert(s.top() == "Garrett");
    // Test #26
    assert(s2.top() == "Garrett");
    // Test #27
    assert(s.pop() == "Garrett");
    // Test #28
    assert(s2.pop() == "Garrett");
    // Test #29
    assert(s.empty());
    // Test #30
    assert(s2.empty());
    // Setup #5
    d.push(0.25);
    d.push(0.5);
    stack<double> d2 = d;
    // Test #31
    assert(d.top() == 0.5);
    // Test #32
    assert(d2.top() == 0.5);
    // Test #33
    assert(d.pop() == 0.5);
    // Test #34
    assert(d2.pop() == 0.5);
    // Test #35
    assert(d.top() == 0.25);
    // Test #36
    assert(d2.top() == 0.25);
    // Test #37
    assert(d.pop() == 0.25);
    // Test #38
    assert(d2.pop() == 0.25);
    // Test #39
    assert(d.empty());
    // Test #40
    assert(d2.empty());

    std::cout << "Done test_ctor_copy" << std::endl;
    //return 0;
  //}
  */

  /*
  #include <iostream>
  #include "stack.hpp"
  #include "../string/string.hpp"
  #include <cassert>
  // test_dtor
  //int main(){
    // Setup #1
    stack<int> i;
    stack<char> c;
    stack<String> s;
    stack<double> d;
    i.push(1);
    i.push(2);
    c.push('c');
    c.push('v');
    s.push("Garrett");
    s.push("Bearss");
    d.push(1.1);
    d.push(1.2);
    // Test #1
    i.~stack();
    assert(i.empty());
    // Test #2
    c.~stack();
    assert(c.empty());
    // Test #3
    s.~stack();
    assert(s.empty());
    // Test #4
    d.~stack();
    assert(s.empty());

    std::cout << "Done test_dtor" << std::endl;
    return 0;
  //}
  */

  /*
  #include "utilities.hpp"
  #include <iostream>
  #include <fstream>
  #include "stack.hpp"
  #include "../string/string.hpp"
  #include <cassert>
  // postfix.cpp
  //int main(int argc, char* argv[]){
    std::ifstream in(argv[1]);
    if(!in){
      std::cerr << "Could not open file, exiting." << std::endl;
      exit(1);
    }
    else{
      if(argc == 2){
        String token;
        String infix;
        while(!in.eof()){
          in >> token;
          if(token != ";"){
            infix = infix + token + " ";
          }
          else{
            infix = infix + ";";
            String result = toPost(infix);
            std::cout << result << std::endl;
            infix = "";
          }
        }
      }
      if(argc == 3){
        std::ofstream file(argv[2]);
        String token;
        String infix;
        while(!in.eof()){
          in >> token;
          if(token != ";"){
            infix = infix + token + " ";
          }
          else{
            infix = infix + ";";
            file << infix << std::endl;
            String result = toPost(infix);
            file << result << std::endl;
            infix = "";
          }
        }
        file.close();
      }
    }

    std::cout << "Done with postfix";
    in.close();
    return 0;
    ////////////////////////////////////
    
    int main(int argc, char* argv[]){
    std::ifstream in(argv[1]);
    if(!in){
      std::cerr << "Specified infix file could not be opened" << std::endl;
    }
    std::ofstream file(argv[2]);
    if (!file) {
        toPost(in, std::cout);
    }
    else{
      toPost(in, file);
    }

    in.close();
    file.close();
    std::cout << "Done with postfix";
    return 0;
}
  //}
  */
//}