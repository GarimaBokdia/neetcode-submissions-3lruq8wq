class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length<1)
        return new int[]{-1};

        if(nums.length <=k)
        return nums;

       

        Map<Integer,Integer> eleCount = new HashMap<>();

        for(int n : nums){
            eleCount.put(n,eleCount.getOrDefault(n,0)+1);
        }

        //Priorirty Queue: Min Heap 
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(k,(a,b)-> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : eleCount.entrySet()){
                if(minHeap.size() < k){
                    minHeap.offer(entry);
                }else{
                    if(minHeap.peek().getValue() < entry.getValue())
                    {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                } 
        }
        
        int[] result = new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
           result[i++] = minHeap.poll().getKey();
        }
        return result;
    }
}
/*
That's a great idea\! Summarizing the core concepts will solidify your understanding.

Here is a concise summary of the **Min-Heap approach** for finding the Top $K$ Frequent Elements:

-----

## 📚 Top K Frequent Elements: Min-Heap Summary

### 1\. Goal and Efficiency

| Concept | Description |
| :--- | :--- |
| **Goal** | Efficiently find the $K$ elements with the highest frequencies. |
| **Efficiency** | The Min-Heap approach provides a time complexity of **$O(N \log k)$**. (It's faster than $O(N \log N)$ when $k$ is much smaller than the total number of unique elements, $N$). |

### 2\. The Data Structure (Java PriorityQueue)

We use a **PriorityQueue** configured as a **Min-Heap**.

  * **Heap Contents:** It stores `Map.Entry<Element, Frequency>`, which in your case is `Map.Entry<Integer, Integer>`.
  * **The Key to the Min-Heap:** The custom comparator forces the heap to prioritize the smallest element based on its **frequency** (the map entry's `Value`).

<!-- end list -->

```java
// Comparator for a Min-Heap based on Frequency (Value)
(a, b) -> a.getValue() - b.getValue()
```

  * **Result:** The element at the root (`peek()`) is always the **least frequent** item currently in the top $K$ list.

### 3\. The Algorithm Logic

The algorithm iterates through every unique element's frequency and uses a two-step process to maintain a heap size of exactly $K$:

| Scenario | Condition | Action |
| :--- | :--- | :--- |
| **Filling** | `minHeap.size() < k` | Simply use `minHeap.offer(entry)` to add the new entry. |
| **Replacing** | `minHeap.size() == k` **AND** `currentFrequency > minHeap.peek().getValue()` | 1. Use `minHeap.poll()` to remove the least frequent element (the root). 2. Use `minHeap.offer(entry)` to add the new, more frequent element. |
| **Skipping** | `minHeap.size() == k` **AND** `currentFrequency <= minHeap.peek().getValue()` | Do nothing. The new element is not frequent enough to be in the top $K$. |

### 4\. Final Result

After the loop completes, the **$K$ elements remaining** in the `minHeap` are the top $K$ most frequent elements. You extract the `Key` (the element itself) from each remaining `Map.Entry` to populate your final result array.
*/