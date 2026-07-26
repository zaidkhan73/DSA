class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }

        Map<String, List> ansMap = new HashMap<>();

        int[] count = new int[26];

        for (String str: strs ){
            Arrays.fill(count,0);

            for(char c: str.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for(int i = 0; i < 26 ; i++){
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();

            if(!ansMap.containsKey(key)){
                ansMap.put(key, new ArrayList());
            }

            ansMap.get(key).add(str);
            
        }

        return new ArrayList(ansMap.values());
    }


    // solution using sorting : (sub-optimal)
    // public List<List<String>> groupAnagrams(String[] strs) {

    //     HashMap<String, List<String>> map = new HashMap<>();

    //     for (String str : strs) {

    //         char[] ch = str.toCharArray();

    //         Arrays.sort(ch);

    //         String sorted = new String(ch);

    //         if (!map.containsKey(sorted)) {
    //             map.put(sorted, new ArrayList<>());
    //         }

    //         map.get(sorted).add(str);
    //     }

    //     return new ArrayList<>(map.values());
    // }
}