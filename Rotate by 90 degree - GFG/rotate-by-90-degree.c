// { Driver Code Starts
//Initial Template for C



#include<stdio.h>

 // } Driver Code Ends
//User function Template for C

#define ll long long

void rotate(int n,int a[][n])
{
    //code here
    for(int row=0;row<n;row++){
        ll str = 0;
        ll ed = n-1;
        
        while(str < ed){
            ll temp = a[row][str];
            a[row][str] = a[row][ed];
            a[row][ed] = temp;
            
            str++;
            ed--;
        }
    }
    
    for(int turn = 0;turn<n;turn++){
        ll str = turn;
        ll ed = turn;
        
        while(str < n && ed < n){
            ll temp = a[turn][str];
            a[turn][str] = a[ed][turn];
            a[ed][turn] = temp;
            
            str++;
            ed++;
        }
    }
}

// { Driver Code Starts.

int main()
{
    int t;
    scanf("%d",&t); 
    while(t--)
    {
        int n;
        scanf("%d",&n);
        int a[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                scanf("%d",&a[i][j]);
        }
        rotate(n,a);
        for (int i = 0; i < n; ++i)
        {
            for(int j=0; j<n; j++)
                printf("%d ",a[i][j]);
            printf("\n");
        }
    }
    return 0;
}

  // } Driver Code Ends