#include <cassert>

template <typename T>
class queue{
  public:
  queue() : beginning(0), ending (0) {};
  ~queue();
  queue(const queue<T>&);
  void swap(queue<T>&);
  queue<T>& operator=(queue<T> rhs){swap(rhs); return *this;};
  bool isEmpty() const {return beginning == 0;};
  bool isFull() const;

  void enqueue(const T&);
  T dequeue(); 

  private:
  node<T> *beginning, *ending;
};

template <typename T>
void queue<T>::enqueue(const T& item){
  assert(isFull());
  if(beginning == 0){
    ending = new node<T>(item);
    beginning = ending;
  }
  else{
    ending->next = new node<T>(item);
    ending = ending->next;
  }
}

template <typename T>
T queue<T>::dequeue(){
  assert(!isEmpty());
  T result = beginning->data;
  node<T> *temp = beginning;
  beginning = beginning->next;
  if(beginning == 0){
    ending = 0;
  }
  delete temp;
  return result;
}