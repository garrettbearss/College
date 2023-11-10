// Garrett Bearss
// 3/9/2023
// hashmap.hpp
// implementation basic hashmap (unordered container)
// Mikhail Nesterenko: adapted from Proc C++
// 4/15/2014

#include <cstddef>
#include <utility>
#include <functional>
#include <vector>
#include <list>

using std::vector;
using std::list;
using std::pair;
using std::make_pair;

//////////////////////////////////////////
// hash function implemented as a class
//////////////////////////////////////////

// any Hash Class must provide 
// two methods: hash() and numBuckets().
template <typename T>
class DefaultHash {
public:
   DefaultHash(size_t numBuckets = defaultNumBuckets);
   size_t hash(const T& key) const;
   size_t numBuckets() const { return numBuckets_; }

private:
   // default number of buckets in the hash
   static const size_t defaultNumBuckets = 101; 
   size_t numBuckets_;
};

template <typename T>
DefaultHash<T>::DefaultHash(size_t numBuckets): numBuckets_(numBuckets) {}


// uses the division method for hashing.
// treats the key as a sequence of bytes, sums the ASCII
// values of the bytes, and mods the total by the number
// of buckets.
// note, this function does not work for C++ strings
template <typename T>
size_t DefaultHash<T>::hash(const T& key) const {
   size_t res = 0;
   for (size_t i = 0; i < sizeof(key); ++i) {
      const unsigned char b = 
      *(reinterpret_cast<const unsigned char *>(&key) + i);
      res += b;
   }
   return res % numBuckets_;
}


////////////////////////////////////////////////
// container class
////////////////////////////////////////////////

template <typename Key, typename Value, 
         typename Compare = std::equal_to<Key>,
         typename Hash = DefaultHash<Key>>
class hashmap{

public:
   typedef pair<const Key, Value> Element;

   // constructor
   // invokes constructors for comparison and hash objects
   hashmap(const Compare& comp = Compare(), 
	   const Hash& hash = Hash());

   // returns pointer to element with key x, nullptr if not found
   Element* find(const Key& x);

   // inserts the key/value pair
   // void insert(const Element& x);
   pair<Element*, bool> insert(const Element& x);
   // erases element with key x, if exists
   // void erase(const Key& x);
   pair<Element*, bool> erase(const Key& x);
   // returns reference on value of element with key, inserts if does not exist
   Value& operator[] (const Key& x);
   // Rehashes the map the the new size specified
   void rehash(size_t size);
   // Returns the size of the hashmap
   size_t getNumBuckets(){return size_;}

private:

   // helper function for various searches
   typename list<Element>::iterator findElement(const Key& x, const size_t bucket);

   size_t size_;   // number of elements in the container
   Compare comp_;  // comparison functor, equal_to by default
   Hash hash_;     // hash functor 

   // hash contents: vector of buckets
   // each bucket is a list containing key->value pairs
   vector<list<Element>> elems_;
};

////////////////////////////////////////////////
// container member functions
////////////////////////////////////////////////

// Construct elems_ with the number of buckets.
template <typename Key, typename Value, typename Compare, typename Hash>
   hashmap<Key, Value, Compare, Hash>::hashmap(
   const Compare& comp, const Hash& hash):
      size_(0), comp_(comp), hash_(hash) {
         elems_ = vector<list<Element>>(hash_.numBuckets());
}

// helper function
template <typename Key, typename Value, 
          typename Compare, typename Hash>
   typename list<pair<const Key, Value>>::iterator // return type
   hashmap<Key, Value, Compare, Hash>::findElement(const Key& x, size_t bucket){

   // look for the key in the bucket
   for (auto it =  elems_[bucket].begin(); it != elems_[bucket].end(); ++it) {
      if (comp_(it->first, x))
	      return it;
   }

   return elems_[bucket].end(); // element not found
}

// returns a pointer to the element with key x
// returns nullptr if no element with this key
template <typename Key, typename Value, typename Compare, typename Hash>
typename hashmap<Key, Value, Compare, Hash>::Element* // return value type
hashmap<Key, Value, Compare, Hash>::find(const Key& x){
   size_t bucket = hash_.hash(x);
   auto it = findElement(x, bucket);    // use the findElement() helper   
   if(it != elems_[bucket].end()){
      // found the element. Return a pointer to it.
      return &(*it); // dereference the iterator to list 
                     // then take the address of list element
   }
   else{ // didn't find the element -- return nullptr
      return nullptr;
   }
}

