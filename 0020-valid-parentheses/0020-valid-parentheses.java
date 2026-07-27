class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                st.push(ch);
            } else {
                if(st.empty()){
                    return false;
                }
                char top = st.pop();
                if (top != map.get(ch)){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}