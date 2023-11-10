const int SIZE = 100;

template <typename T>
class queue {
  public:
    queue() : front(0), back (0), empty(true) {};
    bool isEmpty() const {return empty;};
    bool isFull() const {return front == back && !empty;};
    void enqueue(const T&);
    T dequeue();

  private:
    T q[Size];
    int front, back;
    bool empty;
};
#endif

template <typename T>
void queue<T>::enqueue(const T& item){
  assert(!isFull());
  q[back] = item;
  back = (back + 1) % SIZE;
  empty = false;
}

template <typename T>
T queue<T>::dequeue() {
  assert(!isEmpty());
  T result = q[front];
  front = (front + 1) % SIZE;
  if(front == back){
    empty = true;
  }
  return result;
}

template <typename T>
queue<T>::~queue(){
  while(beginning != 0){
    node<T> *temp;
    temp = beginning;
    beginning = beginning->next;
    delete temp;
  }
}

template <typename T>
queue<T>::queue(const queue<T>& actual) : queue<T>(){
  node<T> *temp = actual.beginning;
  while(temp != 0){
    if(beginning = 0){
    beginning = new node<T>(temp->data);
    ending = beginning;
    }
    else{
      ending->next = new node<T>(temp->data);
      ending = ending->next;
    }
  }
}

template <typename T>
void queue<T>::swap(queue<T>& rhs){
  node<T> *temp = rhs.beginning;
  rhs.beginning = beginning;
  beginning = temp; 

  temp = rhs.ending;
  rhs.ending = ending;
  ending = temp;
}

template <typename T>
bool queue<T>::isFull() const{
  node<T> *temp = new(std::nothrow) node<T>;
  if(temp == 0){
    return true;
  }
  else{
    delete temp;
    return false;
  }
}