// Garrett Bearss
// 3/23/2023
// AdapterObject.cpp
// figures: object adapter pattern
// Mikhail Nesterenko
// 11/7/2022

#include <iostream>

using std::cout; 
using std::cin;
using std::endl;

// base interface
class Square{
public:
   virtual void draw()=0;
   virtual ~Square(){}
};

// implementer/adaptee
class LegacyRectangle{
public:
   LegacyRectangle(int topLeftX, int topLeftY, 
		   int bottomRightX, int bottomRightY): 
      topLeftX_(topLeftX), 
      topLeftY_(topLeftY), 
      bottomRightX_(bottomRightX), 
      bottomRightY_(bottomRightY){}

   void oldDraw() const{
      for(int i=0; i < bottomRightY_; ++i){
         for(int j=0; j < bottomRightX_; ++j)
            if( i >= topLeftY_ && j>= topLeftX_ )
               cout << '*';
            else
               cout << ' ';
         cout << endl;
      }
   }
   // Move Function
   void move(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY){
     topLeftX_ = topLeftX;
     topLeftY_ = topLeftY;
     bottomRightX_ = bottomRightX;
     bottomRightY_ = bottomRightY;
   }
   // Returns the current value of TopLeftX
   int getTopLeftX(){
     return topLeftX_;
   }
   // Returns the current value of TopLeftY
   int getTopLeftY(){
     return topLeftY_;
   }
   // Returns the current value of BottomRightX
   int getBottomRightX(){
     return bottomRightX_;
   }
   // Returns the current value of BottomRightY
   int getBottomRightY(){
     return bottomRightY_;
   }
private: // defining top/left and bottom/right coordinates 
   int topLeftX_;
   int topLeftY_;
   int bottomRightX_;
   int bottomRightY_;
};

// adapter uses composition to delegate 
// requests to adaptee
class SquareAdapter: public Square{
public:
   SquareAdapter(int size){
      adaptee_= new LegacyRectangle(0,0,size,size);
   }
   void draw() override {
      adaptee_->oldDraw();
   }
   // Returns the size of the square
   int size(){
     return adaptee_->getBottomRightX() - adaptee_->getTopLeftX();
   }
   // Resizes the square to the input size
   void resize(int num){
     adaptee_->move(adaptee_->getTopLeftX(), adaptee_->getTopLeftY(), num ,num);
   }
private:
   LegacyRectangle *adaptee_;
};


int main(){
   //Square *square = new SquareAdapter(12);
   //square->draw();
  int num;
  cout << "Enter the Square's size: ";
  cin >> num;
  Square *square = new SquareAdapter(num);
  square->draw();
  SquareAdapter *square2 = new SquareAdapter(num);
  cout << "The current size of the square is " << square2->size() << endl;
  cout << "Enter a new size for the square: ";
  cin >> num;
  square2->resize(num);
  square2->draw();
  cout << "The current size of the square is " << square2->size() << endl;
}