package cn.yzstu.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/17
 * \* Time: 20:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DateUtil {
    public final static String DATE_A = "yyyy-MM-dd";
    public final static String DATE_B = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_C = "yyyyMMddHHmmss";
    public final static String DATE_D = "yyyyMMdd-HHmmss-SS";
    public final static String DATE_E = "M月d日";
    public final static String DATE_F = "MM-dd";
    public final static String DATE_G = "yyyyMMddHHmmss";

    public static Date parseDateString(String dateStr, String formatStr) {
        if (dateStr == null || dateStr.trim().length() == 0) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(formatStr);
        try {
            return df.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatDate(Date date, String formatStr) {
        DateFormat df = new SimpleDateFormat(formatStr);
        try {
            return df.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    // 普通的当前时间转字符串方法，格式为yyyy-MM-dd
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_A);
        return sdf.format(new Date());
    }

    /**
     * 获取当前月，结果格式如：2018-06
     *
     * @return
     */
    public static String getDateMonth() {
        String date = getDate();
        return date.substring(0, 7);
    }

    /**
     * 获取格式为yyyyMMddHHmmss的当前时间
     */
    public static String getDateTimeG() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_G);
        return sdf.format(new Date());
    }

    public static String getDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_A);
        return sdf.format(date);
    }

    /**
     * 将 yyyyMMddHHmmss转为yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTime(String date) {
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sfstr = "";
        try {
            sfstr = sf2.format(sf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sfstr;
    }

    /**
     * 将 yyyymmdd转为yyyy-MM-dd
     */
    public static String getDate(String date) {

        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        String sfstr = "";
        try {
            sfstr = sf2.format(sf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sfstr;
    }

    /**
     * 将 yyyymm转为yyyy-MM
     */
    public static String getDates(String date) {

        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM");
        String sfstr = "";
        try {
            sfstr = sf2.format(sf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sfstr;
    }


    /**
     * 按照指定格式    返回给定时间当前月的第一天
     *
     * @param date
     * @param formatStr
     */
    public static String getFirstDayInMonth(Date date, String formatStr) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 获取某个月的第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date mDate = calendar.getTime();

        return formatDate(mDate, formatStr);
    }

    /**
     * 按照指定格式    返回给定时间当前月的最後一天
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String getLastDayInMonth(Date date, String formatStr) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 获取某月的最后一天
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        Date mDate = calendar.getTime();

        return formatDate(mDate, formatStr);
    }

    /**
     * 返回给定时间当前月的第一天
     * 格式：yy-mm-dd hh:mm:ss
     *
     * @param date
     */
    public static Date getFirstDayInMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 获取某个月的第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 返回当前月的第一天
     * 格式：yy-mm-dd
     */
    public static String getFirstDayInMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        return first;
    }

    /**
     * 返回给定时间当前月的最后一天
     * 格式：yy-mm-dd hh:mm:ss
     *
     * @param date
     * @return
     */
    public static Date getLastDayInMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 获取某月的最后一天
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 获取每月的各个周的起止时间,不包含时、分、秒、毫秒
     *
     * @param date
     * @return
     */
    public static Map<Integer, Date> getWeekInMonth(Date date) {
        Map<Integer, Date> weeksMap = new HashMap<Integer, Date>();
        // 获取当前月的第一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // 去除时、分、秒、毫秒
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 获取当前月第一天为星期几
        int weekPos = calendar.get(Calendar.DAY_OF_WEEK);

        // 获取一个月的实际天数
        int daysNum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 对这个进行判断
        switch (weekPos) {
            case Calendar.SUNDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 7);
                break;
            }
            case Calendar.MONDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 1);
                break;
            }
            case Calendar.TUESDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 2);
                break;
            }
            case Calendar.WEDNESDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 3);
                break;
            }
            case Calendar.THURSDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 4);
                break;
            }
            case Calendar.FRIDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 5);
                break;
            }
            case Calendar.SATURDAY: {
                getFirstLastDayInWeek(weeksMap, calendar, daysNum, 6);
                break;
            }
        }

        return weeksMap;
    }

    /**
     * 获取一个月中各个周的第一天和最后一天
     *
     * @param weeksMap
     * @param calendar
     * @param daysNum
     * @param tagNum
     */
    private static void getFirstLastDayInWeek(Map<Integer, Date> weeksMap, Calendar calendar, int daysNum, int tagNum) {
        // 添加循环计数器
        int count = (int) Math.ceil(((double) (daysNum + tagNum - 1)) / 7);
        // 将calendar往后推1天，作为循环起始时间
        calendar.add(Calendar.DATE, -tagNum);
        for (int i = 1; i <= count; i++) {
            // 起始时间往前推一天
            calendar.add(Calendar.DATE, 1);
            // 放入某一周的第一天
            weeksMap.put(2 * i - 1, calendar.getTime());

            // 起始时间往前推六天
            calendar.add(Calendar.DATE, 6);
            // 放入某一周的最后一天
            weeksMap.put(2 * i, calendar.getTime());
        }
    }

    /**
     * 当前时间提前一天，年月日
     *
     * @param date
     * @return
     */
    public static Date getDayOfBefore(Date date) {
        Calendar result = Calendar.getInstance();
        result.setTime(date);
        result.set(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE) - 1, 0, 0, 0);
        return result.getTime();
    }

    /**
     * 当前时间提前一天，年月日
     *
     * @param date
     * @return
     */
    public static Date getDayOfBefore(Date date, int days) {
        Calendar result = Calendar.getInstance();
        result.setTime(date);
        result.set(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE) - days, 0, 0, 0);
        return result.getTime();
    }

    public static Date getDayOfAfter(Date date, int days) {
        Calendar result = Calendar.getInstance();
        result.setTime(date);
        result.set(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE) + days, 0, 0, 0);
        return result.getTime();
    }

    /***
     * 获取指定date时间 -n天的日期
     */
    public static String getDayOfNum(Date date, int n) {
        String s = null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - n);
        date = c.getTime();
        s = DateUtil.formatDate(date, DATE_A);
        return s;
    }

    /***
     * 获取指定date时间 -n天的日期
     */
    public static String getDayOfNum(String dateStr, int n) {
        Date date = parseDateString(dateStr, DATE_A);
        String s = null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - n);
        date = c.getTime();
        s = DateUtil.formatDate(date, DATE_A);
        return s;
    }

    /**
     * 获取当前时间 所在月份的天数
     */
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.getActualMaximum(Calendar.DATE);
        return day;
    }

    public static List<Date> getIntervalDate(Date beginDate, Date endDate) {
        long dayTime = 24 * 3600 * 1000;
        long startTime = beginDate.getTime();
        long endTime = endDate.getTime();
        List<Date> list = new ArrayList<Date>();
        Date d;
        while (startTime <= endTime) {
            d = new Date(startTime);
            list.add(d);
            startTime = startTime + dayTime;
        }
        return list;
    }

    private static int getMondayPlus(Date currentTime) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(currentTime);
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 0) {
            return -6;
        }
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    /**
     * 获取相应周 周一日期
     */
    public static String getMondayOFWeek(Date currentTime, String parten) {
        int mondayPlus = getMondayPlus(currentTime);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(currentTime);
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        return formatDate(monday, parten);
    }

    /**
     * 获取相应周 周日 的日期
     */
    public static String getCurrentWeekday(Date currentTime, String parten) {
        int mondayPlus = getMondayPlus(currentTime);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(currentTime);
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
        return formatDate(monday, parten);
    }

    public static Calendar getCalendar(Date currTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    // date类型转换为String类型
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    // long类型转换为String类型
    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType) {
        String strTime;
        try {
            Date date = longToDate(currentTime, formatType); // long类型转成Date类型
            strTime = dateToString(date, formatType);
            return strTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // long转换为Date类型
    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType) throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    // string类型转换为long类型
    // strTime要转换的String类型的时间
    // formatType时间格式
    // strTime的时间格式和formatType的时间格式必须相同
    public static long stringToLong(String strTime, String formatType) throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    // date类型转换为long类型
    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static Map<String, Long> dateDiff(String startTime, String endTime, String format) {
        Map<String, Long> map = new HashMap<String, Long>();
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        try {
            // 获得两个时间的毫秒时间差异
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            long day = diff / nd;// 计算差多少天
            long hour = diff % nd / nh;// 计算差多少小时
            long min = diff % nd % nh / nm;// 计算差多少分钟
            long sec = diff % nd % nh % nm / ns;// 计算差多少秒//输出结果
            map.put("day", day);
            map.put("hour", hour);
            map.put("min", min);
            map.put("sec", sec);
            // System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getTime() {
        String ret;
        String datestr;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_B);
        datestr = sdf.format(new Date());
        ret = datestr.substring(11, datestr.length());
        return ret;
    }

    // 自动检测字符串形式然后转换
    public static Date strToDate(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = null;
        if (dateStr == null || dateStr.equals("")) {
            throw new RuntimeException("DateUtil.strToDate():" + dateStr);
        } else if (dateStr.indexOf(":") > 0) {
            sdf = new SimpleDateFormat(DATE_B);
        } else if (dateStr.indexOf("-") > 0) {
            sdf = new SimpleDateFormat(DATE_A);
        } else if (dateStr.length() == 14) {
            sdf = new SimpleDateFormat(DATE_G);
        }
        try {
            if (sdf != null) {
                date = sdf.parse(dateStr);
            }
        } catch (Exception e) {
            throw new RuntimeException("DateUtil.strToDate():" + dateStr);
        }
        return date;
    }

    /**
     * 根据两个时间计算时间差 返回时间的单位：秒； 传入时间格式：16:20:24
     *
     * @param time1 现在的时间
     * @param time2 过去的时间
     * @return timeusage 时间差
     */
    public static int getUsageOfTime(String time1, String time2) {
        String[] timeNow = new String[3];
        String[] timeOld = new String[3];
        timeNow = time1.split(":");
        timeOld = time2.split(":");
        int h = 0;
        int m = 0;
        int s = 0;

        if (!timeNow[0].equals(timeOld[0])) {
            h = Integer.valueOf(timeNow[0]) - Integer.valueOf(timeOld[0]);
        }
        if (!timeNow[1].equals(timeOld[1])) {
            m = Integer.valueOf(timeNow[1]) - Integer.valueOf(timeOld[1]);
        }
        if (!timeNow[2].equals(timeOld[2])) {
            s = Integer.valueOf(timeNow[2]) - Integer.valueOf(timeOld[2]);
        }
        int timeusage = h * 3600 + m * 60 + s;
        return timeusage;

    }

    public static String getTime(java.util.Date date) {
        String ret;
        String datestr;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_B);
        datestr = sdf.format(date);
        ret = datestr.substring(11, datestr.length());
        return ret;
    }

    /**
     * 判断当前日期是否在指定的时间段内
     *
     * @param beginDateStr：开始日期
     * @param endDateStr：结束日期
     * @return
     */
    public static boolean isInDate(String beginDateStr, String endDateStr) {
        boolean ret = false;
        Date curDate = strToDate(getDate());
        Date beginDate = strToDate(beginDateStr);
        Date endDate = strToDate(endDateStr);
        if (curDate.compareTo(beginDate) >= 0 && curDate.compareTo(endDate) <= 0) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    /**
     * 判定当前时间是否在beginTime~endTime之间
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean isInTime(String beginTime, String endTime) {
        boolean ret = false;
        String curTime = getTime();
        if (curTime.compareTo(beginTime) >= 0 && curTime.compareTo(endTime) <= 0) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    /**
     * 计算出beginTime~endTime之间相隔的天数
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static int dateDiffer(String beginTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是
        java.util.Date date1 = sdf.parse(beginTime);
        java.util.Date date2 = sdf.parse(endTime);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) //闰年
                {
                    timeDistance += 366;
                } else //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else //不同年
        {
            return day2 - day1;
        }
    }

    /**
     * 判定curTime是否在beginTime~endTime之间
     *
     * @param curTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean isInTime(String curTime, String beginTime, String endTime) {
        boolean ret = false;
        if (curTime.compareTo(beginTime) >= 0 && curTime.compareTo(endTime) <= 0) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    /**
     * 获取当月第一天
     *
     * @return
     */
    public static String getBeginDate() {// 当月第一天
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);// 当月第一天
        String dateStart = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return dateStart;
    }

    /**
     * 获取当月最后一天
     *
     * @return
     */
    public static String getEndDate() {// 当月最后 一天
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        Date date = cal.getTime();
        String dateEnd = new SimpleDateFormat("yyyy-MM-dd").format(date);// 当月最后一天
        return dateEnd;
    }

    /**
     * 获取当前时间的前一天
     *
     * @return
     */
    public static String getBeforeDate() {
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(dBefore);// 把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_A); // 设置时间格式
        dBefore = calendar.getTime(); // 得到前一天的时间
        String BeforeDate = sdf.format(dBefore); // 格式化前一天
        return BeforeDate;
    }

    public static String getDateTime() {
        Date date = new Date();
        String datestr;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_B);
        datestr = sdf.format(date);
        return datestr;
    }

    /**
     * 获取此刻在seconds秒之前的时间
     *
     * @param seconds
     * @return
     */
    public static String getBeforeTime(int seconds) {
        //设定秒内只能请求一次
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.SECOND, calendar1.get(Calendar.SECOND) - seconds);
        return df.format(calendar1.getTime());
    }

    /**
     * 获取time这个时间所在的时间区间
     *
     * @param time
     * @return
     */
    public static String getTimeStrFromTime(String time) {
        ArrayList<String> timeStrList = getTimeStrList();

        for (String timeStr : timeStrList) {
            String[] times = timeStr.split("~");
            String beginTime = times[0];
            String endTime = times[1];
            if (DateUtil.isInTime(time, beginTime, endTime))
                return timeStr;
        }

        return null;
    }


    /**
     * 获取一个list-String的时间段字符串，两小时一个阶段的
     *
     * @return
     */
    public static ArrayList<String> getTimeStrList() {
        ArrayList<String> timeStrList = new ArrayList<>();
        timeStrList.add("00:00:00~02:00:00");
        timeStrList.add("02:00:00~04:00:00");
        timeStrList.add("04:00:00~06:00:00");
        timeStrList.add("06:00:00~08:00:00");
        timeStrList.add("08:00:00~10:00:00");
        timeStrList.add("10:00:00~12:00:00");
        timeStrList.add("12:00:00~14:00:00");
        timeStrList.add("14:00:00~16:00:00");
        timeStrList.add("16:00:00~18:00:00");
        timeStrList.add("18:00:00~20:00:00");
        timeStrList.add("20:00:00~22:00:00");
        timeStrList.add("22:00:00~23:59:59");
        return timeStrList;
    }

    /**
     * 看time处于哪一个时段，每半小时一个时段
     *
     * @param time
     * @return
     */
    public static String getTimeStrFromTimeHalf(String time) {
        ArrayList<String> timeStrList = getTimeStrListHalf();

        for (String timeStr : timeStrList) {
            String[] times = timeStr.split("~");
            String beginTime = times[0];
            String endTime = times[1];
            if (DateUtil.isInTime(time, beginTime, endTime))
                return timeStr;
        }

        return null;
    }

    public static ArrayList<String> getTimeStrListHalf() {
        ArrayList<String> timeStrList = new ArrayList<>();
        timeStrList.add("00:00:00~00:30:00");
        timeStrList.add("00:30:00~01:00:00");
        timeStrList.add("01:00:00~01:30:00");
        timeStrList.add("01:30:00~02:00:00");

        timeStrList.add("02:00:00~02:30:00");
        timeStrList.add("02:30:00~03:00:00");
        timeStrList.add("03:00:00~03:30:00");
        timeStrList.add("03:30:00~04:00:00");

        timeStrList.add("04:00:00~04:30:00");
        timeStrList.add("04:30:00~05:00:00");
        timeStrList.add("05:00:00~05:30:00");
        timeStrList.add("05:30:00~06:00:00");

        timeStrList.add("06:00:00~06:30:00");
        timeStrList.add("06:30:00~07:00:00");
        timeStrList.add("07:00:00~07:30:00");
        timeStrList.add("07:30:00~08:00:00");

        timeStrList.add("08:00:00~08:30:00");
        timeStrList.add("08:30:00~09:00:00");
        timeStrList.add("09:00:00~09:30:00");
        timeStrList.add("09:30:00~10:00:00");

        timeStrList.add("10:00:00~10:30:00");
        timeStrList.add("10:30:00~11:00:00");
        timeStrList.add("11:00:00~11:30:00");
        timeStrList.add("11:30:00~12:00:00");

        timeStrList.add("12:00:00~12:30:00");
        timeStrList.add("12:30:00~13:00:00");
        timeStrList.add("13:00:00~13:30:00");
        timeStrList.add("13:30:00~14:00:00");

        timeStrList.add("14:00:00~14:30:00");
        timeStrList.add("14:30:00~15:00:00");
        timeStrList.add("15:00:00~15:30:00");
        timeStrList.add("15:30:00~16:00:00");

        timeStrList.add("16:00:00~16:30:00");
        timeStrList.add("16:30:00~17:00:00");
        timeStrList.add("17:00:00~17:30:00");
        timeStrList.add("17:30:00~18:00:00");

        timeStrList.add("18:00:00~18:30:00");
        timeStrList.add("18:30:00~19:00:00");
        timeStrList.add("19:00:00~19:30:00");
        timeStrList.add("19:30:00~20:00:00");

        timeStrList.add("20:00:00~20:30:00");
        timeStrList.add("20:30:00~21:00:00");
        timeStrList.add("21:00:00~21:30:00");
        timeStrList.add("21:30:00~22:00:00");

        timeStrList.add("22:00:00~22:30:00");
        timeStrList.add("22:30:00~23:00:00");
        timeStrList.add("23:00:00~23:30:00");
        timeStrList.add("23:30:00~23:59:59");

        return timeStrList;
    }

    /**
     * 计算bDateStr到eDateStr一共有多少天（注意：包含最后一天）,格式都是{@link #DATE_A}：yyyy-MM-dd,
     *
     * @param bDateStr
     * @param eDateStr
     * @return
     */
    public static int getDaysNumBtwDate(String bDateStr, String eDateStr) {
        Date bDate = parseDateString(bDateStr, DATE_A);
        Date eDate = parseDateString(eDateStr, DATE_A);
        Calendar cal = Calendar.getInstance();
        cal.setTime(bDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(eDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        Integer btwDays = Integer.valueOf(String.valueOf(between_days));
        return btwDays + 1;
    }

    /**
     * 获取两个时间间隔多少小时
     *
     * @param bTimeStr
     * @param eTimeStr
     * @return
     */
    public static long getHoursNumBtwTime(String bTimeStr, String eTimeStr) {
        Date bDate = parseDateString(bTimeStr, DATE_B);
        Date eDate = parseDateString(eTimeStr, DATE_B);
        Calendar cal = Calendar.getInstance();
        cal.setTime(bDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(eDate);
        long time2 = cal.getTimeInMillis();
        long betweenHours = (time2 - time1) / (1000 * 3600);
        return betweenHours;
    }


    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取当前日期，特别注意只获取日期不获取年月
     *
     * @return
     */
    public static int getday() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.DATE);
        return month;
    }

    /**
     * 获取当前日期和星期，格式：1999年09月09日,星期一
     */
    public static String getDateWeek() {
        String week = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        String dateStr = sdf.format(new Date());
        String dateWeek = "";

        Calendar calendar = Calendar.getInstance();

        // 获取当前月第一天为星期几
        int weekPos = calendar.get(Calendar.DAY_OF_WEEK);
        // 对这个进行判断
        switch (weekPos) {
            case Calendar.SUNDAY: {
                week = "星期日";
                break;
            }
            case Calendar.MONDAY: {
                week = "星期一";
                break;
            }
            case Calendar.TUESDAY: {
                week = "星期二";
                break;
            }
            case Calendar.WEDNESDAY: {
                week = "星期三";
                break;
            }
            case Calendar.THURSDAY: {
                week = "星期四";
                break;
            }
            case Calendar.FRIDAY: {
                week = "星期五";
                break;
            }
            case Calendar.SATURDAY: {
                week = "星期六";
                break;
            }
        }
        dateWeek = dateStr + "," + week;
        return dateWeek;
    }

    /**
     * 从现在到23点59分59秒还有多少milliseconds
     *
     * @return
     */
    public static long nowToDayFinish() {
        long time = 0;

        try {
            String nowTimeStr = DateUtil.getDateTime();
            long nowTime = DateUtil.stringToLong(nowTimeStr, DATE_B);

            String endTimeStr = DateUtil.getDate() + " 23:59:59";
            long endTime = DateUtil.stringToLong(endTimeStr, DATE_B);

            time = endTime - nowTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }

    /**
     * 从现在到月底还有多少milliseconds
     *
     * @return
     */
    public static long nowToMonthFinish() {
        long time = 0;

        try {
            String nowTimeStr = DateUtil.getDateTime();
            long nowTime = DateUtil.stringToLong(nowTimeStr, DATE_B);

            String endTimeStr = DateUtil.getLastDayInMonth(new Date(), DATE_A) + " 23:59:59";
            long endTime = DateUtil.stringToLong(endTimeStr, DATE_B);

            time = endTime - nowTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }

    /**
     * 传入时段最后时间即可如：20:30:00；<br>
     * 从现在到endTimeStr还有多少milliseconds
     *
     * @param endTimeStr
     * @return
     */
    public static long nowToEndTime(String endTimeStr) {
        long time = 0;

        try {
            String nowTimeStr = DateUtil.getDateTime();
            long nowTime = DateUtil.stringToLong(nowTimeStr, DATE_B);

            endTimeStr = DateUtil.getDate() + " " + endTimeStr;
            long endTime = DateUtil.stringToLong(endTimeStr, DATE_B);

            time = endTime - nowTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }

    /**
     * 时间戳格式化，传入时间戳timeStamp：例如1520987031361<br>
     *
     * @param timeStamp
     * @return
     */
    public static String timeStampFormat(long timeStamp) {
        String date = getDate();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_B);

            Date temp = new Date(timeStamp);

            date = formatter.format(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static void main(String[] args) {
        String timeStr = getDateMonth();
        System.out.println(timeStampFormat(1520991200500l));
    }


    /**
     * 获取指定某天的前一天或者后一天
     * Jason
     */
    public static String getLastDay(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        //                      此处修改为+1则是获取后一天，-1是获取前一天
        calendar.set(Calendar.DATE, day + 1);

        String lastDay = sdf.format(calendar.getTime());
        return lastDay;
    }
}