package com.github.wjrmffldrhrl;

import com.github.wjrmffldrhrl.exception.InvalidIndexException;

/**
 * String index area
 *
 * @author wjrmffldrhrl
 */
public class Area {

    private final int start;
    private final int end;

    /**
     * Constructor
     * @param startIndex int
     * @param endIndex int
     */
    public Area(int startIndex, int endIndex) {
        if(startIndex < 0 || endIndex < 0) { throw new InvalidIndexException("Area index must over then 0"); }
        if(startIndex > endIndex) { throw new InvalidIndexException("Start index must over then end index"); }
        if(startIndex == endIndex) { throw new InvalidIndexException("Area length must over then 0"); }
        this.start = startIndex;
        this.end = endIndex;
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
     * @return boolean
     */
    public boolean equals(Area compareArea) {
        return compareArea.getStart() == this.start && compareArea.getEnd() == this.end;
    }


    /**
     * Get same index area
     * @return Area
     */
    @Override
    public Area clone() {
        return new Area(this.start, this.end);
    }

    /**
     * Get start index
     * @return int
     */
    public int getStart() { return this.start; }

    /**
     * Get end index
     * @return int
     */
    public int getEnd() { return this.end; }


}
