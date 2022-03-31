class Solution {
public:
    
    bool check(double a,double b){
        if(abs(a+b - 24.0) < 0.0001 || abs(a-b - 24.0) < 0.0001 || abs(a/b - 24.0) < 0.0001 || abs(a*b - 24.0) < 0.0001)return true;
        return false;
    }
    bool check(double a,double b,double c){
        if(check(a+b,c) || check(a-b,c) || check(a/b,c) || check(a*b,c))return true;
        if(check(a,b-c) || check(a,b/c) || check(a,b+c) || check(a,b*c))return true;
        return false;
    }
    bool findans(vector<int>& arr){
        double a = arr[0], b = arr[1], c = arr[2], d = arr[3];
        
        if(check(a+b,c,d) || check(a*b,c,d) || check(a-b,c,d) || check(a/b,c,d))return true;
        if(check(a,b+c,d) || check(a,b-c,d) || check(a,b/c,d) || check(a,b*c,d))return true;
        if(check(a,b,c+d) || check(a,b,c-d) || check(a,b,c*d) || check(a,b,c/d))return true;
        return false;
        
    }
    bool judgePoint24(vector<int>& cards) {
        sort(cards.begin(),cards.end());
        
        do{
            if(findans(cards))return true;
        }while(next_permutation(cards.begin(),cards.end()));
        
        return false;
    }
};