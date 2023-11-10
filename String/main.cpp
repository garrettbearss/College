/*#include <iostream>
#include <fstream>
#include "string.hpp"
#include <cassert>
#include <vector>*/
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <vector>

#include "string.hpp" 
#include "logentry.hpp"

//int main() {
  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_default_ctor.cpp
  //int main(){
    String str;
    assert(str[0] == 0);
    assert(str == "");

    std::cout << "Done test_default_ctor" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_equal.cpp
  //int main(){
    // Setup #1
    String str1;
    String str2;
    // Test #1
    assert(str1 == str2);
    // Setup #2
    str1 = "25";
    str2 = "25";
    // Test #2
    assert(str1 == "25");
    // Test #3
    assert("25" == str1);
    // Test #4
    assert(str1 == str2);
    // Setup #3
    str1 = "Never gonna give you up";
    str2 = "Never gonna give you up";
    // Test #5
    assert(str1 == "Never gonna give you up");
    // Test #6
    assert("Never gonna give you up" == str1);
    // Test #7
    assert(str1 == str2);
    // Test #8
    assert("25" == "25");

    std::cout << "Done test_equal" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_ctor_char.cpp
  //int main(){
    // Setup #1
    String str1('a');
    String str2('a');
    // Test #1
    assert(str1 == "a");
    // Test #2
    assert(str1 == 'a');
    // Test #3
    assert("a" == str1);
    // Test #4
    assert('a' == str1);
    // Test #5
    assert(str1 == str2);
    // Setup #2
    str1 = 'b';
    str2 = 'b';
    // Test #6
    assert(str1 == "b");
    // Test #7
    assert(str1 == 'b');
    // Test #8
    assert("b" == str1);
    // Test #9
    assert('b' == str1);
    // Test #10
    assert(str1 == str2);

    std::cout << "Done test_ctor_char" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_ctor_charArray.cpp
  //int main(){
    // Setup #1
    String str1("Garrett Bearss");
    String str2("Garrett Bearss");
    // Test #1
    assert(str1 == "Garrett Bearss");
    // Test #2
    assert("Garrett Bearss" == str1);
    // Test #3
    assert(str1 == str2);
    // Setup #2
    str1 = ("You are gonna get a good grade");
    str2 = ("You are gonna get a good grade");
    // Test #4
    assert(str1 == "You are gonna get a good grade");
    // Test #5
    assert("You are gonna get a good grade" == str1);
    // Test #6
    assert(str1 == str2);

    std::cout << "Done test_ctor_charArray" << std::endl;
    return 0;
  //}
  */
  
  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_lessThan.cpp
  //int main(){
    // Setup #1
    String str1("Garrett");
    String str2("Bearss");
    // Test #1
    assert(str2 < str1);
    // Test #2
    assert(str1 > str2);
    // Test #3
    assert(str2 <= str1);
    // Test #4
    assert(str1 >= str2);
    // Test #5
    assert(str1 != str2);
    // Setup #2
    str1 = "Haha";
    str2 = "Haha";
    // Test #6
    assert(str1 <= str2);
    // Test #7
    assert(str1 >= str2);
    // Test #8
    assert(str2 <= str1);
    // Test #9
    assert(str2 >= str1);

    std::cout << "Done test_lessThan" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_concat.cpp
  //int main(){
    // Setup #1
    String str1("Get");
    String str2("Go");
    String result;
    // Test #1
    result = str1 + str2;
    assert(result == "GetGo");
    // Test #2
    result = str2 + str1;
    assert(result == "GoGet");
    // Test #3
    str1 += str2;
    assert(str1 == "GetGo");
    // Test #4
    str2 += str1;
    assert(str2 == "GoGetGo");
    // Setup #2
    str1 = "Garrett ";
    str2 = "Bearss";
    // Test #5
    result = str1 + str2;
    assert(result == "Garrett Bearss");
    // Test #6
    result = str2 + str1;
    assert(result == "BearssGarrett ");
    // Test #7
    str1 += str2;
    assert(str1 == "Garrett Bearss");
    // Test #8
    str2 += str1;
    assert(str2 == "BearssGarrett Bearss");
    // Test #9
    str1 = "Garrett";
    result = str1 + "Go";
    assert(result == "GarrettGo");
    // Test #10
    result = "Go" + str1;
    assert(result == "GoGarrett");
    // Test #11
    result = "" + str1;
    assert(result == str1);
    // Test #12
    result = str1 + "";
    assert(result == str1);
    // Setup #2
    str1 = "ab";
    str2 = "ab";
    // Test #13
    result = str1 + str2;
    assert(result == "abab");
    
    std::cout << "Done test_concat" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_subscript.cpp
  //int main(){
    // Setup #1
    String str1("Garrett Bearss");
    // Test #1
    assert(str1[0] == 'G');
    // Test #2
    assert(str1[1] == 'a');
    // Test #3
    assert(str1[2] == 'r');
    // Test #4
    assert(str1[3] == 'r');
    // Test #5
    assert(str1[4] == 'e');
    // Test #6
    assert(str1[5] == 't');
    // Test #7
    assert(str1[6] == 't');
    // Setup #2
    str1 = " G2";
    // Test #8
    assert(str1[0] == ' ');
    // Test #9
    assert(str1[1] == 'G');
    // Test #10
    assert(str1[2] == '2');
    // Setup #3
    String str2;
    // Test #11
    assert(str2[0] == '\0');
    // Test #12
    assert(str2[0] == 0);

    std::cout << "Done test_subscript" << std::endl;
    return 0;
  //}
  */
  

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_len_cap.cpp
  //int main(){
    // Setup #1
    String str1 = "Garrett";
    String str2 = "Bearss";
    // Test #1
    assert(str1.length() == 7);
    // Test #2
    assert(str2.length() == 6);
    // Test #3 (old)
    //assert(str1.capacity() == 255);
    assert(str1.capacity() == 7);
    // Test #4 (old)
    //assert(str2.capacity() == 255);
    assert(str2.capacity() == 6);
 
    std::cout << "Done test_len_cap" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_input.cpp
  //int main(){
    //(Old Tests)
    std::ifstream in("data1-1.txt");
    if(!in) {
        std::cerr << "Could not open data1-1.txt, exiting." << std::endl;
        exit(1);
    }
    String a;
    int count = 0;
    while(in >> a){
      if(count == 0){
        std::cout<< a << std::endl;
        assert(a == "10000000000000000000000000000000000345;");
        count++;
      }
      else if(count == 1){
        std::cout<< "Test #2" << std::endl;
        assert(a == "299793000000");
        count++;
      }
      else if(count == 2){
        std::cout<< "Test #3" << std::endl;
        assert(a == "00000000000000000000067;");
        count++;
      }
      else if(count == 3){
        std::cout<< "Test #4" << std::endl;
        assert(a == "4208574289572473098273498723475;");
        count++;
      }
      else if(count == 4){
        std::cout<< "Test #5" << std::endl;
        assert(a == "28375039287459832728745982734509872340985729384750928734590827098752938723;");
        count++;
      }
      else if(count == 5){
        std::cout<< "Test #6" << std::endl;
        assert(a == "99999999;");
        count ++;
      }
      else if(count == 6){
        std::cout<< "Test #7" << std::endl;
        assert(a == "99999999;");
        count++;
      }
      else{
      }
    }
    std::ifstream in("data1-2.txt");
    if(!in) {
        std::cerr << "Could not open data1-2.txt, exiting." << std::endl;
        exit(1);
    }
    String a;
    int count = 0;
    while(in >> a){
      if(count == 0){
        assert(a == "Hello");
        count++;
      }
      else if(count == 1){
        assert(a == "Garrett");
        count++;
      }
      else if(count == 2){
        assert(a == "I");
        count++;
      }
      else if(count == 3){
        assert(a == "guess");
        count++;
      }
      else if(count == 4){
        assert(a == "this");
        count++;
      }
      else if(count == 5){
        assert(a == "should");
        count++;
      }
      else if(count == 6){
        assert(a == "work");
        count++;
      }
      else{
      }
    }

    std::cout << "Done test_input" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_find_char.cpp
  //int main(){
    // Setup #1
    String str1 = "Garrett Bearss";
    String str2;
    // Test #1
    assert(str1.findch(0, 'G') == 0);
    // Test #2
    assert(str1.findch(0, 's') == 12);
    // Test #3
    assert(str1.findch(13, 's') == 13);
    // Test #4
    assert(str1.findch(3, 'r') == 3);
    // Test #5
    assert(str1.findch(0, ' ') == 7);
    // Test #6
    assert(str1.findch(0, 'g') == -1);
    // Test #7
    assert(str2.findch(0, 'z') == -1);

    std::cout << "Done test_find_char" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_find_string.cpp
  //int main(){
    // Setup #1
    String str1 = "I went home from work at 10:00";
    String str2 = "home";
    String str3 = "zzzape";
    // Test #1
    assert(str1.findstr(0, str2) == 7);
    // Test #2
    assert(str1.findstr(7, str2) == 7);
    // Test #3
    assert(str1.findstr(0, "0") == 26);
    // Test #5
    assert(str2.findstr(0, "me") == 2);
    // Setup #2
    str1 = "sssssssss";
    // Test #6
    assert(str1.findstr(0, "sssssssss") == 0);
    // Test #7
    assert(str1.findstr(3, "sss") == 3);
    // Test #8
    assert(str1.findstr(0, "z") == -1);
    // Test #9
    assert(str1.findstr(0, "Garrett Bearss") == -1);
    // Test #10
    assert(str3.findstr(0, "ape") == 3);
    // Setup #3
    String str4 = "grape";
    // Test #11
    assert(str4.findstr(0, "ape") == 2);

    std::cout << "Done test_find_string" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_substring.cpp
  //int main(){
    // Setup #1
    String str1 = "Garrett Bearss";
    String str2 = "Home away from home";
    String str3 = "grape";
    // Test #1
    assert(str1.substr(0, 13) == "Garrett Bearss");
    // Test #2
    assert(str1.substr(0, 0) == "G");
    // Test #3
    assert(str1.substr(13, 13) == "s");
    // Test #4
    assert(str2.substr(0, 18) == "Home away from home");
    // Test #5
    assert(str2.substr(0, 3) == "Home");
    // Test #6
    assert(str2.substr(5, 8) == "away");
    // Test #7
    assert(str2.substr(10, 13) == "from");
    // Test #8
    assert(str2.substr(15, 18) == "home");
    // Test #9
    assert(str1.substr(19,19) == "");

    std::cout << "Done test_substring" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_ctor_copy.cpp
  //int main(){
    // Setup #1
    String str1 = "Garrett";
    String str2 = "Bearss";
    // Test #1
    String result1(str1);
    assert(str1 == result1);
    // Test #2
    String result2(str2);
    assert(str2 == result2);
    // Test #3
    String result3(result1);
    assert(str1 == result3);
    // Test #4
    String result4(result2);
    assert(str2 == result4);
    // Setup #2
    String str3;
    // Test #5
    String result5(str3);
    assert(str3 == result5);
    // Test #6
    String result6(result5);
    assert(str3 == result6);

    std::cout<< "Done test_ctor_copy" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  // test_swap_assign
  //int main(){
    // Setup #1
    String str1 = "Garrett";
    String str2 = "Bearss";
    String result;
    // Test #1
    result = str1;
    assert(result == str1);
    // Test #2
    result = str2;
    assert(result == str2);
    // Test #3
    result = result;
    assert(result == result);
    // Test #4
    result = "";
    assert(result == "");
    
    std::cout << "Done test_swap_assign" << std::endl;
    return 0;
  //}
  */

  /*
  #include <iostream>
  #include <fstream>
  #include "string.hpp"
  #include <cassert>
  #include <vector>
  // test_split.cpp
  //int main(){
    //Setup #1
    String str1 = "abc ef gh";
    String str2 = "-a--b-";
    String str3 = "555555";
    std::vector<String> test;
    std::vector<String> result;
    // Test #1
    test = {"abc", "ef", "gh"};
    result = str1.split(' ');
    assert(test == result);
    // Test #2
    test = {"", "a", "", "b", ""};
    result = str2.split('-');
    assert(test == result);
    // Test #3
    test = {"abc ef gh"};
    result = str1.split('0');
    assert(test == result);
    // Test #4
    test = {"-a--b-"};
    result = str2.split('0');
    assert(test == result);
    // Test #5
    test = {"ab", " ef gh"};
    result = str1.split('c');
    assert(test == result);
    // Test #6
    test = {"a", "c ef gh"};
    result = str1.split('b');
    assert(test == result);
    // Test #7
    test = {"-a--", "-"};
    result = str2.split('b');
    // Test #8
    test = {"-", "--b-"};
    result = str2.split('a');
    assert(test == result);
    // Test #9
    test = {"", "", "", "", "", "", ""};
    result = str3.split('5');
    assert(test == result);
    //Setup #2
    String str4 = "131.123.32.16 - - [18/Sep/2002:12:06:12 -0400] " + String('"') + "GET /~collard/class/oop/master.css HTTP/1.1" + String('"') + " 200 791";
    // Test #10
    result = str4.split(' ');
    test = {"131.123.32.16", "-", "-", "[18/Sep/2002:12:06:12", "-0400]", String('"') + "GET", "/~collard/class/oop/master.css", "HTTP/1.1" + String('"'), "200", "791"};
    assert(test == result);

    std::cout << "Done test_split" << std::endl;
    return 0;
    //131.123.32.16 - - [18/Sep/2002:12:06:12 -0400] "GET /~collard/class/oop/master.css //HTTP/1.1" 200 791";
  //}
  */   
