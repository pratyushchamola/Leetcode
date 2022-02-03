class Solution {
    public String crackSafe(int n, int k) {
        String str = String.join("",Collections.nCopies(n,"0"));
        StringBuilder strpwd = new StringBuilder(str);
        
        int maxlen = (int)Math.pow(k,n);
        Set<String> hs = new HashSet<>();
        
        hs.add(str);
        calcans(strpwd,maxlen,hs,k,n);
            
        return strpwd.toString();    
    }
    
    private boolean calcans(StringBuilder curpwd,int maxlen,Set<String> hs,int k,int n){
        if(hs.size() == maxlen){
            return true;
        }
        
        String curdigits = curpwd.substring(curpwd.length() - n +1);
        for(char ch = '0' ; ch < ('0' + k);ch++){
            // temppwd += ch;
            String temppwd = curdigits + ch;
            if(!hs.contains(temppwd)){
                hs.add(temppwd);
                curpwd.append(ch);
                
                if(calcans(curpwd,maxlen,hs,k,n)){
                    return true;
                }
                
                hs.remove(temppwd);
                // temppwd.deleteCharAt(temppwd.length()-1);
                curpwd.deleteCharAt(curpwd.length()-1);
            }
        }
        
        return false;
    }
}