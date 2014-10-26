/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author yur
 */
public class PacketUtils {
	
    public static Packet newFromStream(InputStream i, PacketFactory f) {
        PacketHeader h = new PacketHeader();
        if (readHeaderFromStream(h, i)) {
            Packet p = f.newFromHeader(h);
            p.readFromStream(i);
            return p;
        }

        return null;
    }

    private static int prevId = 0;

    public static int nextId() {
        if (prevId == Integer.MAX_VALUE) {
            prevId = 1;
        } else {
            ++prevId;
        }

        return prevId;
    }

    static public int readInt(InputStream i) throws IOException {
        byte[] bytes = new byte[4];
        int c = i.read(bytes);
        if (c < 4) {
            throw new IOException("not enough data");
        }

        return (int) (bytes[0] & 0xFF) | (int) ((bytes[1] & 0xFF) << 8)
                | (int) ((bytes[2] & 0xFF) << 16) | (int) ((bytes[3] & 0xFF) << 24);
    }

    static public void writeInt(OutputStream o, int v) throws IOException {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (v & 0xFF);
        bytes[1] = (byte) ((v >> 8) & 0xFF);
        bytes[2] = (byte) ((v >> 16) & 0xFF);
        bytes[3] = (byte) ((v >> 24) & 0xFF);

        o.write(bytes);
    }

    static public boolean readHeaderFromStream(PacketHeader h, InputStream i) {
        try {
            h.dataSize = readInt(i);
            h.id = readInt(i);
            h.command = readInt(i);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    static public boolean writeHeaderToStream(PacketHeader h, OutputStream o) {
        try {
            writeInt(o, h.dataSize);
            writeInt(o, h.id);
            writeInt(o, h.command);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
