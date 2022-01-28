// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
#include <string>

using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    //Function to find list of all words possible by pressing given numbers.
    vector<string> answer;
    int n = 0;
    
    vector<vector<char>> alphabets = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    void findans(int arr[],int ind,string curstr){
        if(ind >= n){
            answer.push_back(curstr);
            return;
        }
        
        for(int i=0;i<alphabets[arr[ind]].size();i++){
            findans(arr,ind+1,curstr + alphabets[arr[ind]][i]);
        }
        
    }
    vector<string> possibleWords(int a[], int N)
    {
        //Your code here
        n = N;
        findans(a,0,"");
        
        return answer;
        
    }
};


// { Driver Code Starts.

int main() {
  
	int T;
	
	cin >> T; //testcases
	
	while(T--){ //while testcases exist
	   int N;
	    
	   cin >> N; //input size of array
	   
	   int a[N]; //declare the array
	   
	   for(int i =0;i<N;i++){
	       cin >> a[i]; //input the elements of array that are keys to be pressed
	   }
	   
	   Solution obj;
	   
	  vector <string> res = obj.possibleWords(a,N);
	  for (string i : res) cout << i << " ";
	   cout << endl;
	}
	
	return 0;
}  // } Driver Code Ends