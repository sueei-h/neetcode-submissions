class Solution {
    public int[] frequencySort(int[] nums) {
       if (nums == null) {
            throw new IllegalArgumentException();
        }

        int[] counts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            counts[i] = count;
        }

        int end = counts.length - 1;

        while (end > 0) {
            int lastSwap = 0;

            for (int j = 0; j < end; j++) {
                if (counts[j] > counts[j + 1]) {
                    swap(counts, j, j + 1);
                    swap(nums, j, j + 1);
                    lastSwap = j;
                }

                if (counts[j] == counts[j + 1]) {
                    if (nums[j] < nums[j + 1]) {
                        swap(counts, j, j + 1);
                        swap(nums, j, j + 1);
                        lastSwap = j;
                    }
                }
            }

            end = lastSwap;
        }

        return nums; 
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}