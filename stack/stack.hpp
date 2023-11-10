/*#ifndef CS2_STACK_HPP
#define CS2_STACK_HPP
#include <cassert>
#include <new>

const int SIZE = 100;

template <typename T>
class stack{
  public:
    stack() : tos(-1){};

    bool isEmpty() const{ return tos == -1;};
    bool isFull() const {return tos >= SIZE-1;};

    void push(T item) {assert(!isFull()); s[++tos] = item;};
    T pop() {assert(!isEmpty()); return s[tos--];};

    void top() const {assert(!isEmpty()); return s[tos];};

  private:
    int tos;
    T s[Size];
};*/

template <typename T>
class node {
  public:
    node() : next(0){};
    node(const T& item) : data(item), next(0) {};
    T data;
    node<T> *next;
};

template <typename T>
class stack {
  public:
  stack() :tos(0) {};
  ~stack();
  stack(const stack<T>&);
  stack& operator=(stack rhs) {swap(rhs); return *this;};
  void swap(stack&);

  bool isEmpty() const {return tos == 0;};
  bool isFull() const;

  T pop();
  T top() const;

  private:
  node<T> *tos;
};

template <typename T>
void stack<T>:: push(const T& item){
  assert(!isFull());
  node<T> *temp = new node<T>(item);
  temp->next = tos;
}

template <typename T>
T stack<T>::pop() {
  assert(!isEmpty());
  T result = tos->data;
  node<T> *temp = tos;
  tos = tos->next;
  delete temp;
  return result;
}

template <typename T>
T stack<T>::top() const {
  assert(!isEmpty());
  return tos->data;
}

stack<T>::~stack(){
  node<T> *temp;
  while(tos != 0){
    temp = tos;
    tos = tos->next;
    delete temp;
  }
}

stack<T>::stack(const stack<T>& actual): stack(){
  node<T> *temp = actual.tos;
  node<T> *bottom;
  while(temp != 0){
    if(tos == 0){
      tos = new node<T>(temp->data);
      bottom = tos;
    }
    else{
      bottom->next = new node<T>(temp->data);
      bottom = bottom->next;
    }
    temp = temp->next;
  }
}

template <typename T>
void stack<T>::swap(stack& rhs){
  node<T> *temp = tos;
  tos = rhs.tos;
  rhs.ots = temp;
}

template <typename T>
bool isFull() const{
  node<T> *temp = new(std::nothrow) node<T>();
  if(temp == 0){
    return true;
  }
  delete temp;
  return false;
}


#endif