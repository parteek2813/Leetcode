class Solution {
public:
    
   
// APPROACH 1 using simple first extract all vowel in seprate string and then sort it 
//     Then again traverse onto original string, and for each s[i] == vowel, replace it with first available char in // of seprate string
    
    
//     bool isVowel(char ch){
        
//         ch = tolower(ch);
        
//         return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u');
        
//     }
    
//     string sortVowels(string s) {
        
//         string temp;
        
//         for(char &ch: s){
//             if(isVowel(ch)){
//                 temp.push_back(ch);
                
//             }
//         }
        
//         sort(begin(temp), end(temp));
//         int j =0;
//         for(int i =0; i<s.length(); i++){
//             if(isVowel(s[i])){
//                 s[i] = temp[j];
//                 j++;
//             }
//         }
        
//         return s;
    
    
//     APPROACH 2 
    bool isVowel(char ch){
        
        ch = tolower(ch);
        
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u');
        
    }
    
    string sortVowels(string s) {
        unordered_map<char, int> mp;
        
        for(char &ch : s){
            if(isVowel(ch)){
                mp[ch]++;
                
            }
        }
        
        
        string temp = "AEIOUaeiou";
        int j = 0;
        
        for(int i =0; i<s.length(); i++){
            
            if(isVowel(s[i])){
                
                
                while(mp[temp[j]] == 0){
                    j++;
                }
                
                s[i] = temp[j];
                mp[temp[j]]--;
            }
            
        } 
        
        return s;
    }
};