package net.fengyu.worktime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日历概念，时间轴概念
 *
 */

public class WorkTime {


    //工作时间
    public static final int WORKINGHOUR = 1;
    //非工作时间
    public static final int NONWORKINGHOUR = 0;

    //每天早上9点开始上班
    public static final int workStartHour = 9;

    //每天19点下班
    public static final int workEndHour = 19;


    private static Calendar calBegin = Calendar.getInstance();

    static {
        calBegin.set(2019, 1, 1, 0, 0, 0);
        calBegin.set(Calendar.MILLISECOND, 0);//毫秒数设置为0
    }

    //public static final int
    //public static final int


    //按照小时连续排列的数组，从2019年1月1日开始，以小时为单位。时间轴长度5年
    //瓜子内部工作日历，周日不休，只有春节休息
    private List<Integer> timeLine1 = new ArrayList<Integer>(365*24*5);

    //法定工作日历，落档等业务需要车管所时间。按照法定工作日走。
    private List<Integer> timeLine2 = new ArrayList<Integer>(365*24*5);


    public Calendar getExpectedTime(Calendar start, int interval, TimeUnit unit) {

        //检查start时间区间，越界抛出异常

        //保存时间精度
        int minute = start.get(Calendar.MINUTE);
        int second = start.get(Calendar.SECOND);

        if(unit.equals(TimeUnit.WORKHOUR)) {
//            start.get(Calendar)
        }

        return null;
    }

    public void initTimeLine1() {

        // TODO 需要刨除春节
        for(int i=0;i<timeLine1.size();i++) {

            if(calBegin.get(Calendar.HOUR_OF_DAY)>=workStartHour && calBegin.get(Calendar.HOUR_OF_DAY)<=workEndHour) {
                timeLine1.set(i,WORKINGHOUR);
            } else {
                timeLine1.set(i,NONWORKINGHOUR);
            }
        }
    }


    public void initTimeLine2() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, 1, 1, 0, 0, 0);
//        calendar.set(Calendar.MILLISECOND, 0);//毫秒数设置为0

        int week = 0;

        for(int i=0;i<timeLine2.size();i++) {

            //1--7的值,对应：星期日，星期一，星期二，星期三....星期六
            week = calBegin.get(Calendar.DAY_OF_WEEK);

            // TODO 根据具体业务需要初始化日历
            if(week == 1 || week == 7) {//周末，如果有法定假日也要算上。
                timeLine2.set(i,NONWORKINGHOUR);
            } else {//工作日
                if(calBegin.get(Calendar.HOUR_OF_DAY)>=workStartHour && calBegin.get(Calendar.HOUR_OF_DAY)<=workEndHour) {
                    timeLine2.set(i,WORKINGHOUR);
                } else {
                    timeLine2.set(i,NONWORKINGHOUR);
                }
            }

        }
    }

    public int calculateWorkHours(Date start,Date end) {

        long disStart = start.getTime() - calBegin.getTime().getTime();
//        long disEnd = end.getTime() - calBegin.getTime().getTime();

        long index = disStart/(1000*60*60);

        System.out.println(disStart);

//        Calendar calStart = Calendar.getInstance();
//        calStart.setTime(start);
//
//        Calendar calEnd = Calendar.getInstance();
//        calEnd.setTime(end);

        return 0;
    }


    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        //System.out.println(calendar);
//
//        calendar = Calendar.getInstance();
//        calendar.set(2019, 1, 1, 0, 0, 0);
//        calendar.set(Calendar.MILLISECOND, 0);//毫秒数设置为0
//        String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
//        System.out.println(str);

        Calendar start = Calendar.getInstance();


        start.set(2019, 1, 1, 0, 0, 1);
        start.set(Calendar.MILLISECOND, 0);

        WorkTime workTime = new WorkTime();
        workTime.initTimeLine1();
        workTime.initTimeLine2();

        workTime.calculateWorkHours(start.getTime(),null);
    }

    public static enum TimeUnit {
        WORKDAY(1,"工作日"),
        WORKHOUR(2,"工作小时"),
        DAY(3,"自然日"),
        HOUR(4,"自然小时");

        TimeUnit(int id,String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        int id;
        String name;


    }

}
