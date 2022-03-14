// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
	public:
		int AlternatingaMaxLength(vector<int>&nums){
		    // Code here
		    // check for type 1 : increase than, decrease
		    int curele = nums[0];
		    int cnt = 1;
		    bool flag = true;
		    for(int i=1;i<nums.size();i++){
		        if(flag){
		            if(nums[i]>curele){
		                cnt++;
		                curele = nums[i];
		                flag = !flag;
		            }else curele = nums[i];
		        }else{
		            if(nums[i]<curele){
		                cnt++;
		                curele = nums[i];
		                flag = !flag;
		            }else curele = nums[i];
		        }
		    }
		    int ans = cnt;
		    // type 2: decrease then  increase;
		    cnt = 1;
		    curele = nums[0];
		    flag = false;
		    
		    for(int i=1;i<nums.size();i++){
		        if(flag){
		            if(nums[i]>curele){
		                cnt++;
		                curele = nums[i];
		                flag = !flag;
		            }else curele = nums[i];
		        }else{
		            if(nums[i]<curele){
		                cnt++;
		                curele = nums[i];
		                flag = !flag;
		            }else curele = nums[i];
		        }
		}
		
		ans = max(ans,cnt);
		
		return ans;
}
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < n; i++)
			cin >> nums[i];
		Solution obj;
		int ans = obj.AlternatingaMaxLength(nums);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends