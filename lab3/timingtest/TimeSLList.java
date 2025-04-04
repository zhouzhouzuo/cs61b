package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> ns = new AList<Integer>();
        for(int i=0;i<=7;++i){
            ns.addLast((int)Math.pow(2,i)*1000);
        }

        AList<Double> times = new AList<Double>();

        for(int i=0;i<=7;++i){
            int n = ns.get(i);
            SLList<Object> test = new SLList<>();
            for (int j = 0 ; j < n;j++){
                test.addLast(j);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0 ; j < 10000;j++){
                Object a = test.getLast();
            }
            times.addLast(sw.elapsedTime());
        }

        AList<Integer> op  = new AList<Integer>();
        for(int i=0;i<=7;++i){
            op.addLast(10000);
        }

        printTimingTable(ns,times,op);
    }

}
