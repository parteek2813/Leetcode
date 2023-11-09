class Solution {
public:
    bool isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        
        int h_dist = abs(sy-fy);
        int v_dist = abs(sx-fx);
        
        
        // if starting and ending are both same and time = 1 then not possible to come back 
        // again as once you go from that cell, you can't come back within time
        
        if(h_dist == 0 && v_dist == 0 && t == 1){
            return false;
        }
        
        int m_time = max(h_dist, v_dist);
        
        if(m_time > t){
            return false;
        }
        
        return true;
    }
    
};