// finds the element with key x, inserts an
// element with that key if none exists yet. Returns a reference to
// the value corresponding to that key.
template <typename Key, typename Value, typename Compare, typename Hash>
pair<typename hashmap<Key, Value, Compare, Hash>::Element*, bool> hashmap<Key, Value, Compare, Hash>::insert(const Element& x){
   // Keeps track of weither or not the insert was successful or not
   bool result = false;
   // resizes the bucket according to the new value being inserted
   size_t bucket = hash_.hash(x.first);   
   auto it = findElement(x.first, bucket);    // try to find the element

   // if not found, insert a new one.
   if (it == elems_[bucket].end()) {
      ++size_;
      // If the element was able to be inserted
      result = true;
      // Push the element into the vector
      elems_[bucket].push_back(x);
      // Gets the pointer to the element inside the bucket and adds true to the pair because the insert was successful
      it = findElement(x.first, bucket);
   }
   // Returns the pointer to the element that tried to get inserted and the result based on weither or not it was successful in insertion 
   return make_pair(&(*it), result);
}


// removes the Element with key x, if it exists
template <typename Key, typename Value, typename Compare, typename Hash>
pair<typename hashmap<Key, Value, Compare, Hash>::Element*, bool> hashmap<Key, Value, Compare, Hash>::erase(const Key& x){
   // Keeps track of weither the erase was successful
   bool result = false;
   // Resizes the bucket based on the input key
   size_t bucket = hash_.hash(x);
   auto it = findElement(x, bucket);    // try to find the element

   if(it != elems_[bucket].end()){    // the element exists, erase it
      // Decrement the size of the container
      --size_;
      // An erase will occur
      result = true;
      // If there would be no more values in the vector, return a nullptr
      if(size_ == 0){
         // Erase the value
         elems_[bucket].erase(it);
         // Return a pair with a nullptr since the vector is empty
         return make_pair(nullptr, result);
      } 
      // If the next bucket isn't the end
      else if(++it != elems_[bucket].end()){
         // Set the next bucket over to be the one being erased
         it = elems_[bucket].erase(--it);
      }
      // If at the end of the vector
      else{
        // Used to find the value of the next bucket over
        int nextBucket = bucket + 1;
        // If the number of current buckets is lower or equal to the next bucket over, then set the to 0
        if(nextBucket >= hash_.numBuckets()){
          nextBucket = 0;
        }
        // Empty out all values with corresponding key
        while(elems_[nextBucket].empty()){
            ++nextBucket;
        }
        // Set the iterator to the key being returned to the beginning of the elements bucket where it started erasing
         it = elems_[nextBucket].begin();
      }
      // Return the key and that something was erased 
      return make_pair(&(*it), result);
   } 
   // If the value wasn't found and nothing was erased
   else{
      return make_pair(nullptr, result);
   }   
}

// returns reference to value of element with key x,
// inserts if does not exist
template <typename Key, typename Value, typename Compare, typename Hash>
Value& hashmap<Key, Value, Compare, Hash>::operator[] (const Key& x) {
   Element* found = find(x);
   if(found == nullptr){ // if key not found, create new element with empty value
      auto pointer= insert(make_pair(x, Value())); // calling default constructor on Value
     // Returns the Value of the element that was just inserted
     return pointer.first->second;
   }
   // Returns the Value of the element that already exists within the hashmap
   return found->second;
}

template <typename Key, typename Value, typename Compare, typename Hash>
void hashmap<Key, Value, Compare, Hash>::rehash(size_t size){
  // If the size would be smaller than the number current buckets 
  if(size < hash_.numBuckets()){
    return;
  }
  else{
    // Uses the default contructor to reset the values to their predetermined state
    hash_ = DefaultHash<Key>(size);
    // Creates a tempVector to store the elements while they are moved to the newly sized vector
    vector<Element> tempVector;
    // For each bucket in elements
    for(auto &bucket: elems_){
      // For each element inside of the buckets
      for(auto &element: bucket){
         // Push the element into the new vector
         tempVector.push_back(element);
      }
   }
   // Sets elems_ to a new vector of lists of the new number of buckets required
   elems_ = vector<list<Element>>(hash_.numBuckets());
   // Sets the size of the buckets to the user input
   size_ = hash_.numBuckets();
   // For each element in the tempVector
   for(auto &element: tempVector){
      // Sets the size of the hashmap to how many elements are being moved into the new elems_
      size_t t =  hash_.hash(element.first);
      // Push the element into the specified bucket and vector of lists
      elems_[t].push_back(element);
   }
  }
}