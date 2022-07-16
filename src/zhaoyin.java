import javafx.scene.effect.Bloom;

import java.io.*;
import java.util.*;

public class zhaoyin {
    static File file = new File("F:" + File.separator + "dawenjian" + File.separator + "data.txt");
    static File file1 = new File("F:" + File.separator + "dawenjian" + File.separator + "dataSorted.txt");
    static List<Integer> list = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        createData();
        System.out.println("大文件写入成功");
        separateFile();
        System.out.println("文件拆分成功");
        everySingleFileRead();
        System.out.println("==============================");
        //这里将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //升序排序
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

        //System.out.println(map.toString());
//        everySingleFileSort();
//        list.forEach(a-> System.out.println(a));
    }

    private static void everySingleFileRead() throws IOException {
        for (int i = 0; i < 100; i++) {
            FileReader fr = new FileReader("F:"+File.separator+"dawenjian"+File.separator+"data"+i+".txt");
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()){
                yonghu yh = new yonghu();
                String read = br.readLine();
                String[] s = read.split(" ");
                yh.setName(s[0]);
                yh.setTel(Integer.parseInt(s[1]));
                yh.setMoney(Integer.parseInt(s[2]));
                createHashMap(yh);
                System.out.println(yh);
            }
        }
    }

    private static void createHashMap(yonghu yh) {
        map.put(yh.getName(),yh.getMoney());
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
        String[] Surname= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许",

                "何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",

                "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷",

                "罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和",

                "穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒",

                "屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟",

                "徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应",

                "宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀",

                "羊","于","惠","甄","曲","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山",

                "谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","钭","厉","戎","祖","武","符","刘","景",

                "詹","束","龙","叶","幸","司","韶","郜","黎","蓟","溥","印","宿","白","怀","蒲","邰","从","鄂","索","咸","籍","赖","卓","蔺","屠",

                "蒙","池","乔","阴","郁","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","却",

                "璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习",

                "宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄",

                "阙","东","欧","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空",

                "曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红","游","郏","竺","权","逯","盖","益","桓","公","仉",

                "督","岳","帅","缑","亢","况","郈","有","琴","归","海","晋","楚","闫","法","汝","鄢","涂","钦","商","牟","佘","佴","伯","赏","墨",

                "哈","谯","篁","年","爱","阳","佟","言","福","南","火","铁","迟","漆","官","冼","真","展","繁","檀","祭","密","敬","揭","舜","楼",

                "疏","冒","浑","挚","胶","随","高","皋","原","种","练","弥","仓","眭","蹇","覃","阿","门","恽","来","綦","召","仪","风","介","巨",

                "木","京","狐","郇","虎","枚","抗","达","杞","苌","折","麦","庆","过","竹","端","鲜","皇","亓","老","是","秘","畅","邝","还","宾",

                "闾","辜","纵","侴","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","羊舌","尉迟","公羊","澹台","公冶","宗正",

                "濮阳","淳于","单于","太叔","申屠","公孙","仲孙","轩辕","令狐","钟离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","兀官","司寇",

                "南门","呼延","子车","颛孙","端木","巫马","公西","漆雕","车正","壤驷","公良","拓跋","夹谷","宰父","谷梁","段干","百里","东郭","微生",

                "梁丘","左丘","东门","西门","南宫","第五","公仪","公乘","太史","仲长","叔孙","屈突","尔朱","东乡","相里","胡母","司城","张廖","雍门",

                "毋丘","贺兰","綦毋","屋庐","独孤","南郭","北宫","王孙"};
        Random random1 = new Random(System.currentTimeMillis());
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int index=random1.nextInt(Surname.length-1);
            String str = Surname[index]; //获得一个随机的姓氏
            bw.write(str+"用户"+" "+random.nextInt(Integer.MAX_VALUE)+" "+(int)((Math.random()*9+1)*1000000)+"\r\n");
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

        for (int i = 0; i < 100; i++) {
            fw = new FileWriter("F:"+File.separator+"dawenjian"+File.separator+"data"+i+".txt");
            bw = new BufferedWriter(fw);
            fwList.put(i,fw);
            bwList.put(i,bw);
        }

        while (br.ready()){//判断此流是否已准备好被读取。如果缓冲区不为空，或者基础字符流已准备就绪，则缓冲的字符流准备就绪。
            String readStr = br.readLine();
            count++;
            int a = Math.abs(readStr.hashCode()%100);
            //System.out.println("readNumber:"+readStr+"   count:"+count+"   a:"+a);
            BufferedWriter bufferedWriter =  bwList.get(a);
            bufferedWriter.write(readStr+"\r\n");
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

    //testget();
}


