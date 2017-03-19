/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.yishtech.erp.cms.biz.common;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期处理的工具类
 */
public class DateUtil {

    /**
     * 日期+时间的格式
     */
    final static public String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    final static public String DATE_TIME_SS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 日期的格式
     */
    final static public String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 小时:分的格式
     */
    final static public String HHMM_FORMAT = "HH:mm";

    final static public String HHMMSS_FORMAT = "HH:mm:ss";

    /**
     * 24小时, 日期+时间的格式
     */
    final static public String DATE_MIN_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 12小时, 日期+时间的格式
     */
    final static public String DATE_MIN_FORMAT_12 = "yyyy-MM-dd hh:mm";

    public static String getCurrentTimeMillis(long date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_SS_FORMAT);
        return dateFormat.format(date);
    }

    /**
     * 取得当前日期
     *
     * @return
     */
    public static String getCurDateTimeSSS() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_SS_FORMAT);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getCurDateTimeSSSInDefault() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_SS_FORMAT);
        return dateFormat.format(new Date());
    }

    /**
     * 取得当前日期
     *
     * @param dateFormater
     * @return
     */
    public static String getCurrentDate(String dateFormater) {
        DateFormat dateFormat = new SimpleDateFormat(dateFormater);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    /**
     * 取得当前日期
     *
     * @param dateFormater
     * @return
     */
    public static String getCurrentDate(String dateFormater, int days) {
        DateFormat dateFormat = new SimpleDateFormat(dateFormater);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, days);
        return dateFormat.format(cal.getTime());
    }

    /**
     * 将日期字符串解析成指定格式的Date对象
     *
     * @param dateTime 日期字符串
     * @param format   指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parse(String dateTime, String format) {
        try {
            if (dateTime == null || dateTime.length() <= 0)
                return null;
            String sDateTime = ((dateTime.indexOf('.') > 0)) ? dateTime.substring(0,
                    dateTime.indexOf('.')) : dateTime;

            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(sDateTime);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期字符串解析成"yyyy-MM-dd HH:mm:ss"格式的Date对象
     *
     * @param dateTime 日期字符串
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parseDateTime(String dateTime) throws ParseException {
        return parse(dateTime, DATE_TIME_FORMAT);
    }

    /**
     * 将日期类解析成指定格式的日期字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDateTime(Date date, String format) {
        if (date == null)
            return null;
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 将日期字符串解析成"yyyy-MM-dd"格式的Date对象
     *
     * @param dateTime 日期字符串
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parseDate(String dateTime) throws ParseException {
        return parse(dateTime, DATE_FORMAT);
    }

    /**
     * 将日期类解析成"HH:mm"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatHHmm(Date date) {
        return formatDateTime(date, HHMM_FORMAT);
    }

    /**
     * 将日期类解析成"HH:mm:ss"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatHHmmss(Date date) {
        return formatDateTime(date, HHMMSS_FORMAT);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatYYYYMMDD(Date date) {
        return formatDateTime(date, DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static boolean timeInTowTimes(String nowDate, String expectDate) throws ParseException {
        if (StringUtils.isBlank(expectDate)) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(nowDate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(expectDate));
        long time2 = cal.getTimeInMillis();
        return time1 > time2;
    }

    /**
     * 字符串的日期格式的计算
     */
    public static boolean timeInTowTimes(Date nowDate, Date expectDate) throws ParseException {
        if (expectDate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        nowDate = sdf.parse(sdf.format(nowDate));
        expectDate = sdf.parse(sdf.format(expectDate));

        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        long time1 = cal.getTimeInMillis();

        cal.setTime(expectDate);
        long time2 = cal.getTimeInMillis();

        return time1 > time2;
    }

    /**
     * 将日期类解析成"yyyy-MM"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatYYYYMM(Date date) {
        if (date == null)
            return null;

        return getYear(date) + "-" + getMonth(date);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd HH:mm:ss"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return formatDateTime(date, DATE_TIME_FORMAT);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd HH:mm:ss"格式的日期字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null)
            return null;
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 返回日期
     *
     * @param year  1900-...
     * @param month 0-11
     * @param day   1-31
     * @return
     * @throws RuntimeException
     */
    public static Date toDate(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);

        return cal.getTime();
    }

    /**
     * 返回四位年份
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getYear(Date date) {
        if (date == null)
            return -1;
        return date.getYear() + 1900;
    }

    /**
     * 返回月数(0-11)
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMonth(Date date) {
        if (date == null)
            return -1;
        return date.getMonth();
    }

    /**
     * 返回月几(1-31)
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMonthDay(Date date) {
        if (date == null)
            return -1;
        return date.getDate();
    }

    /**
     * 返回周几 returned value (<tt>7</tt> = Sunday, <tt>1</tt> = Monday, <tt>2</tt>
     * = Tuesday, <tt>3</tt> = Wednesday, <tt>4</tt> = Thursday, <tt>5</tt> =
     * Friday, <tt>6</tt> = Saturday)
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getChinaWeekDay(Date date) {
        if (date == null)
            return -1;
        int d = date.getDay();
        if (d == 0)
            d = 7;

        return d;
    }

    /**
     * 返回周几 returned value (<tt>0</tt> = Sunday, <tt>1</tt> = Monday, <tt>2</tt>
     * = Tuesday, <tt>3</tt> = Wednesday, <tt>4</tt> = Thursday, <tt>5</tt> =
     * Friday, <tt>6</tt> = Saturday)
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getWeekDay(Date date) {
        if (date == null)
            return -1;
        return date.getDay();
    }

    /**
     * 返回小时数(0-23)
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getHours(Date date) {
        if (date == null)
            return -1;
        return date.getHours();
    }

    /**
     * 返回分钟数（0-59）
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMinutes(Date date) {
        if (date == null)
            return -1;
        return date.getMinutes();
    }

    /**
     * 是否是今天
     *
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isToday(Date date) {
        if (date == null)
            return false;
        Date today = new Date();
        return date.getYear() == today.getYear() && date.getMonth() == today.getMonth() && date
                .getDate() == today.getDate();
    }

    /**
     * 是否是今天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static boolean isToday(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return false;

        return isToday(toDate(year, month, day));
    }

    /**
     * 是否在某个小时的区间[0,59)内。
     *
     * @param date
     * @param hour
     * @return
     */
    public static boolean isInHour(Date date, int hour) {
        if (date == null || hour < 0)
            return false;
        return getHours(date) == hour;
    }

    /**
     * 某年某月某天的下一天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getNextDay(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, 1);

        return cal.getTime();
    }

    /**
     * 某年某月某天的上一天 如果输入1900年1月1日，则返回1900年1月1日。
     *
     * @param year
     * @param month
     * @param day
     * @return
     * @throws RuntimeException
     */
    public static Date getPrevDay(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        // 如果当前日期为1900-1-1 前一天仍为当天
        if (year == 1900 && month == 0 && day == 1) {
            return toDate(1900, 0, 1);
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, -1);

        return cal.getTime();
    }

    public static Date getNextDaytime(Date date) {
        if (date == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 某年某月某天的下一天
     *
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        if (date == null)
            return null;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);

        return getNextDay(year, month, day);
    }

    /**
     * 获取指定日期的下一天,不改变时分秒
     *
     * @param date
     * @return
     */
    public static Date getNextDayII(Date date) {
        return getNextDayII(date, null);
    }

    public static Date getNextDayII(Date date, Calendar cal) {
        if (cal == null) {
            cal = GregorianCalendar.getInstance();
        }
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    /**
     * 某年某月某天的上一天 如果输入1900年1月1日，则返回1900年1月1日。
     *
     * @param date
     * @return
     */
    public static Date getPrevDay(Date date) {
        if (date == null)
            return null;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        if (year < 1900 || month < 0 || month > 11 || day < 1 || day > 31)
            return null;

        return getPrevDay(year, month, day);
    }

    /**
     * 某年某月某日的所在周的第一天(周一)。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_WEEK, 1 - getChinaWeekDay(toDate(year, month, day)));

        return cal.getTime();
    }

    /**
     * 某年某月某日的所在周的周末一天(周日)。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getEndDayOfWeek(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_WEEK, 7 - getChinaWeekDay(toDate(year, month, day)));

        return cal.getTime();
    }

    /**
     * 某年某月某日的所在周的下一周第一天(周一)。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getFirstDayOfNextWeek(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, 7);
        Date newDate = cal.getTime();

        return getFirstDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月某日的所在周的前一周第一天(周一)。 如果输入1900年1月1日，则返回1900年1月1日。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getFirstDayOfPrevWeek(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        // 如果当前日期为1900-1-1至1900-1-7中任意一天 上一周的第一天
        if (year == 1900 && month == 0 && day <= 7) {
            return toDate(year, month, 1);
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, -7);
        Date newDate = cal.getTime();

        return getFirstDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月某日的所在周的下一周周末一天(周日)。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getEndDayOfNextWeek(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, 7);
        Date newDate = cal.getTime();

        return getEndDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月某日的所在周的前一周周末一天(周日)。 如果输入1900年1月1日，则返回1900年1月1日。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getEndDayOfPrevWeek(int year, int month, int day) {
        if (!checkDay(year, month, day))
            return null;

        // 如果当前日期为1900-1-1至1900-1-7中任意一天 上一周的最后一天
        if (year == 1900 && month == 0 && day <= 7) {
            return toDate(year, month, 7);
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, -7);
        Date newDate = cal.getTime();
        return getEndDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        return toDate(year, month, 1);
    }

    /**
     * 某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getEndDayOfMonth(int year, int month) {
        return toDate(year, month, getMaxDays(year, month));
    }

    /**
     * 某年某月的下一个月的第一天。
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfNextMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11)
            return null;

        if (month == 11) {
            return getFirstDayOfMonth(year + 1, 0);
        }

        return getFirstDayOfMonth(year, month + 1);
    }

    /**
     * 某年某月的下一个月的最后一天。
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getEndDayOfNextMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11)
            return null;

        if (month == 11) {
            return getEndDayOfMonth(year + 1, 0);
        }

        return getEndDayOfMonth(year, month + 1);
    }

    /**
     * 获取此事件对应这个星期所在的第一天，星期一
     *
     * @param time
     * @return
     */
    public static Date getFirstDayOfWeek(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int t = c.get(Calendar.DAY_OF_WEEK);
        if (t == 1) {
            t = 7;
        } else {
            t--;
        }
        c.add(Calendar.DAY_OF_MONTH, -t + 1);
        return c.getTime();
    }

    /**
     * 获取周日所在时间
     *
     * @param time
     * @return
     */
    public static Date getEndDayOfWeek(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int t = c.get(Calendar.DAY_OF_WEEK);
        if (t == 1) {
            t = 7;
        } else {
            t--;
        }
        c.add(Calendar.DAY_OF_MONTH, 7 - t);
        return c.getTime();
    }

    /**
     * 某年某月的上一个月的第一天。 注意：如输入1900年1月，则返回1900年1月1日
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfPrevMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11)
            return null;

        if (year == 1900 && month == 0) {
            return getFirstDayOfMonth(year, month);
        }

        if (month == 0) {
            return getFirstDayOfMonth(year - 1, 11);
        }

        return getFirstDayOfMonth(year, month - 1);
    }

    /**
     * 某年某月的上一个月的最后一天。 注意：如输入1900年1月，则返回1900年1月31日
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getEndDayOfPrevMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11)
            return null;

        if (year == 1900 && month == 0) {
            return getEndDayOfMonth(year, month);
        }

        if (month == 0) {
            return getEndDayOfMonth(year - 1, 11);
        }

        return getEndDayOfMonth(year, month - 1);
    }

    /**
     * 某年某月的天数。
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMaxDays(int year, int month) {
        if (year < 1900 || month < 0 || month > 11)
            return 0;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, 1);

        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回某一天的零点的日期字符串
     *
     * @param date
     * @return
     */
    public static String toZeroDateTime(Date date) {
        return formatDateTime(date, DATE_FORMAT) + " 00:00:00";
    }

    /**
     * 返回某一天的零点的日期
     *
     * @param date
     * @return
     */
    public static Date toZeroDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 返回某一天最后时刻的日期字符串
     *
     * @param date
     * @return
     */
    public static String toLastDateTime(Date date) {
        return formatDateTime(date, DATE_FORMAT) + " 23:59:59";
    }

    /**
     * 返回某一天最后时刻的日期
     *
     * @param date
     * @return
     */
    public static Date toLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 返回某一天的年月日开始，以现在时刻结尾的日期
     *
     * @param date
     * @return
     */
    public static Date toNowDate(Date date) {
        return toDate(DateUtil.getYear(date), DateUtil.getMonth(date), DateUtil.getMonthDay(date));
    }

    /**
     * 比较日期：年月日。
     *
     * @param d0
     * @param d1
     * @return the value <code>0</code> if the argument d1 is equal to d0; a
     * value less than <code>0</code> if d0 is before d1 argument; and a
     * value greater than <code>0</code> if d0 is after d1 argument.
     * @throws NullPointerException if d0 or d1 is null.
     */
    public static int compareDay(Date d0, Date d1) {
        return d0.compareTo(d1);
    }

    /**
     * d0是否在[d1,d2]的日期区间中
     *
     * @param d0
     * @param d1
     * @param d2
     * @return
     * @throws NullPointerException if d0 or d1 or d2 is null.
     */
    public static boolean isInDayZone(Date d0, Date d1, Date d2) {
        return compareDay(d0, d1) >= 0 && compareDay(d1, d2) <= 0;
    }

    /**
     * 返回N个月之后（之前）的某天。 例外情况：如果找到的天数大于此月的最后一天，则返回此月的最后一天。
     * 比如：输入(2007-1-31,1)，则返回2007-2-28
     *
     * @param date
     * @param monthNumber
     * @return
     */
    public static Date getThisDayByMonth(Date date, int monthNumber) {
        if (monthNumber == 0)
            return date;
        if (date == null)
            return null;

        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        if (!checkDay(year, month, day))
            return null;
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.MONTH, monthNumber);

        return cal.getTime();
    }

    /**
     * 返回N天之后（之前）的某天。 例外情况：如找到的那天晚于1900-1-1，则返回1900-1-1。
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getThisDayByDay(Date date, int days) {
        if (days == 0)
            return date;
        if (date == null)
            return null;

        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        if (!checkDay(year, month, day))
            return null;
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, days);

        Date findDate = cal.getTime();
        Date date_1900_1_1 = toDate(1900, 0, 1);
        if (compareDay(findDate, date_1900_1_1) < 0)
            return date_1900_1_1;

        return findDate;
    }

    /**
     * 格式化日期类型，返回中文显示的日期时间 返回String 格式如下： 2007年9月4日 16:32:35
     *
     * @param date
     * @return
     */
    public static String formatDateTimeInChina(Date date) {
        if (date == null)
            return "";
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT,
                Locale.CHINA);
        return df.format(date);
    }

    /**
     * 格式化日期类型，返回中文显示的日期时间 返回String 格式如下： 2007年9月4日
     *
     * @param date
     * @return
     */
    public static String formatDateInChina(Date date) {
        if (date == null)
            return "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        return df.format(date);
    }

    /**
     * 比较2个日期类型，返回2个日期相差的天数，正数表示前一个日期比后一个日期晚n天，负数表示前一日期比后一日期早n天
     *
     * @param d1
     * @param d2
     * @return
     * @throws RuntimeException
     */
    public static int compareDays(Date d1, Date d2) {
        // 重写compareDays实现 by will.wangt
        if (d1 == null || d2 == null) {
            throw new RuntimeException("Not compare between d1<" + d1 + "> and d2<" + d2 + ">!");
        }
        Date v1 = toZeroDate(d1);
        Date v2 = toZeroDate(d2);
        int i = (int) ((v1.getTime() - v2.getTime()) / 86400000.0);
        return i;
    }

    public static void main(String[] a) throws ParseException {
        System.out.println(compareDays(parseDate("2013-10-16"), parseDate("2013-10-23")));
    }

    public static boolean checkDay(int year, int month, int monthDay) {
        if (year < 1900 || month < 0 || month > 11 || monthDay < 1 || monthDay > 31)
            return false;
        int maxDay = getMaxDays(year, month);
        if (monthDay > maxDay)
            return false;
        return true;
    }

    /**
     * 得到开始时间的下1秒时间,开始时间为null时得到当前时间的下1秒时间
     *
     * @param startDate
     * @return
     * @author xb
     */
    public static Date nextSecond(Date startDate) {
        Calendar cal = Calendar.getInstance();
        if (startDate != null) {
            cal.setTime(startDate);
        }
        cal.add(Calendar.SECOND, 1);
        return cal.getTime();
    }

    /**
     * 返回当前的年月日时分秒毫秒
     *
     * @return
     * @author
     */
    public static String getNow() {
        Calendar CD = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(CD.getTime()) + String.valueOf(CD.get(Calendar.MILLISECOND));
    }

    /**
     * 获取当前服务器时间
     *
     * @return
     */
    public static Date getNowTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 返回某个时间的n小时前（后）的时间
     *
     * @param date
     * @param hours
     * @return
     * @author
     * @date 2008-12-3
     */
    @SuppressWarnings("deprecation")
    public static Date getDateByHours(Date date, int hours) {
        date.setHours(date.getHours() + hours);
        return date;
    }

    /**
     * @param date
     * @return
     * @author yafei.wangyf
     * @date 2008-12-28
     */
    public static String getNextDayByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return formatYYYYMMDD(cal.getTime());
    }

    public static String getNextStartTimeByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return formatYYYYMMDD(cal.getTime()) + " 00:00:00";
    }

    public static String getPreEndTimeByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return formatYYYYMMDD(cal.getTime()) + " 23:59:59";
    }

    public static String getPreEndDateByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return formatYYYYMMDD(cal.getTime());
    }

    /**
     * 把秒数转换为易读的时间格式 如：61秒：返回1分1秒 如：3661秒：返回1小时1分1秒
     *
     * @param senconds
     * @return
     * @author
     * @date 2010-2-25
     */
    public static String secondsToHms(int senconds) {
        String hour = "小时";
        String minute = "分";
        String second = "秒";

        if (senconds == 0)
            return senconds + second;

        // long timeInMillis = 123456789;
        int hours = (int) Math.floor(senconds / (60 * 60));
        int minutes = (int) Math.floor((senconds % (60 * 60)) / 60);
        int seconds = (int) (senconds % (60 * 60)) % 60;

        String returnVal = "";
        if (hours != 0)
            returnVal = hours + hour;
        if (minutes != 0)
            returnVal += minutes + minute;
        if (seconds != 0)
            returnVal += seconds + second;

        return returnVal;
    }

    /**
     * 当前时间加上months月
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * 给定日期的周几
     *
     * @param time 给定日期
     * @param week 周几
     * @return
     */
    public static Date getDayOfThisWeek(Date time, int week) {
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) time.clone());

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        cal.add(Calendar.DATE, -dayOfWeek + week);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    static {
        Calendar CD = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        JVM_START = dateFormat.format(CD.getTime());
    }

    private static String JVM_START;

    /**
     * 获取当前服务器启动时间,格式yyyyMMddHH
     *
     * @return
     */
    public static String getJvmStart() {
        return JVM_START;
    }

    /**
     * 两者取更大的值
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Date getMax(Date d1, Date d2) {
        if (d1 == null && d2 == null) {
            return null;
        }
        if (d1 == null) {
            return d2;
        } else if (d2 == null) {
            return d1;
        }
        if (d1.getTime() > d2.getTime()) {
            return d1;
        }
        return d2;
    }

    public static List<String> getBetweenDateArray(String begin, String end) {
        List<String> dateArray = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date beginDate = dateFormat.parse(begin);
            Date endDate = dateFormat.parse(end);
            while (endDate.compareTo(beginDate) != -1) {
                dateArray.add(dateFormat.format(beginDate));
                beginDate = getNextDaytime(beginDate);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return dateArray;
    }
}
