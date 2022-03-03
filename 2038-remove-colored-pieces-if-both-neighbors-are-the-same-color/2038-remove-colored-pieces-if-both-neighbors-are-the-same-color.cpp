class Solution {
public:
    bool winnerOfGame(string colors) {
        int alice = 0, bob = 0;
        int n = colors.length();
        int cnta = 0, cntb = 0;
        for(int i=0;i<n;i++){
            if(colors[i]=='A'){
                if(cnta==2){
                    alice++;
                    cnta = 2;
                    cntb = 0;
                }else{
                    cnta++;
                    cntb = 0;
                }
            }else{
                if(cntb == 2){
                    bob++;
                    cntb=2;
                    cnta = 0;
                }else{
                     cntb++;
                     cnta = 0;
                }
            }
        }
        
        // cout << alice << " " << bob  << endl;
        if(alice > bob)return true;
        else return false;
    }
};