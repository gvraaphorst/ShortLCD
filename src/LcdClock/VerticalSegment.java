package LcdClock;

/**
 * Created by gvraaphorst on 03/07/2014.
 */
public class VerticalSegment extends Segment {
    private final String onCharacter = "|";
    private boolean segmentIsOn;
    public VerticalSegment(int segmentOn){
        if (segmentOn == 1) segmentIsOn = true;

    }
    public String printSegment(){
        if(segmentIsOn) return onCharacter;
        else return super.printSegment();
    }
}