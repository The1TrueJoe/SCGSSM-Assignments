#include <array>
#include <string>

using namespace std;

struct ListNode {
    int data;
    ListNode * next;

    // constructor here
    ListNode(int k) { data = k; }

};

int main() {
    int *p;         // makes a pointer
    p = new int;    // sets aside memory for pointer

    * p = 42;
    
    cout << * p <<  " value at address in p "<< endl;
    cout << p << " address  of p " << endl;



    string * s;
    s = new string;
    * s = "hey you";

    cout << * s << " contents at address in s" << endl;
    cout << s << " address of s" << endl;

    delete s;  // free up memeory allocated by s

    int * k;
    k = new int;
    * k = 50;

    cout << * k << " value at address in k" << endl;
    p = k;

    cout << * p <<  " value at address in p after storing k into it "<<endl;
    cout << p <<  " address in p "<<endl;

    cout << "Now for a linked list... " << endl;

    ListNode * last;   // keeps up with last node as we go thru list
    ListNode * first;  // keeps up with first node

    first  = new ListNode(1);  //create new space for first
    //first->data = 1;        // data will be 1...10 so start with 1
    last = first;           // set last to be first indicating that we have one node

    for (int k = 2; k <= 10; k++){      //loop to create more nodes
      ListNode *newNode = new ListNode(k); // create new node and set its data index
      //newNode->data = k;

      last -> next = newNode;            // set last node's next to point to new node
      last = newNode;                   // set last node to be the new node

    }

    last -> next = NULL;                 //set the last node's next to NULL so we can stop
    cout << "print the 10 linked list elements  " << endl;

    ListNode * current = first;     // current goes thru the list printing its data

    while(current!=NULL){
       cout << current->data << " ";
       current = current ->next;   // and then goes on to the next node

    }

    cout << endl;

    // free up the storage
    current = first;               // start with current set to first
    while (first != NULL){
        first = current -> next;     // set first to be the node after this one
        delete current;           // delete this node
        current = first;           // set current to be the node saved in first.
    
    }
}

