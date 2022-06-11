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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* cur = head;
        ListNode* prev = NULL;
        ListNode* str = NULL;
        while(cur != NULL){
            while(cur != NULL and cur->val == val)cur = cur->next;
            if(str == NULL)str = cur;
            if(prev == NULL)prev = cur;
            else prev->next = cur;
            prev = cur;
            
            if(cur != NULL)cur = cur->next;
        }
        
        return str;
    }
};