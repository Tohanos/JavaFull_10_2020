package lesson3;

import java.util.List;

public class IoHistoryServiceImpl implements HistoryService {

    /**
     * HomeWork
     * */

    @Override
    public List<String> getHistory() {
        return null;
    }

    @Override
    public List<String> getHistory(int limit) {
        // available + skip
        // RandomAccessFile
//        try {
//            RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
//            FileChannel channel = raf.getChannel();
//            ByteBuffer buf = ByteBuffer.allocate(100);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public void saveHistory(List<String> history) {

    }
}
