class RandomizedCollection {
public:
    map<int,set<int>> mp;
    vector<int> ss;
    
    RandomizedCollection() {
        
    }
    
    bool insert(int val) {
        
        mp[val].insert(ss.size());
        ss.push_back(val);
        
        return (mp[val].size() == 1);
    }
    
    bool remove(int val) {
         auto it = mp.find(val);                    
        if(it != mp.end()){                          
            auto pos = *it->second.begin();         
            it->second.erase(it->second.begin());   
            ss[pos] = ss.back();                      
            mp[ss.back()].insert(pos);               
            mp[ss.back()].erase(ss.size()-1);          
        ss.pop_back();                            
            if (it->second.size() == 0)             
                mp.erase(it);                     
            return true;
        }
        return false;
    }
    
    int getRandom() {
        int ind = 0;
        if(ss.size()>0)return ss[rand()%ss.size()];
        return ss[ind];
    }
};

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection* obj = new RandomizedCollection();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */