class Solution {
public:
    bool dfs(vector<int>& arr,int ind,int sum){
        if(ind == arr.size())return sum==0;
        
        int n = arr[ind];
        if(dfs(arr,ind+1,sum))return true;
        arr[ind] = -n;
        if(dfs(arr,ind+1,sum-n))return true;
        arr[ind] = n;
        return false;
    }
    vector<int> recoverArray(int n, vector<int>& sums) {
        int minele = *min_element(sums.begin(),sums.end());
        
        for(int i=0;i<sums.size();i++)sums[i] += -minele;
        
        multiset<int> s(begin(sums),end(sums)), temp;
        vector<int> ans;
        for(int i=0;i<n;i++){
            temp.clear();
            int curele = *next(s.begin());
            ans.push_back(curele);
            
            while(s.size()){
                int firstele = *s.begin();
                temp.insert(firstele);
                s.erase(s.begin());
                s.erase(s.find(firstele + curele));
            }
            swap(s,temp);
        }
        
        dfs(ans,0,-minele);
        
        return ans;
    }
};