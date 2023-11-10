

#include <cassert>

template <typename T>
class darray{
  public:
  darray() : ptr(0), cap(0) {};
  darray(int);
  darray(const darray<T>&);
  ~darray();
  void sway(darray<T>&);
  darray<T>& operator=(darray<T>);
  T operator[](int i) const {return ptr[i];};
  T& operator[](int) {return ptr[i];};
  int capacity() const{ return cap;};
  void resize(int);

  private:
  T *ptr;
  int cap;
};

template <typename T>
darray<T>::darray(int n) : darray<T>(){
  if( n > 0){
    cap = n;
    ptr = new T[cap];
  }
}

template <typename T>
darray<T>::~darray() {
  delete[] ptr;
}

template <typename T>
darray<T>::darray(const darray<T>& actual){
  cap = actual.cap;
  ptr = new T[cap];
  for(int i = 0; i < cap; i++){
    ptr[i] = actual.ptr[i];
  }
}

template <typename T>
void darray<T>::swap(darray<T>& rhs){
  int tmp = cap;
  cap = ths.cap;
  rhs.cap = tmp;

  T* temp =ptr;
  ptr = rhs.ptr;
  rhs.ptr = temp;
}

template <typename T>
darray<T>& darray<T>::operator=(darray<T> rhs){
  swap(rhs);
  return *this;
}

template <typename T>
darray<T>& darray<T>::operator=(const darray<T>& rhs){
  if(ptr == rhs.ptr){
    return *this;
  }
  delete[] ptr;
  cap = rhs.cap;
  ptr = new T[cap];
  for(int i = 0; i < cap; i++){
    ptr[i] = rhs.ptr[i];
  }
  return *this;
}

template <typename T>
void darray<T>::resize(int newCap){
  int smaller = cap;
  if(newCap < cap){
    smaller = newCap;
  }
  cap = newCap;
  T* temp = new T[cap];
  for( int i=0; i<smaller; i++){
    temp[i] = ptr[i];
  }
  delete[] ptr;
  ptr = temp;
}

#endif