package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: DPMaxSalary
 * @description: 你打算利用空闲时间来做兼职工作赚些零花钱。
 *
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 *
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 * 思路讲解 ： https://www.bilibili.com/video/BV18x411V7fm
 * @author: liuliang
 * @create: 2020-12-17 21:48
 */
public class DPMaxSalary {
    static class Job {
        int start;
        int end;
        int payment;

        public Job(int start, int end, int payment) {
            this.start = start;
            this.end = end;
            this.payment = payment;
        }

    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[profit.length];
        for (int i = 0; i < profit.length; i++) {
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }
        Arrays.sort(jobs, Comparator.comparingInt(o->o.end));
        int opt[] = new int[profit.length+1];
        int pre[] = new int[profit.length+1];
        pre[0]=0;
        for(int i=1;i<profit.length;i++) {
            for(int j=i-1;j>=0;j--) {
                if(jobs[i].start>=jobs[j].end) {
                    pre[i]=j+1;
                    break;
                }
            }
        }
        opt[0]=jobs[0].payment;

        for(int i=1;i<profit.length;i++) {
            if(pre[i]==0) {
                opt[i]=jobs[i].payment>opt[i-1]?jobs[i].payment:opt[i-1];
            }
            else {
                opt[i]=opt[i-1]>opt[pre[i-1]]+jobs[i].payment?opt[i-1]:opt[pre[i-1]]+jobs[i].payment;
            }
        }
        return opt[profit.length-1];
    }

    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
    }
}
