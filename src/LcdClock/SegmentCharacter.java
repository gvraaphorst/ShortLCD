package LcdClock;


/**
 * Created by gvraaphorst on 01/07/2014.
 * Object to hold segments per character
 */


public class SegmentCharacter{
    private HorizontalSegment top;
    private VerticalSegment topLeft;
    private VerticalSegment topRight;
    private HorizontalSegment middle;
    private VerticalSegment bottomLeft;
    private VerticalSegment bottomRight;
    private HorizontalSegment bottom;
    private Segment emptySegment = new Segment();

    public SegmentCharacter(int topOn, int topLeftOn, int topRightOn, int middleOn, int bottomLeftOn, int bottomRightOn, int bottomOn){
        top = new HorizontalSegment(topOn);
        topLeft = new VerticalSegment(topLeftOn);
        topRight = new VerticalSegment(topRightOn);
        middle = new HorizontalSegment(middleOn);
        bottomLeft = new VerticalSegment(bottomLeftOn);
        bottomRight = new VerticalSegment(bottomRightOn);
        bottom = new HorizontalSegment(bottomOn);
    }




    public String printLine(int lineNumber, int charSize){
        String line = "";
        if (lineNumber == 1){
            line = line.concat(" ");
            line = line.concat(segmentCharacterConcat(top,charSize));
            line = line.concat(" ");
        }
        else if (lineNumber == 2){
            line = line.concat(topLeft.printSegment());
            line = line.concat(segmentCharacterConcat(emptySegment,charSize));
            line = line.concat(topRight.printSegment());
        }
        else if (lineNumber == 3){
            line = line.concat(" ");
            line = line.concat(segmentCharacterConcat(middle,charSize));
            line =  line.concat(" ");
        }
        else if (lineNumber == 4){
            line =  line.concat(bottomLeft.printSegment());
            line = line.concat(segmentCharacterConcat(emptySegment,charSize));
            line =  line.concat(bottomRight.printSegment());
        }
        else if (lineNumber == 5){
            line = line.concat(" ");
            line =  line.concat(segmentCharacterConcat(bottom,charSize));
            line = line.concat(" ");
        }
        return line;
    }


    private String segmentCharacterConcat(Segment segment, int charSize){
        String concatenatedSegments = "";
        for(int i=1; i <= charSize ; i++){
            concatenatedSegments = concatenatedSegments.concat(segment.printSegment());
            }
        return concatenatedSegments;
    }

}
