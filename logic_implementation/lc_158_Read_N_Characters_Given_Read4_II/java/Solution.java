public class Solution extends Reader4 {

    char[] _buf = new char[4];
    int dataInBuffer = 0;
    int buffStartPosition = 0;
    boolean eof = false;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int totalRead = 0;
        do {
            readData();
            totalRead += copyData(buf, totalRead, n);
        } while (totalRead < n && !eof);
        return totalRead;
    }
    void readData() {
        if (dataInBuffer == 0) {
            dataInBuffer = read4(_buf);
            buffStartPosition = 0;
            eof = (dataInBuffer < 4);
        }
    }
    int copyData(char[] buf, int totalRead, int n) {
        int cnt = Math.min(n - totalRead, dataInBuffer);
        System.arraycopy(_buf, buffStartPosition, buf, totalRead, cnt);

        buffStartPosition += cnt;
        dataInBuffer -= cnt;
        return cnt;
    }
}

class Reader4 {
    public int read4(char[] buf) {
        return 0; // fake implementation
    }
}