class MedianFinder {

    private PriorityQueue<Integer> upperHalf , lowerHalf ;
    public MedianFinder() {
        //minHeap => to store the larger elements  ; maxHeap = to store the smaller half of elemets
        upperHalf = new PriorityQueue<>();
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        
    }
    
    public void addNum(int num) {
        if(lowerHalf.isEmpty() || (num < lowerHalf.peek() ))
            lowerHalf.add(num);
        else
            upperHalf.add(num);

            if(lowerHalf.size()<upperHalf.size()){
                lowerHalf.add(upperHalf.remove());
            }
            else if(lowerHalf.size() > upperHalf.size()+1){
                upperHalf.add(lowerHalf.remove());
            }
        
    }
    
    public double findMedian() {
        if(lowerHalf.size() == upperHalf.size()){
            return ((lowerHalf.peek()+upperHalf.peek())/2.0);
        }
            return lowerHalf.peek();
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */