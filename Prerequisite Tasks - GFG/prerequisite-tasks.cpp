// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
	bool isPossible(int N, vector<pair<int, int> >& prerequisites) {
	    // Code here
	    vector<int> nodes[N];
	    
	    for(auto child:prerequisites){
	        nodes[child.first].push_back(child.second);
	    }
	    
	    vector<int> indeg(N,0);
	    for(int i=0;i<N;i++){
	        for(auto child:nodes[i]){
	            indeg[child]++;
	        }
	    }
	    
	    queue<int> q;
	    
	    for(int i=0;i<N;i++){
	        if(indeg[i] == 0)q.push(i);
	    }
	    
	    int cnt = 0;
	    while(!q.empty()){
	        int curnode = q.front();
	        q.pop();
	        
	        cnt++;
	        for(auto child:nodes[curnode]){
	            indeg[child]--;
	            
	            if(indeg[child] == 0)q.push(child);
	        }
	    }
	    
	    if(cnt == N)return true;
	    else return false;
	}
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
    	int N, P;
        vector<pair<int, int> > prerequisites;
        cin >> N;
        cin >> P;
        for (int i = 0; i < P; ++i) {
            int x, y;
            cin >> x >> y;
            prerequisites.push_back(make_pair(x, y));
        }
        // string s;
        // cin>>s;
        Solution ob;
        if (ob.isPossible(N, prerequisites))
            cout << "Yes";
        else
            cout << "No";
        cout << endl;
	}
	return 0;
}  // } Driver Code Ends