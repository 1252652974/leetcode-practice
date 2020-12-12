package leetcode.greek;

import java.util.zip.CheckedOutputStream;

/**
 * @ClassName: PlaceFlowers
 * @description: 花卉不能种植在相邻的地块上, 定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

 * @author: liuliang
 * @create: 2020-12-12 22:14
 */
public class PlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) {
            return true;
        }
        if (flowerbed.length==1) {
            if (n==1 && flowerbed[0]==0) return true;
            return false;
        }
        int count = 0;
        if (flowerbed[0]==0 && flowerbed[1] == 0) { count++; flowerbed[0]=1; }
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i] != 1 && (flowerbed[i-1] == 0 && flowerbed[i+1] == 0))  {
                count++;
                flowerbed[i] = 1;
            }
        }
        if (flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length -2] ==0) { count++;}
        if (count >= n) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1}, 0));
    }
}
