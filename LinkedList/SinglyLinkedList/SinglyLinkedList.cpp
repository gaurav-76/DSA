#include<bits/stdc++.h>
using namespace std;

struct ListNode{
    int data;
    ListNode *next;

    ListNode(int data){
        this->data = data;
        this->next = nullptr;
    }
};

void print(ListNode *head){
    ListNode *curr = head;
    while(curr != nullptr){
        cout << curr->data << " --> ";
        curr = curr->next;
    }
    cout << "nullptr" << endl;
}

int main(){

    ListNode *head = nullptr;
    ListNode *curr = nullptr;
    
    while(true){

        cout << "Want to enter elemnent in linked list?" << endl;
        cout << "Enter 1 for yes or -1 for no : ";

        int num;
        cin >> num;
        if(num == 1){
            int data;
            cout << "Enter node value : ";
            cin >> data;

            ListNode *node = new ListNode(data);
            if(head == nullptr){
                head = node;
                curr = node;
            }
            else{
                curr->next = node;
                curr = curr->next;
            }
        }
        else{
            break;
        }
    }

    cout << "Singly Linked List" << endl;
    print(head);
}