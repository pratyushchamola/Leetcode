#define ll long long
class Solution {
public:
    int countGoodTriplets(vector<int>& arr, int a, int b, int c) {
        int sz = arr.size();
        
        ll ans = 0;
        for(int i=0;i<sz-2;i++){
            for(int j=i+1;j<sz-1;j++){
                for(int k=j+1;k<sz;k++){
                    ll one = abs(arr[i] - arr[j]);
                    ll two = abs(arr[j] - arr[k]);
                    ll three = abs(arr[i] - arr[k]);
                    
                    if((one <= a) && (two <= b) && (three <= c))ans++;
                }
            }
        }
        
        return ans;
    }
};



//    ll one = abs(arr[i] - arr[str]);
//                 ll two = abs(arr[str] - arr[ed]);
//                 ll three = abs(arr[i] - arr[ed]);
             