package com.learn.fori;

/**
 * @program: leetCode
 * @description: 寻找两个正序数组的中位数
 * @author: 空见
 * @create:
 */

public class FindTwoMiddle {

    public static void main(String[] args) {

        int[] one = new int[]{10, 12, 22, 23};

        int[] two = new int[]{3, 5, 6, 7, 8};


        // 时间复杂度 O(m+n)
        buildTwoMiddle(one, two);

        // 时间复杂度  O(log(m+n))

        buildTwoMiddle2(one, two);


    }

    private static void buildTwoMiddle2(int[] nums1, int[] nums2) {
        //保证num1长度小，如果不小交换一下
        if (nums1.length > nums2.length) {
            int team[] = nums2.clone();
            nums2 = nums1;
            nums1 = team;
        }
        //理论中位数满足的位置 ，即中位数的个数
        int k = (nums1.length + nums2.length + 1) / 2;
        //二分查找短的 这里的左右是标注短数组左右元素的个数的
        int left = 0, right = nums1.length;

        //找到对应位置
        while (left < right) {
            //在短的位置 先二分法，直接定位到中间
            int m1 = (left + right) / 2;
            //在长的第几个 -为满足中位数的个数，长的需要提供的元素个数
            int m2 = k - m1;
            // 调解中位线分割线的位置，以满足数组交叉时候，number1  左边最大元素，小于number2右边最小元素
            if (nums1[m1] < nums2[m2 - 1]) {
                //left右移
                left = m1 + 1;
            } else {
                //right左移
                right = m1;
            }
        }
        //左侧最大和右侧最小那个先算出来再说，根据奇偶再使用
        double leftbig = Math.max(left == 0 ? Integer.MIN_VALUE : nums1[left - 1],
                k - left == 0 ? Integer.MIN_VALUE : nums2[k - left - 1]);
        double rightsmall = Math.min(left == nums1.length ? Integer.MAX_VALUE : nums1[left],
                k - left == nums2.length ? Integer.MAX_VALUE : nums2[k - left]);
        if ((nums1.length + nums2.length) % 2 == 0) {
            System.out.println((leftbig + rightsmall) / 2);
        } else {
            System.out.println(leftbig);
        }

    }

    private static void buildTwoMiddle(int[] one, int[] two) {
        int[] temp = new int[one.length + two.length];
        int a = 0;
        int b = 0;
        int c = 0;

        while (a < one.length || b < two.length) {

            if (a == one.length && b != two.length) {
                temp[c] = two[b];
                b++;
            } else if (a != one.length && b == two.length) {
                temp[c] = one[a];
                a++;
            } else {
                if (one[a] < two[b]) {
                    temp[c] = one[a];
                    a++;
                } else {
                    temp[c] = two[b];
                    b++;
                }
            }
            c++;
        }

        if (temp.length % 2 == 0) {
            System.out.println((double) (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2);
        } else {
            System.out.println(temp[temp.length / 2]);
        }
    }
}
