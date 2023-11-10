template <typename T>
class btree{
  public:
  btree() : root(0) {};
  btree (const T& item) { root = new bnode<T>(item);};
  btree (const btree<T>&);
}
template <typename T>
class bnode{
  public:
  bnode() : left(0), right(0) {};
  bnode(const T& item) : left(0), right(0), data(item) {};
  bnode (const bnode<T>&);
}

template <typename T>
btree<T>::btree(const btree<T>& actual) : btree(){
  if(actual.root){
    root = new bnode<T>(*(actual.root));
  }
}

template <typename T>
bnode<T>::bnode(const bnode<T>& actual) : bnode(){
  data= actual.data;
  if(actual.left){
    left = new bnode<T>(*(actual.left));
  }
  if(actual.right){
    right = new bnode<T>(*(actual.right));
  }
}

template <typename T>
btree<T>::~bnode(){
  if(root){
    delete root;
  }
}

template <typename T>
bnode<T>::~bnode(){
  if(left){
    delete left;
  }
  if(right){
    delete right;  
  }
}

template <typename T>
bool btree<T>::find(const T& key) const{
  if(!root){
    return false;
  }
  return root->find(key);
}

template <typename T>
bool bnode<T>::find(const T& key) const{
  if(data == key){
    return true;
  }
  if(key < data){
    if(left){
      return left->find(key);
    }
    else{
      return false;
    }
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

template <typename T>
void bnode<T>::binsert(const T& x){
  if(x < data){
    if(left){
      left->binsert(x);
    }
    else{
      left = new bnode<T>(x);
    }
  }
  else{
    if(right){
      right->binsert(x);
    }
    else{
      right = new bnode<T>(x);
    }
  }
}

template <typename T>
void btree<T>::inorder(std::ostream& out) const{
  if(root){
    root->inorder(out);
  }
}

void bnode<T>::inorder(std::ostream& out) const{
  if(left){
    left->inorder(out);
  }
  out << data;
  if(right){
    right->inorder(out);
  }
}

template <typename T>
T bnode<T>::predecessor() const{
  if(right){
    return right->predecssor();
  }
  return data;
}
template <typename T>
void btree<T>::bremove(const T& x){
  if(find(x)){
    root = root->bremove(x);
  }
}

template <typename T>
bnode<T>* bnode<T>::bremove(const T& x){
  bnode<T> *temp;
  if(x == data){
    if(!left && !right){
      delete this;
      return 0;
    }
    if(!left && right){
      temp = right;
      right = 0;
      delete this;
      return temp;
    }
    if(left && !right){
      temp = left;
      left = 0;
      delete this;
      return temp;
    }
    data = left->predecessor();
    left = left->bremove(data);
    return this;
  }
  else{
    if(x < data){
      left = left->bremove(x);
    }
    else{
      right = right->bremove(x);
    }
  }
  return this;
}