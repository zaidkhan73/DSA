class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)-> b-a);

        for (int stone: stones){
            max.add(stone);
        }

        while(max.size() > 1){
            int y = max.poll();
            int x = max.poll();

            if(x != y){
                max.add(y-x);
            }
        }

        return max.isEmpty() ? 0 : max.poll();
    }
}