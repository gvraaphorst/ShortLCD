import LcdClock.SegmentCharacter;
import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentCharacterTest {

    @Test
    public void returns_spacedashspace_if_top_segment_is_on_and_size_is_one() {
        SegmentCharacter segmentcharacter = new SegmentCharacter(1,0,0,0,0,0,0);
        String result = segmentcharacter.printLine(1,1);

        assertEquals(" - ", result);

    }
    @Test
     public void returns_spacespacespace_if_top_segment_is_off_and_size_is_one() {
        SegmentCharacter segmentcharacter = new SegmentCharacter(0,0,0,0,0,0,0);
        String result = segmentcharacter.printLine(1,1);

        assertEquals("   ", result);

    }
    @Test
    public void returns_barspacebar_if_topleftright_segments_are_on_and_size_is_one() {
        SegmentCharacter segmentcharacter = new SegmentCharacter(0,1,1,0,0,0,0);
        String result = segmentcharacter.printLine(2,1);

        assertEquals("| |", result);

    }
    @Test
    public void returns_barspacespacebar_if_topleftright_segments_are_on_and_size_is_two() {
        SegmentCharacter segmentcharacter = new SegmentCharacter(0,1,1,0,0,0,0);
        String result = segmentcharacter.printLine(2,2);

        assertEquals("|  |", result);

    }


}