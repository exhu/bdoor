/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Little-endian int32, int32 string length, string chars, optional bin length,
 * bin data.
 *
 * @author yur
 */
public abstract class Packet {

    protected PacketHeader header;

    /// minimum data size in bytes
    /// override if differs from hedaerSize
    public int defaultSize() {
        return PacketHeader.headerSize;
    }

    protected Packet(PacketHeader h) {
        header = h;
    }


    /// read only packet specific data, excluding the header
    public abstract boolean readFromStream(InputStream i);

    public boolean writeToStream(OutputStream o) {
        return PacketUtils.writeHeaderToStream(header, o);
    }
}
