class Solution {
    public int ind = 0;
    public String findans(String s,int n,boolean flag,int cnt){
        if(ind >= n)return "";
        
        // int cnt = 0;
        String ans = "";
       
        if(flag == false){
            while(ind < n){
                if(ind < n && (s.charAt(ind) >= '0' && s.charAt(ind) <= '9')){
                    int sum = 0;
                    while(s.charAt(ind) != '['){
                        sum = sum*10 + (s.charAt(ind) - '0');
                        ind++;
                    }

                    ind++;
                    System.out.println("sum : " + sum);
                    ans += findans(s,n,true,sum);
                }else{
                    ans += s.charAt(ind);
                    ind++;
                }
            }
        }else{
           while(ind<n){
               if(s.charAt(ind) == ']'){
                   ind++;
                   break;
               }
               else if(s.charAt(ind) >= '0' && s.charAt(ind) <= '9'){
                   int sum = 0;
                   while(s.charAt(ind) != '['){
                        sum = sum*10 + (s.charAt(ind) - '0');
                        ind++;
                    }

                    ind++;
                    ans += findans(s,n,true,sum);
               }else{
                    ans += s.charAt(ind);
                   ind++;
               }
           } 
        }
        
        String temp = ans;
        for(int i=1;i<cnt;i++)ans += temp;
        
        return ans;
    }
    public String decodeString(String s) {
        return findans(s,s.length(),false,1);
    }
}