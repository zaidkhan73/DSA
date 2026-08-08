class Solution {

    public String predictPartyVictory(String senate) {

        int n = senate.length();

        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {

            int ri = r.poll();
            int di = d.poll();

            if (ri < di) {
                r.offer(ri + n);
            } else {
                d.offer(di + n);   
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";  
    }
}