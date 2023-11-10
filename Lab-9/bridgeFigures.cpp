// Garrett Bearss
// bridgeFigures.cpp
// 3/16/2023
// filled/hollow figures demonstrates Bridge Design Pattern,
// square is either hollow or square and is painted with a particular character,
// it is bridged over Figure --> Fill abstract body/handle
// Mikhail Nesterenko
// 2/12/2014

#include <iostream>

using std::cout; 
using std::endl; 
using std::cin;

// abstract body
class Fill{
public:
   //Fill(char fillChar): fillChar_(fillChar){}
   Fill(char borderChar, char fillChar): borderChar_(borderChar), fillChar_(fillChar){}
   virtual char getBorder()=0;
   virtual char getInternal()=0;
   virtual ~Fill() {}
protected:
   char borderChar_;
   char fillChar_;
};

// concrete body
class Hollow: public Fill{
public:
   //Hollow(char fillChar):Fill(fillChar){}
   Hollow(char borderChar):Fill(borderChar, ' '){}
   //char getBorder() override {return fillChar_;}
   char getBorder() override {return borderChar_;}
   char getInternal() override {return ' ';}
   ~Hollow() override {}
};


// another concrete body
class Filled: public Fill {
public:
   //Filled(char fillChar):Fill(fillChar){}
   Filled(char fillChar):Fill(fillChar, fillChar){}
   char getBorder() override {return fillChar_;}
   char getInternal() override {return fillChar_;}
   ~Filled() override {}
};

class FullyFilled: public Filled{
public:
    FullyFilled(char borderChar, char fillChar):Filled(fillChar), borderChar_(borderChar){}
    char getBorder() override {return borderChar_;}
    char getInternal() override {return fillChar_;}
    ~FullyFilled() override{}
private:
    char borderChar_;
};

class RandomFilled: public Fill {
public:
    RandomFilled(char borderChar, char fillChar):Fill(borderChar, borderChar){}
    char getBorder() override {return rand()%2 == 0 ? borderChar_ : fillChar_;}
    char getInternal() override {return rand()%2 == 1 ? fillChar_ : borderChar_;}
    ~RandomFilled() override{}
};

// abstract handle
class Figure {
public:
   Figure(int size, Fill* fill): size_(size), fill_(fill){}
   virtual void draw() =0;
   virtual ~Figure(){}
protected:
   int size_;
   Fill *fill_;
};

// concrete handle
class Square: public Figure{
public:
   Square(int size, Fill* fill): Figure(size, fill){}
   void draw() override;

};

void Square::draw(){
   for(int i=0; i < size_; ++i){
      for(int j=0; j < size_; ++j)
	 if(i==0 || j==0 || i==size_-1 || j==size_-1 )
	    cout << fill_ -> getBorder();
	 else
	    cout << fill_ -> getInternal();
      cout << endl;
   }
}

int main(){

   /*
   Fill* hollowPaintQ = new Hollow('Q');
   Fill* filledPaintStar = new Filled('*');

   
   Figure *smallBox = new Square(5, hollowPaintQ);
   Figure *bigBox = new Square(15, filledPaintStar);

   smallBox->draw();
   cout << endl;
   bigBox -> draw();
   */

   
   // ask user for figure parameters
   cout << "Enter fill character: "; 
   char fchar; 
   cin >> fchar;
   //cout << "Filled or hollow? [f/h] "; 
   //char ifFilled; cin >> ifFilled;
   cout << "Enter border character: ";
   char bchar;
   cin >> bchar;
   cout << "Enter size: "; 
   int size; 
   cin >> size;

   // Testing Filled
   Figure *userBox1 = new Square(size, new Filled(fchar));
   userBox1->draw();
   cout << endl;

   // Testing Hollow
   Figure *userBox2 = new Square(size, new Hollow(bchar));
   userBox2->draw();
   cout << endl;

   // Testing FullyFilled
   Figure *userBox3 = new Square(size, new FullyFilled(bchar, fchar));
   userBox3->draw();
   cout << endl;

   // Testing RandomFilled
   Figure *userBox4 = new Square(size, new RandomFilled(bchar, fchar));
   userBox4->draw();
   cout << endl;
  
   /*
   Figure *userBox = new Square(size, ifFilled == 'f'? 
	       static_cast<Fill *>(new Filled(fchar)):
	       static_cast<Fill *>(new Hollow(fchar))
	       ); 
   
   Figure *userBox = new Square(size,
	       ifFilled == 'f'? new Filled(fchar): new Hollow(fchar)
               );
   
   Figure *userBox = ifFilled == 'f'?
      new Square(size, new Filled(fchar)):
      new Square(size, new Hollow(fchar));
   userBox -> draw();
   cout << endl;
   */
   
}