//}

int main() {
    // Options
    int argc = 3;
    std::vector<String> argv(3);
    argv[0] = "Garrett";
    argv[1] = "all";
    argv[2] = "log_4_large.txt";
    std::vector<String> option(3);
    option[0] = "all";
    option[1] = "bytes";
    option[2] = "host";

    if (argc != 3) {      // Error if there are not 3 things on the command line
        std::cerr << "Error" << std::endl;
        std::cerr << "Usage: " << argv[0] << " [ "
        << option[0] << " | "
        << option[1] << " | "
        << option[2] << " ] log_file" << std::endl;
        exit(1);         // Exit with error
    }

    std::ifstream in("log_4_large.txt");     // Open file, quit if open fails
    if (!in) {
        std::cerr << "Error: Can not open " << argv[2] << std::endl;
        exit(2);
    }
    std::vector<LogEntry> log_entries = parse(in);   // Process the log file
    in.close();

    if (argv[1] == option[0]) {                // Handle the specified option
        output_all(std::cout, log_entries);
    }
    else if (argv[1] == option[1]) {
        std::cout << "Total number of bytes sent: " 
                  << byte_count(log_entries) << std::endl;
    }
    else if (argv[1] == option[2]) {
        by_host(std::cout, log_entries);
    }
    else { //Error, bad option
        std::cerr << "Unrecognized option: " << argv[1] << std::endl;
        std::cerr << "Recognized options: " 
             << option[0] << " "
             << option[1] << " "
             << option[2] << std::endl;
        exit(3);
    }
    return 0;
}