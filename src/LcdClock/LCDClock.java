package LcdClock;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class LCDClock {
    private HashMap<String, SegmentCharacter> characterMap = new HashMap<String,
                                                                 SegmentCharacter>();

    LCDClock() {
        characterMap.put("1", new SegmentCharacter(0, 0, 1, 0, 0, 1, 0));
        characterMap.put("2", new SegmentCharacter(1, 0, 1, 1, 1, 0, 1));
        characterMap.put("3", new SegmentCharacter(1, 0, 1, 1, 0, 1, 1));
        characterMap.put("4", new SegmentCharacter(0, 1, 1, 1, 0, 1, 0));
        characterMap.put("5", new SegmentCharacter(1, 1 ,0, 1, 0, 1, 1));
        characterMap.put("6", new SegmentCharacter(0, 1, 0, 1, 1, 1, 1));
        characterMap.put("7", new SegmentCharacter(1, 0, 1, 0, 0, 1, 0));
        characterMap.put("8", new SegmentCharacter(1, 1, 1, 1, 1, 1, 1));
        characterMap.put("9", new SegmentCharacter(1, 1, 1, 1, 0, 1, 0));
        characterMap.put("0", new SegmentCharacter(1, 1, 1, 0, 1, 1, 1));
        characterMap.put("A", new SegmentCharacter(1, 1, 1, 1, 1, 1, 0));
        characterMap.put("P", new SegmentCharacter(1, 1, 1, 1, 1, 0, 0));
        characterMap.put(" ", new SegmentCharacter(0, 0, 0, 0, 0, 0, 0));
        characterMap.put("-", new SegmentCharacter(0, 0, 0, 1, 0, 0, 0));
    }

    public void printCurrentTime(int size, int format) {
        String hour;
        if (format == 24) hour = getCurrentHour24();
        else hour = getCurrentHour12();
        String time = hour + " -" + getCurrentMinute();

        printLines(time, size);
        System.out.println(time);
    }

    private void printLines(String time, int size) {

    ArrayList<String> lineList = new ArrayList<String>();

        for(int i = 1; i <= 5; i++) {
            lineList.add(characterConcat(time, i, size));
        }
        System.out.println(lineList.get(0));
        for (int i = 1; i <= size; i++) {
            System.out.println(lineList.get(1));
        }
        System.out.println(lineList.get(2));
        for (int i = 1; i <= size; i++) {
            System.out.println(lineList.get(3));
        }
        System.out.println(lineList.get(4));


    }
    private String characterConcat(String time,int lineNumber, int size) {
        String line = "";
        for(int i=0; i < time.length(); i++){
            line = line.concat(characterMap.get(Character.toString(time.charAt(i))).printLine(lineNumber,size));
        }

        return line;
    }

    private String getCurrentHour12() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour <=12 )return String.format("A%02d", hour);
        else return String.format("P %02d", hour - 12);

    }


    private String getCurrentHour24() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return String.format("%02d", hour);
    }

    private String getCurrentMinute() {
        Calendar calendar = Calendar.getInstance();
        int minutes = calendar.get(Calendar.MINUTE);
        return String.format("%02d", minutes);
    }


}
