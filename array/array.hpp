#include <cassert>

class darray{
  public:
  darray() : ptr(0), cap(0) {};
  darray(int);
  darray(const darray&);
  ~darray();
  darray& operator=(const darray&);
  darray& operator=(darray);
  void swap(darray&);

  int operator[](int) const;
  int& operator[](int);

  void resize(int);
  inr capactiy() const {return cap;};

  bool operator==(const darray&) const;

  private:
  int *ptr;
  int cap;
};

#endif