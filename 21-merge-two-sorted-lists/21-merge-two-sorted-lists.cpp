/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* smaller = list1;
        ListNode* larger = list2;
        
        if(list1 == NULL)return list2;
        if(list2 == NULL)return list1;
        
        if(list2->val < list1->val){
            swap(smaller,larger);
        }
        
        ListNode* ans = smaller;
        ListNode* prev = NULL;
        while(smaller != NULL and larger != NULL){
            while(smaller != NULL and larger != NULL and smaller->val <= larger->val){
                prev = smaller;
                smaller = smaller->next;
            }
            prev->next = larger;
            swap(smaller,larger);
        }
        
        return ans;
        
    }
};