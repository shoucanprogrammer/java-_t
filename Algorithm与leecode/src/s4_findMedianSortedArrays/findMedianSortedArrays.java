package s4_findMedianSortedArrays;

import org.junit.Test;

import java.util.LinkedList;

public class findMedianSortedArrays {
    @Test
    public void test(){
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays4(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int m1 = 0;
        int n1 = 0;
        double mid = 0;
        LinkedList<Integer> list = new LinkedList();
        while (m1+n1<m+n){
            if (m1<m && n1 < n && nums1[m1] <= nums2[n1]){
                list.add(nums1[m1] );
                m1++;
            }else if (m1<m && n1 < n && nums1[m1] > nums2[n1]){
                list.add(nums2[n1] );
                n1++;
            }else if (m1 < m){
                list.add(nums1[m1] );
                m1++;
            }else {
                list.add(nums2[n1] );
                n1++;
            }
        }
        if ((m + n) % 2 == 0){
            double min = list.get((m + n) / 2-1);
            double max = list.get((m+n)/2);
            mid = (min + max)/2;
        }else {
            mid = list.get((m + n) /2);
        }
        return mid;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int m1 = 0;
        int n1 = 0;
        double mid = 0;
        if ((m + n) % 2 == 0){
            int l = (m + n) / 2-1;
            int r = (m+n)/2;
            double lnum = 0;
            double rnum = 0;
            while (m1+n1<=(m+n)/2){
                if (m1<m && n1 < n && nums1[m1] <= nums2[n1]){
                    if (m1+n1 == l){
                        lnum = nums1[m1];
                    }
                    if (m1+n1 == r){
                        rnum = nums1[m1];
                    }
                    m1++;
                }else if (m1<m && n1 < n && nums1[m1] > nums2[n1]){
                    if (m1+n1 == l){
                        lnum = nums2[n1];
                    }
                    if (m1+n1 == r){
                        rnum = nums2[n1];
                    }
                    n1++;
                }else if (m1 < m){
                    if (m1+n1 == l){
                        lnum = nums1[m1];
                    }
                    if (m1+n1 == r){
                        rnum = nums1[m1];
                    }
                    m1++;
                }else {
                    if (m1+n1 == l){
                        lnum = nums2[n1];
                    }
                    if (m1+n1 == r){
                        rnum = nums2[n1];
                    }
                    n1++;
                }

            }
            mid = (lnum+rnum)/2;

        }else {
            int r = (m+n)/2;

            while (m1+n1<=(m+n)/2){
                if (m1<m && n1 < n && nums1[m1] <= nums2[n1]){
                    if (m1+n1 == r){
                        mid = nums1[m1];
                    }
                    m1++;
                }else if (m1<m && n1 < n && nums1[m1] > nums2[n1]){
                    if (m1+n1 == r){
                        mid = nums2[n1];
                    }
                    n1++;
                }else if (m1 < m){
                    if (m1+n1 == r){
                        mid = nums1[m1];
                    }
                    m1++;
                }else {
                    if (m1+n1 == r){
                        mid = nums2[n1];
                    }
                    n1++;
                }

            }

        }

        return mid;
    }


    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* ??????????????????????????? k (k>1) ??????????????????????????? pivot1 = nums1[k/2-1] ??? pivot2 = nums2[k/2-1] ????????????
         * ????????? "/" ????????????
         * nums1 ??????????????? pivot1 ???????????? nums1[0 .. k/2-2] ?????? k/2-1 ???
         * nums2 ??????????????? pivot2 ???????????? nums2[0 .. k/2-2] ?????? k/2-1 ???
         * ??? pivot = min(pivot1, pivot2)?????????????????????????????? pivot ??????????????????????????? (k/2-1) + (k/2-1) <= k-2 ???
         * ?????? pivot ??????????????????????????? k-1 ????????????
         * ?????? pivot = pivot1????????? nums1[0 .. k/2-1] ?????????????????? k ???????????????????????????????????? "??????"???????????????????????? nums1 ??????
         * ?????? pivot = pivot2????????? nums2[0 .. k/2-1] ?????????????????? k ???????????????????????????????????? "??????"???????????????????????? nums2 ??????
         * ???????????? "??????" ??????????????????????????????????????? k ?????????????????????????????????????????? k ????????????????????????????????????
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // ????????????
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // ????????????
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public double findMedianSortedArrays4(int[] nums1, int[] nums2){
        int len1 = nums1.length; int len2 = nums2.length;
        double mid = 0;
        if ((len1 + len2) % 2 == 1){
            mid = getKthElement1(nums1,nums2,(len1+len2)/2+1);
        }else {
            mid = (getKthElement1(nums1,nums2,(len1+len2)/2) + getKthElement1(nums1,nums2,(len1+len2) / 2+1 ))/2.0;
        }
        return mid;
    }
    public int getKthElement1(int[] nums1, int[] nums2, int k){
        int star1index = -1;
        int star2index = -1;
        int qury1 = 0;
        int qury2 = 0;
        int value = 0;
        while (true){
            if (star1index == nums1.length - 1){
                return nums2[star2index + k];
            }
            if (star2index == nums2.length - 1){
                return nums1[star1index + k];
            }
            if (k==1){
                star1index = star1index + 1;
                star2index = star2index + 1;
                if (nums1[star1index] <= nums2[star2index]){
                    return nums1[star1index];
                }else {
                    return nums2[star2index];
                }
            }
            qury1 = star1index + (k/2) ;
            qury2 = star2index + (k/2) ;
            qury1 = Math.min(qury1, nums1.length-1);
            qury2 = Math.min(qury2, nums2.length-1);

            if (nums1[qury1] <= nums2[qury2]){
                k = k - (qury1 - star1index);
                star1index = qury1;

            }else {
                k = k - (qury2 -star2index);
                star2index = qury2;

            }

        }
    }

}


