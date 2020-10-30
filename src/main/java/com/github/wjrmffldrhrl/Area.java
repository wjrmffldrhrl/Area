package com.github.wjrmffldrhrl;

import java.util.regex.Matcher;

/**
 * String slice util
 *
 * @author wjrmffldrhrl
 */
public class Area {

    private final int start;
    private final int end;
    private final int length;

    /**
     * Constructor with int
     * @param start int
     * @param end int
     * @throws IllegalArgumentException If try initialize with invalid value
     * <p>Invalid value list</p>
     * <li>Input under 0</li>
     * <li>End value under then start value</li>
     * <li>Area length 0</li>
     */
    public Area(int start, int end) {
        if(isInvalid(start, end)) { throw new IllegalArgumentException("Don't use invalid value"); }
        this.start = start;
        this.end = end;
        this.length = end - start;
    }

    /**
     * Constructor with String
     * @param startStr String value
     * @param endStr String value
     */
    public Area(String startStr, String endStr) {
        this(Integer.parseInt(startStr),  Integer.parseInt(endStr));
    }

    /**
     * Constructor with matcher
     * @param matcher Need to available matcher
     */
    public Area(Matcher matcher) {
        this(matcher.start(), matcher.end());

    }

    /**
     * Check index area overlap
     * @param compareArea Area
     * @return If compareArea index overlap with this Area : true
     *         else : false
     */
    public boolean isOverlap(Area compareArea) {

        if(compareArea.getStart() > this.start && compareArea.getStart() < this.end) {
            return true;
        } else if(compareArea.getEnd() > this.start && compareArea.getEnd() < this.end) {
            return true;
        } else if(compareArea.getStart() < this.start && compareArea.getEnd() > this.end) {
            return true;
        } else if(compareArea.getStart() > this.start && compareArea.getEnd() < this.end) {
            return true;
        }

        return false;
    }

    /**
     * Check compareArea equals this area
     * @param compareArea Area
     * @return Check is have same value
     */
    public boolean equals(Area compareArea) {
        return compareArea.getStart() == this.start && compareArea.getEnd() == this.end;
    }


    /**
     * Get same index area
     * @return New area instance what have same value
     */
    @Override
    public Area clone() {
        return new Area(this.start, this.end);
    }

    /**
     * Get start index
     * @return start value
     */
    public int getStart() { return this.start; }

    /**
     * Get end index
     * @return end value
     */
    public int getEnd() { return this.end; }

    /**
     * Get area length
     * @return area length
     */
    public int getLength() { return this.length; }


    /**
     * Return area to String
     * {@code (start : 3 end : 5 )}
     * @return String value
     */
    @Override
    public String toString() {
        return "start : " + this.start + " end : " + this.end;
    }

    private boolean isInvalid(int startValue, int endValue) {
        return startValue < 0 || endValue < 0 || startValue > endValue || startValue == endValue;
    }
}
