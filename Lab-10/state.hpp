// Garrett Bearss
// 3/23/2023
// state.hpp
#include <iostream>
#include <string>

using std::cout;
using std::string; 
using std::to_string;

class State;

// Process class
class Process {
public:
    // Default constructor
    Process();
    // Constructor used for clone() function
    Process(State *s);
    // Clone function allows for easy copying of member variable
    Process* clone();

    // Different functions used to change the state
    void create();
    void dispatch();
    void block();
    void unblock();
    void suspend();
    void exit();
    string report();

    // Changes the state based off the input state
    void changeState(State *state) { state_ = state;}
private:
    State* state_;
    int id_;
    // Static variable that keeps track of the identifier 
    static int num_;
};

// State class
class State {
public:
    virtual void dispatch(Process *){}
    virtual void block(Process *){}
    virtual void unblock(Process *){}
    virtual void suspend(Process *){}
    virtual void exit(Process *){}
    virtual void create(Process *){}
    virtual string report() = 0;
    // Changes the state of a process
    void changeState(Process *p, State *s){
        p->changeState(s);
    }
};

// NewState Class
class NewState: public State{
public:
    static State* instance(){
        static State* onlyInstance = new NewState;
        return onlyInstance;
    }
    void create(Process *) override;
    // Used to report that the process was created successfully
    string report() override { return "created"; }
private:
    NewState(){}
    NewState(const NewState &) = delete;
    NewState& operator=(const NewState &) = delete;
};

// Ready Class
class Ready: public State{
public:
    static State* instance(){
        static State* onlyInstance = new Ready;
        return onlyInstance;
    }

    void dispatch(Process *) override;
    string report() override { return "READY"; }
private:
    Ready(){}
    Ready(const Ready &) = delete;
    Ready& operator=(const Ready &) = delete;
};

// Running Class 
class Running: public State{
public:
    static State* instance(){
        static State* onlyInstance = new Running;
        return onlyInstance;
    }

    void block(Process *) override;
    void suspend(Process *) override;
    void exit(Process *) override;

    string report() override { return "RUNNING"; }
private:
    Running(){}
    Running(const Running &) = delete;
    Running& operator=(const Running &) = delete;
};

// Blocked class
class Blocked: public State{
public:
    static State* instance(){
        static State* onlyInstance = new Blocked;
        return onlyInstance;
    }

    void unblock(Process *) override;

    string report() override { return "BLOCKED"; }
private:
    Blocked(){}
    Blocked(const Blocked &) = delete;
    Blocked& operator=(const Blocked &) = delete;
};

// Exited class
class Exited: public State{
public:
    static State* instance(){
        static State* onlyInstance = new Exited;
        return onlyInstance;
    }
    
    string report() override { return "exited"; }
private:
    Exited(){}
    Exited(const Exited &) = delete;
    Exited& operator=(const Exited &) = delete;
};

// Used in the creation of a new state
void NewState::create(Process *p){
    changeState(p, Ready::instance());
    cout << p->report();
}

// Changes the state from created to ready
void Ready::dispatch(Process *p) {
    changeState(p, Running::instance());
    cout << p->report();
}

// Changes the state from running to blocked
void Running::block(Process *p) {
    changeState(p, Blocked::instance());
    cout << p->report();
}

// Changes the state from running to suspended
void Running::suspend(Process *p) {
    changeState(p, Ready::instance());
    cout << p->report();
}

// Changes the state from running to exitting
void Running::exit(Process *p) {
    changeState(p, Exited::instance());
    cout << p->report();
}

// Changes the state from blocked to ready
void Blocked::unblock(Process *p) {
    changeState(p, Ready::instance());
    cout << p->report();
}

int Process::num_ = 0;

// Default Constructor
Process::Process() { 
    state_ = NewState::instance();
    ++num_;
}

// Constructor used for clone()
Process::Process(State *s) {
    state_ = s;
    id_ = num_;
    ++num_;
}

// Clone function that allows you 
Process* Process::clone() {
    return new Process(state_);
}

// Different Process functions
void Process::create() { state_->create(this); }
void Process::dispatch() { state_->dispatch(this); }
void Process::block() { state_->block(this); }
void Process::unblock() { state_->unblock(this); }
void Process::suspend() { state_->suspend(this); }
void Process::exit() { state_->exit(this); }
string Process::report() {
    return "PID " + to_string(id_) + " state: " + state_->report() + "\n";
}