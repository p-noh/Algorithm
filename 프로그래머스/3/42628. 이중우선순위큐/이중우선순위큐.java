import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations){
            char cmd = op.charAt(0);
            int num = Integer.parseInt(op.substring(2));
            
            if(cmd == 'I'){
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if(cmd == 'D'){
                if (map.isEmpty()) continue;

                int key = (num == 1) ? map.lastKey() : map.firstKey();
                int cnt = map.get(key);

                if (cnt == 1) map.remove(key);
                else map.put(key, cnt - 1);                
            }
        }
        
        
        if (map.isEmpty()) return new int[]{0,0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}