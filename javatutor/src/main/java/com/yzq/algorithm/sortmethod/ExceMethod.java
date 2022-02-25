package com.yzq.algorithm.sortmethod;


public class ExceMethod extends DeleteDuplicated {
    void deletduplicate() {
        int nums[] = {2, 4, 1, 3, 2, 5, 4, 5, 4};
        int[] values = new int[]{18, 68, 62, 82, 65, 9};
        int[] re={3,4,5,6,7,};
        int leng = 6;
        int[] nl = {0, 0};
        duplicate(nums, leng, nl);
    }

    void find() {
        int t = 4;
        int[][] ar;
        ar = new int[][]{{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {563, 234, 5, 66, 5}};
        Find(t, ar);
    }

    void replacestr() {
        StringBuffer a = new StringBuffer("ad ddde e ee  eert");
        System.out.println(replaceSpace(a));
    }

}
