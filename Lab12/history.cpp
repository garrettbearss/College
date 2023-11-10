// Garrett Bearss
// 4/13/2023
// history.cpp
// implements command history (multiple undos)
// demonstrates command pattern
// Mikhail Nesterenko
// 11/22/2014

#include <iostream>
#include <vector>
#include <string>
#include <stack>

using std::vector; 
using std::string;
using std::cout; 
using std::cin; 
using std::endl;

// receiver
class Document{
public:

   Document(const vector <string> & lines={}): lines_(lines){}

   // actions
   void insert(int line, const string &str) {
      const int index = line-1;
      if (index <= lines_.size())
	 lines_.insert(lines_.begin() + index, str); 
      else
	 cout << "line out of range" << endl; 
   }

   string remove(int line) {
      const int index = line-1;
      string deletedLine="";
      if(index < lines_.size()){
	 deletedLine = lines_[index];
	 lines_.erase(lines_.begin() + index); 
      }else
	 cout << "line out of range" << endl; 
      return deletedLine;
   } 

   void show() {
      for(int i = 0; i < lines_.size(); ++i)
	 cout << i + 1 << ". " << lines_[i] << endl; 
   }

private:
   vector<string> lines_; 
}; 

// abstract command
class Command{
public:
   Command(Document *doc) : doc_(doc){}
   virtual void execute() = 0; 
   virtual void unexecute() = 0;
   // Added to be able to show commands from insert and erase command classes
   virtual void show() = 0;
   virtual ~Command(){}
protected:
   Document *doc_; 
}; 

// two concrete commands
class InsertCommand : public Command {
public:
   InsertCommand(Document *doc, int line, const string &str): 
      Command(doc), line_(line),  str_(str) {}
   void execute() override { doc_->insert(line_, str_);}
   void unexecute() override {doc_->remove(line_);}
   // Shows the command being done
   void show() override {cout << "insert \"" << str_ << "\" at line " << line_;}
private:
   int line_; 
   string str_; 
}; 


class EraseCommand : public Command {
public:
   EraseCommand(Document *doc, int line): 
      Command(doc), line_(line), str_("") {}
   void execute() override {str_ = doc_->remove(line_);}
   void unexecute() override {doc_->insert(line_, str_);}
   // Shows the command being done
   void show() override {cout << "insert at line " << line_;}
private:
   int line_;
   string str_;
};

// Forward declaration of class Memento
class Memento;

// client
class DocumentWithHistory{
public:
   DocumentWithHistory(const vector<string> & text={}) : doc_(text){}

   void insert(int line, string str) {
      Command *com = new InsertCommand(&doc_, line, str); 
      com->execute(); 
      doneCommands_.push(com); 
   }

   void erase(int line){
      Command *com = new EraseCommand(&doc_, line);
      com->execute();
      doneCommands_.push(com);
   }

   void undo() {
      if(doneCommands_.size() != 0) {
	 Command *com = doneCommands_.top(); 
	 doneCommands_.pop(); 
	 com->unexecute();
	 delete com; // don't forget to delete command
      }else
	 cout << "no commands to undo" << endl; 
   }

   void show() {doc_.show();}

   // Prints the command lines retained in history
   void history(){
     // If there are some commands to print
     if(doneCommands_.size() != 0){
       std::stack<Command *> temp;
       // For each command in the done commands, print them
       for(int i=1; !doneCommands_.empty(); i++){
         temp.push(doneCommands_.top());
         cout << i << ". ";
         doneCommands_.top()->show();
         cout << "\n";
         doneCommands_.pop();
       }
       // Pushes the values of temp back onto doneCommands
       while(!temp.empty()){
         doneCommands_.push(temp.top());
         temp.pop();
       }
     }
     else{
       cout << "no commands in history...";
     }
   }

   // Redo a command that has previously been performed
   void redo(int num){
     std::stack<Command *> temp;

     // If there are no commands to redo or the user input the wrong value
     if(doneCommands_.empty() || num > doneCommands_.size()){
       cout << "invalid command history input";
       return;
     }
     else{
       // Loop through done commands till you find the command that needs redone
       for(int i = 0; i < num-1; i++){
         temp.push(doneCommands_.top());
         doneCommands_.pop();
       }
       // Store that command and execute it
       Command *c = doneCommands_.top();
       c->execute();

       // Push the contents of temp back onto done commands
       while(!temp.empty()){
         doneCommands_.push(temp.top());
         temp.pop();
       }

       // Since the command was just done, push it back onto the command history
       doneCommands_.push(c);
     }
   }

   // Links the Memento class to the doc with history class
   class Memento *createMemento();
   // Rollback is performed by the Memento class
   void rollBack(class Memento *);
private:
   Document doc_;
   std::stack<Command*> doneCommands_; 
}; 

// Memento class definition
class Memento{
public:
    // Constructor
    Memento(const DocumentWithHistory& doc): doc_(doc){}
    // Returns the version of the doc it stores
    const DocumentWithHistory& getState() const {return doc_;}
private:
    const DocumentWithHistory doc_;
};

// Creating a Memento function
Memento *DocumentWithHistory::createMemento(){
  // Remove all the done commands
  while(!doneCommands_.empty()){
    doneCommands_.pop();
  }
  // Copy the document into the Memento
  return new Memento(*this);
}

// Rolls back the document to a previous state
void DocumentWithHistory::rollBack(Memento *m){
  // Copys back the info into document from the Memento
  *this = m->getState();
}

// invoker
int main() {
   DocumentWithHistory his({
	 "Lorem Ipsum is simply dummy text of the printing and typesetting",
	 "industry. Lorem Ipsum has been the industry's standard dummy text",
	 "ever since the 1500s, when an unknown printer took a galley of",
	 "type and scrambled it to make a type specimen book. It has",
	 "survived five centuries."}); 

   char option;
   do{
      static Memento *checkpoint = nullptr;
      his.show(); 
      cout << endl;

      cout << "Enter option (i)nsert line, (e)rase line, (u)ndo last command (c)heckpoint roll(b)ack (h)istory (r)edo command: ";
      cin >> option; 

      int line; string str; 
      switch(option) {
      case 'i':
	 cout << "line number to insert: "; 
	 cin >> line; 
	 cout << "line to insert: "; 
	 cin.get(); // removes end-of-line character so getline() works correctly
	 getline(cin, str); 
	 his.insert(line, str); 
   cout << endl;
	 break;
 
      case 'e':
	 cout << "line number to remove: ";
	 cin >> line;
	 his.erase(line);
   cout << endl;
	 break;

      case 'u':
	 his.undo(); 
   cout << endl;
	 break; 
    
      case 'c':
   checkpoint = his.createMemento();
   cout << endl;
   break;

      case 'b':
   if(checkpoint != nullptr){
     his.rollBack(checkpoint);
     delete checkpoint;
     checkpoint = nullptr;
   }
   cout << endl;
   break;

      case 'h':
   his.history();
   cout << endl;
   break;

      case 'r':
   int i;
   cout << "command number to redo: ";
   cin >> i;
   his.redo(i);
   cout << endl;
   break;     
  }

   }while(option == 'i' || option == 'e' || option == 'u' || option == 'c' || option == 'b' || option == 'h' || option == 'r');
}