import java.io.*;
import java.util.*;

public class DaWenJian {
    static File file = new File("F:"+File.separator+"dawenjian"+File.separator+"data.txt");
    static File file1 = new File("F:"+File.separator+"dawenjian"+File.separator+"dataSorted.txt");
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        createData();
        System.out.println("大文件写入成功");
        separateFile();
        System.out.println("文件拆分成功");
        everySingleFileSort();
        list.forEach(a-> System.out.println(a));
    }

    //将每个小文件进行排序
    private static void everySingleFileSort() throws IOException {
        for (int i = 0; i < 20; i++) {
            LinkedList numbers = new LinkedList<>();
            String path = "F:"+File.separator+"dawenjian"+File.separator+"data"+i+".txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()){
                numbers.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(numbers);
            numbersWrite(numbers,path);
            br.close();
            fr.close();
        }
    }

    private static void numbersWrite(LinkedList numbers, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator iterator = numbers.iterator();
        while (iterator.hasNext()){
            int a = (Integer) iterator.next();
            bw.write(a+"\r\n");
            if(!iterator.hasNext()){
                list.add(a);
            }
        }
        bw.close();
        fw.close();
    }

    private static void createData() throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            bw.write(random.nextInt(Integer.MAX_VALUE)+"\r\n");
        }
        bw.close();
        fw.close();
    }

    private static void separateFile() throws IOException{
        int count = 0;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = null;
        BufferedWriter bw = null;
        HashMap<Integer,FileWriter> fwList = new HashMap();
        HashMap<Integer,BufferedWriter> bwList = new HashMap();

        for (int i = 0; i < 20; i++) {
            fw = new FileWriter("F:"+File.separator+"dawenjian"+File.separator+"data"+i+".txt");
            bw = new BufferedWriter(fw);
            fwList.put(i,fw);
            bwList.put(i,bw);
        }

        while (br.ready()){//判断此流是否已准备好被读取。如果缓冲区不为空，或者基础字符流已准备就绪，则缓冲的字符流准备就绪。
            Integer readNumber = Integer.valueOf(br.readLine());
            count++;
            System.out.println("readNumber:"+readNumber+"   count:"+count);
            int a = readNumber.hashCode()%20;
            BufferedWriter bufferedWriter =  bwList.get(a);
            bufferedWriter.write(readNumber+"\r\n");
        }

        for(Map.Entry<Integer,BufferedWriter> a : bwList.entrySet()){
            a.getValue().close();
        }
        for(Map.Entry<Integer,FileWriter> a : fwList.entrySet()){
            a.getValue().close();
        }
        br.close();
        fr.close();
    }


    //再将所有小文件整合到一个大文件中
//    public static void mergeFile() throws Exception {
//        PriorityQueue queue = new PriorityQueue(20, new Obj());
//        FileReader fr = null;
//        BufferedReader br = null;
//        FileWriter fw = new FileWriter(file1);
//        BufferedWriter bw = new BufferedWriter(fw);
//        List frList = new LinkedList();
//        List brList = new LinkedList();
//        int n;
//        for (int i = 0; i < 20; i++) {
//            String path = "F:" + File.separator + "dataTest" + File.separator + "data" + i + ".txt";
//            fr = new FileReader(path);
//            br = new BufferedReader(fr);
//            frList.add(fr);
//            brList.add(br);
//        }
//        //把每个小文件的第一个数读入队列中
//        for (int i = 0; i <= 20; i++) {
//            BufferedReader buffR;
//            if (i == 20) {
//                while (queue.size() != 0) {
//                    Obj obj = queue.poll();
//                    bw.write(obj.a + "\r\n");
//                    buffR = brList.get(obj.b);
//                    while (buffR.ready() && queue.size() < 20) {
//                        n = Integer.parseInt(buffR.readLine());
//                        queue.add(new Obj(n, obj.b));
//                    }
//                }
//                break;
//            }
//            buffR = brList.get(i);
//            while (buffR.ready() && queue.size() < 20) {
//                n = Integer.parseInt(buffR.readLine());
//                Obj obj = new Obj(n, i);
//                queue.add(obj);
//                break;
//            }
//        }
//        bw.close();
//        fw.close();
//        //遍历关闭所有子文件流
//        for (Iterator iterator = brList.iterator(); iterator.hasNext(); ) {
//            BufferedReader it = (BufferedReader) iterator.next();
//            it.close();
//        }
//
//        for (Iterator iterator = frList.iterator(); iterator.hasNext(); ) {
//            FileReader it = (FileReader) iterator.next();
//            it.close();
//        }
//    }
}


