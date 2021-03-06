package videodirt;

import processing.core.PConstants;
import processing.core.PImage;
import java.nio.IntBuffer;

class VideoPlane extends PImage {

    private VideoClip clip;
    private boolean active;
    private int lastWidth;
    private int lastHeight;

    void init(IntBuffer int_buffer, int width, int height) {
        if (lastWidth != width || lastHeight != height) {
            init(width, height, PConstants.ARGB);
            lastWidth = width;
            lastHeight = height;
            pixels = new int[width * height];
        }
        loadPixels();
        int_buffer.rewind();
        int_buffer.get(pixels, 0, width * height);
        updatePixels();

        active = true;
    }

    void clear() {
        active = false;
    }

    boolean isActive() {
        return active;
    }

    void connectClip(VideoClip clip) {
        this.clip = clip;
    }

    VideoClip getConnectedClip() {
        return clip;
    }
}
