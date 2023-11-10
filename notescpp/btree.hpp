template <typename T>
class btree{
  public:
  btree() : empty(true), left(0), right(0) {};
  btree(const T& item) : data(item), empty(false), left(0), right(0) {};
  ~btree();
  btree(const btree<T>&);
  void swap(btree<T>&);
  btree<T>& operator=(btree<T> rhs) {swap(rhs); return *this;};
  bool find(const T&) const;
  void insert(const T&);
  void inorder(std::ostream&) const;
  void preorder(std::ostream&) const;
  void postorder(std::ostream&) const;
  bool isEmpty() const{ return empty;};
  bool isFull() const;

  private:
  T data;
  bool empty;
  btree<T> *left, *right;
};

template <typename T>
void btree<T>::binsert(const T& item){
  if(empty){
    data = item;
    empty = false;
  }
  else if(item < data){
    if(!left){
      left = new btree(item);
    }
    else{
      left->binsert(item);
    }
  }
  else{
    if(item == data){
      return;
    }
    if(!right){
      right = new btree(item);
    }
    else{
      right->binsert(item);
    }
  }
}

typename <typename T>
bool btree<T>::find(const T& key) const{
  if(empty){
    return false;
  }
  if(key == data){
    return true;
  }
  if(key < data){
    if(left){
      return left->find(key);
    }
    else{
      return false;
    }
    else{
      if(right){
        return right->find(key);
      }
      else{
        return false;
      }
    }
  }
}

typename <typename T>
void btree<T>::postorder(std::ostream& out)const{
  if(empty){
    return;
  }
  if(left){
    left->postorder(out);
  }
  if(right){
    right->postorder(out);
  }
  out << data << " ";
}

typename <typename T>
void btree<T>::preorder(std::ostream& out)const{
  if(empty){
    return;
  }
  out << data << " ";
  if(left){
    left->preorder(out);
  }
  if(right){
    right->preorder(out);
  }
}

typename <typename T>
void btree<T>::inorder(std::ostream& out)const{
  if(empty){
    return;
  }
  if(left){
    left->preorder(out);
  }
  out << data << " ";
  if(right){
    right->preorder(out);
  }
}

template <typename T>
btree<T>::btree(const btree<T>& actual) : btree<T>(){
  empty = actual.empty;
  data = actual.data;
  if(actual.left){
    left = new btree<T>(*(actual.left);
  }
  if(actual.right){
    right = new btree<T>(*(actual.right));
  }
}

template <typename T>
btree<T>::~btree(){
  if(left){
    delete left;
  }
  if(right){
    right;
  }
}

template <typename T>
void btree<T>::swap(btree<T>&rhs){
  bool tempty = empty;
  empty = rhs.empty;
  rhs.empty = tempty;

  T temp = data;
  data = rhs.data;
  rhs.data = temp;

  btree<T>* ptr = left;
  left = rhs.left;
  rhs.left = ptr;
  ptr = right;
  right = rhs.right;
  rhs.right = ptr;
}