/**
 * Problem: Greatest Common Divisor Traversal
 * Description: You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices. You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common divisor.
 *
 * Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a sequence of traversals that can take us from i to j.
 *
 * Return true if it is possible to traverse between all such pairs of indices, or false otherwise.
 */
class DSU {
    private int[] parent;
    private int[] size;
    private int numberOfComponents;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent)
            return;

        if (size[xParent] > size[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        } else if (size[xParent] < size[yParent]) {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        } else {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }

        numberOfComponents -= 1;
    }

    public int maxSize() {
        return numberOfComponents;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);

        int m = Arrays.stream(nums).max().orElse(0);
        int[] first = new int[m + 1];
        Arrays.fill(first, -1);

        for (int i = 0; i < n; ++i) {
            for (int prime = 2; prime * prime <= nums[i]; ++prime) {
                if (nums[i] % prime != 0)
                    continue;

                if (first[prime] != -1)
                    dsu.union(first[prime], i);
                else
                    first[prime] = i;

                while (nums[i] % prime == 0)
                    nums[i] /= prime;
            }

            if (nums[i] > 1) {
                if (first[nums[i]] != -1)
                    dsu.union(first[nums[i]], i);
                else
                    first[nums[i]] = i;
            }
        }

        return dsu.maxSize() == 1;
    }
}