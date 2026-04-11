class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand==null)
            return false;
        
        int N = hand.length;
        if(N==0 || N % groupSize !=0)
            return false;

        Map<Integer,Integer> counterMap = new TreeMap<>();
        for(int num : hand){
            counterMap.put(num,counterMap.getOrDefault(num,0)+1);
        }
        //Arrays.stream(hand).boxed().collect(Collectors.groupingBy(i -> i, TreeMap::new,Collectors.counting()));

        for(int key : counterMap.keySet()){
            int freq = counterMap.get(key);
            if(freq > 0){
                for(int i=0; i<groupSize; i++){
                    int next = key+i;
                    if(counterMap.getOrDefault(next,0) < freq){
                        return false;
                    }
                    counterMap.put(next,counterMap.get(next)-freq);
                }
            }
        }
        return true;

    }
}