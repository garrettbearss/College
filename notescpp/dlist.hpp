template<typename T>
class dnode{
  public:
  dnode() : next(0), prev(0) {};
  dnode(const T& item) : data(item), next(0), prev(0) {};

  T data;
  dnode<T> *next;
  dnode<T> *prev;

};

template <typename T> class List;
template <typename T>
class Itr{
  public:
  Itr() : current(0) {};
  Itr(dnode<T> *ptr) : current(ptr) {};

  Itr<T>& operator++() {if (current) current = current->next; return}// ++i
  Itr<T> operator++(int) {Itr<T> result(current); if(current) current = current->next; return};// i++

  Itr<T>& operator--() {if (current) current = current-> prev; return *this;}; // --i
  Itr<T> operator--(int) {Itr<T> result(current); if(current) current = current->prev; return result;}; // i--

  bool operator==(Itr<T> rhs) const{return current == rhs.current;};

  const T operator*() const {return current->data;};
  T& operator*() {return current -> data;};

  const dnode<T>* operator->()const {return current;};
  dnode<T>* operator->() {return current;};

  friend class List<T>;

  private:
  dnode<T> *current;

};

template<typename T>
class List{
  public:
  List() : beginning(0), ending(0) {};

  List(const List<T>&);
  ~List();
  void swap(List<T>&);
  List<T>& operator=(List<T> rhs) {swap(rhs); return *this;};
  void insertAfter(Itr<T>, const T&);
  void insertBefore(Itr<T>, const T&);
  void remove(Itr<T>);
  const Itr<T> begin() const {return Itr<T>(beginning);};
  Itr<T> begin() {return Itr<T>(beginning);};
  const Itr<T> end() const {return Itr<T>(ending);};
  Itr<T>& end() {return Itr<T>(ending);};

  T front() const; { return beginning->data;};
  T& front() { return beginning ->data;};
  T back() const { return ending->data;};
  T& back() {return ending->data;};

  bool isEmpty() const{return beginning == 0;};
  bool isFull() const;
  int length() const;

  const Itr<T> operator[](int) const;
  Itr<T> operator[](int);
  
  const Itr<T> find(const T&) const;
  Itr<T> find(const T&); 

  private:
  dnode<T> *beginning, *ending;
}

template <typename T>
void List<T>::insertBefore(Itr<T> ptr, const T& item){
  dnode<T> *temp = new dnode<T>(item);
  if(beginning == 0){
    beginning = temp;
    ending = temp;
  }
  else if(ptr == beginning){
    beginning->prev = temp;
    temp->next = beginning;
    beginning = temp;
  }
  else{
    temp->next = ptr.current;
    temp->prev = ptr->prev;
    ptr->prev->next = temp;
    ptr->prev = temp;
  }
}

template <typename T>
void List<T>::insertAfter(Itr<T> ptr, const T& item){
  dnode<T> *temp = new dnode<T>(item);
  if(beginning == 0){
    beginning = temp;
    ending = temp;
  }
  else if(ptr == ending){
    ending->next = temp;
    temp->prev = ending;
    ending = temp;
  }
  else{
    temp->prev = ptr.current;
    temp->next = ptr->next;
    ptr->next->prev = temp;
    ptr->next = temp;
  }
}

template <typename T>
void List<T>::remove(Itr<T> ptr){
  if(isEmpty()){
    return;
  }
  if(ptr == 0){
    return;
  }
  if(ptr == beginning){
    beginning = beginning->next;
  }
  else{
    ptr->prev->next = ptr->next;
  }
  if(ptr == ending){
    ending = ending->prev;
  }
  else{
    ptr->next->prev = ptr->prev;
  }
  delete ptr.current;
}

template <typename T>
int List<T>::length() const{
  int len = 0;
  Itr<T> ptr = begin();
  while(ptr != 0){
    ptr++;
    len++;
  }
  return len;
}

template <typename T>
Itr<T> List::operator[](int n){
  if(n < 0){
    return Itr<T>();
  }
  while(n >= 0){
    if(result == 0){
      return result;
    }
      n--;
      result++;
  }
  return result;
}

template <typename T>
const Itr<T> List<T>::operator[](int n) const{

}

template <typename T>
List<T>::~List(){
  dnode<T> *temp;
  while(beginning != 0){
    temp = beginning;
    beginning = beginning->next;
    delete temp;
  }
}

template <typename T>
List<T>::List(const List<T>& actual) : List(){
  dnode<T> *temp = actual.beginning;
  while(temp != 0){
    if(beginning == 0){
      beginning = new node<T>(temp->data);
      ending = beginning;
    }
    else{
      ending->next = new dnode<T>(temp->data);
      ending->next->prev = ending;
      ending = ending->next;
    }
    temp = temp->next;
  }
}

template <typename T>
void List<T>::swap(List<t>& rhs){
  dnode<T> *temp = beginning;
  beginning = rhs.beginning;
  rhs.beginning = temp;

  temp = ending;
  ending = rhs.ending;
  rhs.ending = temp;
}