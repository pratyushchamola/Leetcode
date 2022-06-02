class RandomizedCollection {
public:
    unordered_map<int,vector<int>> mp;
    vector<pair<int,int>> arr;
    RandomizedCollection() {
        
    }
    
    bool insert(int val) {
        auto it = mp.find(val) == mp.end();
        
        mp[val].push_back(arr.size());
        arr.push_back(pair<int,int>(val,mp[val].size()-1));
        
        return it;
    }
    
    bool remove(int val) {
        auto it = mp.find(val) != mp.end();
        
        if(it){
            auto last = arr.back();
            mp[last.first][last.second] = mp[val].back();
            arr[mp[val].back()] = last;
            
            mp[val].pop_back();
            
            if(mp[val].empty())mp.erase(val);
            arr.pop_back();
            
        }
        
        return it;
    }
    
    int getRandom() {
        return arr[rand()%arr.size()].first;
    }
};

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection* obj = new RandomizedCollection();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */