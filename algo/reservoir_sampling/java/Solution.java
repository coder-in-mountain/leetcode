import java.math.*;
public class Solution {


    static final int m = 10;
    /**
     * 单机的蓄水池抽样
     * 给定一个数据流，数据流长度N很大，且N直到处理完所有数据之前都不可知，
     * 请问如何在只遍历一遍数据（O(N)）的情况下，能够随机选取出m个不重复的数据。
     *
     * 算法的精妙之处在于：当处理完所有的数据时，蓄水池中的每个数据都是以m/N的概率获得的。
     */
    int[] reservoir = new int[m];

    // init
    for (int i = 0; i < m; i++) {
        reservoir[i] = dataStream[i];
    }

    for (int i = m; i < dataStream.length; i++) {
        int d = Math.rand.nextInt(i+1); // 随机获得一个[0, i]内的随机整数
        // 如果随机整数落在[0, m-1]范围内，则替换蓄水池中的元素
        if (d < m) {
            reservoir[d] = dataStream[i];
        }
    }

    /*
     * 分布式的蓄水池抽样问题
     consider a distributed environment such as Hadoop where the input stream consists of several sub-streams
     and each sub-stream is feed to a single work.  How can we extend the simple algorithm to efficiently
     sample all sub-streams in parallel and still generate k uniform samples from the entire input stream
     in the end?

     Without loss of generality, let us assume there are two sub-streams of size m and n, respectively.
     Both m and n are far greater than k. In the first step of the algorithm, workers work on their own
     sub-streams in parallel, using the basic algorithm. When both workers finish their sub-stream traversal,
     two reservoir lists R and S are generated. In addition, both workers also count the number of items in
     their own sub-streams during the traversal, and thus m and n are known when R and S are available.

     The critical step is to combine the two reservoir lists to get k items out of them. To do this, we assign
     weights to items according to the sizes of the sub-stream where they were sampled in the first step, and
     then do a second sampling phase. We run k iterations for this secondary sampling. In each iteration, we
     flip a random coin such that, with probability p = m/(m+n), we pick one random sample from reservoir list
     R, and with probability 1-p, we pick one random sample from reservoir list S. At the end of the k-th
     iteration, we will get the final reservoir list for the entire stream. This algorithm is described as follows:

     for(sub-stream s: sub-streams) do in parallel {
       simple sequential reservoir sampling and count length of s;
     }
     double p = (double) m / (m+n);
     for(int i = 0; i < k; ++i){
       j = rand.nextDouble();
       if(j <= p)
         move a random item from R to T;
       else
         move a random item from S to T;
     }
     return T;
     */
}