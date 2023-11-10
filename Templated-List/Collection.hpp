// Garrett Bearss
// Collection.hpp
// 2/2/2023

#ifndef COLLECTION_HPP_
#define COLLECTION_HPP_
#include "list.hpp"
#include <iostream>

template <typename T>
class Collection {
  public:
  // Constructor
  Collection(){
    list_ = nullptr;
  }
  // Adds an item to the end of the Collection of items
  void add(const T item);
  // Removes the item specified in the argument
  void remove(const T item);
  // Returns the last item in the collection
  T last();
  // Prints all items that are currently in the collection
  void print();
  // Compares two collections for equality
  friend bool equal(const Collection<T> &collect1, const Collection<T> &collect2){
    node<T> *collect1Ptr = collect1.list_;
    node<T> *collect2Ptr = collect2.list_;
    // While there is a value being pointed to from both of the collections
    while(collect1Ptr != nullptr && collect2Ptr != nullptr){
      // Check to see if the value of the pointers is the same
      if(collect1Ptr->getData() == collect2Ptr->getData()){
        collect1Ptr = collect1Ptr->getNext();
        collect2Ptr = collect2Ptr->getNext();
      }
      // If they are not the same
      else{
        return false;
      }
    }
    // Checks to make sure both collections are at the end
    if(collect1Ptr == nullptr && collect2Ptr == nullptr){
      return true;
    }
    // If one of the collections are still not at the end
    else{
      return false;
    }
  }
  private:
  node<T> *list_;
};

// Add function
template <typename T>
void Collection<T>::add(const T item){
  // Create a new node that stores item
  node<T> *nodePtr1 = new node<T>();
  nodePtr1->setData(item);
  // Set the pointer to the next value to be null
  nodePtr1->setNext(nullptr);
  // If this is the first element being added to the collection
  if(list_ == nullptr){
    list_ = nodePtr1;
  }
  // If this is not the first element being added to the collection
  else{
    node<T> *nodePtr2 = list_;
    // If the new ptr isn't at the end of the collection yet
    while(nodePtr2->getNext() != nullptr){
      nodePtr2 = nodePtr2->getNext();
    }
    // Sets the last pointer in the current list to the next element being added
    nodePtr2->setNext(nodePtr1);
  }
}

// Remove function
template <typename T>
void Collection<T>::remove(const T item){
  node<T> *currentPtr = list_;
  node<T> *previousPtr = currentPtr;
  // While the currentPtr does not contain the item to be deleted and the pointer is pointing to something
  while(currentPtr && currentPtr->getData() != item){
    previousPtr = currentPtr;
    currentPtr = previousPtr->getNext();
  }
  // If the item was within the collection
  if(currentPtr != nullptr){
    // If the item wasn't at the start, but exists in the middle part/ end
    if(currentPtr != list_){
      // Set the previous item's next ptr to the current one's next ptr, effectively skipping the value over
      previousPtr->setNext(currentPtr->getNext());
    }
    // If the item was at the start
    else{
      // Set the list ptr to the next item
      list_ = currentPtr->getNext();
    }
  }
  // Item does not exist within the collection
  else{
    return;
  }
  // Deletes the requested item
  delete currentPtr;
}

// Last function
template <typename T>
T Collection<T>::last(){
  node <T> *nodePtr1 = list_;
  /*
  // If there is no value in the list
  if(nodePtr1 == nullptr){
    return nullptr;
  }
  */
  // While the node ptr is pointing to something, there is another value afterward, increment the node ptr
  while(nodePtr1 && nodePtr1->getNext()){
    nodePtr1 = nodePtr1->getNext();
  }
  return nodePtr1->getData();
}

// Print function
template <typename T>
void Collection<T>::print(){
  node <T> *nodePtr1 = list_;
  // While there is still a value in the list, print it
  while(nodePtr1 != nullptr){
    std::cout << nodePtr1->getData() << " --> ";
    nodePtr1 = nodePtr1->getNext();
  }
  std::cout << std::endl;
}

#endif